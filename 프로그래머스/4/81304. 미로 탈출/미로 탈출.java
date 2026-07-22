import java.util.*;

class Edge {
    int w; // 가중치
    int to;
    int foward; // 0이면 정방향 1이면 리버스일때
    
    Edge(int w, int to, int foward){
        this.w = w;
        this.to = to;
        this.foward = foward;
    }
}

class Status implements Comparable<Status> { //pq같은데 쳐넣어서 우선순위할거면 컴퍼레이터가아니라 컴페어러블로
    int to;
    int cost;
    int mask;
    Status(int to, int cost, int mask){
        this.to = to;
        this.cost =cost;
        this.mask=mask;
    }
    @Override
    public int compareTo( Status o){ //comparable 인터페이스는 compareTo를 오버라이드
        return this.cost-o.cost;
    }
}



class Solution { 
    public int solution(int n, int start, int end, int[][] roads, int[] traps) {
        int [] trapF = new int [n+1]; //트랩 마스크 저장  1 2 4 8 16 .... 01  10  100 느낌임 이진수
        Arrays.fill(trapF,-1); //트랩이 아니면 -1 고고
        
        int answer = 0;
        int tIndex = 1;
        for(int i=0; i<traps.length; i++){
           trapF[traps[i]] = tIndex;
           tIndex = tIndex<<1; 
        }
        
        int dist[][] = new int[tIndex][n+1];
        
        for(int i = 0; i<tIndex; i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        
        
        //그래프 초기화
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for(int i =0; i<=n ; i++ ){
            graph.add(new ArrayList<>());
        }
        for(int i =0; i<roads.length; i++){
            int p = roads[i][0];
            int q = roads[i][1];
            int s = roads[i][2];
            
            graph.get(p).add(new Edge(s,q,0));
            
            if(trapF[p] != -1 || trapF[q]!= -1){
                graph.get(q).add(new Edge(s,p,1));
            }
        }
        
        PriorityQueue<Status> pq = new PriorityQueue();
        dist[0][start] = 0;
        pq.offer(new Status(start,0,0));
        
        //다익 이키마쇼!!!
        while(!pq.isEmpty()){
            Status cur = pq.poll();
            int here = cur.to;
            int cost = cur.cost;
            int mask = cur.mask;
            int hereTrap = trapF[here];
                
            if(cost>dist[mask][here]) continue;
            if(here == end){
                    answer = cost;
                    break;
                }
            
            for(Edge temp : graph.get(here)){
                int weight = temp.w; 
                int next = temp.to;
                int foward = temp.foward;
                int nextTrap = trapF[next];
                int nextMask = 0;
                
                
                
                if(nextTrap != -1){
                    if((mask&nextTrap)==0){
                        nextMask = mask+nextTrap;
                    }else{
                        nextMask = mask-nextTrap;
                    }
                }else{
                    nextMask=mask;
                }
                
                if(dist[nextMask][next]<=cost+weight) continue;
                
                
                if(foward ==0){ //정방향
                    if(hereTrap != -1 && nextTrap != -1){ //트랩에서 트랩
                        if((mask & hereTrap)!=0 && (mask &nextTrap) !=0){
                            dist[nextMask][next] = cost+weight;
                            pq.offer(new Status(next,cost+weight,nextMask));
                        }else if((mask & hereTrap)==0 && (mask &nextTrap) ==0){
                            dist[nextMask][next] = cost+weight;
                            pq.offer(new Status(next,cost+weight,nextMask));
                        }
                    }else if(hereTrap != -1){ //트랩에서 일반
                        if((mask & hereTrap)==0){
                            dist[nextMask][next] = cost+weight;
                            pq.offer(new Status(next,cost+weight,nextMask));
                        }
                    }else if(nextTrap != -1){//일반에서 트랩
                        if((mask &nextTrap) ==0){
                            dist[nextMask][next] = cost+weight;
                            pq.offer(new Status(next,cost+weight,nextMask));
                        }
                    }else{ //일반 to 일반
                        dist[nextMask][next] = cost+weight;
                        pq.offer(new Status(next,cost+weight,nextMask));
                    }
                }else{//역방향
                    if(hereTrap != -1 && nextTrap != -1){ //트랩에서 트랩
                        if((mask & hereTrap)==0 && (mask &nextTrap) !=0){
                            dist[nextMask][next] = cost+weight;
                            pq.offer(new Status(next,cost+weight,nextMask));
                        }else if((mask & hereTrap)!=0 && (mask &nextTrap) ==0){
                            dist[nextMask][next] = cost+weight;
                            pq.offer(new Status(next,cost+weight,nextMask));
                        }
                    }else if(hereTrap != -1){ //트랩에서 일반
                        if((mask & hereTrap)!=0){
                            dist[nextMask][next] = cost+weight;
                            pq.offer(new Status(next,cost+weight,nextMask));
                        }
                    }else if(nextTrap != -1){//일반에서 트랩
                        if((mask &nextTrap) !=0){
                            dist[nextMask][next] = cost+weight;
                            pq.offer(new Status(next,cost+weight,nextMask));
                        }
                    }else{ //일반 to 일반
                        dist[nextMask][next] = cost+weight;
                        pq.offer(new Status(next,cost+weight,nextMask));
                    }
                }
            
                
               
                
                
            }
            
            
        }
        
        
        return answer;
    }
    
    
    
    
}