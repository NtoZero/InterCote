package solutions.seungtae.stack;

import problems.stack.P1_BOJ10828;

import java.util.*;
import java.io.*;

public class S1_BOJ10828 implements P1_BOJ10828 {
    /*
        문제 분석 : stack 구현에 관한 문제
     */

    static int[] data; // 스택에 포함할 요소
    static int pos; // 현재 스택의 크기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        data = new int[N]; // 배열의 요소 개수가 N보다 크지는 않을 것이다.
        for(int i=0; i<N; i++) {
            String[] commandArr = br.readLine().split(" ");
            String command = commandArr[0];
            int pushNum = 0;
            if(command.equals("push")) {
                pushNum = Integer.parseInt(commandArr[1]);
            }

            switch (command) {
                case "push":
                    data[pos++] = pushNum;
                    break;
                case "top":
                    sb.append(pos != 0 ? data[pos-1]+"\n" : -1+"\n");
                    break;
                case "size":
                    sb.append(pos+"\n");
                    break;
                case "empty":
                    sb.append(pos==0 ? 1 +"\n" : 0 + "\n");
                    break;
                case "pop":
                    sb.append(pos==0 ? -1 +"\n" : data[--pos] +"\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
