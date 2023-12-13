package solutions.seungtae.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_BOJ18258 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        S1_BOJ10845.MyQueue q = new S1_BOJ10845.MyQueue(n);
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
