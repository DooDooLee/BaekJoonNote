
import java.io.*;
import java.util.*;

public class Main {
	static class Node{
		int index;
		int cost;
		
		Node(int index, int cost){
			this.index = index;
			this.cost = cost;
		}
		
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         
        int v= Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());
        
        ArrayList<ArrayList<Node>> al = new ArrayList<>();
        
        for(int i=0; i<=v; i++) {
        	al.add(new ArrayList<>());
        }
        for(int i=0; i<e;i++) {
        	StringTokenizer st2= new StringTokenizer(br.readLine());
        	int index = Integer.parseInt(st2.nextToken());
        	int nindex = Integer.parseInt(st2.nextToken());
        	int cost = Integer.parseInt(st2.nextToken());
        	
        	al.get(index).add(new Node(nindex,cost));
        }
        
        Queue<Node> pq = new PriorityQueue<>((a,b)->{return a.cost-b.cost;});
        
        int[] d =new int[v+1];
        Arrays.fill(d,Integer.MAX_VALUE);
        d[k] = 0;
        
        pq.add(new Node(k,0));
        
        while(!pq.isEmpty()) {
        	 Node n =  pq.poll();
        	 int idx = n.index;
        	 int cost = n.cost;
        	 
        	 for(Node sn : al.get(idx)) {
        		 int cc = cost+sn.cost;
        		 if(d[sn.index]>cc) {
        			 d[sn.index] = cc;
        			 pq.add(new Node(sn.index,cc));
        		 }
        	 }
        }
        
        
        for(int i=1; i<=v; i++) {
        	if(d[i]==Integer.MAX_VALUE) {
        		System.out.println("INF");
        	}else {
        		System.out.println(d[i]);
        	}
        }
        
        
    }

}    
