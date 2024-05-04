import os

# 获取当前路径
print(os.getcwd()) # /Users/myry/Documents/MyPythonProject/lernLibs/os_tutor

# 改变目录
os.chdir("/Users/myry/Documents/MyPythonProject/lernLibs")

# 获取当前路径的文件夹 dir directory
print(os.listdir()) # ['os_tutor', 'lern_pygame', '.DS_Store', 'lern_rembg', 'matplotlib_tutor', 'lern_scipy', 'lern_sympy', '.venv', 'pandas_tutor', 'nympy_tutor', 'lern_manim', 'Signal&System', '.idea']

# 还可以遍历去判断 os.path.isdir() 是否为目录 os.path.isfile() 是否为文件夹
for d in os.listdir():
    print(d, os.path.isdir(d), os.path.isfile(d))
"""
os_tutor True False
lern_pygame True False
.DS_Store False True
lern_rembg True False
matplotlib_tutor True False
lern_scipy True False
lern_sympy True False
.venv True False
pandas_tutor True False
nympy_tutor True False
lern_manim True False
Signal&System True False
.idea True False
"""