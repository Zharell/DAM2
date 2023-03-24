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

            //Recibe valorB
            read(tuberia[LECTURA],&numB,sizeof(numB));

            //Realiza la operacion
            sum=numA+numB;

            //Cierra tuberia despues de recibir
            close(tuberia[LECTURA]);

            write(tuberia[ESCRITURA],&sum,sizeof(sum));

            //Cierra tuberia despues de enviar
            close(tuberia[ESCRITURA]);

        break;
        default:
            int numAP,numBP,sumP;

            //Primer valor enviado
            printf("Introduce valor A: ");
            scanf("%d",&numAP);
            write(tuberia[ESCRITURA],&numAP,sizeof(numAP));

            //Segundo valor enviado
            printf("Introduce valor B: ");
            scanf("%d",&numBP);
            write(tuberia[ESCRITURA],&numBP,sizeof(numBP));
            
            //Cierra tuberia despues de escribir
            close(tuberia[ESCRITURA]);

            //Espera a que termine el hijo
            wait(NULL);

            read(tuberia[LECTURA],&sumP,sizeof(sumP));

            //Cierra tuberia despues de leer
            close(tuberia[LECTURA]);

            //Muestra el resultado de la suma
            printf("Padre tras sumar es: %d",sumP);
            
            wait(NULL);
        break;
    }
}
