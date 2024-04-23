//
// Created by 王嘉琪 on 15.03.24.
//

#include<stdio.h>

/*
 * sizeof() 查看变量, 数组，指针占用的内存
 */

int main() {
    char c;
    int i;
    short s;
    double d;
    printf("sizeof(c) = %d\n", sizeof(c));//1
    printf("sizeof(i) = %d\n", sizeof(i));//4
    printf("sizeof(s) = %d\n", sizeof(s));//2
    printf("sizeof(d) = %d\n", sizeof(d));//8
    return 0;
}

