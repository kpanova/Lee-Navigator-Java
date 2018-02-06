package com.test.navigator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Program {
    public static void main(String[] args) throws IOException {
        Map map = new Map(getMap());
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
    private static char[][] getMap() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите количество строк на карте M>=1:");
        int rows = Integer.parseInt(reader.readLine());
        System.out.println("Введите количество столбцов на карте Т<=10000:");
        int columns = Integer.parseInt(reader.readLine());
        char[][] map = new char[rows][columns];
        for (int i = 0; i < rows; i++){
            String str;
            String badSigns;
            do{
            System.out.println("Введите " + columns + " символов " + (i+1) + "-й строки карты последовательно:");
            str = reader.readLine();
            badSigns = str.replaceAll("#.@X", "");
            }
            while (badSigns.length()>0 || str.length()<columns);
            char[] string = str.toCharArray();
            System.arraycopy(string, 0, map[i], 0, columns);
        }
        Write(map);
        return map;
    }
}

