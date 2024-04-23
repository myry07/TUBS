//
// Created by 王嘉琪 on 15.03.24.
//

/**
 * 指针就是一个地址
 * 数据类型 *
 * int* p
 * p是一个指针变量
 *
 * &取地址 *取值
 */

#include<stdio.h>

void s1() {
    int a = 0x1234abcd;
    int *p;//定义指针变量 p
    p = &a;//把a的地址取出来 赋给p
    int num = *p;
    printf("%d\n", num);

    /**
     * 变量a的值是0x1234abcd -> 305441741
     * &a 取出a的地址 是p指向a
     * 那么 p的值 其实也就等于 a的值了
     * *p 取出p的值 赋给num
     * 那么num == p == a
     *
     * 总结
     * 给指针是要赋地址 使其指向 &a
     * 给变量是要赋值 使其用有 *p
     */
}

void s2() {
    int a = 100, b = 200;
    int *p1, *p2 = &b;
    //p1此时未指向 称为野指针 随意指向一个地址
    p1 = &a;
    printf("%d %d\n", *p1, *p2);//100 200
}

void s3() {
    /**
     * 指针大小
     * 32位系统是4字节
     * 本少爷64位 8字节
     */

    char *c;
    short *s;
    int *i;
    long *l;
    float *f;
    double *d;

    printf("%d\n", sizeof(c));
    printf("%d\n", sizeof(s));
    printf("%d\n", sizeof(i));
}

void s4() {
    int a = 0x5678cdef;
    int* p = &a;

    printf("%p\n", &a);//0x16bc873bc
    printf("%p\n",p);//0x16bc873bc

    printf("%d\n", a);//1450757615
    printf("%d\n", *p);//1450757615

}
int main() {
//    s1();
//    s2();
//    s3();
    s4();
}