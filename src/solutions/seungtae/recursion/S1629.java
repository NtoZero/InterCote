package solutions.seungtae.recursion;

import java.util.*;
import java.io.*;

public class S1629 {
    /*
        - 권장 시간복잡도 : logN 이하 (b가 최대 21억번 연산되므로)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long A, B, C = 0L;
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(pow(A, B, C));
    }

    static long pow(long a, long b, long mod) { // a ^ b % m
        if(b==1) {
            System.out.printf("a: %d, b: %d, mod: %d, a 모듈러 mod: %d\n", a, b, mod, a % mod); // 로깅
            return a % mod;
        }
        long result = pow(a, b/2, mod); // O(N -> logN), 지수 b를 절반으로 나눈다.

        System.out.printf("a: %d, b: %d, mod: %d, result: %d\n", a, b, mod, result); // 로깅

        // 거듭제곱 원상 복구 (지수를 2로 나누었으므로)
        result = result * result % mod;
        if(b%2==0) { // 지수 b가 짝수일 경우 원상 복구 완료
            return result;
        } else { // 지수 b가 홀수일 경우 a를 한 번 더 곱하고 m 모듈러 연산을 해주어야 원상복구 완료
            return result * a % mod;
        }
    }
}
