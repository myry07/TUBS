from matplotlib import pyplot as plt
import random

# 列表a表示10点-12点的每一分钟的气温
# a = [random.randint(20, 35) for i in range(120)]

x = range(0, 120)  # 两小时
y = [random.randint(20, 35) for i in range(120)]
plt.figure(figsize=(20, 8), dpi=80)
plt.plot(x, y)

# 调整x轴
# x_ = x
# x_lables = ["min{}".format(i) for i in range(120)]
# plt.xticks(x_lables)

# x_ = x[::5]
# x_lables = ["min{}".format(i) for i in range(0,120, 5)]
# plt.xticks(x_ ,x_lables)


x_ = x[::5]
x_lables = ["10:{}".format(i) for i in range(0, 60, 5)]
x_lables += ["11:{}".format(i) for i in range(0, 60, 5)]
plt.xticks(x_, x_lables, rotation=45) # rotation 旋转45度

# 需要一一对应 因为xticks只能传入数字
# 如果想传入字符串 需要一个数字与之一一对应
# 由于是一一对应 那么长度 幅度务必相同
plt.savefig("/Users/myry/Documents/MyPythonProject/lernLibs/matplotlib_tutor/imgforp4.png")
plt.show()
