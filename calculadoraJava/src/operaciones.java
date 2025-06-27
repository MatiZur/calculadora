import java.util.Scanner; 
public class operaciones {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
	        int opcion;
	        float num1 = 0, num2 = 0;

	        do {
	            System.out.print("\n\n1: Suma | 2: Resta | 3: Multiplicación | 4: División | 5: Potencia | 6: Raíz | 7: Salir\n\nIngrese su opción: ");
	            opcion = scanner.nextInt();

	            if (opcion >= 1 && opcion <= 4) {
	                System.out.print("\nIngrese un número: ");
	                num1 = scanner.nextFloat();
	                System.out.print("Ingrese otro número: ");
	                num2 = scanner.nextFloat();
	            }

	            switch (opcion) {
	                case 1:
	                    suma(num1, num2);
	                    break;
	                case 2:
	                    resta(num1, num2);
	                    break;
	                case 3:
	                    multi(num1, num2);
	                    break;
	                case 4:
	                    divi(num1, num2);
	                    break;
	                case 5:
	                    potencia();
	                    break;
	                case 6:
	                    raiz();
	                    break;
	                case 7:
	                    System.out.println("Saliendo");
	                    break;
	                default:
	                    System.out.println("Opción inválida.");
	                    break;
	            }
	        } while (opcion != 7);

	        scanner.close();
	    }

	    public static void suma(float num1, float num2) {
	        float res = num1 + num2;
	        System.out.println("Resultado de la suma: " + res);
	    }

	    public static void resta(float num1, float num2) {
	        float res = num1 - num2;
	        System.out.println("Resultado de la resta: " + res);
	    }

	    public static void multi(float num1, float num2) {
	        float res = num1 * num2;
	        System.out.println("Resultado de la multiplicación: " + res);
	    }

	    public static void divi(float num1, float num2) {
	        if (num2 == 0) {
	            System.out.println("Error: División por cero.");
	            return;
	        }
	        float res = num1 / num2;
	        System.out.println("Resultado de la división: " + res);
	    }

	    public static void potencia() {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Ingrese la base: ");
	        float base = scanner.nextFloat();
	        System.out.print("Ingrese el exponente: ");
	        float exponente = scanner.nextFloat();
	        float res = (float) Math.pow(base, exponente);
	        System.out.println("Resultado de la potencia: " + res);
	    }

	    public static void raiz() {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Ingrese el radicando (el número): ");
	        float radicando = scanner.nextFloat();
	        System.out.print("Ingrese el índice de la raíz: ");
	        float indice = scanner.nextFloat();

	        if (indice == 0) {
	            System.out.println("Error: El índice no puede ser 0.");
	            return;
	        }

	        float res = (float) Math.pow(radicando, 1.0f / indice);
	        System.out.println("Resultado de la raíz: " + res);
	    }
	  
}
