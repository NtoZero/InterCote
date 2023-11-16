package solutions.seungtae.stack;

import problems.stack.P2_BOJ10773;

import java.io.*;
import java.util.*;

public class S2_BOJ10773 implements P2_BOJ10773 {
    /*
        문제 분석 : 재민이가 부른 수는 스택에 push하고 잘못 부른 수는 pop한다.
            - 시간 복잡도 : O(NlogN) 이하 권장. K<=10^6
            - 자료구조 : 스택, 스택은 모든 연산이 O(1)이므로 K번 연산해도 최대 10^6이다.

        주의 사항 : 해당 문제는 정수가 "0"일 경우 스택이 비어 있지 않음을 보장하지만, 다른 문제의 경우 비어 있는 경우도 유념.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int K = Integer.parseInt(br.readLine());
        for(int i=0; i<K; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) {
                stack.pop();
            } else {
                stack.push(num);
            }
        }

        // 마지막에 스택에 포함된 모든 수의 합 계산
        int sum = 0;
        while(!stack.isEmpty()) {
            sum += stack.pop();
        }
        System.out.println(sum);
    }
}
