import pandas as pd

"""
nympy 只能处理numerical的数据
比如字符串 时间序列 需要借助pandas

常见数据类型
series 一维 带标签的数组
dataframe 二维 series的容器
"""

# 1. 默认的索引
t = pd.Series([1, 2, 31, 12, 3, 4])
print(t)
"""
0     1                    左边是索引    ->   标签
1     2                         右边才是数值
2    31
3    12
4     3
5     4
dtype: int64
"""
print(type(t))  # <class 'pandas.core.series.Series'>

# 2. 自创的索引
t2 = pd.Series([1, 2, 3, 4, 5], index=list("abcde"))
print(t2)
"""
a    1            可以自己指定索引
b    2
c    3
d    4
e    5
dtype: int64
"""

# 3. 字典式索引
temp = {"name": "jack", "age": 30, "tel": 10086}
t3 = pd.Series(temp)
print(t3)
"""
name     jack
age        30
tel     10086
dtype: object
"""

print(t[1])
print(t[:1])
