#include <stdio.h> 
#include <stdlib.h> 
#include <string.h> 

void main(void) { 

    char saludo[] = "Un saludo!!! \n";

    char buffer[10];

    int path, bytesleidos; 

    system("touch texto.txt");

    path=open("texto.txt",1) ;//abro mi fichero con open("mifichero", 0 para lectura, 1 para escritura, 2 para lectura y escritura) 

    if( path== -1){
    //-1 da error
        printf ("ERROR AL ABRIR EL FICHERO ... \n"); 
        exit(-1);

    }

    printf("Escribo el saludo ... \n");
    //como path ahora mismo está abierto con(1)"escritura" utilizo 
    write(path,saludo,strleng(saludo));

    // write(path,saludo,strlen(saludo); strlen devuelve el tamaño de una string para escribir necesitamos darle el tamaño de lo que escribiremos

    // podría usar un número write(path,saludo,10);
    close(path); //cierro el fichero 

    path=open("texto.txt",0);

     //abro el fichero para leer lo

    printf("Contenido del Fichero: \n"); 

    //leo bytes de uno en uno y lo guardo en buffer 

    bytesleidos = read(path, buffer,1); 

    while (bytesleidos!=0){

        printf("%s", buffer); //pinto el byte leido 

        bytesleidos = read(path, buffer, 1) ;//leo otro _byte

    }

    close(path);

}
