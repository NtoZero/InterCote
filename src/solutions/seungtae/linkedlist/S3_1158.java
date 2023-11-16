package solutions.seungtae.linkedlist;

import problems.linkedlist.P3_1158;

import java.util.*;
import java.io.*;

public class S3_1158 implements P3_1158 {
    /*
        문제 분석 : (N, K) 요세푸스 순열
        - 1~N까지의 원에서 제거되는 순서
        - K <= N <= 5*10^3

        문제 풀이 :
            자료 구조 : 원형 linkedList
                - But 자바에서는 원형 LinkedList가 없다.
                - CollectionFramework의 이중 연결리스트를 기본적으로 구현한 다음,
                    모듈러 연산을 통해 요세푸스 순열을 구한다.

        리스트 (요세프스 7,3일 때)
            1 2 3 4 5 6 7 -> 3제거 idx:2
            1 2 4 5 6 7 -> 6제거 idx:4
            1 2 4 5 7 -> 2제거 idx:1
            1 4 5 7 -> 7제거 idx:3
            1 4 5 -> 5제거 idx:2
            1 4 -> 1제거 idx:0
            4 -> 4제거 idx:0

            Y(7,3) -> i번째 제거되는 인덱스 => 직전idx+2 % size

        점화식
            Y(N,K) ->
                - idx = (직전 idx+(K-1)) % 현재 size
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> list = new LinkedList<>();
        // 연결 리스트 요소 : 1~N까지 추가
        for(int i=1; i<=N; i++) {
            list.add(i);
        }

        List<Integer> answer = new ArrayList<>();

        int idx = 0; //초기식
        for(int i=0; i<N; i++) { // N번동안 순회한다.
            // 갱신: idx = (직전 idx+(K-1)) % 현재 size
            idx = (idx+(K-1)) % list.size();

            int target = list.remove(idx);
            answer.add(target); // 정답 배열에 추가
        }

        //출력
        bw.write("<");
        for(int i=0; i<answer.size(); i++) {
            bw.write(answer.get(i)+"");
            if(i != answer.size()-1) {
                bw.write(", ");
            }
        }
        bw.write(">");
        bw.close();
    }
}
