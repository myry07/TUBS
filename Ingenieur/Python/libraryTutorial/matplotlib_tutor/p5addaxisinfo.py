from matplotlib import pyplot as plt
import random

# 列表a表示10点-12点的每一分钟的气温
# a = [random.randint(20, 35) for i in range(120)]

x = range(0, 120)  # 两小时
y = [random.randint(20, 35) for i in range(120)]
plt.figure(figsize=(20, 8), dpi=80)
plt.plot(x, y)
dimension = 5
x_ = x[::dimension]
x_lables = ["10:{}".format(i) for i in range(0, 60, dimension)]
x_lables += ["11:{}".format(i) for i in range(0, 60, dimension)]
plt.xticks(x_, x_lables, rotation=45) # rotation 旋转45度

plt.xlabel("time")
plt.ylabel("temperature C")
plt.title("Temperature time domain 10:00 - 12:00")

# plt.savefig("/Users/myry/Documents/MyPythonProject/lernLibs/matplotlib_tutor/imgforp5.png")
plt.show()
