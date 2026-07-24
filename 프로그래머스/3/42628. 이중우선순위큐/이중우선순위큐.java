import java.util.*;



class Solution {

    public  int[] solution(String[] operations) {

        Map<Integer, Integer> count = new HashMap<>();

        int[] answer = new int[]{0,0};

        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

        PriorityQueue<Integer> min = new PriorityQueue<>();

        

        for(String op : operations){

            String[] split = op.split(" ");

            String command = split[0];

            int num = Integer.parseInt(split[1]);

            

            if(command.equals("I")){

               

                max.offer(num);

                min.offer(num);

                if(count.get(num)!=null){

                    count.put(num,count.get(num)+1);

                }else{

                    count.put(num,1);

                }

                

            }else if(command.equals("D")){

             
                PriorityQueue<Integer> temp;

                if(num==1){
                    temp = max;
                }else{
                    temp = min;
                }

                while(!temp.isEmpty()){
                    int cur = temp.peek();
                    

                    if(count.get(cur)==0){
                        temp.poll();
                       
                        continue;

                    }else{
                        count.put(cur,count.get(cur)-1);
                        break;

                    }

                }

            }

            

            
            

        }

        
        while(!max.isEmpty()){

                   int cur = max.peek();

                    if(count.get(cur)==0){
                        max.poll();
                        continue;

                    }else{
                        
                        answer[0] = cur;

                        break;

                    }

                }

            while(!min.isEmpty()){

                   int cur = min.peek();

                    if(count.get(cur)==0){
                        min.poll();
                        continue;

                    }else{

                        answer[1] = cur;

                        break;

                    }

                }

        

        

        

        

        return answer;

    }

}