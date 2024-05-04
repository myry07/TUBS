//
// Created by 王嘉琪 on 16.03.24.
//

/**
 * 结构体变量存放在内存中 也有起始地址
 * 可以定义一个指针变量来存放该地址
 *
 * struct 结构体名 * 指针名
 */

#include <stdio.h>

typedef struct stu {
    char *name;
    int age;
    char sex;
} STU;

int main() {
    struct stu* p;
    struct stu boy;
    p = &boy;//得到boy的地址 赋给p
    boy.name = "jack";
    boy.age = 20;
    boy.sex = 'm';

    /*
     * 现在访问结构体变量成员的方法有三种了
     * 1. boy.name   结构体名+成员名
     * 2. (*p).name  *p 相当于 p指向的变量boy
     * 3. p->name    指针->成员名
     */

    printf("boy.name=%s\n", boy.name);
    printf("(*p).name=%s\n", (*p).name);
    printf("p->name=%s\n", p->name);

}
