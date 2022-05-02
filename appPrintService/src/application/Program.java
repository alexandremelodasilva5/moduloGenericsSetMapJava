package application;


import java.util.Scanner;

import service.PrintService;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		PrintService<String> ps = new PrintService<>();
		
		System.out.print("How many values? ");
		int listSize = sc.nextInt();
		
		for(int i=0; i<listSize;i++) {
			String number = sc.next();
			
			ps.addValue(number);
		}
		
		
		
		ps.print();
		
		
		System.out.println("First: "+ps.first());
		
		sc.close();

	}

}
