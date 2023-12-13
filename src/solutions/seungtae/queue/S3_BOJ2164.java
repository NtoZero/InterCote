package solutions.seungtae.queue;

import problems.queue.P3_BOJ2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class S3_BOJ2164 implements P3_BOJ2164 {
    /*
        문제 분석: FIFO 구조로 한 번은 head를 버리고, 한 번은 head를 끝에 추가하는 방식
        - 자료 구조 : Queue
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue q = new ArrayDeque();
        int N = Integer.parseInt(br.readLine());
        for(int i=1; i<=N; i++) {
            q.add(i);
        }
        while(q.size()!=1) {
            q.remove();
            q.add(q.poll());
        }
        System.out.println(q.poll());
    }
}
