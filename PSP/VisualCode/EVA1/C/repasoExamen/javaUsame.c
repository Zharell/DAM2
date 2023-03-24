#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
#define LECTURA 0
#define ESCRITURA 1

main (void)
{   
    //variable pid_t
    pid_t pid;
    //Crea array que sera la tuberia
    int tuberia[2];

    srand(time(NULL));

    //Activa la tuberia
    pipe(tuberia);
    
    //se realiza la creacion del hijo
    pid=fork();

    switch(pid) {
        case -1:
            printf("No se ha creado el hijo");
            exit(-1);
        case 0:
            int numA,numB,sum=0;

            //Recibe valorA
            read(tuberia[LECTURA],&numA,sizeof(numA));
            printf("\nHijo ha recibido: %d",numA);
            //Recibe valorB
            read(tuberia[LECTURA],&numB,sizeof(numB));
            printf("\nHijo ha recibido: %d",numB);
            //Realiza la operacion
            sum=numA+numB;

            //Cierra tuberia despues de recibir
            close(tuberia[LECTURA]);

            printf("\nHijo devuelve suma: %d\n",sum);
            write(tuberia[ESCRITURA],&sum,sizeof(sum));

            //Cierra tuberia despues de enviar
            close(tuberia[ESCRITURA]);

        break;
        default:
            int numAP,numBP,sumP;

            //Primer valor enviado
            
            numAP= rand() %100;
            write(tuberia[ESCRITURA],&numAP,sizeof(numAP));

            //Segundo valor enviado
            
            numBP= rand()%100;
            
            write(tuberia[ESCRITURA],&numBP,sizeof(numBP));
            
            //Cierra tuberia despues de escribir
            close(tuberia[ESCRITURA]);

            //Espera a que termine el hijo
            wait(NULL);

            read(tuberia[LECTURA],&sumP,sizeof(sumP));
            //Cierra tuberia despues de leer
            close(tuberia[LECTURA]);
            printf("\nPadre tras sumar es: %d",sumP);
            
        break;
    }
}
