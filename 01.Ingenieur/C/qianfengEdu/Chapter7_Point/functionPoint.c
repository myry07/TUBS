//
// Created by 王嘉琪 on 16.03.24.
//

#include <stdio.h>

/**
* 运行程序时 会将函数的指令加载到内存的代码段 所以函数也有起始地址
 * 函数的名字就是函数的首地址 可以定义指针变量来存放函数地址
*/

int max(int x, int y) {
    if (x > y) {
        return x;
    } else {
        return y;
    }
}

//2.
int min(int x, int y) {
    if (x < y) {
        return x;
    } else {
        return y;
    }
}


int sub(int x, int y) {
    return x - y;
}

int mux(int x, int y) {
    return x * y;
}

int process(int(*p)(int,int), int x, int y){//函数指针 传入函数地址
    return p(x, y);
}


int main() {
    int (*p)(int, int);
    int num;
    //1. 通过函数的名字去调用函数
    num = max(2, 3);
    printf("%d\n", num);

    //2. 通过函数指针调用函数
    p = min;
    num = (*p)(2, 3);//可以加* 也可不加
    printf("%d\n", num);

    printf("%d\n", process(sub, 7,5));
    printf("%d\n", process(mux, 7,5));

}