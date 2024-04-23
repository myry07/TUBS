from matplotlib import pyplot as plt

"""
给图片添加信息

figure() 指图形图标的意思
         可以传入参数设置figure大小
         也可以传入dpi参数 是图片清晰  dots per inch 每英寸点数
         
savefig() save figure
          保存图片
          
xticks() 设置x轴取值

"""

plt.figure(figsize=(20, 8), dpi=80)
x = range(2, 26, 2) # 确定x轴 从2-26 间隔为2
y = [15, 13, 14.5, 17, 20, 25, 26, 26, 24, 22, 18, 15]
plt.plot(x, y) # 传入x和y
plt.xticks(range(0,25))
plt.yticks(range(min(y), max(y) + 1))
plt.savefig("/Users/myry/Documents/MyPythonProject/lernLibs/matplotlib_tutor/imgforp2.png")
plt.show()