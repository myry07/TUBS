//
// Created by 王嘉琪 on 16.03.24.
//


/**
 * 指针的运算
 */

#include <stdio.h>

int main() {
    int a[10];
    int *p, *q;

    p = &a[1];
    q = &a[6];

    if (p < q) {
        printf("p<q\n");//p<q 因为p指向了前面元素 q指向了后面
    } else if (p > q) {
        printf("p>q\n");
    } else {
        printf("p==q\n");
    }

    printf("p-q=%d",q-p);//p-q=5 中间差了5个元素
}