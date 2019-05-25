package mathconsumer;
import java.util.Scanner;

import osgi.MathService.*;
public class Cal {
	 
	 
	public static void run(MathService ms) {
		Scanner scan=new Scanner(System.in); 
		int a=scan.nextInt();
		
		int b=20;
		System.out.println(ms.Sum(a,b));
	}

}
