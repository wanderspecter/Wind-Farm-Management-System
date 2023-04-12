from sklearn.preprocessing import StandardScaler
import pandas as pd
import numpy as np
import sys
import joblib


data_tr=[]
for i in range(1,len(sys.argv)):
    data_tr.append(sys.argv[i])

data_tr=pd.DataFrame(data_tr)
data=np.array(data_tr).T
std_data=StandardScaler().fit_transform(data)


model=joblib.load("saved_model/model252")
y_pre=model.predict(std_data)


out_str=""
for i in y_pre:
    out_str+=str(i)+" "
print(out_str)
