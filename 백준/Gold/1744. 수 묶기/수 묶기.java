import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        
        List<Integer> plus = new ArrayList<>(); 
        List<Integer> minus = new ArrayList<>(); 
        int zero = 0;
        int sum =0;
        for(int i = 0; i<n; i++) {
        	int num = Integer.parseInt(br.readLine());
        	if(num>0) {
        		plus.add(num);
        	}else if(num == 0) {
        		zero++;
        	}else {
        		minus.add(num);
        	}
        }
        
        Collections.sort(plus,Comparator.reverseOrder());
        Collections.sort(minus);
        
        for(int i =0; i<plus.size(); i+=2) {
        	if(i+1>=plus.size()) {
        		sum += plus.get(i);
        	}else{
        		if(plus.get(i)==1 || plus.get(i+1)==1) {
        			sum += plus.get(i)+plus.get(i+1);
        		}else {
        			sum += plus.get(i)*plus.get(i+1);
        		}
        	}
        }
        
        
        for(int i=0; i<minus.size(); i+=2) {
        	if(i+1>=minus.size()) {
        		if(zero >0) {
        			zero--;
        		}else {
        			sum += minus.get(i);
        		}
        	}else {
        	sum += minus.get(i)*minus.get(i+1);
        	}
        }
        
        System.out.println(sum);
        
        
       
        br.close();
    }
}
