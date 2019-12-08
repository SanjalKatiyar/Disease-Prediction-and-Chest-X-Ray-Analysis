import re, json, requests
import cv2
# api-endpoint
URL = "http://127.0.0.1:8000/"

# defining a params dict for the parameters to be sent to the API


# sending get request and saving the response as response object
img = cv2.imread('uploads/00000103_001.png')
# print(img)
data= {"photo":img}

resp = requests.post(url=URL, data=data)
# print(resp.status_code)
# #print("cookie :",di)
# print(json.loads(resp.content.decode('utf-8')))
# data= {"userId":69,
# "context":'add_booking'
# }
# resp = s.post(url=URL, data=data)
# # print(resp.status_code)
# # print(s.cookies.get_dict())
# # print(json.loads(resp.content.decode('utf-8')))
# str= json.loads(resp.content.decode('utf-8'))
# print("response from request: ",str)
# data= {"userId":69,
# "context":str
# }
# resp = s.post(url=URL, data=data)
# # print(resp.status_code)
# # print(s.cookies.get_dict())
# # print(json.loads(resp.content.decode('utf-8')))
# str= json.loads(resp.content.decode('utf-8'))
# print("response from request: ",str)
# data= {"userId":69,
# "context":str
# }
# resp = s.post(url=URL, data=data)
# # print(resp.status_code)
# # print(s.cookies.get_dict())
# # print(json.loads(resp.content.decode('utf-8')))
# str= json.loads(resp.content.decode('utf-8'))
# print("response from request: ",str)
