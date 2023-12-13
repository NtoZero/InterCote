package solutions.seungtae.deque;

import problems.deque.P3_BOJ5430;

import java.util.*;
import java.io.*;

public class S3_BOJ5430 implements P3_BOJ5430 {
    /*
        문제 분석: 함수 뒤집기 R / 첫 수 버리기 D
            - 시간제한 1초, 메모리 제한 256MB
            - 변수의 크기:
                테스트 케이스 T (10^2), 함수 P(10^5), 배열 개수 N (10^5)

        문제 풀이:
            - R이 존재할 때마다 배열을 reverse 하게 되면 그 때마다 O(N)의 시간 복잡도가 소요되므로 위험하다. (특히 전부 R일 경우)
            - 처음부터 덱으로 배열을 구성하여 R이 나타날 때마다 앞에서 remove할지, 뒤에서 remove할지의 여부만 바꿔준다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // TC 개수
        String command = ""; // 함수 P
        int N = 0; // 배열 개수
        Deque<Integer> deque = null; // 구성할 덱

        for(int i=0; i<T; i++) {
            command = br.readLine();
            N = Integer.parseInt(br.readLine());
            String tmp = br.readLine();
            String[] strArr = tmp.substring(1, tmp.length()-1) // 첫 [ 과 끝 ] 제거
                    .split(","); // O(N), N은 문자열 길이
            deque = new ArrayDeque<>();
            if(N!=0) {
                for(String s : strArr) { // O(N)
                    deque.add(Integer.valueOf(s));
                }
            }

            boolean reversed = false; // reversed 여부 초기화, // 배열이 뒤집혔는지 여부, false면 removeFirst(), true면 removeLast()
            boolean error = false; // error 여부 초기화
            for(char c : command.toCharArray()) {
                if(error) break;
                switch (c) {
                    case 'R':
                        reversed = !reversed;
                        break;
                    case 'D':
                        if(deque.isEmpty()) {
                            System.out.println("error");
                            error = true;
                            break;
                        }
                        if(!reversed) {
                            deque.removeFirst();
                        } else {
                            deque.removeLast();
                        }
                        break;
                }
            }
            if(!error) { //error가 발생하지 않았다면
                // reversed 여부에 따라 마지막에 한 번만 뒤집어 준다.
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                while(!deque.isEmpty()) {
                    if(reversed) {
                        sb.append(deque.removeLast()+",");
                    } else {
                        sb.append(deque.removeFirst()+",");
                    }
                }
                sb.deleteCharAt(sb.length()-1); // 마지막 ,(콤마) 지우기
                sb.append("]");
                System.out.println(sb);
            }
        }
    }
}
