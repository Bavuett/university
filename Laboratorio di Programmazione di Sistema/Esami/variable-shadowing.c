#include <stdio.h>

short v1 = 10;

void leaf() {
    printf("v1 di leaf: %p\n", &v1);
}

void fun() {
    long v1;

    printf("v1 di fun: %p\n", &v1);

    leaf();
}

int main(void) {
    printf("v1 di main: %p\n", &v1);

    fun();

    printf("v1 di main: %p\n", &v1);
}