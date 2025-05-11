#include <stdio.h>
#include <math.h>

void sistema2(){
	int a1, b1, r1, a2, b2, r2;
	float resB, resR, y, x;
	printf("\nIngrese los coeficientes de la primer ecuacion (a1 b1 r1): ");
	scanf("%d %d %d", &a1, &b1, &r1);
	printf("\nIngrese los coeficientes de la segunda ecuacion (a2 b2 r2): ");
	scanf("%d %d %d", &a2, &b2, &r2);
	printf("\nLas ecuaciones son:\n%dx + %dy = %d\n%dx + %dy = %d", a1, b1, r1, a2, b2, r2);
    resB = (a2 * b1) - (a1 * b2);
    resR = (a2 * r1) - (a1 * r2);
	y = resR / resB;
	x = (r1 - (b1 * y)) / a1;
	printf("\n\nx es igual a %f.\ny es igual a %f.\n\n\n",x,y);
}

void sistema3(){
	int a1, b1, c1, r1, a2, b2, c2, r2, a3, b3, c3, r3;
	float resB1, resC1, resR1, resB2, resC2, resR2, finalB, finalC, finalR, z, y, x;
	printf("\nIngrese los coeficientes de la primer ecuacion (a1 b1 c1 r1): ");
	scanf("%d %d %d %d", &a1, &b1, &c1, &r1);
	printf("\nIngrese los coeficientes de la segunda ecuacion (a2 b2 c2 r2): ");
	scanf("%d %d %d %d", &a2, &b2, &c2, &r2);
	printf("\nIngrese los coeficientes de la tercer ecuacion (a3 b3 c3 r3): ");
	scanf("%d %d %d %d", &a3, &b3, &c3, &r3);
	printf("\nLas ecuaciones son:\n%dx + %dy + %dz = %d\n%dx + %dy + %dz = %d\n%dx + %dy + %dz = %d", a1, b1, c1, r1, a2, b2, c2, r2, a3, b3, c3, r3);
	resB1 = (a2 * b1) - (a1 * b2);
    resC1 = (a2 * c1) - (a1 * c2);
    resR1 = (a2 * r1) - (a1 * r2);
	resB2 = (a3 * b1) - (a1 * b3);
    resC2 = (a3 * c1) - (a1 * c3);
    resR2 = (a3 * r1) - (a1 * r3);
    finalC = (resB2 * resC1) - (resB1 * resC2);
    finalR = (resB2 * resR1) - (resB1 * resR2);
	if(finalC == 0 || resB1 == 0 || a1 == 0){
    	printf("\n\nEl sistema no tiene solucion unica o hay una division por cero.\n\n\n");
    	return;
	}
	z = finalR / finalC;
	y = (resR1 - (resC1 * z)) / resB1;
	x = (r1 - (b1 * y) - (c1 * z)) / a1;
	printf("\n\nx es igual a %f.\ny es igual a %f.\nz es igual a %f.\n\n\n",x,y,z);
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
				break;
			default:
				printf("\nOpcion no reconocida\n\n\n");
				break;
		}
	}while(opcion!=3);
}
