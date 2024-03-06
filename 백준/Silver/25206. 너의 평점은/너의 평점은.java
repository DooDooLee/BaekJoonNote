import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double sum = 0;
        double count = 0;
        while(sc.hasNext()){
            String s = sc.next();
            double a = sc.nextDouble();
            String d = sc.next();
            //스위치문은 실수형 타입불가능 ,  ""문자열 ''문자
            switch(d){
                case "A+":
                    sum += 4.5*a;
                    count+=a;
                    break;
                case "A0":
                    sum += 4.0*a;
                    count+=a;
                    break;
                case "B+":
                    sum += 3.5*a;
                    count+=a;
                    break;
                case "B0":
                    sum += 3.0*a;
                    count+=a;
                    break;
                case "C+":
                    sum += 2.5*a;
                    count+=a;
                    break;
                case "C0":
                    sum += 2.0*a;
                    count+=a;
                    break;
                case "D+":
                    sum += 1.5*a;
                    count+=a;
                    break;
                case "D0":
                    sum += a;
                    count+=a;
                    break;
                case "F":
                    sum += 0;
                    count+=a;
                    break;
            }

        }

        System.out.println(sum/count);
        sc.close();





    }
}
