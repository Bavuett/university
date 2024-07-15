#include <stdio.h>

unsigned char vettore[8] = {4, 12, 8, [5] = 20, 41}, c;

int main(void) {
    printf("%d", sizeof(vettore)); 
}