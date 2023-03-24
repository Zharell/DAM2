#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>

int main (void) {
    
    int fd[2];
    int num;
    pid_t pid;

    pipe(fd);
    pid=fork();
   //num = rand() % 21;
    int suma=0;
   
        switch(pid) {
            case -1:
                printf("ERROR EN CREACIÓN HIJO");
                exit(-1);
            break;
            case 0:
                close(fd[1]);
                do {
                    read(fd[0],&num,sizeof(num));
                    printf("Hijo recibe número del padre: %d \n",num);
                    suma+=num;
                    } while (num!=17);
            break;
            default:
                close(fd[0]);
                srand(time(0));
                 while (num!=17) {
                    num = rand() % 21;
                    printf("quechaval %d",num);
                    write(fd[1],&num,sizeof(num));
                    //printf("Padre envía número al hijo %d \n",num);
                 }
                 //wait();
            break;
        }
    
    printf("El total sumado por el hijo es %d",suma);

}