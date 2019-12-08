# from flask import Flask, render_template, url_for, request, jsonify
# import numpy as np
# import pickle

# app = Flask(__name__)
# loaded_model = pickle.load(open("finalized_model.sav", "rb"))

# @app.route("/")
# def home():
#     symptoms = request.args.get("symptoms")
#     input_vector=[]
#     for i in range(0,132):
#         input_vector.append(int(symptoms[i]))

#     return jsonify({"data": loaded_model.predict([input_vector])[0]})


# if __name__ == "__main__":
#     app.debug = True
#     app.run(host="0.0.0.0", port=5000)


import sys
import os
import glob
import re
import numpy as np
import cv2
import keras
import tensorflow as tf
from werkzeug.utils import secure_filename
from keras.applications.imagenet_utils import preprocess_input, decode_predictions
from keras.models import load_model, model_from_json
from keras.preprocessing import image
from keras.preprocessing.image import ImageDataGenerator
from flask import Flask, redirect, url_for, request, render_template, jsonify
from PIL import Image

app = Flask(__name__)

json_file = open('model.json', 'r')
loaded_model_json = json_file.read()
json_file.close()
loaded_model = model_from_json(loaded_model_json)

loaded_model.load_weights('xray_class_weights.best.hdf5')
print('Model loaded. Start serving...')
labels = [['Atelectasis', 'Cardiomegaly', 'Consolidation', 'Edema', 'Effusion', 'Emphysema',
           'Fibrosis', 'Infiltration', 'Mass', 'Nodule', 'Pleural_Thickening', 'Pneumonia', 'Pneumothorax']]

loaded_model._make_predict_function()
graph = tf.get_default_graph()

# def flow_from_dataframe(img_data_gen, ff, path, **dflow_args):
#     print('#######')
#     base_dir = os.path.dirname(path)
#     print("base_dir: ",base_dir)
#     print('## Ignore next message from keras, values are replaced anyways')
#     df_gen = img_data_gen.flow_from_directory(base_dir,
#                                      class_mode = 'sparse',
#                                     **dflow_args)
#     print("df_gen: ",df_gen)
#     df_gen.filenames = ff.filename
#     df_gen.classes = [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]
#     df_gen.samples = 1
#     df_gen.n = 1
#     df_gen._set_index_array()
#     df_gen.directory = '' # since we have the full path
#     print("lalala")
#     return df_gen


def model_predict(img_path):
    img = cv2.imread(img_path)
    print("original_img: ", img.shape)
    img = cv2.resize(img, (128, 128))
    # if img.shape[2] ==1:
    #              img = np.dstack([img, img, img])
    img = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
    print("grayscale_image: ", img.shape)
    img = img[:, :, np.newaxis]
    print("new_grayscale_image: ", img.shape)
    img = img.astype(np.float32)/255.
    img = np.expand_dims(img, axis=0)
    return img


@app.route('/', methods=['GET', 'POST'])
def home():
    if request.method == 'POST':
        # Get the file from post request
        f = request.files['file']
        print("object: ", f)
        print("filename: ", f.filename)

        # Save the file to ./uploads
        basepath = os.path.dirname(__file__)
        file_path = os.path.join(
            basepath, 'uploads', secure_filename(f.filename))
        f.save(file_path)

        IMG_SIZE = (128, 128)
        # core_idg = ImageDataGenerator(samplewise_center=True,
        #                       samplewise_std_normalization=True,
        #                       horizontal_flip = True,
        #                       vertical_flip = False,
        #                       height_shift_range= 0.05,
        #                       width_shift_range=0.1,
        #                       rotation_range=5,
        #                       shear_range = 0.1,
        #                       fill_mode = 'reflect',
        #                       zoom_range=0.15)
        # print("file_path: ", file_path)

        # test_X, test_Y= next(flow_from_dataframe(core_idg,
        #                     f,
        #                     file_path,
        #                     target_size = IMG_SIZE,
        #                     color_mode = 'grayscale',
        #                     batch_size = 1024))
        # print("test_X: ",test_X)
        # print("length_test_X: ",len(test_X))
        test_X = model_predict(file_path)
        print("image_shape: ", test_X.shape)
        global graph
        with graph.as_default():
            pred_Y = loaded_model.predict(test_X, verbose=True)
            #print("pred_Y: ",pred_Y)

            indices = np.argsort(pred_Y)
            #print("prediction: ",labels[0][indices[0][12]]);
            #print("value: ",pred_Y[0][indices[0][12]]);
            top_diseases = []
            top_prob = []
            f = 0
            for i in range(12, -1, -1):
                if f == 3:
                    break
                elif labels[0][indices[0][i]] == 'Infiltration' and pred_Y[0][7] > 0.60:
                    top_diseases.append('Infiltration')
                    top_prob.append(pred_Y[0][7])
                    f = f+1
                elif labels[0][indices[0][i]] == 'Effusion' and pred_Y[0][4] > 0.3455:
                    top_diseases.append('Effusion')
                    top_prob.append(pred_Y[0][4])
                    f = f+1
                elif labels[0][indices[0][i]] == 'Atelectasis' and pred_Y[0][0] > 0.3351:
                    top_diseases.append('Atelectasis')
                    top_prob.append(pred_Y[0][0])
                    f = f+1
                elif labels[0][indices[0][i]] != 'Infiltration' and labels[0][indices[0][i]] != 'Effusion' and labels[0][indices[0][i]] != 'Atelectasis':
                    top_diseases.append(labels[0][indices[0][i]])
                    top_prob.append(pred_Y[0][indices[0][i]])
                    f = f+1

            q = str(top_diseases[0])
            w = str(top_diseases[1])
            t = str(top_diseases[2])
            st = q+" "+w+" "+t
            q = str(top_prob[0])
            w = str(top_prob[1])
            t = str(top_prob[2])
            st = st+" "+q+" "+w+" "+t
            return jsonify({"data": st})
    else:
    	return jsonify({"data": "Something is wrong!!"})


if __name__ == "__main__":
    app.debug = True
    app.run(host="127.0.0.1", port=80)
