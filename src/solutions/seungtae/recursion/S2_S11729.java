package solutions.seungtae.recursion;

import java.util.*;

public class S2_S11729 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        System.out.println((1 << k) - 1); // 하노이 탑의 최소 이동 횟수 구하는 공식 : 2^k-1
        func(1, 3, k);
        System.out.println(sb);
    }

    private static void func(int start, int goal, int n) {
        if (n == 1) { // base condition : n은 1일 때 a에서 b로 이동
            sb.append(start + " " + goal+"\n");
            return;
        }
        // start 탑에서 n-1까지의 원판을 또다른 탑으로 옮겨야 한다.
        func(start, 6 - start - goal, n - 1); // 6 - start - goal : 시작과 목표지점이 아닌 다른 봉
        sb.append(start + " " + goal+"\n");
        // 그 n-1까지의 원판을 goal 지점으로 다시 옮겨야 한다.
        func(6 - start - goal, goal, n - 1);
    }
}
