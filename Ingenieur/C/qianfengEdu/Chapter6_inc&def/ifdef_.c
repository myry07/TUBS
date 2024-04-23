//
// Created by 王嘉琪 on 15.03.24.
//

/**
 * 预处理三 选择性编译
 * #ifdef AAA
 *    代码一段
 * #else
 *    代码二段
 * #endif
 */

//如果在ifdef上边定义过宏 AAA 那么就编译代码段1 否则代码段2

#include<stdio.h>

void s1() {
#ifdef AAA
    printf("hello world\n");
#else
    printf("hello China\n");//hello China
#endif
}

void s2() {
#define AAA 3
#ifdef AAA
    printf("hello world\n");//hello world
#else
    printf("hello China\n");
#endif
}

/**
 * #ifndef AAA -> 如果没有定义AAA 与ifdef互补
 *    代码一段
 * #else
 *    代码二段
 * #endif
 */

void s3() {
#ifndef AAA
    printf("hello world\n");
#else
    printf("hello China\n");//hello China
#endif
}

/**
 * #if 表达式
 *   程序段一
 * #else
 *   程序段二
 * #endif
 */

#define A 0 // 1为真 0为假
void s4() {
//#if 0
#if A
    printf("hello world\n");
#else
    printf("hello China\n");
#endif
}


int main() {
    s1();
    s2();
    s4();
}
