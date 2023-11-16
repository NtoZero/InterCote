package solutions.seungtae.linkedlist;

import problems.linkedlist.P2_5397;

import java.io.*;
import java.util.*;

public class S2_5397 implements P2_5397 {
    /*
        문제 분석 :
            - 테스트 케이스 개수 N
            - 문자열의 길이 L (10^6), 권장 알고리즘 NlogN 이하

        문제 풀이:
                          배열                vs  연결 리스트
        - 요소 탐색 :         O(1)             vs   O(N)
        - 요소 추가/제거 :    O(마지막:1, 중간:N) vs   O(커서가 해당 위치에 있는 경우:1, 아니면 탐색 후 제거:N)

        선택 자료구조:
            '만약 커서의 위치가 줄의 마지막이 아니라면, 커서 및 커서 오른쪽에 있는 모든 문자는 오른쪽으로 한 칸 이동한다.' => 배열 단점

            LinkedList 선택, 커서가 존재하며 한 칸씩만 이동이 가능한 '에디터'의 특성 때문에
                최악의 경우에도 시간복잡도 L을 보장한다. (커서 이동, 커서가 이동한 위치에서 원소 삽입/삭제
            배열을 선택하면 최악의 경우 테스트케이스 개수 N * 명령어 개수 L에 근접하는 상황이 나타날 수 있다.

        CollectionFramework:
            ListIterator를 선택한다. 좌우 커서 이동이 가능하다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            String src = br.readLine();
            char[] srcChars = src.toCharArray();

            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> iter = list.listIterator();

            for(char ch : srcChars) {
                switch(ch) {
                    case '<':
                        if(iter.hasPrevious())
                            iter.previous();
                        break;
                    case '>':
                        if(iter.hasNext())
                            iter.next();
                        break;
                    case '-':
                        if(iter.hasPrevious()) {
                            iter.previous();
                            iter.remove();
                        }
                        break;
                    default:
                        iter.add(ch);
                        break;
                }
            }

            for(char c:list) {
                bw.write(c);
            }

            bw.newLine();
        }
        bw.close();
    }
}
