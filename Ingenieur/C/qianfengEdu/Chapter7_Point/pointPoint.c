//
// Created by 王嘉琪 on 16.03.24.
//

/**
 * 指针的指针
 */

#include <stdio.h>

int main() {
    int a = 0x12345678;
    int *p;
    int **q;
    int ***m;
    p = &a;
    q = &p;
    m = &q;


    printf("&a = %p\n", &a);//&a = 0x16f3773bc
    printf("p = %p\n", p);//p = 0x16f3773bc

    printf("&p = %p\n", &p);//&p = 0x16f3773b0
    printf("q = %p\n", q);//q = 0x16f3773b0

    printf("&q = %p\n", &q);//&q = 0x16f3773a8
    printf("m = %p\n", m);//m = 0x16f3773a8

    printf("a = %d\n", a);//a = 305419896
    printf("*p = %d\n", *p);//*p = 305419896
    printf("**q = %d\n", **q);//**q = 305419896
    printf("***m = %d\n", ***m);//***m = 305419896

}