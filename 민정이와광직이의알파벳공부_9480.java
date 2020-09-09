package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ¹ÎÁ¤ÀÌ¿Í±¤Á÷ÀÌÀÇ¾ËÆÄºª°øºÎ_9480 {
	static int N;
	static int result;
	static String words[];
	static boolean select[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= tc; t++) {
			N = Integer.parseInt(br.readLine());
			words = new String[N];
			select = new boolean[N];
			result = 0;
			for(int i = 0; i < N; i++) {
				words[i] = br.readLine();
			}
			dfs(0);
			System.out.println("#" + t + " " + result);
		}
		
	}
	
	static void dfs(int cnt) {
		if(cnt == N) {
			boolean alpha[] = new boolean[26];
			for(int i = 0; i < words.length; i++) {
				if(select[i]) {
					for(int j = 0; j < words[i].length(); j++) {
						alpha[words[i].charAt(j) - 'a'] = true;
					}
				}
			}
			
			boolean flag = true;
			for(int i = 0; i < alpha.length; i++) {
				if(!alpha[i]) {
					flag = false;
					break;
				}
			}
			
			if(flag) {
				result++;
			}
			
			return;
		}
		
		select[cnt] = true;
		dfs(cnt+1);
		select[cnt] = false;
		dfs(cnt+1);
	}
}
