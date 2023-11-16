package solutions.seungtae.linkedlist;

import problems.linkedlist.P1_1406;

import java.util.*;
import java.io.*;

public class S1_1406 implements P1_1406 {
    /*
    문제 분석:
        명령어 4개에 해당하는 로직 수행
        수의 크기 :
            문자열 길이 N : 10^5
            명령어 개수 M : 5*10^5, 권장 시간복잡도 O(NlogN) 이하

        주의 사항 :
            - 명령어 수행 전 커서는 가장 마지막에 위치해 있음

    문제 풀이:
                          배열                vs  연결 리스트
        - 요소 탐색 :         O(1)             vs   O(N)
        - 요소 추가/제거 :    O(마지막:1, 중간:N) vs   O(커서가 해당 위치에 있는 경우:1, 아니면 탐색 후 제거:N)

    선택 자료구조:
        LinkedList 선택, 커서가 존재하며 한 칸씩만 이동이 가능한 '에디터'의 특성 때문에
            최악의 경우에도 시간복잡도 M을 보장한다.
        배열을 선택하면 최악의 경우 문자열 길이 N * 명령어 개수 M에 근접하는 상황이 나타날 수 있다.

    CollectionFramework:
        ListIterator를 선택한다. 좌우 커서 이동이 가능하다.
 */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Character> linkedList = new LinkedList<>();
        StringTokenizer st;

        String src = br.readLine();
        char[] srcCharArr = src.toCharArray();
        for(char c : srcCharArr) linkedList.add(c); // 연결리스트 초기화

        int cursor = linkedList.size(); // cursor, 0 ~ 사이즈까지. 최초 커서 - 사이즈
        ListIterator<Character> iter = linkedList.listIterator(cursor);

        int M = Integer.parseInt(br.readLine()); // 명령어 수행 횟수

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            Character plusWhat = null;
            if(st.hasMoreTokens()) { // <=> if(command.equals(P))
                plusWhat = st.nextToken().charAt(0);
            }

            switch(command) {
                case "L" :
                    if(iter.hasPrevious()) iter.previous();
                    break;
                case "D" :
                    if(iter.hasNext()) iter.next();
                    break;
                case "B" :
                    // 커서 왼쪽의 글자 삭제
                    if(iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case "P" :
                    //글자 추가
                    iter.add(plusWhat);
                    break;
            }
        }

        // 최종 문자열 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(char c : linkedList) {
            bw.write(c);
        }
        bw.close();
    }

}

/*
    LinkedList의 내용이 ListIterator로 변경한 내용을 그대로 반영하는 원리는
    ListIterator가 리스트의 내부 구조에 직접 접근하여 변경 작업을 수행하기 때문입니다.
    ListIterator는 리스트와 연결된 상태에서 동작하는 "뷰" 또는 "커서"로 생각할 수 있습니다.
 */