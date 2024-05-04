//
// Created by 王嘉琪 on 16.03.24.
//

#include <stdio.h>
#include <string.h>

/**
 * string n compare
 * int strcmp(const char *s1, const char *s2, size_t n)
 * 相同返回0 不同返回ascii码差值
 */

int main() {
    char *str1 = "hello world";
    char *str3 = "hello ketty";

    printf("%d\n", strncmp(str1, str3, 6));//0
    printf("%d\n", strncmp(str1, str3, 7));//12
}