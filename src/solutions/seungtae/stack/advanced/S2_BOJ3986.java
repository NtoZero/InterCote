package solutions.seungtae.stack.advanced;

import problems.stack.advanced.P2_BOJ3986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class S2_BOJ3986 implements P2_BOJ3986 {
    /*
        문제 분석 : 선끼리 교차하지 않으면서 A-A, B-B 짝을 찾기
            - 단어의 수 : 10^2 단어의 길이 : 10^5 , 모든 단어 길이 합 10^6
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Character> stack = null;
        int result = 0; // 좋은 단어의 수

        for(int i=0; i<N; i++) {
            String str = br.readLine();
            stack = new Stack<>();
            boolean no = false; // 안좋은 수인지 체크
            for(char c : str.toCharArray()) {
                if(no) break;
                if(c=='A' || c == 'B') {
                    if(stack.isEmpty()) {
                        stack.push(c);
                    } else { // !stack.isEmpty()
                        if(c=='A' && stack.peek()=='A') {
                            stack.pop();
                            continue;
                        } else if(c=='B' && stack.peek()=='B') { // c == 'B'
                            stack.pop();
                            continue;
                        }
                        stack.push(c);
                    }
                }
            }
            if(!stack.isEmpty()) {
                no = true;
            } else {
                no = false;
            }
            if(!no) result++;
        }
        System.out.println(result);
    }
}
