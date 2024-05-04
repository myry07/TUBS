//
// Created by 王嘉琪 on 16.03.24.
//

#include <stdio.h>

/**
 * 结构体数组
 */

typedef struct stu {
    char *name;
    int age;
    char sex;
} STU;

int main() {
    STU edu[3] = {{"tom",  20, 'm'},
                  {"jack", 22, 'm'},
                  {"rose", 30, 'f'}};

    for (int i = 0; i < 3; i++) {
        printf("edu[%d].name=%s edu[%d].age=%d edu[%d].sex=%c\n",
               i, edu[i].name, i, edu[i].age, i, edu[i].sex);
    }
}