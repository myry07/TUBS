//
// Created by 王嘉琪 on 16.03.24.
//

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/**
 * 字符串的地址 其实就是第一个字符的地址
 * helloworld 的地址是 h的地址
 * 可以定义字符指针保存字符串的地址 char *S = "helloworld";
 */

void example() {
    char *str = "I love C";
    //字符只能保存一个四个字节 -> str只是存放了字符I的地址编号 "I love C"存在放了文字常量区
}

/**
* 字符串的三种存储形式
*/

//1. 数组
//   可修改
void methode1() {
    char str[100] = "I love C";//数组长度100 包括结尾 '\0'
    printf("%s\n", str);//I love C
    str[0] = 'U';
    printf("%s\n", str);//U love C
}


//2. 字符指针
//   存放在文字常量区 不可修改
void methode2() {
    char *str = "I love C";
    printf("%s\n", str);
}

//3. 堆区
//   使用malloc函数在堆区申请空间 将字符串拷贝过去
//   可以修改
void methode3() {
    char *str = (char*)malloc(10); //长度为10
    strcpy(str,"I love C");//将"I love C" 拷贝到str
    printf("%s\n", str);
    *str = 'U';
    printf("%s\n", str);
}

int main() {
    methode1();
    methode2();
    methode3();
}