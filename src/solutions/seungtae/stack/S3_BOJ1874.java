package solutions.seungtae.stack;

import problems.stack.P3_BOJ1874;

import java.io.*;
import java.util.*;

public class S3_BOJ1874 implements P3_BOJ1874 {
    /*
        문제 분석: 스택의 오름차순 push()와 주어진 수 pop()을 이용해 +, - 를 출력 한다.
                    단, 스택 수열이 불가능한 경우 (LIFO를 충족하지 못하는 경우)는 NO를 출력한다.

        문제 풀이:
            - 시간복잡도 : NlogN 이하 권장 (N<=10^6)
            - 자료구조 : Stack (모든 연산 시간복잡도 1)

            sudo:
                1) N을 받는다.
                2) for문으로 N번 만큼 주어진 수 K 를 받는다.
                    - 주어진 수 K를 만날 때까지 오름차순 숫자를 push()한다. + 스트링 빌더를 이용해 (+)를 누적한다.
                    - if(주어진 수 K를 만나면) pop()한다. 스트링 빌더로 - 를 누적한다.
                    - for문의 다음 숫자로 넘어간다. 반복.
                3)언제 "NO"를 출력할까?
                    - 위 과정을 거치고 주어진 수 K보다 스택의 최상단이 크면 "NO"를 출력한다.
                    - 스트링 빌더를 초기화한 다음, "NO"를 붙인다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int num = 1; // 오름차순으로 증가할 수 num
        for(int i=1; i<=N; i++) {
            int k = Integer.parseInt(br.readLine());
            while(num <= k) { // num은 오름차순으로 증가하며 k를 만날 때까지 push()되어야 한다.
                stack.push(num++);
                sb.append("+\n");
            }
            // num > k 이면서
            // stack의 peek()이 k 이상이면 pop()으로 수열을 만들 수 있다.
            if(!stack.isEmpty() && stack.peek() == k) { // peek()이 k에 도달 했을 때 pop()한다.
                stack.pop();
                sb.append("-\n");
            }

            // num > k 이면서
            if(!stack.isEmpty() && stack.peek()>k) { // k보다 stack의 최상단에 있는 숫자가 크면
                sb = new StringBuilder();
                sb.append("NO");
                break;
            }
        }
        System.out.println(sb);
    }
}
