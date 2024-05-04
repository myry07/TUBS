from matplotlib import pyplot as plt
"""
条形图 块状图
"""
a = ["deutsch", "mathe", "english", "history", "politics", "physic"]
b = [17.14, 26.94, 90, 22.4, 9.32, 50.01]
plt.figure(figsize=(10,8), dpi=80)
plt.bar(a, b, width=0.4, color="cyan")
plt.show()