#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>

int main(void )
{
        int fd[2],fd2[2],fd3[2];
        pid_t pid;
        char saludoPadre[]="Buenos dias hijo.\0";
        char saludoHijo[]="Buenos días papa \0";
        char mensaje3[]="No se si funcione 2 veces... \0";
        char buffer[80];
        char bufferPadre[80];

        pipe(fd); //creo pipe
        pipe(fd2);
        pid=fork(); // creo proceso

        switch(pid) {
                case -1 : //ERROR
                        printf("NO SE HA PODIDO CREAR HIJO ... " );
                        exit (-1);
                case 0: //HIJO RECIBE
                        close(fd[1]); //cierra el descriptor de entrada
                        close(fd2[0]);
                        for (int i = 0;i<3;i++){
                        write(fd2[1],saludoHijo,strlen(saludoHijo));
                        //printf("El hijo ENVIA MENSAJE AL padre ...\n");
                        read(fd[0], buffer, sizeof(buffer));
                        printf("\tEl HIJO recibe algo del pipe : %s\n",buffer);
                        }
                        break;
                default : // PADRE ENVIA
                        close(fd[0]);
                        close(fd2[1]);
                        for (int i=0;i<3;i++){
                        write(fd[1],saludoPadre,strlen(saludoPadre)); //escribo en pipeS
                        read(fd2[0], bufferPadre, sizeof(bufferPadre));
                        //printf("El PADRE ENVIA MENSAJE AL HIJO ...\n");
                        printf("\tEl padre recibe algo del pipe : %s\n",bufferPadre);
                        }
                        wait(NULL); //espero al proceso hijo
                        break;
        }
        return 0;
}