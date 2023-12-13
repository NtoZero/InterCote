package solutions.seungtae.deque;

import problems.deque.P1_BOJ10866;

import java.io.*;
import java.util.StringTokenizer;

public class S1_BOJ10866 implements P1_BOJ10866 {
    /*
        문제 분석 : 덱 구현
     */

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        MyDeque deque = new MyDeque(N);
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int pushNum = 0;
            if(command.startsWith("push")) pushNum = Integer.parseInt(st.nextToken());


            switch (command) {
                case "push_front":
                    deque.push_front(pushNum);
                    break;
                case "push_back":
                    deque.push_back(pushNum);
                    break;
                case "pop_front":
                    deque.pop_front();
                    break;
                case "pop_back":
                    deque.pop_back();
                    break;
                case "size":
                    deque.size();
                    break;
                case "empty":
                    deque.doEmpty();
                    break;
                case "front":
                    deque.front();
                    break;
                case "back":
                    deque.back();
                    break;
            }
        }
        System.out.println(sb);
    }
    static class MyDeque {
        int[] arr;
        int head;
        int tail;

        public MyDeque(int n) {
            arr = new int[2*n]; // n의 최대값이 1만이므로 2만이어도 메모리 4byte * 2만. 최대 메모리를 초과하지 않는다.
            head = n/2;
            tail = n/2;
        }

        void push_front(int x) {
            int size = tail-head;
            if(size==0) arr[head] = x;
            arr[--head] = x;
        }

        void push_back(int x) {
            arr[tail++] = x;
        }

        void pop_front() {
            sb.append(isEmpty() ? "-1\n" : arr[head++]+"\n");
        }

        void pop_back() {
            sb.append(isEmpty() ? "-1\n" : arr[--tail]+"\n");
        }

        void size() {
            // head - tail > 0 이면 사이즈라고 볼 수 없다.
            sb.append(head>tail? "-1\n" : tail-head+"\n");
        }

        void doEmpty() {
            sb.append(isEmpty()? "1\n" : "0\n");
        }
        private boolean isEmpty() {
            return head>=tail;
        }

        public void front() {
            sb.append(isEmpty()? "-1\n" : arr[head]+"\n");
        }

        public void back() {
            sb.append(isEmpty()? "-1\n" : arr[tail-1]+"\n");
        }

    }
}
