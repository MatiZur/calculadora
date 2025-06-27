import java.util.Scanner;

public class sistemas{
	public static void sistema2(){
		Scanner scanner = new Scanner(System.in);
		int a1, b1, r1, a2, b2, r2;
		float resB, resR, y, x;
		System.out.printf("\n\nIngrese los coeficientes de la primer ecuación (a1 b1 r1): ");
		a1 = scanner.nextInt();
		b1 = scanner.nextInt();
		r1 = scanner.nextInt();
		System.out.printf("\nIngrese los coeficientes de la segunda ecuación (a2 b2 r2): ");
		a2 = scanner.nextInt();
		b2 = scanner.nextInt();
		r2 = scanner.nextInt();
		System.out.printf("\nLas ecuaciones son:\n%dx + %dy = %d\n%dx + %dy = %d", a1, b1, r1, a2, b2, r2);
		resB = (a2 * b1) - (a1 * b2);
		resR = (a2 * r1) - (a1 * r2);
		if(resB == 0 || a1 == 0){
			System.out.printf("\n\n\nError: El sistema no tiene solución única o hay una división por cero.\n\n");
	    	return;
		}
		y = resR / resB;
		x = (r1 - (b1 * y)) / a1;
		System.out.printf("\n\n\nx es igual a %.2f.\ny es igual a %.2f.\n\n", x, y);
		return;
	}
	
	public static void sistema3(){
		Scanner scanner = new Scanner(System.in);
		int a1, b1, c1, r1, a2, b2, c2, r2, a3, b3, c3, r3;
		float resB1, resC1, resR1, resB2, resC2, resR2, finalC, finalR, z, y, x;
		System.out.printf("\n\nIngrese los coeficientes de la primer ecuación (a1 b1 c1 r1): ");
		a1 = scanner.nextInt();
		b1 = scanner.nextInt();
		c1 = scanner.nextInt();
		r1 = scanner.nextInt();
		System.out.printf("\nIngrese los coeficientes de la segunda ecuación (a2 b2 c2 r2): ");
		a2 = scanner.nextInt();
		b2 = scanner.nextInt();
		c2 = scanner.nextInt();
		r2 = scanner.nextInt();
		System.out.printf("\nIngrese los coeficientes de la tercer ecuación (a3 b3 c3 r3): ");
		a3 = scanner.nextInt();
		b3 = scanner.nextInt();
		c3 = scanner.nextInt();
		r3 = scanner.nextInt();
		System.out.printf("\nLas ecuaciones son:\n%dx + %dy + %dz = %d\n%dx + %dy + %dz = %d\n%dx + %dy + %dz = %d", a1, b1, c1, r1, a2, b2, c2, r2, a3, b3, c3, r3);
		resB1 = (a2 * b1) - (a1 * b2);
		resC1 = (a2 * c1) - (a1 * c2);
		resR1 = (a2 * r1) - (a1 * r2);
		resB2 = (a3 * b1) - (a1 * b3);
		resC2 = (a3 * c1) - (a1 * c3);
		resR2 = (a3 * r1) - (a1 * r3);
		finalC = (resB2 * resC1) - (resB1 * resC2);
		finalR = (resB2 * resR1) - (resB1 * resR2);
		if(finalC == 0 || resB1 == 0 || a1 == 0){
			System.out.print("\n\n\nError: El sistema no tiene solución única o hay una división por cero.\n\n");
	    	return;
		}
		z = finalR / finalC;
		y = (resR1 - (resC1 * z)) / resB1;
		x = (r1 - (b1 * y) - (c1 * z)) / a1;
		System.out.printf("\n\n\nx es igual a %.2f.\ny es igual a %.2f.\nz es igual a %.2f.\n\n", x, y, z);
		return;
	}
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int opcion;
		do{
			System.out.print("\n\n1: Sistema 2 por 2 | 2: Sistema 3 por 3 | 3: Salir\n\nIngrese su opción: ");
			opcion = scanner.nextInt();
			switch(opcion){
				case 1:
					sistema2();
					break;
				case 2:
					sistema3();
					break;
				case 3:
					System.out.print("\n\nSaliendo de Sistemas de ecuaciones...\n\n\n\n");
					scanner.close();
					break;
				default:
					System.out.print("\n\nError: Opcion inválida.\n");
					break;
			}
		}while(opcion != 3);
		return;
	}
}