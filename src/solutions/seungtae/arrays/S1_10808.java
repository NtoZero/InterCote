package solutions.seungtae.arrays;

import problems.arrays.P1_10808;

import java.util.*;
import java.io.*;

public class S1_10808 implements P1_10808 {
    /*
        문제 분석 : 특정 단어에 포함된 알파벳의 개수를 출력하는 문제
        N <= 100, => O(N^4) 이하 권장
        - 이용 알고리즘 : 계수 정렬 (Counting Sort) , 양의 인덱스
        - 소문자 'a'는 ASCII 상 97을 의미하는 것을 이용한다. (대문자는 65)
            - ASCII 코드가 생각나지 않는다면 다른 방법을 이용할수도 있다. 문자 'z'를 선언한 후, 배열의 크기를 'z+1'만큼 놓은 다음,
              'a'부터 'z'까지의 계수 정렬에 포함되어 있는 숫자를 출력하면 된다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char a = 'a';
        char z = 'z';

        // 알파벳 개수
        int[] countArr = new int[z+1];

        String word = br.readLine();

        for(char ch : word.toCharArray()) {
            countArr[ch]++;
        }

        for(int i=a; i<=z; i++) {
            sb.append(countArr[i]+" ");
        }

        System.out.println(sb);
    }
}
