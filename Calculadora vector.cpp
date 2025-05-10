#include <stdio.h>

void ingresoDosVectores(int *vector1, int *vector2, int *tam)
{
	printf("\nIngrese el tamanio de los vectores\n");
	scanf("%d",&*tam);
	for(int i=0;i<*tam;i++)
	{
	printf("\nIngrese el valor %d del vector 1\n",i+1);
	scanf("%d",&vector1[i]);
	}
	for(int i=0;i<*tam;i++)
	{
	printf("\nIngrese el valor %d del vector 2\n",i+1);
	scanf("%d",&vector2[i]);
	}
}

void ingresoUnVector(int *vector,int *tam)
{
	printf("\nIngrese el tamanio del vector\n");
	scanf("%d",&*tam);
	for(int i=0;i<*tam;i++)
	{
		printf("\nIngrese el valor %d del vector\n",i+1);
		scanf("%d",&vector[i]);
	}
}

void ingresoDosVectores3N(int *vector1, int *vector2, int *tam)
{
	*tam=3;
	for(int i=0;i<*tam;i++)
	{
		printf("\nIngrese el valor %d del vector 1\n",i+1);
		scanf("%d",&vector1[i]);
	}
	for(int i=0;i<*tam;i++)
	{
		printf("\nIngrese el valor %d del vector 2\n",i+1);
		scanf("%d",&vector2[i]);
	}		
}

void mostrarVectores(int vector1[], int vector2[], int tam)
{
	printf("\nVector 1: ");
	for(int i=0;i<tam;i++)
	{
		printf("|%d|",vector1[i]);	
	}	
	printf("\n\n");
	printf("\nVector 2: ");
	for(int i=0;i<tam;i++)
	{
		printf("|%d|",vector2[i]);	
	}
	printf("\n");
}

void sumaVectores(int vector1[], int vector2[], int tam)
{
	int res[tam];
	for(int i=0;i<tam;i++)
	{
		res[i]=vector1[i]+vector2[i];
	}
	mostrarVectores(vector1,vector2,tam);
	printf("\n\nEl resultado de la suma de ambos vectores es:\n");
	for(int i=0;i<tam;i++)
	{
		printf("|%d|",res[i]);
	}
	printf("\n\n");
}

void restaVectores(int vector1[], int vector2[], int tam)
{
	int res[tam];
	for(int i=0;i<tam;i++)
	{
		res[i]=vector1[i]-vector2[i];
	}
	mostrarVectores(vector1,vector2,tam);
	printf("\nEl resultado de la resta de ambos vectores es:\n");
	for(int i=0;i<tam;i++)
	{
		printf("|%d|",res[i]);
	}	
	printf("\n\n");
}

void multiEscalar(int vector1[], int tam)
{
	int escalar;
	int res[tam];
	printf("\nIngrese el valor del escalar\n");
	scanf("%d",&escalar);
	for(int i=0;i<tam;i++)
	{
		res[i]=escalar * vector1[i];
	}
	printf("\nVector: ");
	for(int i=0;i<tam;i++)
	{
		printf("|%d|",vector1[i]);	
	}
	printf("\n");
	printf("\nEl resultado de la multiplicacion entre el escalar y el vector es:\n");
	for(int i=0;i<tam;i++)
	{
		printf("|%d|",res[i]);
	}
	printf("\n\n");
}

void productoEscalar(int vector1[], int vector2[], int tam)
{
	int res=0;
	for(int i=0;i<tam;i++)
	{
		res=res + (vector1[i]*vector2[i]);
	}
	mostrarVectores(vector1,vector2,tam);
	printf("\n\nEl resultado del producto escalar de ambos vectores es:\n%d\n\n",res);
}

void productoVectorial(int vector1[], int vector2[], int tam)
{
	int ter1,ter2,ter3,res[3];
	ter1=vector1[1]*vector2[2] - vector1[2]*vector2[1];
	ter2=vector1[0]*vector2[2] - vector1[2]*vector2[0];
	ter3=vector1[0]*vector2[1] - vector1[1]*vector2[0];
	int terminos[3]={ter1,ter2,ter3};
	for(int i=0;i<tam;i++)
	{
		int signo=1;
		if(i==1)
		{
			signo=-1;
		}
		res[i]=signo*terminos[i];
	}
	mostrarVectores(vector1,vector2,tam);
	printf("\nEl valor del producto vectorial de ambos vectores es:\n");
	printf("(%d;%d;%d)",res[0],res[1],res[2]);
	printf("\n\n");
}

int main()
{
	int opcion,tam;
	int vector[100],vector1[100],vector2[100];
	do
	{
		printf("EJECUCIONES DEL PROGRAMA\n/ Suma de vectores (1) / Resta de vectores (2) /\n/ Multiplicacion por escalar (3) / Producto escalar (4) /\n/ Producto vectorial(3 dimensiones) (5) / Salir del programa (6) /\nQue desea realizar?:");
		scanf("%d",&opcion);
		switch(opcion)
		{
			case 1:
				ingresoDosVectores(vector1,vector2,&tam);
				sumaVectores(vector1,vector2,tam);
				break;		
			case 2:
				ingresoDosVectores(vector1,vector2,&tam);
				restaVectores(vector1,vector2,tam);
				break;				
			case 3:
				ingresoUnVector(vector,&tam);
				multiEscalar(vector,tam);
				break;			
			case 4:
				ingresoDosVectores(vector1,vector2,&tam);
				productoEscalar(vector1,vector2,tam);
				break;		
			case 5:
				ingresoDosVectores3N(vector1,vector2,&tam);
				productoVectorial(vector1,vector2,tam);
				break;
			case 6:
				printf("\nTerminando programa...");
				break;
			default:
				printf("\n\nEjecucion no valida, por favor, ingrese una ejecucion valida\n\n");
				break;
		}
	}while(opcion!=6);
}
