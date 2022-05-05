package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import entities.Log;

public class Program {

	public static void main(String[] args) {
		String path = new String("C:\\Users\\Alex\\Desktop\\Documento Alexandre\\inLogsVoteCount.txt");
		Map<String, Integer> m = new LinkedHashMap<>();
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = br.readLine();
			while(line != null) {
				String[] fields = line.split(",");
				String name = fields[0];
				Integer votes = Integer.parseInt(fields[1]);
				Log log = new Log(name, votes);
				
				if(!m.containsKey(log.getName())) {
					m.put(log.getName(), log.getVotes());
					
				}else {
					Integer sum = m.get(log.getName());
					m.put(name, sum+votes);
				}
				
				
				
				line = br.readLine();
			}
			
			for(String key:m.keySet()) {
				System.out.println(key+": "+m.get(key));
			}
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
