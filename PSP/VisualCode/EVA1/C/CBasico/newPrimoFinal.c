#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>


void main () {
    int Lini=100000,Lfin=200000;
    int numero = 4,ini = 100000,fin = 200000;
    fin = ini+((fin-ini)/4);
    for (int i = 0;i < numero;i++) {
        if (fork()==0) {
            ini = imprimePrimos(ini,fin);
            fin = ini+((Lfin-Lini)/4);
            printf("nuevo fin %d",fin);
            exit(0);
        }
        ini = imprimePrimos(ini,fin);
        fin = ini+((Lfin-Lini)/4);
        printf("nuevo fin %d",fin);
    }
    for (int i = 0;i < numero;i++ ) {
        wait(0);
    }
}
int imprimePrimos(int ini,int fin) {
    int num = ini;
    
    for (num=ini;num<fin;num++) {
        int y=2;
        for (y;y<num;y++) {

            if (num%y==0) {
                break;
            }
        }
        if (y>=num) {
        printf("\n primai: %d ",num);
        }

    }
    
    return num;
}
