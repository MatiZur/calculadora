#include <stdio.h>
#include <math.h>

void suma(float *num1, float *num2){
	float res = *num1 + *num2;
	printf("\nLa suma entre %f y %f da %f.\n\n\n", *num1, *num2, res);
}

void resta(float *num1, float *num2){
	float res = *num1 - *num2;
	printf("\nLa resta entre %f y %f da %f.\n\n\n", *num1, *num2, res);
}

void multi(float *num1, float *num2){
	float res = *num1 * *num2;
	printf("\nLa multiplicacion entre %f y %f da %f.\n\n\n", *num1, *num2, res);
}

void divi(float *num1, float *num2){
	float res = *num1 / *num2;
	printf("\nLa division entre %f y %f da %f.\n\n\n", *num1, *num2, res);
}

void potencia(){
	float num1, num2;
	printf("\nIngrese un numero: ");
	scanf("%f",&num1);
	printf("Ingrese el exponente: ");
	scanf("%f",&num2);
	float res = pow(num1, num2);
	printf("\nLa potencia de %f de exponente %f da %f.\n\n\n", num1, num2, res);
}

void raiz(){
	float num1, num2;
	do{
		printf("\nIngrese un numero: ");
		scanf("%f",&num1);
		if(num1<0){
			printf("\nEl numero no puede ser negativo.\n");
		}
	}while(num1<0);
	do{
		printf("Ingrese el indice: ");
		scanf("%f",&num2);
		if(num2==0){
			printf("\nEl indice no puede ser 0.\n\n");
		}
	}while(num2==0);
	float res = pow(num1, (1 / num2));
	printf("\nLa raiz de %f de indice %f da %f.\n\n\n", num1, num2, res);
}

int main(){
	int opcion;
	float num1, num2;
	do{
		printf("1: Suma | 2: Resta | 3: Multiplicacion | 4: Division | 5: Potencia | 6: Raiz | 7: Terminar programa\n\nIngrese su opcion: ");
		scanf("%d",&opcion);
		if(opcion>=1 && opcion<=4){
			printf("\nIngrese un numero: ");
			scanf("%f",&num1);
			printf("Ingrese otro numero: ");
			scanf("%f",&num2);
		}
		switch(opcion){
			case 1:
				suma(&num1, &num2);
				break;
			case 2:
				resta(&num1, &num2);
				break;
			case 3:
				multi(&num1, &num2);
				break;
			case 4:
				divi(&num1, &num2);
				break;
			case 5:
				potencia();
				break;
			case 6:
				raiz();
				break;
			case 7:
				printf("\nTerminando programa...");
				break;
			default:
				printf("\nOpcion invalida.\n\n\n");
				break;
		}
	}while(opcion!=7);
	return 0;
}
