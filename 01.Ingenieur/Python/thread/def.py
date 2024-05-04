"""
1. 导入线程模块
   import threading

2. 创建子线程并指定执行的任务
   sub_thread = threading.Thread(target=)

3. 开启线程
   sub_thread.start()
"""

import threading
import time

def sing():
    for i in range(3):
        print("唱歌", i)
        time.sleep(1)
def dance():
    for i in range(3):
        print("跳舞", i)
        time.sleep(1)

# if __name__ == '__main__':
#     sing()
#     dance()
# """
# 唱歌 0
# 唱歌 1
# 唱歌 2
# 跳舞 0
# 跳舞 1
# 跳舞 2
# -> 依次执行的
# """

if __name__ == '__main__':
    t1 = threading.Thread(target=sing)
    t2 = threading.Thread(target=dance)
    t1.start()
    t2.start()

"""
唱歌 跳舞0
 0
唱歌 1
跳舞 1
唱歌 2
跳舞 2
同时执行
"""