#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <signal.h>

void sighandler(int);

int main () {
   signal(SIGINT, sighandler);
   signal(SIGKILL, sighandler);

   while(1) {
      printf("Interrúmpeme si puedes, soy el proceso %d \n",getpid());
      printf("Going to sleep for a second...\n");
      sleep(1); 
   }
   return(0);
}

void sighandler(int signum) {
   if(signum==2){
      printf("No me puedes cerrar así\n");
      fork();
   }

   //exit(1);
}