//
// Created by 王嘉琪 on 15.03.24.
//

#include<stdio.h>
/*
 * void -> 函数没有返回值或者没有传参
 */

int fun1(int a, int b) {
    return a + b;
}

void fun2(int a, int b) {
    printf("a + b = %d", a+b);
}

void fun3(void) {
    printf("a + b");
}

int main() {
    int a = 10;
    int b = 20;
    printf("%d\n", fun1(a, b));
    fun2(a, b);
    printf("\n");
    fun3();
    return 0;
}