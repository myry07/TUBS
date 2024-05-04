import numpy as np
import matplotlib.pyplot as plt

"""
使用matplotlib库的 imread可以读取图片数据
彩色图片 -> 三维矩阵
黑白图片 -> 二维矩阵
视频可能是四维的
"""
img = plt.imread('/Users/myry/Documents/MyPythonProject/lernLibs/nympy_tutor/bg.png')
print(img)
print(type(img)) # 获取类型 <class 'numpy.ndarray'>

# 生成矩阵的方法
# 方法1
t1 = np.array([1, 2, 3])
print(t1)
print(type(t1)) # <class 'numpy.ndarray'>

# 方法2
t2 = np.array(range(2,10,2))
print(t2) # [2 4 6 8]

# 方法3 nympy独有的arange -> Array(RANGE)
t3 = np.arange(2,10,2)
print(t3) # [2 4 6 8]

