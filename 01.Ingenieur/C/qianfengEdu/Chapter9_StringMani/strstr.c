//
// Created by 王嘉琪 on 16.03.24.
//

/**
* string string
* 字符串中找字符串
* char *strstr(const char *haystack, const char *needle);
* 在haystack 中查找 needle 也是首次匹配
*/

#include <stdio.h>
#include <string.h>

int main() {
    char *str = "hello world";
    char *p = strstr(str, "llo");//指针之间做减法
    printf("%d\n", p-str);//2

}