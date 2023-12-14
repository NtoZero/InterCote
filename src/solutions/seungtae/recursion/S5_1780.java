package solutions.seungtae.recursion;

import java.io.*;
import java.util.*;

public class S5_1780 {
    /*
        문제 분석 : 종이의 크기를 9등분해가며 같은 수를 저장하는 종이를 만나면 그 개수를 세서 -1, 0, 1 순으로 출력한다.

        문제 풀이 :
            1. base condition
                - 크기가 3^0, 즉 1*1에 도달하면 해당 숫자를 세고 종료
            2. 함수 정의
                - 인자 : 한 행의 크기 N (사이즈)
                - 인자2 : 행 열의 좌표
                - 기능 :
                    N을 9등분하여 같은 값을 가지고 있는 종이만 -1, 0, 1의 개수로 센다.
            3. 체크 함수 정의
                - 인자 : 사이즈, 시작행, 시작열
                - 배열[시작행][시작열]에서 시작하여 사이즈를 모두 돌아 같은 값을 가지고 있는지 여부를 판단
     */

    public static int[][] arr;
    public static int minusOne;
    public static int zero;
    public static int plusOne;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(N, 0, 0);

        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(plusOne);
    }

    //분할(사이즈, 시작점 행, 시작점 열)
    static void partition(int size, int row, int col) {
        // 같은 수로 이루어져 있는지 여부
        if(isSame(size, row, col)) {
            if(arr[row][col] == -1) {
                minusOne++;
            } else if(arr[row][col] == 0) {
                zero++;
            } else {
                plusOne++;
            }
            return;
        }

        int newSize = size / 3; // 3분할 (좌변 우변 모두가 3분할 되므로 최종적으로 9분할)

        partition(newSize, row, col); // 상좌단
        partition(newSize, row, col+newSize); // 상중단
        partition(newSize, row, col + 2*newSize); // 상상단

        partition(newSize, row+newSize, col); // 중좌단
        partition(newSize, row+newSize, col+newSize); // 중중단
        partition(newSize, row+newSize, col + 2*newSize); // 중우단

        partition(newSize, row+2*newSize, col); // 하좌단
        partition(newSize, row+2*newSize, col+newSize); // 하중단
        partition(newSize, row+2*newSize, col + 2*newSize); // 하우단
    }

    private static boolean isSame(int size, int row, int col) {
        int num = arr[row][col]; // 시작점의 좌표값

        // 해당 배열의 시작점부터 블럭 끝(row + size, col + size)까지 검사
        for(int i = row; i < row+size; i++) {
            for(int j = col; j<col+size; j++) {
                // 시작점 좌표값과 모든 값이 일치하는지 여부
                if(num != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
