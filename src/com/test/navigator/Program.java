package com.test.navigator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Program {
    public static void main(String[] args) throws IOException {
        Map map = new Map( new char[][]
        {
            {'@', '.', '.', '.','.'},
            {'.', '.', '.', '.','.'},
            {'.', '.', '.', '.','.'},
            {'.', '.', '.', '.','.'},
            {'.', '.', '.', '.','.'},
            {'.', '.', '.', '.','X'}
        });
        Write(map.GetWay());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
    }

    private static void Write(char[][] map)
    {
        System.out.println("");
        StringBuilder s;
        for (int i = 0; i <= map.length - 1; i++)
        {
            s = new StringBuilder();
            for (int j = 0; j <= map[0].length - 1; j++)
            {
                s.append(map[i][j]).append(" ");
            }
            System.out.println(s);
        }
    }
}
