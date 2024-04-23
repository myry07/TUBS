//
// Created by 王嘉琪 on 15.03.24.
//

#include<stdio.h>

typedef struct String String;

int main()
{
    char c = 'a';
    printf("%c\n", c);

    int i = 10;
    printf("%d\n", i);

    float f = 3.14f;
    printf("%f\n", f);

    double d = 20;
    printf("%lf\n", d);

    char* p = "hello world";//指针
    printf("%p\n", p);//打印指针 0x10431bf95
    printf("%s\n", p);//打印字符串 hello world

    /**
     * %3d 左推三格
     * %-3d 右推三格
     */

    int i2 = 6;
    printf("**%3d**\n", i2);//**  6**
    printf("**%-3d**\n", i2);//**6  **
}
