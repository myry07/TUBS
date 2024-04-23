//
// Created by 王嘉琪 on 16.03.24.
//

#include <stdio.h>
#include <stdlib.h>

/**
* 字符串 转int long flot
 * 类似于 自动装箱
 *
 * int atoi(const char *nptr)
*/

int main() {
    char *str = "123";
    int i = atoi(str);
    printf("%d", i);
}

