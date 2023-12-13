package solutions.seungtae.stack.advanced;

import problems.stack.advanced.P1_BOJ4949;

import java.io.*;
import java.util.*;

public class S1_BOJ4949 implements P1_BOJ4949 {
    /*
        문제 분석 : 소괄호와 대괄호의 짝을 이루는 문장은 yes, 아닌 문장은 no를 출력한다.

        문제 풀이 :
            1. 여는 괄호는 스택에 담는다.
            2. 닫는 괄호를 마주치면 스택과 비교한다.
                - 스택이 비어 있으면 no를 출력한다.
                - 스택이 존재하면서 top이 닫는 괄호와 일치하지 않으면 no를 출력한다.
                - 스택이 존재하면서 top이 닫는 괄호와 일치하면 마지막에 empty()여부를 따져 본다.
                    - !isEmpty()면 "yes"를 출력한다.
                    - !isEmpty()면 "no"를 출력한다.

        주의 사항 :
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = null;

        while(true) {
            stack = new Stack<>(); // 새 스택으로 초기화
            boolean no = false; // no를 출력할지의 여부

            String str = br.readLine();
            if(str.equals(".")) break; // 종료 조건 마지막 온점

            for(Character c : str.toCharArray()) {
                switch(c) {
                    case '[':
                    case '(':
                        stack.push(c);
                        break;
                    case ']':
                        if(stack.isEmpty())
                            no = true;
                        else { // !stack.isEmpty()
                            if(stack.peek().equals('[')) {
                                stack.pop();
                            } else {
                                no = true;
                            }
                        }
                        break;
                    case ')':
                        if(stack.isEmpty())
                            no = true;
                        else { // !stack.isEmpty()
                            if(stack.peek().equals('(')) {
                                stack.pop();
                            } else {
                                no = true;
                            }
                        }
                        break;
                }
            }

            // 위의 과정을 진행하고 스택이 비어 있으면서 !no이면 yes를 입력
            if(stack.isEmpty() && !no) {
                sb.append("yes\n");
            } else { // stack.isEmpty() || no
                sb.append("no\n");
            }
        }

        System.out.println(sb);
    }
}
