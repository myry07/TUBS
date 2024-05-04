//
// Created by 王嘉琪 on 16.03.24.
//

#include <stdio.h>

//argc 参数的个数
//argv 指针数组的首地址
int main(int argc, char *argv[]) {
    printf("argc=%d\n", argc);
    for(int i = 0; i < argc; i++) {
        printf("argv[%d]=%s\n",i,argv[i]);
    }
    /*
     * 第一行是exe文件名字
     * /Users/myry/Documents/MyCProject/qianfengEdu/mainWithPara aaa bbb ccc ddd eee
     * argc=6
        argv[0]=/Users/myry/Documents/MyCProject/qianfengEdu/mainWithPara
        argv[1]=aaa
        argv[2]=bbb
        argv[3]=ccc
        argv[4]=ddd
        argv[5]=eee

     */
}
