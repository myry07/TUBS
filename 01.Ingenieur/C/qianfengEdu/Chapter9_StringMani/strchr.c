//
// Created by 王嘉琪 on 16.03.24.
//

/**
 * string char
 * strchr 字符串中找字符 返回首次找到的位置
 * char *strchr(const char *s,int c) 返回值是指针
 *
 * strrchr 返回末次找到的位置
*/

#include <stdio.h>
#include <string.h>

int main() {
    char *str = "hello world";
    char *p = strchr(str, 'l');//指针之间做减法
    printf("%d\n", p-str);

    char *q = strrchr(str, 'l');
    printf("%d\n", q-str);//9
}