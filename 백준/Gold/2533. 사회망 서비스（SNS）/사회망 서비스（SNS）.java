import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];
        dp= new int[N+1][2];
        visited = new boolean[N+1];

        for (int i=1; i <= N; i++) {
            adj[i]=new ArrayList<>();
        }

        for (int i=0;i<N-1;i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            int u = Integer.parseInt( st.nextToken() );
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add( u );
        }

        dfs(1);
        System.out.println( Math.min(dp[1][0], dp[1][1]) );
    }

    public static void dfs(int u){
        visited[u] = true;
        dp[u][1] = 1; 
        dp[u][0] =0;

        for(int v : adj[u]){
            if( !visited[v] ){
                dfs(v);
                dp[u][0]+= dp[v][1];
                dp[u][1] += Math.min(dp[v][0], dp[v][1]);
            }
        }
    }
}