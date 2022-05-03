package service;

import java.util.ArrayList;
import java.util.List;


//aplicando generics e typesafety
public class PrintService<Type> {
	
	private List<Type> list = new ArrayList<>();

	

	public PrintService() {
		
	}

	public List<Type> getList() {
		return list;
	}

	
	
	 public void addValue(Type value) {
		 list.add(value);
	 }
	 
	public Type first() {
		if(list.isEmpty()) {
			throw new IllegalStateException("The list is empty");
		}
		return list.get(0);
	}
	public void print() {
		if(list.isEmpty()) {
			throw new IllegalStateException("The list is empty");
		}
		for(int i=0; i < list.size();i++) {
			if(i == 0) {
				System.out.print("["+list.get(i));
			}else{
				System.out.print(", "+list.get(i));
			}
		}
		System.out.println("]");
	}
	
}
