package solutions.seungtae.recursion;

import java.io.*;
import java.util.*;
public class S6_2630 {
    /*
        문제 분석 : 4분할로 분할하며 같은 색을 지니고 있는 흰색종이와 파란색 종이의 개수 세기

        문제 풀이 :
            1. base condition:
                정사각형의 크기가 1이거나 사각형 내부의 모든 숫자가 같으면 개수 세고 종료
            2. 함수 정의:
                - 인자 (사이즈, 시작점)
                - 기능
                    base condition을 체크해서 만족하지 않으면 지속적으로 정사각형을 분할하는 함수
     */

    static int[][] arr;
    static int white;
    static int blue;

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

        System.out.println(white);
        System.out.println(blue);
    }

    static void partition(int size, int row, int col) {
        //1. base condition
            // 모두 같은 숫자를 가지고 있으면 숫자를 세고 탈출한다.
        if(size==1 || checkSameFill(size, row, col)) {
            if(arr[row][col]==0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        //2. 같은 숫자를 가지고 있지 않으면 4분할한다. 한 행을 2분할하면 4분할이다.
        int half = size/2;

        partition(half, row, col); // 좌상단
        partition(half, row, col+half); // 우상단
        partition(half, row+half, col); // 좌하단
        partition(half, row+half, col+half); // 우하단

    }

    private static boolean checkSameFill(int size, int row, int col) {
        int num = arr[row][col]; //시작점의 요소

        // 시작행, 시작열부터 시작하여 size만큼 순회하여 모든 값이 일치하는지 여부를 리턴 (사이즈가 1이어도 false 리턴)
        for(int i=row; i<row+size; i++) {
            for(int j=col; j<col+size; j++) {
                if(arr[i][j]!=num) {
                    return false;
                }
            }
        }

        // 모두 일치하면 true 리턴
        return true;
    }
}
