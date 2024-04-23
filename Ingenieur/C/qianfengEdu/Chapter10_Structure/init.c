//
// Created by 王嘉琪 on 16.03.24.
//

#include <stdio.h>
#include <string.h>

struct student {
    char name[20];
    int age;
    char sex;
    char* addr;
};

int main() {
    struct student s1;
//    s1.name = "jack"; 这是错误的 name[20]是首地址 是个常量
//    char* name;
//    指针的话 直接赋值就行
     strcpy(s1.name, "jack");
     s1.age = 22;
     s1.sex = 'm';
     s1.addr = "shanghai";
    struct student s2 = {"rose", 20, 'f', "beijing"};

    printf("s1.name=%s s1.age=%d s1.sex=%c s1.addr=%s\n",s1.name,s1.age,s1.sex,s1.addr);
    printf("s2.name=%s s2.age=%d s2.sex=%c s2.addr=%s\n",s2.name,s2.age,s2.sex,s2.addr);
}


