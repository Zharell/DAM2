#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

void main(){

    pid_t pid;
    
    int tuberia[2];

    pipe(tuberia);

    pid=fork();

    srand(time(NULL));


    int num=0,suma=0;

    switch(pid) {
        case -1:
            printf("No ha podido crear el hijo");
        break;
        case 0:
        //hijo
            
            while (num!=17) {
                read(tuberia[0],&num,sizeof(num));
                printf("\nHe recibido de mi padre %d",num);
                suma+=num;
            }
            write(tuberia[1],&suma,sizeof(suma));
            close(tuberia[1]);

        break;
        default:
        //padre
            
            while (num!=17) {
                num = rand() %21;
                write(tuberia[1],&num,sizeof(num));
                printf("\nHe enviado a mi hijo %d",num);
            }
            wait(NULL);
            
            read(tuberia[0],&num,sizeof(num));
            close(tuberia[0]);
            //wait(NULL);
            printf("\nMi hijo me ha mandado: %d",num);
        break;
    }




};