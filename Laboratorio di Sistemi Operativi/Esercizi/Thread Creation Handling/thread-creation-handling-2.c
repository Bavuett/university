#include <pthread.h>
#include <stdio.h>

typedef struct {
    int *ar;
    int n;
} subarray;

void *incrsum(void *arg) {
    for (int i = 0; i < ((subarray *) arg)->n; i++) {
        ((subarray *) arg)->ar[i] = ((subarray *) arg)->ar[i] + i;
    }
}

int main(void) {
    int ar[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, err, i;
    pthread_t th1, th2;
    subarray sb1, sb2;

    sb1.ar = &ar[0];
    sb1.n = 5;

    (void) pthread_create(&th1, NULL, incrsum, &sb1);

    sb2.ar = &ar[5];
    sb2.n = 9;

    (void) pthread_create(&th2, NULL, incrsum, &sb2);

    err = pthread_join(th1, NULL);
    if (err != 0) printf("Can't join with thread 1");
    else printf("First thread joined!\n");

    err = pthread_join(th2, NULL);
    if (err != 0) printf("Can't join with thread 2");
    else printf("Second thread joined!\n");

    for (int i = 0; i < 10; i++) {
        printf("%d\n", ar[i]);
    }

    return 0;
}