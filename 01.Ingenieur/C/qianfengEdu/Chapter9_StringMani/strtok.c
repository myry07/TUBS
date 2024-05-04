//
// Created by 王嘉琪 on 16.03.24.
//

/**
 * strtok 字符串切割
 * char *strtok(char *str, const char *delim)
 * 返回的是指针字符串
 * str中出现delim 就切割delim 变成 \0
 */

#include <stdio.h>
#include <string.h>

int main() {
    char str[100] = "xiaoming;21;男;北京;海淀;";
    char *s = ";";
    char *p[5];
    printf("%s\n", str);//xiaoming;21;男;北京;海淀;
    p[0] = strtok(str, s);
    printf("%s\n", str);//xiaoming
    printf("%s\n", p[0]);//xiaoming

//    p[1] = strtok(NULL, s);
//    printf("%s\n", p[1]);//xiaoming

    int i = 0;
    while(p[i] != NULL) {
        i++;
        p[i] = strtok(NULL, s);//这样的strtok含有记忆功能 会把之前切剩下的传入
        printf("%s\n", p[i]);//xiaoming
    }

}