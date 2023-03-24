#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>

int main(void )
{
    int num;

    
    num = rand() % 21;
    printf("random: %d",num);
    
}