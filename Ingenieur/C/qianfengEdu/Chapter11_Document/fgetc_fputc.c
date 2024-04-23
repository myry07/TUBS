//
// Created by 王嘉琪 on 17.03.24.
//

/**
 * 文件的读写 可读单个字符 也可以读字符串
 * int fgetc(FILE* stream)
 * 从stream所标识的文件中读取一个字节 并返回
 *
 * int fputc(int c, FILE* stream)
 * 将c的值 写到stream所代表的文件中
 */

#include <stdio.h>

int main() {
    FILE *fp1, *fp2;
    char c;
    fp1 = fopen("/Users/myry/Documents/MyCProject/qianfengEdu/test", "r");
    if (fp1 == NULL) {
        perror("fopen");
        return 0;
    }

    fp2 = fopen("/Users/myry/Documents/MyCProject/qianfengEdu/test2", "w");


    while ((c = fgetc(fp1)) != EOF) {//EOF 文件末尾
//        printf("%c", c);
//        fputc(c, stdout);//二者都行

        fputc(c, fp2);//将fp1中读取的字节 写入到fp2
    }
    fclose(fp1);
    fclose(fp2);
}