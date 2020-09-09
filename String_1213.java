package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String_1213 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			String word = br.readLine();
			String total = br.readLine();
			int result = 0;
			
			for(int i = 0; i < total.length()-word.length()+1; i++) {
				if(word.equals(total.substring(i, i+word.length()))) {
					result++;
				}
			}
			
			System.out.println("#" + t + " " + result);
			
		}
	}
}
