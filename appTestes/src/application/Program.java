package application;

import java.util.ArrayList;
import java.util.List;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;

public class Program {

	public static void main(String[] args) {
		List<Shape> list = new ArrayList<>();
		list.add(new Circle(2));
		list.add(new Rectangle(3, 2));
		
		List<Circle> listCircle = new ArrayList<Circle>();
		listCircle.add(new Circle(2));
		listCircle.add(new Circle(3));
		
		System.out.println("A soma total das areas de shapes é : "+ String.format("%.2f", sum(list)));
		System.out.println("A soma total das areas de circulos é: "+ String.format("%.2f", sum(listCircle)));
		
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
}
