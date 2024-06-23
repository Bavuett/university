#include <stdio.h>

int main(void) {
	printf("%s", "Prova\n");

	char c[] = "Ciao", *p;

	p = c;
	
	printf("%s - %p\n", p, (void *)p);

	while (*p != '\0') {
		p++;
	}

	printf("%s - %p\n", c, (void *)p);

	*p = '!';

	p++;

	*p = '\0';

	printf("%s - %p\n", c, (void *)p);

	// c++
	// *c = '\0';
}
