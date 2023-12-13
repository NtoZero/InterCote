package solutions.seungtae;

import java.util.*;

public class Ladder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] participants = {"승태", "동건", "종규", "민주", "예지"};
        List<String> list = new ArrayList<String>(List.of(participants));

        System.out.print("뽑을 숫자의 범위를 입력해 주세요.:");
        int N = sc.nextInt();

        ArrayList<Integer> numList = new ArrayList<>();
        for(int i=1; i<=N; i++) {
            numList.add(i);
        }

        System.out.print("뽑을 숫자의 개수를 입력해 주세요.:");
        int num = sc.nextInt();

        while (!list.isEmpty()) {
            Random random = new Random();
            int partIdx = random.nextInt(list.size());
            String name = list.remove(partIdx);
            System.out.print(name + " : ");

            for(int i=0; i<num; i++) {
                int k = random.nextInt(numList.size());
                System.out.print(numList.remove(k));
                if(i<num-1) System.out.print(", ");
            }
            System.out.println();
        }
    }
}
