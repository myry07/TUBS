from matplotlib import pyplot as plt
import random

# 列表a表示10点-12点的每一分钟的气温
# a = [random.randint(20, 35) for i in range(120)]

x = range(0, 120) #两小时
y = [random.randint(20, 35) for i in range(120)]
plt.figure(figsize=(20, 8), dpi=80)
plt.plot(x, y)
plt.show()
