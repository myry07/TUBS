//
// Created by 王嘉琪 on 16.03.24.
//

/**
 * malloc 和 calloc在申请完后再申请 是不连续的
 * 想在原先基础上继续申请 realloc
 *
 * void*realloc(void*s, unsigned int newsize)
 * 在原先的s上重新申请
 */
