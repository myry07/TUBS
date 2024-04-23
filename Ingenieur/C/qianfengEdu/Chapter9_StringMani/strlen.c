//
// Created by 王嘉琪 on 16.03.24.
//

/**
 * string length 测字符串长度
 * 函数定义: size_t strlen(const char*s)
 */

#include <stdio.h>
#include <string.h>

int main() {
    char* str1 = "hello world!";
    printf("%d\n", strlen(str1));//长度12
    printf("%d\n", sizeof(str1));//容量8 -> 在内存中站多少字节 32位4 64位8

    char str2[20] = "hello";
    printf("%d\n", strlen(str2));//5
    printf("%d\n", sizeof(str2));//20
}