from matplotlib import pyplot as plt

x = range(2, 26, 2) # 确定x轴 从2-26 间隔为2
y = [15, 13, 14.5, 17, 20, 25, 26, 26, 24, 22, 18, 15]
plt.plot(x, y) # 传入x和y
plt.show()