import java.io.*;

public class Main {
    public static int [] tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());


        int [] src = new int[size];
        tmp = new int[src.length];

        for(int i=0; i<size; i++){
            src[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(src,0,src.length-1);
        for(int i : src){
            bw.write(i+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mergeSort(int[] src, int start, int end){
        if(start < end) {
            int mid = (start + end) / 2;
            mergeSort(src, start, mid);
            mergeSort(src, mid + 1, end);
            int p = start;
            int q = mid+1;
            int k = start;
            while(p<=mid && q<=end){
                if(src[p]<=src[q]){
                    tmp[k] = src[p];
                    p++;
                }
                else{
                    tmp[k]=src[q];
                    q++;
                }
                k++;
            }
            if(p>mid){
                for(int i = q; i<=end; i++){
                    tmp[k] = src[i];
                    k++;
                }
            }else{
                for(int i = p; i<=mid; i++){
                    tmp[k] = src[i];
                    k++;
                }
            }
            for(int i = start; i<=end; i++){
                src[i]=tmp[i];
            }
        }
    }
}