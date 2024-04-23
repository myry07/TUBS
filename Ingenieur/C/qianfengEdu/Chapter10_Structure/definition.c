//
// Created by 王嘉琪 on 16.03.24.
//

/*
 * java中的类
 */

//1. 定义结构体 然后定义变量
struct student1 {
    char name[20];
    int age;
    char sex;
};

struct student1 jack1, lucy1;

//2. 定义结构体顺便定义变量
struct student2 {
    char name[20];
    int age;
    char sex;
}jack2,lucy2;

//3. 不喊结构体名
struct {
    char name[20];
    int age;
    char sex;
};

//4. 配合typedef
typedef int JQ16;//利用typedef 将某个数据类型名进行更改 同样适用于结构体
typedef struct student {
    char name[20];
    int age;
    char sex;
}STU;//struct student -> STU

//好处
struct student s1;
STU s2;
//二者等价 只是不用再写struct


