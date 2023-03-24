#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#define LECTURA 0
#define ESCRITURA 1

void main () {
    
    pid_t pid;
    int tuberia[2];
    int numAle=0,suma=0;

    //Aleatoriedad
    srand(time(NULL));
    
    pipe(tuberia);
    pid =fork();
           
    switch (pid) {
        case -1:
            printf("Error en la creacion del proceso");

        break;
        case 0:
            
            while(numAle!=17){
                read(tuberia[LECTURA],&numAle,sizeof(numAle));
                printf("\n Numero aleatorio recibido: %d",numAle);
                suma+=numAle;
            }
            close(tuberia[LECTURA]);
            write(tuberia[ESCRITURA],&suma,sizeof(suma));
        break;
        default:
            
            while (numAle!=17) {
                numAle = rand()%21-1;
                write(tuberia[ESCRITURA], &numAle,sizeof(numAle));
            }
            close(tuberia[ESCRITURA]);
            wait(NULL);
            read(tuberia[LECTURA],&numAle,sizeof(numAle));
            printf("\nEl padre ha recibido el total sumado: %d",numAle);
        break;
    }
}