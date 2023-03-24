#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
int main()
{   
    pid_t pid;
	pid = fork ();
    int contador, n, primo;
    printf( "\n   " );
    if (pid == -1) // Ha ocurrido un error
	{
		printf ("No se ha podido crear el proceso hijo ... " );
		exit(-1);
	}
    if (pid==0){
        for ( n = 100000 ; n <= 150000 ; n++ )
        {
            if(esPrimo(n)){
                printf("%d ",n);
            }
        }
    }
    else{
        for ( n = 150000 ; n <= 200000 ; n++ )
        {
            if(esPrimo(n)){
                printf("%d ",n);
            }
        }
    }
    return 0;
}
int esPrimo(int numero) {

  if (numero == 0 || numero == 1) return 0;
  if (numero == 4) return 0;

  for (int x = 2; x < numero / 2; x++) {
    
    if (numero % x == 0) return 0;
  }
  
  return 1;
}