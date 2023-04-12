from sklearn.preprocessing import StandardScaler
import pandas as pd
import numpy as np
import sys
import joblib


l0=[]
l1=[]
l2=[]
l3=[]

data={'0':l0,'1':l1,'2':l2,'3':l3,}
for i in range(1,len(sys.argv)):
    if i%4==1:
        l1.append(sys.argv[i])
    elif i%4==2:
        l2.append(sys.argv[i])
    elif i%4==3:
        l3.append(sys.argv[i])
    elif i%4==0:
        l0.append(sys.argv[i])
data=pd.DataFrame(data)
data=np.array(data)
std_data=StandardScaler().fit_transform(data)

model=joblib.load("saved_model/model293")
y_pre=model.predict(std_data)


out_str=""
for i in y_pre:
    out_str+=str(i)+" "
print(out_str)

