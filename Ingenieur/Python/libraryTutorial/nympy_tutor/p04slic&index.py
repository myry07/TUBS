import numpy as np

us_file_path = "/Users/myry/Documents/MyPythonProject/lernLibs/nympy_tutor/data/US_video_data_numbers.csv"

t1 = np.loadtxt(us_file_path, delimiter=",", dtype=int)
print(t1)
print("*" * 100)

# 取行
print(t1[2])
print("*" * 100)
# 取0 - 1行
print(t1[0:2])
print("*" * 100)
# 取2行以后的
print(t1[2:])
print("*" * 100)
# 取0 2 4行
print(t1[[0, 2, 3]])
print("*" * 100)

# 取列
print(t1[:, 0])
print("*" * 100)
# 取多列
print(t1[:, 2:])
print("*" * 100)
# 取0 2 3列
print(t1[:, [0, 2, 3]])
print("*" * 100)

# 取三行四列
print(t1[2, 3])  # 170708
print("*" * 100)
# 取多行多列
print(t1[3:5, 2:4])
print("*" * 100)

# 取多个不相间的点
print(t1[[0, 2], [0, 1]])  # (0,2) (0,1)
print("*" * 100)

# 了解即可
print(t1[[0, 2, 2], [0, 1, 3]])  # (0,0) (2,1) (2,3)
print("*" * 100)


