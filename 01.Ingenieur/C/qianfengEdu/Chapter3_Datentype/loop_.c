//
// Created by 王嘉琪 on 15.03.24.
//

#include <stdio.h>

void if_()
{
    float score;
    printf("please input a score:\n");
    scanf("%f",&score);//&取地址的意思 ->输入的 %f 保存在了 score

    if(score < 0 || score > 100) {
        printf("error");
    } else if (score < 50) {
        printf("5.0");
    } else if (score < 60) {
        printf("4.0");
    }
}

void switch_()
{
    int num;
    scanf("%d", &num);
    switch(num){//只能是short int, int, long int
        case 1:
            printf("Monday");
            break;
        case 2:
            printf("Tuesday");
            break;
        default:
            printf("Error");
    }
}

void for_()
{
    //99乘法表
    for(int i = 1; i <= 9; i++) {
        for(int j = 1; j <= i; j++) {
            printf("%d * %d = %d  ", i, j, i*j);
        }
        printf("\n");
    }
}

void while_()
{
    int i = 10;
    while(i > 0)
    {
        printf("%d\n", i--);
    }
}

int main() {
//    if_();
//    switch_();
//      for_();
      while_();
}