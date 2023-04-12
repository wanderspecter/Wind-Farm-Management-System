from sklearn.neural_network import MLPRegressor
from sklearn.preprocessing import StandardScaler
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import joblib

file_url=".\processed_datas\data267.xlsx"
first_train_data=0
last_train_data=14820
first_train_col=0
last_train_col=8
select_index=14820
scaler=StandardScaler()

data_tr=pd.read_excel(file_url,sheet_name=0,header=0)
X_train=data_tr.iloc[first_train_data:last_train_data, first_train_col:last_train_col]
y_train=data_tr.iloc[first_train_data:last_train_data, 8]
X_pre=data_tr.iloc[0:select_index,first_train_col:last_train_col]
y_true=data_tr.iloc[0:select_index,8]
x=range(0,last_train_data)
# X_train=data_tr.iloc[first_train_data:last_train_data, first_train_col:last_train_col]
# y_train=data_tr.iloc[first_train_data:last_train_data, 8]
# X_pre=data_tr.iloc[select_index:,first_train_col:last_train_col]
# y_true=data_tr.iloc[select_index:,8]
# x=range(1,18526-select_index)



X_train=np.array(X_train)
y_train=np.array(y_train)
X_pre=np.array(X_pre)
y_true=np.array(y_true)

std_X_train=scaler.fit_transform(X_train)
std_X_pre=scaler.fit_transform(X_pre)

model = MLPRegressor(hidden_layer_sizes=(7,), random_state=15,
                     activation="relu",
                     solver='adam', alpha=0.0005,
                     batch_size='auto', learning_rate="constant",
                     learning_rate_init=0.0005, power_t=0.5, max_iter=10000, tol=1e-4
                     )  # Define the BPNeuralNetworkRegressor model
model.fit(std_X_train, y_train)  # Fit in datas and train model
y_pre = model.predict(std_X_pre)+47
joblib.dump(model,"saved_model/model267")

# mse = np.abs(y_true - y_pre).mean()
# # print(mse)
# mean = np.abs(y_pre[:]).mean()
# value = 100 - mse * 100 / mean
out_str=""
for i in y_pre:
    out_str+=str(i)+" "
print(out_str)
# print(str(value) + "%")
# plt.plot(x, y_pre, 'b')
# plt.plot(x, y_true, 'r')
# plt.show()# Plot the figure of pre_value
