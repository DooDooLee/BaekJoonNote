
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args)throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	String a = br.readLine();
	Stack<Character> st =new Stack<>();
	StringBuilder sb = new StringBuilder();

	for(int i =0; i<a.length(); i++) {
		
		char t = a.charAt(i);
		if(!isC(t)) {
			sb.append(t);
		}else {
			if(t=='(') {
				st.push(t);
			}else if(t==')') {
				while(st.peek()!='(') {
					sb.append(st.pop());
				}
				st.pop();
				
			}else {
				
				while(!st.isEmpty()&&p(st.peek())>=p(t) ) {
					sb.append(st.pop());
				}
				st.push(t);
			}
			
			
			
		}
		
	}
	
	while(!st.isEmpty()) {
		sb.append(st.pop());
	}
	
	System.out.println(sb.toString());
	
	
	
	
	
	
	
	
	
	}	
	
	static int p(char a) {
		if(a=='+'||a=='-') {
			return 1;
		}else if(a=='*'||a=='/') {
			return 2;
		}else {
			return 0;
		}
	}
	
	
	
	static boolean isC(char a ) {
		if(a=='+'||a=='*'||a=='-'||a=='/'||a==')'||a=='(') {
			return true;
		}else {
			return false;
		}
	}
}

    
