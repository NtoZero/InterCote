package solutions.seungtae.recursion;
//https://www.acmicpc.net/problem/17478

import java.io.*;
import java.util.*;

public class S4_17478 {
    /*
        문제 분석 : 재귀에 따른 채팅 사용구 출력
            단 재귀가 발생할 때 '____'을 붙여야 함.

        문제 풀이 :
                1. Base Condition
                    예제 입력 N이 0이되면 재귀함수에 대한 답변을 하고 종료한다.
                2. 함수 정의
                    인자 N을 받아 N이 0이 되는 순간 모든 상용구를 출력하는 함수
                        주의 사항으로 prefix '____'를 붙여야 한다.
                        이 때 prefix는 재귀가 깊어질수록 2배씩 늘어난다.
                            => 인자2로 depth를 받는다.
     */

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n"); // 재귀 x

        func(N, 0);
        System.out.println(sb);
    }

    private static void func(int n, int depth) {
        String prefix = "_".repeat(depth*4);

        //base condition
        if(n<0) return;

        if(n==0) {
            sb.append(prefix).append("\"재귀함수가 뭔가요?\"\n");
            sb.append(prefix)
                    .append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
        } else {
            sb.append(prefix).append("\"재귀함수가 뭔가요?\"\n");
            sb.append(prefix).append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
            sb.append(prefix).append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
            sb.append(prefix).append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
        }


        //recursion
        func(n-1, depth+1); // 증감 연산자를 사용하면 안됨! 증감 연산자를 사용하면 이전 스택에서 변수가 변한다. 결국 스택오버플로우 에러 발생
        sb.append(prefix).append("라고 답변하였지.\n");
    }
}
