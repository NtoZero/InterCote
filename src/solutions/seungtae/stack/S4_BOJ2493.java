package solutions.seungtae.stack;

import java.util.*;
import java.io.*;

public class S4_BOJ2493 {
    /*
        문제 분석 : N개의 높이가 서로 다른 탑이 수평 직선에 배치되어 있을 때,
                    각각의 탑이 우->좌로 송신하는 레이저가 어떤 인덱스의 탑에서 가장 먼저 만나는지 기록
            - 시간 복잡도 : O(NlogN) 이하 권장 ( N<= 5*10^5 )

            - 주의 사항 : 탑들의 높이가 10^8, long타입을 써야하나? 일단 int 범위 안.

            - 주의 사항2 : 배열 2개를 만들 경우 쉽게 풀이할 수 있지만 최악의 경우 시간 복잡도가 등차수열의 합 O(N*(N+1)/2)가 된다.
                - 이 때의 최악의 경우란, 탑이 오름차순일 경우를 의미한다.
                    => 스택을 활용한다. 가장 끝 원소부터 첫 원소까지 역순으로 순회하며 조건식에 해당하는 수의 '인덱스'를 정답배열에 기록한다.
                        - 스택에 담는 값도 '인덱스'로 한다.
                        - 현재 원소가 arr[스택의 peek()]보다 작으면 넘어간다.
                        - 현재 원소가 arr[스택의 peek()]보다 크면 현재 원소의 '인덱스'를 정답 배열 answer[스택의 pop()]에 기록한다.
                            - 비교하는 것은 while문으로 한다. 스택의 pop()으로 바뀌는 인덱스가 여전히 처음으로 자기 요소 값보다 큰 값을 만나는지 확인해야 한다.


        문제 풀이:
            - 필요한 것:
                1) Stack<Integer> stack ( 인덱스 값 )
                2) N+1 크기의 int[] arr
                3) N+1 크기의 정답 배열 int[] answer
            - SUDO:
                1) 탑들의 개수 N을 받는다. N+1 크기의 배열을 선언 한다.
                    - int[] arr = new int[N+1];
                        - N+1로 시작하는 이유는 첫 탑의 인덱스를 1로 계산하기 위함
                2) 배열의 1번부터 N번 인덱스까지 탑의 높이를 저장(초기화)한다.
                3) 배열의 N번부터 1번까지 역순으로 돌며
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] answer = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int k = Integer.parseInt(st.nextToken());
            arr[i] = k;
        }

        Stack<Integer> stack = new Stack<>();
        // 역순
        for(int i=N; i>=1; i--) {
            stack.push(i); // i는 인덱스
            int curIdx = i-1;
            while(!stack.isEmpty() && arr[curIdx] > arr[stack.peek()]) {
                answer[stack.pop()] = curIdx;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) {
            sb.append(answer[i]+" ");
        }
        System.out.println(sb);
    }
}

/*
 시간 초과
 public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] answer = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            int k = Integer.parseInt(st.nextToken());
            arr[i] = k;
        }

        for(int i=1; i<=N; i++) {
            int start = i;
            int idx = i-1;
            while(idx > 0) {
                if(arr[idx] > arr[start]) {
                    answer[start] = idx;
                    break;
                }
                idx--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) {
            sb.append(answer[i]+" ");
        }
        System.out.println(sb);
    }
 */