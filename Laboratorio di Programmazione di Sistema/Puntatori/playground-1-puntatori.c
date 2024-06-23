#include <stdio.h>

int a = 0x01020304;

unsigned char *p;

int main(void) {
	p = (unsigned char*)&a;
	printf("*(p+0): %p\n", *p);
	printf("*(p+1): %p\n", *(p+1));
	printf("*(p+2): %p\n", *(p+2));
	printf("*(p+3): %p\n", *(p+3));

	printf("\n");

	printf("Puntatore &a: %p - Valore a: %p\n", (void *)p, a);

	*p = 0x01;
	printf("Puntatore &a: %p - Valore a: %p\n", (void *)p, a);

	p++;
	printf("Puntatore &a: %p - Valore a: %p\n", (void *)p, a);

	*p = 0x02;
	printf("Puntatore &a: %p - Valore a: %p\n", (void *)p, a);
	
	p++;
	printf("Puntatore &a: %p - Valore a: %p\n", (void *)p, a);

	*p = 0x03;
	printf("Puntatore &a: %p - Valore a: %p\n", (void *)p, a);

	p++;
	printf("Puntatore &a: %p - Valore a: %p\n", (void *)p, a);

	*p = 0x04;
	printf("Puntatore &a: %p - Valore a: %p\n", (void *)p, a);

	p = p - 3;
	printf("Puntatore &a: %p - Valore a: %p\n", (void *)p, a);
}
