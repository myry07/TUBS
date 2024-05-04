//
// Created by 王嘉琪 on 16.03.24.
//

#include <stdio.h>

/**
* 若想保存n个地址 -> 定义指针数组
*/

void example() {
    int *p[5];
    int a;
    p[0] = &a;
    int b[10];
    p[1] = &b[5];
}

void example2() {
    char *name[5] = {"hello", "China", "Beijing", "project", "Computer"};
    for(int i = 0; i< 5; i++) {
        printf("%s\n", name[i]);
    }
}


int main() {
    example2();
}
