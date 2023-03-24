#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>

void main()
{
    pid_t pid, Hijo_pid;
    pid = fork();

    if (pid == -1) // Ha ocurrido un error
    {
        printf("No se ha podido crear el proceso hijo ... ");
        exit(-1);
    }

    if (pid == 0) // Nos encontramos en Proceso hijo
    {
        // int i =0;
        // for (i;i<100;i++) {
        getchar();
        printf("Soy el proceso hijo Mi PID es %d, El PID de mi padre es: %d.", getpid(), getppid());
        //}
    }
    else // Nos encontramos en Proceso padre
    {
        Hijo_pid = wait(NULL); // espera la finalización del proceso hijo
        // int i =0;
        // for (i;i<100;i++) {
        printf("Soy el proceso padre: Mi PID es %d, El PID de mi padre es: %d. Mi hijo: %d terminó. ", getpid(), getppid(), pid);
        //}
    }
    exit(0);
}