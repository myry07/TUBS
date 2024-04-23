//
// Created by 王嘉琪 on 16.03.24.
//

#include <stdio.h>
#include <string.h>

/**
 * string compare
 * int strcmp(const char *s1, const char *s2)
 * 相同返回0
 */

int main() {
    char *str1 = "hello";
    char *str2 = "hallo";
    char *str3 = "hello";

    printf("%d\n", strcmp(str1, str2));//4
    printf("%d\n", strcmp(str1, str3));//0
}
