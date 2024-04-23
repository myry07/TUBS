from matplotlib import pyplot as plt
import random
"""
散点图的绘制
"""
# 天气变化情况
x_3 = range(1, 32)
x_10 = range(41, 72)
y_3 = [random.randint(10, 24) for i in range(0, 31)]
y_10 = [random.randint(5, 30) for i in range(0, 31)]

dimension = 2
# 这边得用list 不然range无法与range相加
x_ = list(x_3)
x_labels = ["mar.{}".format(i) for i in x_3]
x_ += list(x_10)
x_labels += ["oct.{}".format(i - 40) for i in x_10]
plt.figure(figsize=(20,8), dpi=80)
plt.xticks(x_[::dimension], x_labels[::dimension] ,rotation=45)
plt.xlabel("time")
plt.ylabel("temperature")
plt.title("temperature in march and october")
plt.scatter(x_3, y_3, color="red", label="march")
plt.scatter(x_10, y_10, color="blue", label="october")
plt.legend(loc="upper left")
plt.show()
