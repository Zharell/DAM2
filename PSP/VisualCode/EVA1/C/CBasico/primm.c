#include <stdio.h> 
#include <unistd.h>
#include <stdlib.h>

void main () {

    for (int num=100000;num<200000;num++) {
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





}