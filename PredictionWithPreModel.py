from sklearn.neural_network import MLPRegressor
import pandas as pd
import matplotlib.pyplot as plt
import numpy as np
import joblib

train_cnt=10000
date_norm=900000000000
first_pre_time=10
last_pre_time=25
pre_cnt=last_pre_time-first_pre_time

file_url=".\datas\J00252\机组发电功率数据.xlsx"
data_tr = pd.read_excel(file_url,sheet_name=0,header=0)
X_train= data_tr.iloc[0:train_cnt, 0]
y_train= data_tr.iloc[0:train_cnt, 2]
X_pre=(data_tr.iloc[first_pre_time:last_pre_time, 0])
y_pre= data_tr.iloc[first_pre_time:last_pre_time, 2]
X_pre=np.array(X_pre)

base_df="2021/1/1"
base_df = pd.to_datetime(base_df)
df_train={}
df_pre={}

for i in range(0, train_cnt):
    X_train[i]=pd.to_datetime(X_train[i])
    # print(X_train[i].value - base_df.value)
    ls=[(X_train[i].value - base_df.value) / date_norm]
    df_train[str(i)]=ls
for i in range(0, pre_cnt):
    X_pre[i]=pd.to_datetime(X_pre[i])
    ls=[(X_train[i].value - base_df.value) / date_norm]
    df_pre[str(i)]=ls

df_train=pd.DataFrame(df_train)
df_pre=pd.DataFrame(df_pre)
D_train=np.array(df_train).T # D is a matrix consisted by dateform elements
D_pre=np.array(df_pre).T

model=joblib.load("saved_model/MLPR_1.01.pkl")
pre = model.predict(D_pre)
mse=np.abs(y_pre[:] - pre).mean()
mean=np.abs(y_pre[:]).mean()
value=100-mse*100/mean
print(str(value)+"%")# This is a value for evaluating the proformence of our model
output=pd.DataFrame(pre.T)
output=output.values.tolist()
output=str(output)
print(output)

plt.plot(D_pre, y_pre, 'b')
plt.plot(D_pre, pre, 'r')
plt.show()# Plot the figure of pre_value
