package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.Clients;
import entities.Product;

public class Program {

	public static void main(String[] args) {
		List<Shape> list = new ArrayList<>();
		list.add(new Circle(2));
		list.add(new Rectangle(3, 2));
		
		List<Circle> listCircle = new ArrayList<Circle>();
		listCircle.add(new Circle(2));
		listCircle.add(new Circle(3));
		
		List<Integer> myInts = new ArrayList<>();
		myInts.add(2);
		myInts.add(10);
		myInts.add(2);
		
		List<Double> myDouble = Arrays.asList(3.14, 6.28);
		List<Object> objList = new ArrayList<Object>();
		copy(myInts,objList);
		copy(myDouble,objList);
		
		List<Object> myObjs = new ArrayList<Object>();
		myObjs.add("Alex");
		myObjs.add("Bob");
		List<? super Number> nums = myObjs;
		List<? extends Number> listNum = myInts;
		//listNum.add(6);não funciona add(erro de compatibilidade), mas o get sim.
		Number y = listNum.get(0);
		nums.add(2);
		nums.add(3);
		//Number x = nums.get(0);
		
		
		Clients client1 = new Clients("Alexandre", "alexandre@gmail.com");
		Clients client2 = new Clients("Maira", "maira@gmail.com");
		Clients client3 = new Clients("Maira", "maira@gmail.com");
		
		
		Set<String> set = new LinkedHashSet<>();
		set.add("Tv");
		set.add("Notebook");
		set.add("Tablet");
		
		
		Set<Integer> a = new TreeSet<Integer>(Arrays.asList(0,2,4,5,6,8,10));
		Set<Integer> b = new TreeSet<Integer>(Arrays.asList(5,6,7,8,9,10));
		
		Set<Integer> c = new TreeSet<Integer>(a);
		c.addAll(b);
		
		Set<Integer> d = new TreeSet<Integer>(a);
		d.retainAll(b);
		
		Set<Integer> e = new TreeSet<Integer>(a);
		e.removeAll(b);
		
		
		Set<Product> setProduct = new HashSet<Product>();
		setProduct.add(new Product("tv", 3000));
		setProduct.add(new Product("note", 4000));
		setProduct.add(new Product("tablet", 5000));
		
		
		Product prod = new Product("note", 4000);
		
		System.out.println("A soma total das areas de shapes é : "+ String.format("%.2f", sum(list)));
		System.out.println("A soma total das areas de circulos é: "+ String.format("%.2f", sum(listCircle)));
		System.out.println(y);
		printList(objList);
		System.out.println(client1.hashCode());
		System.out.println(client2.hashCode());
		System.out.println(client3.hashCode());
		System.out.println(client1.equals(client2));
		System.out.println(client2.equals(client3));
		System.out.println(client2 == client3);
		System.out.println(set.contains("Tablet"));
		set.remove("Tv");
		set.removeIf(x -> x.charAt(0) == 'N');
		for(String s : set) {
			System.out.print(s+" ");
		}
		System.out.println();
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(setProduct.contains(prod));
		
	}
	
	/* a expressão <? extends Shape> faz com que a função aceita qualquer lista de Shape e suas subclasses, 
	mas não pode adicionar nenhum elemento a lista*/
	
	public static double sum(List<? extends Shape> list) {
		double sum = 0;
		for(Shape s: list) {
			sum += s.area();
		}
		return sum;
	}
	
	public static void copy(List<? extends Number> source, List<? super Number> destiny) {
		for(Number number:source) {
			destiny.add(number);
		}
	}
	
	public static void printList(List<?> list) {
		for(int i=0; i<list.size();i++) {
			if(i==0) {
				System.out.print("[ "+list.get(i));
			}else {
				System.out.print(", "+list.get(i));
			}	
		}
		System.out.println("]");
	}
}
