//
// Created by 王嘉琪 on 17.03.24.
//


/**
* enumerate 枚举
*/

/**
 * 枚举是常量 无法赋值 monday=1 错误
 * 枚举元素由系统默认编值 从0开始
 * 但是可以改变默认值
 */

#include <stdio.h>

enum week {
    monday,
    tuesday,
    wednesday,
    thursday,
    friday,
    saturday,
    sunday
};

int main() {
    enum week workday;
    workday = friday;
    printf("workday=%d\n", friday);//workday=4
    printf("%d\n", monday);//0
    printf("%d\n", sunday);//6
}