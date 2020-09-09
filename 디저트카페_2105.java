package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 디저트카페_2105 {
	static int map[][];
	static boolean v[][];
	static int dx[] = {1, -1, -1, 1};
	static int dy[] = {1, 1, -1, -1};
	static int max;
	static boolean num[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			v  = new boolean[N][N];
			num = new boolean[101];
			max = -1;
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					v[i][j] = true;
					num[map[i][j]] = true;
					dfs(i,j,i,j, 0, 1);
					v[i][j] = false;
					num[map[i][j]] = false;
				}
			}
			
			System.out.println("#" + t + " " + max);
		}
		
	}
	
	static void dfs(int startX, int startY, int x, int y, int cnt, int score) {
		
		
		for(int i = cnt; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || ny < 0 || nx == map.length || ny == map[0].length) {
				continue;
			}
			
			if(score >= 4 && startX == nx && startY == ny) {
				if(score > max ) {
					max = score;
				}
				return;
			}
			
			if(!v[nx][ny] && !num[map[nx][ny]]) {
				v[nx][ny] = true;
				num[map[nx][ny]] = true;
				dfs(startX, startY, nx, ny, i, score+ 1);
				v[nx][ny] = false;
				num[map[nx][ny]] = false;
			}			
		}
		
		
	}
}
