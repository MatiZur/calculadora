#include <stdio.h>

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
	int res;
	for(int i=0;i<tam;i++)
	{
		res=res + (vector1[i]*vector2[i]);
	}
	mostrarVectores(vector1,vector2,tam);
	printf("\n\nEl resultado del producto escalar de ambos vectore es:%d\n",res);
}
int main()
{
	int opcion,tam;
	int vector[100],vector1[100],vector2[100];
	do
	{
		printf("EJECUCIONES DEL PROGRAMA\n Suma de vectores (1) / Resta de vectores (2) / Multiplicacion de escalar (3) / Producto escalar (4) / Producto vectorial (5) / Salir del programa (6)\nQue desea realizar?:");
		scanf("%d",&opcion);
		if(opcion<1 || opcion>6)
		{
			printf("\n\nEjecucion no valida, por favor, ingrese una ejecucion valida\n\n");
		}
		if(opcion==1||opcion==2||opcion==4||opcion==5)
		{
			printf("\nIngrese el tamanio de los vectores\n");
			scanf("%d",&tam);
			for(int i=0;i<tam;i++)
			{
				printf("\nIngrese el valor %d del vector 1\n",i+1);
				scanf("%d",&vector1[i]);
			}
			for(int i=0;i<tam;i++)
			{
				printf("\nIngrese el valor %d del vector 2\n",i+1);
				scanf("%d",&vector2[i]);
			}
		}else if(opcion==3)
		{
			printf("\nIngrese el tamanio del vector\n");
			scanf("%d",&tam);
			for(int i=0;i<tam;i++)
			{
				printf("\nIngrese el valor %d del vector\n",i+1);
				scanf("%d",&vector[i]);
			}
		}
		switch(opcion)
		{
			case 1:
				sumaVectores(vector1,vector2,tam);
				break;
			
			case 2:
				restaVectores(vector1,vector2,tam);
				break;
				
			case 3:
				multiEscalar(vector,tam);
				break;
			
			case 4:
				productoEscalar(vector1,vector2,tam);
				break;
		}
	}while(opcion!=6);
}
