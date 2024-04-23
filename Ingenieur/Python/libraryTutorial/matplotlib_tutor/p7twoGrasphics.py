from matplotlib import pyplot as plt

# 年龄
x = range(11, 31)
# 交友数量
y_1 = [1, 0, 1, 1, 2, 4, 3, 2, 3, 4, 4, 5, 6, 5, 4, 3, 3, 1, 1, 1]
y_2 = [1, 0, 3, 1, 2, 2, 3, 3, 2, 1, 2, 1, 1, 1, 1, 1, 1 ,1 ,1, 1]

dimension = 1

plt.figure(figsize=(20, 8))

x_ = x[::dimension]
x_lables = ["{}years old".format(i) for i in x_]
plt.xticks(x, x_lables, rotation=45)
plt.yticks(range(min(y_1), max(y_1) + 1))

plt.xlabel("age")
plt.ylabel("how many girlfriends")
plt.title("research how many girlfriends in all years old")

# 添加网格 grid -> Netz
# alpha 透明度
plt.grid(alpha=1)

"""
color="" 设置颜色
linestyle="--" :, -., - 线条风格
linewidth=5 线条粗细
"""

plt.plot(x, y_1, color="red", label="jack", linestyle="--", linewidth=2)
plt.plot(x, y_2, color="cyan", label="tom", linestyle="-", linewidth=2)
plt.legend(loc="upper left")  # 用来显示右上角的图形 legend 图例 传奇的
# upper left 左上角
plt.show()
