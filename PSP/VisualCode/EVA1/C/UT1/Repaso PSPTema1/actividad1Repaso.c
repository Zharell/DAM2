#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>

void main() {
    pid_t process;
    process = fork();
    int valor = 6;
    
    if (process == -1) {
        printf("No se ha podido crear el hijo");
    }
    if (process == 0) {
        printf("Soy el hijo y resto 5, sale: %d \n",valor-5);
    } else {
        wait(NULL);
        printf("Soy el padre y sumo 5, sale: %d \n",valor+6);
    };
};