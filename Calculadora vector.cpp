#include <stdio.h>

int validacionTamanio(int *tam1, int *tam2)
{
	if(*tam1 != *tam2)
	{
		return 0;
	}else
	{
		return 1;
	}
}
void ingresoDosVectores(float *vector1, float *vector2, int *tam1, int *tam2)
{
	do{
		printf("\nIngrese el tamanio del vector 1 :");
		scanf("%d",&*tam1);
		if(*tam1<=0)
		{
			printf("\nERROR, no puede haber un vector con un tamanio igual o menor a 0\n");
  		}
	}while(*tam1<=0);
	for(int i=0;i<*tam1;i++)
	{
	printf("\nIngrese el valor %d del vector 1\n",i+1);
	scanf("%f",&vector1[i]);
	}
	do{
		printf("\nIngrese el tamanio del vector 2 :");
		scanf("%d",&*tam2);
		if(*tam2<=0)
		{
			printf("\nERROR, no puede haber un vector con un tamanio igual o menor a 0\n");
  		}
	}while(*tam2<=0);
	for(int i=0;i<*tam2;i++)
	{
	printf("\nIngrese el valor %d del vector 2\n",i+1);
	scanf("%f",&vector2[i]);
	}
}

void ingresoUnVector(float *vector,int *tam)
{
	do{
		printf("\nIngrese el tamanio del vector\n");
		scanf("%d",&*tam);
		if(*tam<=0)
		{
			printf("\nERROR, no puede haber un vector con un tamanio igual o menor a 0\n");
		}
	}while(*tam<=0);
	for(int i=0;i<*tam;i++)
	{
		printf("\nIngrese el valor %d del vector\n",i+1);
		scanf("%f",&vector[i]);
	}
}

void ingresoDosVectores3N(float *vector1, float *vector2, int *tam)
{
	*tam=3;
	for(int i=0;i<*tam;i++)
	{
		printf("\nIngrese el valor %d del vector 1\n",i+1);
		scanf("%f",&vector1[i]);
	}
	for(int i=0;i<*tam;i++)
	{
		printf("\nIngrese el valor %d del vector 2\n",i+1);
		scanf("%f",&vector2[i]);
	}		
}

void mostrarVectores(float vector1[], float vector2[], int tam)
{
	printf("\nVector 1: ");
	for(int i=0;i<tam;i++)
	{
		printf("|%f|",vector1[i]);	
	}	
	printf("\n\n");
	printf("\nVector 2: ");
	for(int i=0;i<tam;i++)
	{
		printf("|%f|",vector2[i]);	
	}
	printf("\n");
}

void sumaVectores(float vector1[], float vector2[], int tam)
{
	float res[tam];
	for(int i=0;i<tam;i++)
	{
		res[i]=vector1[i]+vector2[i];
	}
	mostrarVectores(vector1,vector2,tam);
	printf("\n\nEl resultado de la suma de ambos vectores es:\n");
	for(int i=0;i<tam;i++)
	{
		printf("|%f|",res[i]);
	}
	printf("\n\n");
}

void restaVectores(float vector1[], float vector2[], int tam)
{
	float res[tam];
	for(int i=0;i<tam;i++)
	{
		res[i]=vector1[i]-vector2[i];
	}
	mostrarVectores(vector1,vector2,tam);
	printf("\nEl resultado de la resta de ambos vectores es:\n");
	for(int i=0;i<tam;i++)
	{
		printf("|%f|",res[i]);
	}	
	printf("\n\n");
}

void multiEscalar(float vector1[], int tam)
{
	float escalar;
	float res[tam];
	printf("\nIngrese el valor del escalar\n");
	scanf("%f",&escalar);
	for(int i=0;i<tam;i++)
	{
		res[i]=escalar * vector1[i];
	}
	printf("\nVector: ");
	for(int i=0;i<tam;i++)
	{
		printf("|%f|",vector1[i]);	
	}
	printf("\n");
	printf("\nEl resultado de la multiplicacion entre el escalar y el vector es:\n");
	for(int i=0;i<tam;i++)
	{
		printf("|%f|",res[i]);
	}
	printf("\n\n");
}

void productoEscalar(float vector1[], float vector2[], int tam)
{
	float res=0;
	for(int i=0;i<tam;i++)
	{
		res=res + (vector1[i]*vector2[i]);
	}
	mostrarVectores(vector1,vector2,tam);
	printf("\n\nEl resultado del producto escalar de ambos vectores es:\n%f\n\n",res);
}

void productoVectorial(float vector1[], float vector2[], int tam)
{
	float ter1,ter2,ter3,res[3];
	ter1=vector1[1]*vector2[2] - vector1[2]*vector2[1];
	ter2=vector1[0]*vector2[2] - vector1[2]*vector2[0];
	ter3=vector1[0]*vector2[1] - vector1[1]*vector2[0];
	float terminos[3]={ter1,ter2,ter3};
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
	printf("(%f;%f;%f)",res[0],res[1],res[2]);
	printf("\n\n");
}

int main()
{
	int opcion,tam,tam1,tam2;
	float vector[100],vector1[100],vector2[100];
	do
	{
		printf("\nEJECUCIONES DEL PROGRAMA\n/ Suma de vectores (1) / Resta de vectores (2) /\n/ Multiplicacion por escalar (3) / Producto escalar (4) /\n/ Producto vectorial(3 dimensiones) (5) / Salir del programa (6) /\nQue desea realizar?:");
		scanf("%d",&opcion);
		switch(opcion)
		{
			case 1:
				ingresoDosVectores(vector1,vector2,&tam1,&tam2);
				if(validacionTamanio(&tam1,&tam2)==1)
				{
					int tam=tam1;
					sumaVectores(vector1,vector2,tam);
				}else
				{
					printf("\nError en el calculo, ya que el tamanio de ambos vectores no es el mismo\n");
				}
				break;		
			case 2:
				ingresoDosVectores(vector1,vector2,&tam1,&tam2);
				if(validacionTamanio(&tam1,&tam2)==1)
				{
					int tam=tam1;
					restaVectores(vector1,vector2,tam);
				}else
				{
					printf("\nError en el calculo, ya que el tamanio de ambos vectores no es el mismo\n");
				}
				break;				
			case 3:
				ingresoUnVector(vector,&tam);
				multiEscalar(vector,tam);
				break;			
			case 4:
				ingresoDosVectores(vector1,vector2,&tam1,&tam2);
				if(validacionTamanio(&tam1,&tam2)==1)
				{
					int tam=tam1;
					productoEscalar(vector1,vector2,tam);
				}else
				{
					printf("\nError en el calculo, ya que el tamanio de ambos vectores no es el mismo\n");
				}
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
