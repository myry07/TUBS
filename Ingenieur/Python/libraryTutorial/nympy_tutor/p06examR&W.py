import numpy as np
from matplotlib import pyplot as plt

path = "/Users/myry/Documents/MyPythonProject/lernLibs/nympy_tutor/data/test.txt"
new_score = 20
with open(path, 'a') as file:
    # 写入新数据
    file.write(str(new_score) + "\n")

# scores = np.loadtxt(path, delimiter=" ", dtype=int)
# print(scores)
# x = range(len(scores))
#
# new_score = 16
#
# new_scores = np.hstack((scores, new_score))
# print(new_scores)
#
# np.savetxt(path, new_scores, delimiter=" ", fmt="%d")
#
# plt.plot(x, scores)
# plt.show()


