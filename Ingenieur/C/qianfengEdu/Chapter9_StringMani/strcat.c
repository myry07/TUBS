//
// Created by 王嘉琪 on 16.03.24.
//

/**
 * string catch 字符串追加函数
 * char *strcat(cahr *dest, const char *src)
 * 将scr字符串追加到dest后面 同样要保证dest指向的空间足够大
 * 追加的时候 追加到 '\0'
*/

#include <stdio.h>
#include <string.h>

int main() {
    char str1[100] = "123\0aa6789";
    char *str2 = "hello";
    printf("%s\n", str1);//123
    strcat(str1, str2);
    printf("%s\n", str1);//123hello
}