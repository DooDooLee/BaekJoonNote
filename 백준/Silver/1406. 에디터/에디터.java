import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stR = new Stack<>();
        Stack<Character> stL = new Stack<>();
        String sr = br.readLine();

        for(int i=0; i<sr.length(); i++){
            stL.push(sr.charAt(i));
        }

        int T = Integer.parseInt(br.readLine());
        char word ;
        for(int i=0; i<T; i++){
            word = (char)br.read();
            if(word == 'L'){
                if(!stL.isEmpty())
                    stR.push(stL.pop());
            }
            else if(word =='D'){
                if(!stR.isEmpty())
                    stL.push(stR.pop());
            }
            else if(word =='B'){
                if(!stL.isEmpty())
                    stL.pop();
            } else if(word =='P'){
                br.read();
                char word2 = (char)br.read();
                stL.push(word2);
            }
            br.readLine();
        }

        while(!stL.isEmpty()){
            stR.push(stL.pop());
        }

        while(!stR.isEmpty()){
           bw.write(stR.pop());
        }

        br.close();
        bw.flush();
        bw.close();
    }
}

