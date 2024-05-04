//
// Created by 王嘉琪 on 16.03.24.
//

/**
 * string n catch 追加src指向的字符串前的第n个字符
 * 追加到 \0
 */

#include <stdio.h>
#include <string.h>

int main() {
    char str1[100] = "123\0aa6789";
    char *str2 = "hello";
    printf("%s\n", str1);//123
    strncat(str1, str2, 2);
    printf("%s\n", str1);//123he
}