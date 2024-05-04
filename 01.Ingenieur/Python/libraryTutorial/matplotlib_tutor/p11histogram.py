import matplotlib.pyplot as plt
import random

"""
直方图
与块状图相比 多了组数和组距
"""

a = [random.randint(70, 200) for i in range(0, 100)]

# 计算组数
d = 3 # 组距
num_bins = (max(a) - min(a)) // d # 组数 最大值-最小值 整除 组距
plt.figure(figsize=(20, 5), dpi=80)
plt.hist(a, bins=num_bins)
plt.xticks(range(min(a), max(a) + d, d))
plt.grid()
plt.show()
