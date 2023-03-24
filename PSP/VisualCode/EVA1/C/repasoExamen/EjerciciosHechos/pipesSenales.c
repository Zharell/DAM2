#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
#include <signal.h>
#define LECTURA 0
#define ESCRITURA 1

void main(){
    
    pid_t pid;

    int tuberia[2];

    int num=0,suma=0;

    srand(time(NULL));

    pipe(tuberia);

    pid=fork();

    switch(pid) {
        case -1:
            printf("No se ha podido crear el hijo");
        break;
        case 0:
            //HIJO
            close(tuberia[LECTURA]);
            do {
                num = rand() %10;
                printf("\n Envio aleatorio a padre: %d",num);
                write(tuberia[ESCRITURA],&num,sizeof(num));
            } while(1);
        break;
        default:
            do {
                close(tuberia[ESCRITURA]);
                read(tuberia[LECTURA],&num,sizeof(num));
                printf("\n El padre recibe: %d",num);
                suma+=num;
            } while(num!=0);
            kill(pid,9);
            printf("\n El padre tiene un total de suma de: %d",suma);
            printf("\n He matado al hijo, Diablo");
        
        break;
    };

}


