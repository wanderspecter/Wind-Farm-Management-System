from sklearn.neural_network import MLPRegressor
import pandas as pd
import matplotlib.pyplot as plt
import numpy as np

cnt=10000
data_tr = pd.read_excel("D:\py_project\pythonProject\datas\J00252\机组发电功率数据.xlsx",sheet_name=0,header=0)
time_list_X=[]
time_list_X2=[]
X=data_tr.iloc[0:cnt,0]
y=data_tr.iloc[0:cnt,2]
X2=(data_tr.iloc[10:25,0])
y2=data_tr.iloc[10:25,2]
X2=np.array(X2)
base_df="2021/1/1"
base_df = pd.to_datetime(base_df)
d={}
d2={}
for i in range(0,cnt):
    X[i]=pd.to_datetime(X[i])
    # print(type(X[i]))
    print(X[i].value-base_df.value)
    ls=[(X[i].value-base_df.value)/900000000000]
    d[str(i)]=ls
for i in range(0,15):
    X2[i]=pd.to_datetime(X2[i])
    ls=[(X[i].value-base_df.value)/900000000000]
    d2[str(i)]=ls


d=pd.DataFrame(d)
d2=pd.DataFrame(d2)
D=np.array(d).T
D2=np.array(d2).T


model = MLPRegressor(hidden_layer_sizes=(10,), random_state=10,
                     activation="relu",
                     solver='adam', alpha=0.0002,
                     batch_size='auto', learning_rate="constant",
                     learning_rate_init=0.01, power_t=0.5, max_iter=5000, tol=1e-4
                     )  # BP神经网络回归模型
model.fit(D,y)  # 训练模型
pre = model.predict(D2)
print(pre)
mse=np.abs(y2[:]-pre).mean()
mean=np.abs(y2[:]).mean()
value=100-mse*100/mean
print(str(value)+"%")
plt.plot(D2,y2,'b')
plt.plot(D2,pre,'r')
plt.show()
