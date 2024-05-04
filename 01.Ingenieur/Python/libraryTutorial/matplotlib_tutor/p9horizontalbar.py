from matplotlib import pyplot as plt
"""
横向条形图 块状图
"""
a = ["deutsch", "mathe", "english", "history", "politics", "physic"]
b = [17.14, 26.94, 90, 22.4, 9.32, 50.01]
plt.figure(figsize=(10,8), dpi=80)
plt.barh(a, b, height=0.4, color="orange") # width -> height
plt.show()