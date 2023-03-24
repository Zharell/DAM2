#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main()
{
        int fd[2];
        char buffer[30];
        pid_t pid;

        pipe(fd); //se crea el pipe
        pid=fork(); // se crea el proceso hijo

        switch(pid) {
                case -1: //ERROR
                        printf("NO SE HA PODIDO CREAR HIJO ... ");
                        exit(-1);
                        break;
                case 0 : //HIJO
                        //sleep(3);
                        printf("Voy a leer el pipe ...\n");
                        //write(fd[1], "Hola papi", 10);
                        read(fd[0],buffer, 10);
                        printf ("\tMensaje leido: %s\n",buffer);
                        break;
                default : //PADRE
                        //sleep(2);
                        //wait(NULL); //espera que finalice proceso hijo
                        printf("Voy a escribir en el pipe ...\n");
                        //read(fd[0], buffer, 10);
                        write(fd[1],"Hola Hijo",10);
                        //printf ("\tMensaje leido: %s\n",buffer);
                        wait(NULL);
                        break;
        }
}