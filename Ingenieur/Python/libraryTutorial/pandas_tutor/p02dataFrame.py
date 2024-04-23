import pandas as pd
import numpy as np

# 1. 默认的索引
t = pd.DataFrame(np.arange(12).reshape((3, 4)))
print(t)
"""
   0  1   2   3           行索引和列索引
0  0  1   2   3
1  4  5   6   7
2  8  9  10  11
"""
print(t[0][1])  # 4

# 2. 字节设置索引
t2 = pd.DataFrame(np.arange(12).reshape((3, 4)), index=['a', 'b', 'c'], columns=['w', 'x', 'y', 'z'])
print(t2)
"""
   w  x   y   z
a  0  1   2   3
b  4  5   6   7
c  8  9  10  11
"""
print(t2.loc['a','w']) # 0