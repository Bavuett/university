#include <pthread.h>
#include <stdio.h>

long job(int i) {
    if (i < 0) return -1;

    if (i == 0) return 0;
    else if (i == 1) return 1;
    else return job(i - 1) + job(i - 2);
}

void *thr_job(void *arg) {
    long res = job((int) arg);

    printf("Job done! Response: %ld\n", res);

    return ((void * ) res);
}

int main(void) {
    int err;
    pthread_t tid1, tid2;
    void *tret1, *tret2;

    err = pthread_create(&tid1, NULL, thr_job, (void *) 8);
    if (err != 0) printf("Couldn't create thread 1");

    err = pthread_create(&tid2, NULL, thr_job, (void *) 44);
    if (err != 0) printf("Couldn't create thread 2");

    err = pthread_join(tid1, &tret1);
    if (err != 0) printf("Can't join with thread 1");
    else printf("First thread joined.\n");

    err = pthread_join(tid2, &tret2);
    if (err != 0) printf("Can't join with thread 2");
    else printf("Second thread joined.\n");

    printf("Final result %ld\n", (long) tret1 + (long) tret2);
}