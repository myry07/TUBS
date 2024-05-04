//
// Created by 王嘉琪 on 16.03.24.
//

#include <stdio.h>

//1. 保存结构体变量的地址
typedef struct stu {
    char *name;
    int age;
    char sex;
} STU;

//2. 给函数传结构体地址 -> 被调用的函数行参必须是 结构体指针
void func1(STU *p, char* name) {
    p->name=name;
}

//3. 传结构体数组的地址
//   结构体数组的地址 其实就是第0个变量的地址
void func2(STU *p, int len) {
    for(int i = 0; i < len; i++) {
        printf("%s\n", p[i].name);
    }
}

int main() {
    //1.
    STU *p, s1;//定义一个结构体指针 和 结构体变量
    p = &s1;
    p->name="lucy";
    printf("%s\n", s1.name);//lucy

    //2.
    STU s2;
    func1(&s2, "jack");
    printf("%s\n", s2.name);//jack


    //3.
    STU edu[3] = {{"tom",  20, 'm'},
                  {"jack", 22, 'm'},
                  {"rose", 30, 'f'}};
    func2(edu, 3);
}
