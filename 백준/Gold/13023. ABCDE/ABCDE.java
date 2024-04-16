import java.util.*;
import java.io.*;

public class Main{
    static boolean isLine = false;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[n];
        LinkedList<LinkedList<Integer>> adjacent = new LinkedList<>();

        for(int i = 0; i<n; i++){
            adjacent.add(new LinkedList<>());
        }


        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjacent.get(a).add(b);
            adjacent.get(b).add(a);
        }


        for(int i = 0; i<n; i++){
            Arrays.fill(visited, false);
            dfs(i,adjacent,visited,1);
            if(isLine){
                break;
            }
        }

        bw.write(isLine? "1":"0");
        bw.flush();
        bw.close();
        br.close();
    }


    static void dfs(int index,  LinkedList<LinkedList<Integer>> adjacent, boolean[] visited, int cnt){
        if(cnt == 5){
            isLine = true;
            return;
        }
        visited[index] = true;
        for(int i : adjacent.get(index)){
            if(!visited[i]){
                dfs(i,adjacent,visited,cnt+1);
            }
            if(isLine){
                return; //5개짜리 한줄 찾았으면 더 찾을 필요 없으니깐 튀어나오기
            }
        }
        visited[index] = false;

    }
}