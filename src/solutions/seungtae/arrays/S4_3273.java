package solutions.seungtae.arrays;

import problems.arrays.P4_3273;

import java.io.*;
import java.util.*;

public class S4_3273 implements P4_3273 {
    /*
        문제 분석 : 서로 다른 인덱스의 합이 자연수 x를 만족시키는 순서쌍의 개수
        - 수의 크기 n <= 10^6, 권장 시간복잡도 : NlogN 이하

        문제 풀이 :
            - 시간 복잡도상 이중 for문 불가능
            - 투포인터 활용
                1. start 포인터와 end 포인터 구분
                2. start<end인 동안 두 쌍의 합이 x를 만족하는 개수 카운팅
                    - start == end이면 end++, start=0
                    - end가 n에 도달하지 못하도록 신경써야 한다. (AOI 주의)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 크기 n의 배열 생성
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 배열 초기화
        for(int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // x
        int x = Integer.parseInt(br.readLine());

        int result = 0, start = 0, end = 1;

        while(start<end && end < n) {
            if(arr[start] + arr[end] == x) {
                result++;
            }

            if(start<end)
                start++;

            if(start==end) {
                start = 0;
                end++;
            }
        }

        System.out.println(result);

    }
}
