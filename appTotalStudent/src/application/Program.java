package application;


import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import entities.User;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set<User> a = new TreeSet<>();
		Set<User> b = new TreeSet<>();
		Set<User> c = new TreeSet<>();
		
		System.out.print("How many students for course A? ");
		int lenghtA = sc.nextInt();
		for(int i=0;i<lenghtA;i++) {
			int item = sc.nextInt();
			User user = new User(item);
			a.add(user);
		}
		
		System.out.print("How many students for course B? ");
		int lenghtB = sc.nextInt();
		for(int i=0;i<lenghtB;i++) {
			int item = sc.nextInt();
			User user = new User(item);
			b.add(user);
		}
		
		System.out.print("How many students for course C? ");
		int lenghtC = sc.nextInt();
		for(int i=0;i<lenghtC;i++) {
			int item = sc.nextInt();
			User user = new User(item);
			c.add(user);
		}
		
		Set<User> d = new TreeSet<User>(a);
		d.addAll(b);
		d.addAll(c);
		System.out.println("Total de estudantes: "+d.size());
		sc.close();
		
	}

}
