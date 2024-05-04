//
// Created by 王嘉琪 on 17.03.24.
//

/**
 * FILE* fopen(const char* path, const char* mode)
 * fopen函数的功能是打开一个已经存在的文件 并返回该文件的指针
 * 或者创建一个文件并打开 然后返回文件的标识
 *
 * 1. 绝对路径 "D:\\demo\\test\\aaa.txt"
 * 2. 相对路径 ".\\test\\aaa.txt"
 */


/**
 * 读写权限
 * r 只读方式
 * w 只写方式
 * a 追加方式
 * + 同时读写
 */


/**
 * int fclose(FILE* fp)
 * 成功返回0  失败非0
 */

#include<stdio.h>

int main() {
    FILE* fp1;
    fp1 = fopen("/Users/myry/Documents/MyCProject/qianfengEdu/test", "r+");
    if(fp1 == NULL) {
        printf("error\n");
        perror("fopen");
    } else {
        printf("success\n");
    }
    if(fclose(fp1) == 0) {
        printf("success\n");
    } else {
        printf("error\n");
    }
}