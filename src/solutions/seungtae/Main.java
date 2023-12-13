package solutions.seungtae;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println(func(6, 100, 5));
    }

    private static int func(int a, int b, int m) {
        int val = 1;
        while(b>0) {
            b--;
            val = val * a % m;
        }
        return val % m;
    }
}