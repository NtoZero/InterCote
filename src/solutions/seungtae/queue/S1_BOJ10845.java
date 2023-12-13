package solutions.seungtae.queue;

import problems.queue.P1_BOJ10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_BOJ10845 implements P1_BOJ10845 {
    /*
        문제 분석 : 큐2와 큐1은 같은 문제이므로 모수가 큰 큐2(18258)를 기준으로 풀이하겠음
            - 모수 N 2*10^6 -> NlogN 이하의 알고리즘 권장됨

        큐 구현 :
            데이터를 저장할 배열 int[] arr
            커서를 가리킬 int cur
            마지막으로 집어넣을 위치를 가리킬 int pos

            push : 데이터를 추가한다.
     */

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        MyQueue q = new MyQueue(n);
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int pushNum = 0;
            if(command.equals("push")) pushNum = Integer.parseInt(st.nextToken());
            switch (command) {
                case "push":
                    q.push(pushNum);
                    break;
                case "pop":
                    q.pop();
                    break;
                case "front":
                    q.front();
                    break;
                case "back":
                    q.back();
                    break;
                case "empty":
                    q.empty();
                    break;
                case "size":
                    q.size();
                    break;
            }
        }
        System.out.println(sb);
    }

    static class MyQueue {
        int[] arr;
        int pos ; // 마지막 인덱스 보다 +1
        int cur ; // poll()의 대상이 되는 FIFO 인덱스

        public MyQueue(int n) {
            this.arr = new int[n];
        }

        void push(int num) {
            arr[pos++] = num;
        }

        void pop() {
            sb.append(cur>=pos ? "-1\n" : arr[cur++]+"\n");
        }

        void size() {
            sb.append(pos-cur+"\n");
        }

        void empty() {
            sb.append(cur==pos ? "1\n" : "0\n");
        }

        void front() {
            sb.append(cur>=pos ? -1+"\n" : arr[cur]+"\n");
        }

        void back() {
            sb.append(cur>=pos || pos-1<0 ? -1+"\n" : arr[pos-1]+"\n");
        }
    }
}
