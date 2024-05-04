//
// Created by 王嘉琪 on 15.03.24.
//

/**
 * typedef 可以定义出来新的类型名
 * 1. 想起名类型 比如int
 * 2. 自定义类型名字 比如 JQ15
 * 3. typedef int JQ15
*/

#include <stdio.h>

typedef int JQ15;
int main() {
    double a = 15;
    JQ15 b = 17;
    printf("%f %d", a, b);
}