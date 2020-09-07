package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Contatct_1238_dfs {

	static int people[][];
	static boolean v[];
	static int result[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t = 1; t <= 10; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			people = new int[101][101];
			v = new boolean[101];
			v[start] = true;
			result = new int[101];
			for(int i = 0; i < N/2; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				people[x][y] = 1;
			}
			
			
			dfs(start, 1);
			int max = 0;
			for(int i = 1; i < result.length; i++) {
				max = Integer.max(result[i], max);
			}
			
			List<Integer> list = new ArrayList<Integer>();
			
			for(int i = 1; i < result.length; i++) {
				if(result[i] == max) {
					list.add(i);
				}
			}
			
			Collections.sort(list, new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o2-o1;
				}
				
			});
			
		
			
			System.out.println("#" + t+ " " + list.get(0));
		}
	}

	static void dfs(int start, int cnt) {
		
		for(int i = 1; i < 101; i++) {
			if(people[start][i] == 1) {
				
				if(result[i] == 0) {
					result[i] = cnt+1;
					dfs(i,cnt+1);
				}
				
				if(result[i] > cnt+1) {
					result[i] = cnt+1;
					dfs(i, cnt+1);
				}
			}
		}
		
	}
	
	static class data {
		int x;
		int count;
		
		public data(int x, int count) {
			this.x = x;
			this.count = count;
		}
	}
}
