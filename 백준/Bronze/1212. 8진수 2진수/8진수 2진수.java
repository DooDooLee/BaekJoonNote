
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args)throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		String oct = br.readLine();
		
		Map<Character, String> map =new HashMap<>();
		
		map.put('0',"000");
		map.put('1',"001");
		map.put('2',"010");
		map.put('3',"011");
		map.put('4',"100");
		map.put('5',"101");
		map.put('6',"110");
		map.put('7',"111");
		
		
		for(int i =0; i<oct.length(); i++) {
			sb.append(map.get(oct.charAt(i)));
		}
		
		while(sb.length()>1 && sb.charAt(0)=='0') {
			sb.deleteCharAt(0);
		}
				
				
				
				
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
		
		
		
		
	}
}
	
