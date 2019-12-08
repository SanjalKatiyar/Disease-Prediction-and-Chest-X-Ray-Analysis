from flask import Flask, render_template, url_for, request, jsonify
import numpy as np
import pickle

app = Flask(__name__)
loaded_model = pickle.load(open("finalized_model.sav", "rb"))

@app.route("/")
def home():
    symptoms = request.args.get("symptoms")
    input_vector=[]
    for i in range(0,132):
        input_vector.append(int(symptoms[i]))
        
    return jsonify({"data": loaded_model.predict([input_vector])[0]})


if __name__ == "__main__":
    app.debug = True
    app.run(host="0.0.0.0", port=5000)