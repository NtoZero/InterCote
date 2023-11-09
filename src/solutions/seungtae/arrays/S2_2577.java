package solutions.seungtae.arrays;

import problems.arrays.P2_2577;

import java.io.*;
import java.util.*;

public class S2_2577 implements P2_2577 {
    /*
        문제 요약 : A * B * C의 계산 결과에 0 ~ 9까지 각 숫자가 몇 번씩 쓰였는지 구하는 프로그램
        - 주의 사항 : A * B * C가 int 범위를 넘는가?(overflow 여부) => X 최대도 10^9 미만이다.

        - 문제 풀이 :
            양의 정수 0~9까지의 숫자를 세는 문제 => 계수 정렬(counting sort)를 이용한다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int multiple = A*B*C;
        String mulStr = String.valueOf(multiple); // 각 char형을 분리하기 위한 형변환

        int[] countArr = new int[10]; // 0 ~ 9까지 인덱스를 담을 숫자
        for(int i=0; i<mulStr.length(); i++) {
            int idx = mulStr.charAt(i)-'0'; // 문자 숫자를 숫자로 형변환 (ASCII)
            countArr[idx]++;
        }

        for(int i=0; i<countArr.length; i++) {
            System.out.println(countArr[i]);
        }
    }
}
