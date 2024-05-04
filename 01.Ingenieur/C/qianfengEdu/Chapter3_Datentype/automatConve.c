//
// Created by 王嘉琪 on 15.03.24.
//

/**
 * signed 有符号数据类型 默认情况下省略
 * unsigned 无符号数据类型
 */
#include <stdio.h>

int main() {
    int a = -8;
    unsigned int b = 7;
    if (a + b > 0) {
        printf("a+b>0\n");//会自动转型 有符号数->无符号数
    } else {
        printf("a+b<0\n");
    }

    printf("a+b=%d\n", a+b);//转为整数类型是-1 %d是有符号形式的

}
