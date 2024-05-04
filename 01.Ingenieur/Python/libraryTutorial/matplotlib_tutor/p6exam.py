from matplotlib import pyplot as plt

# 年龄
x = range(0, 20)
# 交友数量
y = [1, 0, 1, 1, 2, 4, 3, 2, 3, 4, 4, 5, 6, 5, 4, 3, 3, 1, 1, 1]

dimension = 2

plt.figure(figsize=(20, 8))

x_ = x
x_lables = ["{}years old".format(i + 11) for i in x_]
plt.xticks(x[::dimension], x_lables[::dimension], rotation=45)
plt.yticks(range(min(y), max(y) + 1))

plt.xlabel("age")
plt.ylabel("how many girlfriends")
plt.title("research how many girlfriends in all years old")

# 添加网格 grid -> Netz
# alpha 透明度
plt.grid(alpha=1)

plt.plot(x, y)
plt.show()
