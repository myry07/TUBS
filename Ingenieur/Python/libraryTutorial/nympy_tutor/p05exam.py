import numpy as np
from matplotlib import pyplot as plt

us_file_path = "/Users/myry/Documents/MyPythonProject/lernLibs/nympy_tutor/data/US_video_data_numbers.csv"
t1 = np.loadtxt(us_file_path, delimiter=",", dtype=int)

like = t1[:,0]
unlike = t1[:,1]
dimension = 250
x = range(0, len(like))
x_ = x
x_lable = ["{}".format(i) for i in x_]
# plt.figure(figsize=(20,8))
plt.xticks(x[::dimension], x_lable[::dimension],rotation=45)
plt.plot(x, like, color="blue", label="like")
plt.plot(x, unlike, color="red", label="unlike")
plt.title("Data for Youtube video")
plt.legend(loc="upper left")
plt.show()
