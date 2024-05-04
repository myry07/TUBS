//
// Created by 王嘉琪 on 16.03.24.
//

#include <stdio.h>

/**
 * 变量存放在内存中 有地址编号
 * 数组是多个相同类型变量的集合
 */

void example1() {
    int a[5];
    a[2] = 100;
    int *p;
    p = &a[2];
}

//数组元素的引用方法
void methode1() {
    //1. 数组名
    int a[5];
    a[2] = 100;
}

void methode2() {
    //2. 指针名加下标
    int a[5];
    int *p;
    p = a;
    p[2] = 100;//相当于 a[2]=100;
}

void methode3() {
    //3. 通过指针变量运算加取值的方法来引用数组元素
    int a[5];
    int *p;
    p = a;
    *(p+2) = 100;
}

void methode4() {
    //4. 通过数组名+取值的方法引用数组的元素
    int a[5];
    *(a+2) = 100;
}

void example2() {
    int a[5] = {0, 1, 2, 3, 4, 5};
    int *p;
    p = a;
    printf("a[2] = %d\n", a[2]);
    printf("p[2] = %d\n", p[2]);
    printf("*(p+2) = %d\n", *(p+2));
    printf("*(a+2) = %d\n", *(a+2));

    printf("p=%p\n",p);//p=0x16d467390
    printf("p+2=%p\n",p+2);//p+2=0x16d467398
    //刚好差了八个字节 一个指针是四个字节
}

int main() {
    example2();
}


