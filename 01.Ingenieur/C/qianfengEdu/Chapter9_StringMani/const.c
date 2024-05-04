//
// Created by 王嘉琪 on 16.03.24.
//

/**
 * const -> final
 * 1. 修饰变量
 *    const int a = 100;
 *    a = 10; 报错
 *    变量无法再被修改
 * 2. 修饰指针
 *    const char *str
 *    指针指向的内存的内容不能通过str修改
 *    但是str可以指向别的地方
 *    也就是 保护了str指向的内容
 *
 * 3. char const *str
 *    str无法指向别的内容
 */

#include <stdio.h>
#include <string.h>

int main() {
    const int a = 100;
//    a = 10;

    char buf[20] = "helloworld";
    const char* str = buf;
//    *str = "wtf";

    char* const st = "hellokitty";
//    st = "wtf";
}