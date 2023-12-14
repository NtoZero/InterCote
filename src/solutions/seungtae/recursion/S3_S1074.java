package solutions.seungtae.recursion;

import java.io.*;
import java.util.*;

public class S3_S1074 {
    /*
        문제 분석 : Z 탐색 과정에서 R행 C열을 몇 번째로 방문하는지 출력
            - 아이디어 : 2*2로 분할하여 유효한 값에서 Z를 그리며 재귀

        문제 풀이
            - 재귀 :
                1. BASE CONDITION : R, C를 만날 때 해제
                2. 함수 정의
                    - 함수 N과 인자 R,C를 받아 Z재귀 하여 R,C번째 방문 순서를 출력
                    - 2^n * 2^n 배열에서 (r,c)를 방문하는 순서를 반환
     */

    //static int[][] arr; => X, (2^15)^2의 메모리로 힙 공간을 초과

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(func(N, R, C));
    }

    private static int func(int N, int R, int C) {
        if (N == 0) return 0;
        int half = 1 << (N - 1); // 2^(N-1) , Math.pow(2, N-1)
        if (R < half && C < half) return func(N - 1, R, C); // R,C가 1번 사각형
        if (R < half && C >= half) return half * half + func(N - 1, R, C - half); // R,C가 2번 사각형
        if (R >= half && C < half) return 2 * half * half + func(N - 1, R - half, C); // R,C가 3번 사각형
        return 3 * half * half + func(N - 1, R - half, C - half); // R,C가 4번 사각형
    }
}
