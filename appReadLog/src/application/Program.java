package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.time.Instant;

import java.util.Date;
import java.util.HashSet;

import java.util.Set;

import entities.Log;

public class Program {

	public static void main(String[] args) {
		String path = "C:\\Users\\Alex\\Desktop\\Documento Alexandre\\inLogs.txt";
		
	
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
			Set<Log> set = new HashSet<>();
			String line = br.readLine();
			
			while(line != null) {
				
				String[] fields = line.split(" ");
				String name = fields[0];
				Date date = Date.from(Instant.parse(fields[1]));
				set.add(new Log(name, date));
				line = br.readLine();
			}
			
			System.out.println(set.size());
			
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
