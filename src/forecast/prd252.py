import sys

import joblib
import numpy as np
from sklearn.preprocessing import StandardScaler

filePath = sys.argv[1]
filePath += "/result.txt"
data = np.genfromtxt(filePath, dtype=float)
std_data = StandardScaler().fit_transform(data)

model = joblib.load(sys.argv[1] + "/saved_model/model252")
y_pre = model.predict(std_data)

out_str = ""
for i in y_pre:
    out_str += str(i) + " "
print(out_str)
