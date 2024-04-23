//
// Created by 王嘉琪 on 17.03.24.
//

/**
 * union 共用体
 * 是几种不同的变量共同占用一段内存的结构
 */

/**
 * 1. 同一内存段可以存放几种不同类型的成员 但每一瞬间只有一种起作用
 * 2. 共用体变量中起作用的成员是最后一次存放的成员
 * 3. 共用体变量的地址和它的各成员的地址是同一地址
 * 4. 共用体变量的初始化 只能为第一个成员赋值
 */

#include <stdio.h>

typedef struct data1 {
    short int i;
    char ch;
    float f;
}DATA1;
DATA1 temp1; //最小占7个字节 2+1+4


typedef union data2 {
    short int i;
    char ch;
    float f;
}DATA2;
DATA2 temp2; //占4个字节 最大的那个是4个字节

int main() {
    printf("%d\n", sizeof(temp1));//8 因为需要内存对齐
    printf("%d\n", sizeof(temp2));//4

    DATA1 d1 = {123,'h',1.2f};
    printf("%d %c %f\n", d1.i, d1.ch, d1.f);//123 h 1.200000
    DATA2 d2 = {123, 'h', 1.2f};
    printf("%d %c %f\n", d2.i, d2.ch, d2.f);//123 { 0.000000
}