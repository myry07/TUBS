//
// Created by 王嘉琪 on 15.03.24.
//

#include <stdio.h>
/**
 * goto -> 跳转
 * temp: -> 标签
 * @return
 */

int main()
{
    printf("a");
    goto temp;
    printf("b");
    printf("c");
    printf("d");
    temp://标签
    printf("e");
    printf("f");
}