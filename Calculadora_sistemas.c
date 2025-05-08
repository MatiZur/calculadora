#include <stdio.h>
#include <math.h>

void sistema2(){
	int multiUno1, multiDos1, res1, multiUno2, multiDos2, res2;
	float resUno, resDos, resTot, y, x;
	printf("\nIngrese el multiplicador de la primer variable de la primer ecuacion: ");
	scanf("%d",&multiUno1);
	printf("Ingrese el multiplicador de la segunda variable de la primer ecuacion: ");
	scanf("%d",&multiDos1);
	printf("Ingrese el resultado de la primer ecuacion: ");
	scanf("%d",&res1);
	printf("\nIngrese el multiplicador de la primer variable de la segunda ecuacion: ");
	scanf("%d",&multiUno2);
	printf("Ingrese el multiplicador de la segunda variable de la segunda ecuacion: ");
	scanf("%d",&multiDos2);
	printf("Ingrese el resultado de la segunda ecuacion: ");
	scanf("%d",&res2);
	printf("\nLas ecuaciones son:\n%dx + %dy = %d\n%dx + %dy = %d", multiUno1, multiDos1, res1, multiUno2, multiDos2, res2);
	if((multiUno1 > 0 && multiUno2 > 0) || (multiUno1 < 0 && multiUno2 < 0)){
		int multiInver;
		multiInver = -1 * multiUno1;
		resUno = (multiUno2 * multiUno1) + (multiInver * multiUno2);
		resDos = (multiUno2 * multiDos1) + (multiInver * multiDos2);
		resTot = (multiUno2 * res1) + (multiInver * res2);
	}
	else{
		resUno = (multiUno2 * multiUno1) + (multiUno1 * multiUno2);
		resDos = (multiUno2 * multiDos1) + (multiUno1 * multiDos2);
		resTot = (multiUno2 * res1) + (multiUno1 * res2);
	}
	y = resTot/resDos;
	x = (res1 - (multiDos1 * y)) / multiUno1;
	printf("\n\ny es igual a %f.\nx es igual a %f.\n\n\n",y,x);
}

void sistema3(){
	printf("Hola");
}

int main(){
	int opcion;
	do{
		printf("1: Sistema 2 por 2 | 2: Sistema 3 por 3 | 3: Terminar programa\nIngrese una opcion: ");
		scanf("%d",&opcion);
		switch(opcion){
			case 1:
				sistema2();
				break;
			case 2:
				sistema3();
				break;
			case 3:
				printf("\nTerminando programa...");
			default:
				printf("\nOpcion no reconocida\n\n\n");
				break;
		}
	}while(opcion!=3);
}
