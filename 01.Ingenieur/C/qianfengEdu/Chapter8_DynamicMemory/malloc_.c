//
// Created by 王嘉琪 on 16.03.24.
//

/**
 *  malloc Memory ALLOCation
 *  void *malloc(unsigned int size)
 *  在堆区分配长度为size的连续区域 函数原型返回位void*指针
 */

#include <stdio.h>
#include <stdlib.h>

int main() {
    int *p;
    int n;
    printf("请输入要申请的int数组的元素个数\n");
    scanf("%d", &n, 4);//给n赋值 4个字节的整数
    p = (int *) malloc(n * 4);//malloc返回void* 用的时候要转型
                                  //每个元素4个字节 动态申请n*4个空间
    if(p == NULL) {//可能会申请失败 所以需要判断
        printf("malloc error");
    }

    for(int i = 0; i < n;i++) {
        p[i] = i;
    }

    for(int i = 0; i < n; i++) {
        printf("p[%d]=%d\n",i,p[i]);
    }

    free(p);//内存释放
}
