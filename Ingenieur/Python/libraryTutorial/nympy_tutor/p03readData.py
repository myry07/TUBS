import numpy as np

uk_file_path = "/Users/myry/Documents/MyPythonProject/lernLibs/nympy_tutor/data/GB_video_data_numbers.csv"
us_file_path = "/Users/myry/Documents/MyPythonProject/lernLibs/nympy_tutor/data/US_video_data_numbers.csv"

"""
loadtxt 读取文件 可以不是txt的

fname: 文件或字符串 可以是gz bz2的压缩文件
dtype: 数据类型 csv的字符串 默认np.float
delimiter: 分割字符串 默认是空格
skiprows: 跳过前x行
usecols: 读取指定的列
unpack: 如果True -> 转置
"""
t1 = np.loadtxt(us_file_path, delimiter=',', dtype="int")
print(t1)
