//
// Created by 王嘉琪 on 15.03.24.
//

#include <stdio.h>

/**
 * 指针和变量的关系
 */

void s1() {
    /**
     * 指针可以存放变量的地址编号
     * 变量存放在内存中 有地址编号
     */

    int a = 100;//定义变量a
    int *p;     //定义指针p
    p = &a;     //将a的地址赋给p -> p指向a
    *p = a;     //给p赋值
}

void example1() {
    int *p1,*p2;
    int temp, a, b;

    p1 = &a;
    p2 = &b;

    printf("请输入:a,b的值:\n");
    scanf("%d %d", p1, p2);//p1 p2是指针 直接给它赋值 -> 给它指向的地址赋值

    printf("%d %d\n", p1, p2);//1862775704 1862775700
    printf("%d %d\n", *p1, *p2);//1 2

    temp = *p1;//取p1的值 -> 将p1指向的对象 赋给temp -> temp = a
    *p1 = *p2;//a = b;
    *p2 = temp;
    printf("a=%d b=%d\n", a, b);
    printf("*p1=%d *p2=%d\n", *p1, *p2);
}

void example2() {
    //不同指针相互赋值时 需要强制转换
    int a = 0x12345678, b = 0xabcdef66;
    char *p1, * p2;
    p1 = (char*) &a;
    p2 = (char*) &b;
    printf("%0x %0x\n", *p1, *p2);//78 66
    //因为是int指针以四字节存储的 0x12345678 -> 0x12 0x34 0x56 0x78 取低地址 0x78
    p1++;
    p2++;
    printf("%0x %0x\n", *p1, *p2);//56 ffffffef
}

int main() {
//    example1();
    example2();
}
