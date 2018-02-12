package com.test.navigator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program {
    public static void main(String[] args) throws IOException {
        System.out.println("Ввод карты (допустимые символы: '#' - стена, '.' - дорога, '@' - старт, 'X' - финиш):");
        Map map = new Map(getMap());
        System.out.println("Произвожу вычисления...");
        Write(map.GetWay(),"Ваш кратчайшмй маршрут отмечен символами '+' :");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
    }
    private static void Write(char[][] map, String string) //Вывод готовой карты в консоль
    {
        if(map!=null) {
            System.out.println(string);
            StringBuilder s;
            for (int i = 0; i <= map.length - 1; i++) {
                s = new StringBuilder();
                for (int j = 0; j <= map[0].length - 1; j++) {
                    s.append(map[i][j]).append(" ");
                }
                System.out.println(s);
            }
        }
        else System.out.println("null");

    }
    static void RunSearch(char[][] Map){
        if(searchErrors(Map)){
            Map map = new Map(Map);
            Write(map.GetWay(),"Ваш кратчайшмй маршрут отмечен символами '+' :");
        }
    }
    private static char[][] getMap() throws IOException { //Получение карты из консоли
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int columns;
        int rows;
        do {
            System.out.println("Введите количество строк на карте M>=1:");
            rows = Integer.parseInt(reader.readLine());
        }while (rows<1);
        do {
            System.out.println("Введите количество столбцов на карте N<=10000:");
            columns = Integer.parseInt(reader.readLine());
        }while (columns >10000);
        char[][] map = new char[rows][columns];
        for (int i = 0; i < rows; i++){
            String str;
            String badSigns;
            do{
                System.out.println("Введите " + columns + " символов " + (i+1) + "-й строки карты последовательно и нажмите Enter:");
                str = reader.readLine();
                badSigns = str.replaceAll("[@X#.]", "");
                if(badSigns.length()>0){
                    System.out.println("Ваша строка содержала недопустимые символы: '" + badSigns + "'. Повторите ввод (допустимые символы: '#' - стена, '.' - дорога, '@' - старт, 'X' - финиш)");
                }
                else if(str.length()<columns || str.length()>columns){
                    System.out.println("Вы ввели недопустимое количество символов, повторите ввод.");
                }
            } while (badSigns.length()>0 || str.length()<columns || str.length()>columns);

            char[] string = str.toCharArray();
            System.arraycopy(string, 0, map[i], 0, columns);
        }
        Write(map, "Ваша карта:");
        return map;
    }

    private static boolean searchErrors(char[][] map){
        for (int i = 0; i < map.length; i++){
            String str;
            String badSigns;
            do{
                str = new String(map[i]);
                badSigns = str.replaceAll("[@X#.]", "");
                if(badSigns.length()>0){
                    System.out.println("Ваша строка " + (i+1) +  " содержала недопустимые символы: '" + badSigns + "'. Повторите ввод (допустимые символы: '#' - стена, '.' - дорога, '@' - старт, 'X' - финиш).");
                    return false;
                }
                else if(str.length()<map[0].length || str.length()>map[0].length){
                    System.out.println("Вы ввели недопустимое количество символов в строке" + (i+1) + ", повторите ввод.");
                    return false;
                }
            } while (str.length() < map[0].length || str.length() > map[0].length);
        }
        System.out.println("Карта верна. Происходят вычисления...");
        return true;
    }
}

