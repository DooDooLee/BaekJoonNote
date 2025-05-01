import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args)throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	int s = Integer.parseInt(st.nextToken());
	int p  = Integer.parseInt(st.nextToken());
	String dna  = br.readLine();
	StringTokenizer st2 = new StringTokenizer(br.readLine());

	int a = Integer.parseInt(st2.nextToken());
	int c = Integer.parseInt(st2.nextToken());
	int g = Integer.parseInt(st2.nextToken());
	int t = Integer.parseInt(st2.nextToken());
	
	int [] count = new int[4];
	int result = 0;

	
	for(int i =0; i<p; i++) {
		char temp = dna.charAt(i);
		if(temp=='A') count[0]++;
		else if(temp == 'C') count[1]++;
		else if(temp == 'G') count[2]++;
		else if(temp == 'T') count[3]++;
	} 
	
	
	int right =p;
	int left = 0;
	
	
	if(a<=count[0] &&c<=count[1] &&g<=count[2] &&t<=count[3]) {
		result++;
	}
 	
	
	while(right<s) {
		
		char temp = dna.charAt(left);
		if(temp=='A') count[0]--;
		else if(temp == 'C') count[1]--;
		else if(temp == 'G') count[2]--;
		else if(temp == 'T') count[3]--;
		
		left++;
		
		
		temp = dna.charAt(right);
		if(temp=='A') count[0]++;
		else if(temp == 'C') count[1]++;
		else if(temp == 'G') count[2]++;
		else if(temp == 'T') count[3]++;
		right++;
		if(a<=count[0] &&c<=count[1] &&g<=count[2] &&t<=count[3]) {
			result++;
		}
	}
	
	
	
	System.out.println(result);
	
	
   br.close();
	

	}
}
