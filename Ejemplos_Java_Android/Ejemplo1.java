import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		System.out.println("   Hola Mundo   ");
		int a,b,c = 0;
		Scanner s =new Scanner(System.in);
		System.out.println("Suma de dos numeros:");
		System.out.println("Introduce numero a:");
		a = s.nextInt();
		System.out.println("Introduce numero b:");
		b = s.nextInt();
		c = a + b;
		System.out.println("La suma de a y b es:"+c);
	}
}
