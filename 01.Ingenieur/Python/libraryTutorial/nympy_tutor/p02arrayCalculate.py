import numpy as np

# 1. shape 方法 获得数组的维度
t1 = np.arange(4)
print(t1)  # [0 1 2 3]
print(t1.shape)  # (4,)
t2 = np.array([[1, 2, 3], [4, 5, 6]])
print(t2)
print(t2.shape)  # (2, 3)

# 2. reshape 方法 修改数组的维度
t4 = np.arange(12)
print(t4)
"""[ 0  1  2  3  4  5  6  7  8  9 10 11]"""
t5 = t4.reshape(3, 4)
print(t5)
"""
[[ 0  1  2  3]
 [ 4  5  6  7]
 [ 8  9 10 11]]
"""

# 3. 广播机制 一个人说话 所有人听得见
t6 = np.array([[1, 2], [3, 4]])
print(t6 + 1)
print(t6 * 2)
"""
[[2 3]    [[2 4]
 [4 5]]    [6 8]]
"""
