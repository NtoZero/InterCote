package solutions.seungtae.stack.advanced;

import problems.stack.advanced.P3_BOJ10799;

import java.util.*;
import java.io.*;

public class S3_BOJ10799 implements P3_BOJ10799 {
    /*
        문제 분석: 레이저'()'로 잘리는 쇠막대기의 개수 구하기
            - 괄호 문자의 개수 : 10^7
            - 점화식 : 잘라진 쇠막대기 수 => 쇠막대기 안의 레이저 수 +1
                => 큰 괄호 안에 레이저가 몇 개 있는지 여부를 체크
        문제 풀이:
            1. 열린 괄호 (가 들어오면 push, 닫힌 괄호 )이 들어오면 pop
            2. 인접 괄호쌍 () => 레이저.
                -> 스택의 사이즈만큼 결과값을 더한다.
                    괄호가 닫히기 전에 레이저가 추가되면 남은 ( 갯수 만큼 쇠막대기 갯수 증가.
            3. 연속으로 )가 제시되면 결과값 +1.
                -> )가 연속되어 있으면 쇠막대기가 하나씩 증가됨.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        char beforeCh = '0';
        for(char c : str.toCharArray()) {
            if(c== '(') {
                stack.push(c);
            } else if (c==')') {
                stack.pop();
                if(beforeCh == '(') { // 레이저일 경우 (인접한 괄호 쌍일 경우)
                    result += stack.size();
                } else { // 레이저가 아닐경우 1씩 결과값 증가
                    result++;
                }
            }
            beforeCh = c;
        }
        System.out.println(result);
    }
}
