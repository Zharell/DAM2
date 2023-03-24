#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(){
	int n=2, ini=100000,fin=200000, div=(fin-ini)/n;
	for (int i=0;i<n;i++){
		if (fork()==0) {
			printf("\nSoy el hijo = 3, Mi padre es = %d, Mi PID = %d\n", getpid());
		}
	}
	for (int i=0;i<n;i++) wait(NULL);	
}