package solutions.seungtae.deque;

import problems.deque.P2_BOJ1021;

import java.io.*;
import java.util.*;

public class S2_BOJ1021 implements P2_BOJ1021 {
    /*
        문제 분석: 3가지 연산이 있다.
            1. 첫번째 원소를 뽑아내는 것
            2. 첫 번째 원소를 가장 마지막 원소에 포함하는 것
            3. 마지막 원소를 가장 첫 번째 원소로 포함시키는 것
        => 주어진 숫자를 순서대로 뽑을 때 2,3 연산을 최소한으로 이용해서 뽑는 것

        문제 풀이:
            - 2,3번 연산의 최소값을 구하는 것
                => 순서대로 뽑아야 하며,
                    왼쪽 연산이 효율적인지, 또는 오른쪽 연산이 효율적인지 알 수 있어야 한다.
                    -> 뽑는 수가 중앙에서 가까운 쪽을 기준으로 2번 또는 3번 연산을 결정한다.

     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        MyDeque<Integer> d = new MyDeque<>(N);

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            int target = Integer.parseInt(st.nextToken());
            while(true) {
                int midIdx = d.size()%2==0 ? d.size()/2-1 : d.size()/2;
                int targetIdx = d.getIdx(target);
                if(target==d.deque.getFirst()) {
                    d.removeFirst();
                    break;
                }
                if(targetIdx<=midIdx) { // left에 등호(=)를 포함하는 이유?
                    d.moveLeft();
                } else {
                    d.moveRight();
                }
            }
        }
        System.out.println(d.count);
    }

    public static class MyDeque<T> {
        LinkedList<Integer> deque = new LinkedList<>();
        int count;

        public MyDeque(int n) {
            for(int i=1; i<=n; i++) {
                this.deque.add(i);
            }
        }

        public void removeFirst() {
            deque.removeFirst();
//            System.out.println("remove");
        }

        public void moveLeft() {
            deque.add(deque.removeFirst());
            count++;
//            System.out.println("left");
        }

        public void moveRight() {
            deque.addFirst(deque.removeLast());
            count++;
//            System.out.println("right");
        }

        public int size() {
            return this.deque.size();
        }

        public int getIdx(int num) {
            return deque.indexOf(num);
        }
    }
}

/*
   <헷갈렸던 개념>
 *  만약 현재 덱의 원소가 짝수 개라면 중간 지점을
 *  현재 덱의 절반 크기에서 -1 감소시킨다.
 *
 *  {1, 2, 3, 4} 일 때, 2를 중간지점으로 하면
 *  인덱스는 1이기 때문
 */