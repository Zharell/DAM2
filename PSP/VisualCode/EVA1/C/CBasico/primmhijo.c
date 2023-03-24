#include <stdio.h> 
#include <unistd.h>
#include <stdlib.h>

void main () {
    pid_t pid , pid2;
    pid=fork();
    pid2=fork();
    if (pid == -1) {
        printf("Error en la creación de procesos");
    } 
    if (pid==0) {
        for (int num=100000;num<150000;num++) {
        int y=2;
        for (y;y<num;y++) {
            if (num%y==0) {
                break;
            }
        }
        if (y>=num) {
        printf("\n primai hijo: %d ",num);
        }
    }
    } else {
        for (int num=150000;num<200000;num++) {
        int y=2;
        for (y;y<num;y++) {
            if (num%y==0) {
                break;
            }
        }
        if (y>=num) {
        printf("\n primai padre: %d ",num);
        }
    }
    }

    
}