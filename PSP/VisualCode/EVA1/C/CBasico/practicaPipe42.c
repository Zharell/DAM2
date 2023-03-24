#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>

int main(void )
{
        int fd[2];
        int num=0;
        pid_t pid;
        char buffer[80];

        pipe(fd); //creo pipe
        
        pid=fork(); // creo proceso

        while (num!=17) {
            switch(pid) {
                    case -1 : //ERROR
                            printf("NO SE HA PODIDO CREAR HIJO ... " );
                            exit (-1);
                    case 0: //HIJO RECIBE
                            close(fd[1]); //cierra el descriptor de entrada
                            
                            read(fd[0], &buffer, sizeof(buffer));
                            printf("\tEl HIJO recibe algo del pipe : %s\n",buffer);
                            break;
                    default : // PADRE ENVIA
                            close(fd[0]);
                            num = rand() % 21;
                            write(fd[1],&num,sizeof(num)); //escribo en pipeS
                            printf("El PADRE ENVIA MENSAJE AL HIJO ...\n");    
                            //wait(NULL); //espero al proceso hijo
                            break;
            }
        }
        return 0;
}