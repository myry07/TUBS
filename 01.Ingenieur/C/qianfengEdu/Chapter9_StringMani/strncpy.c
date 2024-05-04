//
// Created by 王嘉琪 on 16.03.24.
//

/**
 * string n copy
 * 将src指向的字符串前n个字节 拷贝到dest指向的内存中
 * 不拷贝 '\0'
 */

#include <stdio.h>
#include <string.h>

int main() {
    char str[100] = "123456789";
    printf("%s\n", str);//123456789
    strncpy(str,"hello", 2);
    printf("%s\n", str);//he3456789 he后面无'\0'
    printf("%s\n", str+6);//789
    //所以 str要足够大 可以被dest覆盖才行
}