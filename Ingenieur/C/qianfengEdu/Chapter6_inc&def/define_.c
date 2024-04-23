//
// Created by 王嘉琪 on 15.03.24.
//


/**
 * 预处理二 define
 * define -> 定义宏
 */
#include <stdio.h>

#define PI 3.14

/**
 * 1. 不带参的宏 类似于全局变量
 * #define PI 3.14
 * PI 是宏的名字 建议大写
 *
 * #undef 终止宏的定义
 */
void def1() {
    double d;
    printf("PI=%lf\n", PI);//PI=3.140000
    d = PI;
    printf("d=%lf\n",d);//d=3.140000
}

/**
 * 2. 带参的宏 类似于函数 但是完全是两种东西
 * #define S(a,b) a*b
 * S是宏的名字, ab是参数 a*b是字符串
 * S(2,4) -> 2*4
 */

#define S(a,b) a*b
#define P(a,b) a+b
void def2()
{
    int a = 2, b = 4;
    int num = S(2,4);//8
    printf("%d\n",num);
    printf("%d\n", P(2,3));//5

}


int main() {
//    def1();
    def2();
}