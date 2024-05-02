
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T;
        T = Integer.parseInt(br.readLine());

		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for (int i = 1; i <= T; i++) {
            int n = Integer.parseInt(br.readLine());
            Integer[][] arr = new Integer[n][n];
            System.out.println("#" + i);


            for (int x = 0; x < n; x++) {
                for (int j = 0; j <= x; j++) {
                    if (j == 0 || j == x) {
                        arr[x][j] = 1;
                    } else {
                        arr[x][j] = arr[x - 1][j - 1] + arr[x - 1][j];
                    }
                    System.out.print(arr[x][j]+" ");
                }
                System.out.print("\n");
            }


        }
    }
}
