package solutions.seungtae.arrays;

import java.io.*;
import java.util.*;

public class S3_1475 {
    /*
        문제 분석: 방 번호 구성에 필요한 0~9 숫자 세트의 개수 구하기. 단, 6 || 9 활용 가능
        - 시간 복잡도 : O(NlogN) 이하 권장 (N <= 10^6)

        - sudo
            1. 0~9 세트를 담는 배열을 만든다.
            2. for문으로 roomNum의 숫자를 순회한다.
            3. 세트를 순회하며 최대 값을 찾는다.
                단, 6과 9는 이중으로 활용할 수 있으므로 별도로 집계한다.
                (6+9 필요한 개수 / 2) => 세트의 개수. 홀수면 +1 세트가 더 필요하다.
            나머지 배열의 최대 값과 6+9 세트의 카운트 값을 비교하여 그 중 우세값 출력
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String roomNum = br.readLine();

        // 1. 0~9 세트를 담는 배열을 만든다.
        int[] numSet = new int[10];

        // 2. for문으로 roomNum의 숫자를 순회한다.
        for(int i=0; i<roomNum.length(); i++) {
            int idx = roomNum.charAt(i)-'0';
            numSet[idx]++;
        }

        // 3. 세트를 순회하며 최대 값을 찾는다.
        int sixOrNine = 0;
        int max = 0;
        for(int i=0; i<numSet.length; i++) {
            if( i == 6 || i == 9) {
                sixOrNine += numSet[i];
                continue;
            }
            if(numSet[i]>max) {
                max = numSet[i];
            }
        }

        if(sixOrNine %2 == 0) sixOrNine= sixOrNine/2;
        else sixOrNine = sixOrNine/2+1;

        System.out.println(Math.max(max, sixOrNine));
    }
}
