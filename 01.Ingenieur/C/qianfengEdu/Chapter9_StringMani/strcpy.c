//
// Created by 王嘉琪 on 16.03.24.
//

/**
 * string copy 字符串拷贝 拷贝'\0'
 * 函数定义: char *strcpy(char*dest, const char*str)
 * 将src指向的字符串 拷贝到dest指针指向 的内存中
 */

#include <stdio.h>
#include <string.h>

int main() {
    char str[100] = "123456789";
    printf("%s\n", str);//123456789
    strcpy(str,"hello");
    printf("%s\n", str);//hello
    printf("%s\n", str+6);//789

    //所以 str要足够大 可以被dest覆盖才行
}