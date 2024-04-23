//
// Created by 王嘉琪 on 16.03.24.
//

/**
 * memory set
 * void *memset(void *ptr, int value, size_t num)
 * 将ptr指向的内存空间的num个字节 全部赋值位value参数
 * ptr 指向任意类型的指针 即指向外面需要修改的内存
 * value 给ptr所指向的内存空间赋的值
 * num 确定将ptr所指的内存中的num个字节 全部用value代替
 *
 * 返回值 ptr的值 -> 内存的首地址
 */

#include <stdio.h>
#include <string.h>

int main() {
    char str[100] = "helloworld";//用数组 指针无法被修改
    printf("%s\n", str);//helloworld
    memset(str, 'a',2);//前两个字节 变成a
    printf("%s\n", str);//aalloworld
}