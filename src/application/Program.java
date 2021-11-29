package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter file full path: ");
		String path = sc.next();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
			LinkedHashMap<String, Integer> candidates = new LinkedHashMap<>();
			
			String line = br.readLine();
			
			while (line != null) {
				String[] fields = line.split(",");
				String name = fields[0];
				Integer votes = Integer.parseInt(fields[1]);
				
				if (candidates.containsKey(name)) {
					candidates.put(name, candidates.get(name) + votes);
				}
				else {
					candidates.put(name, votes);
				}
				
				line = br.readLine();
			}
			
			for (String key : candidates.keySet()) {
				System.out.println(key + ": " + candidates.get(key));
			}
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();
	}

}
