//
// Created by 王嘉琪 on 15.03.24.
//

/**
 * 打印水仙花数
 */
#include<stdio.h>

int main()
{
    for(int i = 100; i < 1000; i++) {
        int num = i, res = 0;
        while (num > 0) {
            res += (num % 10) * (num % 10) * (num % 10);
            num /= 10;
        }

        if(res == i) {
            printf("%d\n", i);
        }
    }
}