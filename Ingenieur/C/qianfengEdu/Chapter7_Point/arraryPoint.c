//
// Created by 王嘉琪 on 16.03.24.
//

/**
 * 数组指针 是一个指针
 * 与指针数组不同 那是数组
 */

#include <stdio.h>

void example() {
    int a[3][5];
    int b[6][5];
    int (*p)[5]; // 一定要有括号 不然就变成数组指针了
    p = a;//指向a的行数

    printf("a=%p\n", a);
    printf("a+1=%p\n", a+1);

    printf("p=%p\n", p);
    printf("p+1=%p\n", p+1);

    /**
     * a=0x16b21337c
     * a+1=0x16b213390
     * p=0x16b21337c
     * p+1=0x16b213390
     */
}

//使用数组指针指向二维数组 并确定行列 去修改
void func(int (*p)[3], int x, int y) {
    p[x][y] = 1000;
}

int main() {
    example();

    int a[3][3] = {{1, 2, 3},
                   {4, 5, 6},
                   {7, 8, 9}};

    printf("a[1][2] = %d\n", a[1][2]);//a[1][2] = 6
    a[1][2] = 100;
    printf("a[1][2] = %d\n", a[1][2]);//a[1][2] = 100
    func(a,1, 2);
    printf("a[1][2] = %d\n", a[1][2]);//a[1][2] = 1000
}