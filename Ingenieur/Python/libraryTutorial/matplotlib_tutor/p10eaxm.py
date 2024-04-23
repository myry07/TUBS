from matplotlib import pyplot as plt
import random

"""
横向条形图 块状图
"""
a = ["deutsch", "mathe", "english", "history", "politics", "physic"]
b1 = [random.randint(7, 100) for i in range(0, 6)]
b2 = [random.randint(7, 100) for i in range(0, 6)]
b3 = [random.randint(7, 100) for i in range(0, 6)]

w = 0.2
x_1 = list(range(0, len(a))) # 需要先将a转成range 因为字符串无法直接与i相加
x_2 = [(i + w) for i in x_1]
x_3 = [(i + 2 * w) for i in x_1]

plt.figure(figsize=(10, 8), dpi=80)
plt.xticks(x_2, a)
plt.bar(x_1, b1, color="orange", width=w, label="Mannheim-Schule")
plt.bar(x_2, b2, color="red", width=w, label="Braunschwieg-Schule")
plt.bar(x_3, b3, color="blue", width=w, label="Northeim-Schule")
plt.legend(loc="upper right")
plt.show()
