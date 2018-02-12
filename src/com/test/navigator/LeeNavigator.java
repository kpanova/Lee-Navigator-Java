package com.test.navigator;
import java.util.ArrayList;
import java.util.List;

public class LeeNavigator implements Navigator
{

    private List<Point> list = new ArrayList<>();
    private List<Point> finalList = new ArrayList<>();

    private int[][] WeightMap = new int[][]
    {
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0}
    };
    private int rows;
    private int columns;

    public char[][] searchRoute(char[][] map) // Поиск маршрута алгоритмом Ли
    {
        WeightMap = ResizeWeightMap(map);
        int weight = 0;
        rows = map.length - 1;
        columns = map[0].length - 1;
        for (int i = rows; i >= 0; i--)
        {
            for (int j = 0; j <= columns; j++)
            {
                if (IsFinish(i, j, map))
                {
                    list.add(new Point(j, i, weight));
                    list.get(0).IsFinish();
                    GetWeight(list.get(0).GetX(), list.get(0).GetY(), list.get(0).Getweight(), map);
                    WeightMap[list.get(0).GetY()][list.get(0).GetX()] = list.get(0).Getweight();
                    break;
                }
            }
        }

        for (int i = 1; ; i++)
        {
            try
            {
                weight = GetWeight(list.get(i).GetX(), list.get(i).GetY(), list.get(i).Getweight(), map);
                if (weight == -2)
                {
                    break;
                }
            }
            catch (Exception e)
            {
                return null;
            }
        }
        return FindBacktrace(map);
    }

    private char[][] FindBacktrace(char[][] map) // Поиск обратного пути
    {
        int weight = 0;
        for (int i = list.size() - 1; i >= 0; i--)
        {
            if (IsStart(list.get(i).GetY(), list.get(i).GetX(), map))
            {
                finalList.add(list.get(i));
                weight = list.get(i).Getweight() - 1;
            }
            else if (IsFinish(list.get(i).GetY(), list.get(i).GetX(), map))
            {
                finalList.add(list.get(i));
                break;
            }
            else if (list.get(i).Getweight() == weight && Math.abs((finalList.get(finalList.size() - 1).GetY() - list.get(i).GetY())) <= 1 && Math.abs((finalList.get(finalList.size() - 1).GetX() - list.get(i).GetX())) <= 1)
            {
                finalList.add(list.get(i));
                map[list.get(i).GetY()][list.get(i).GetX()] = '+';
                weight--;
            }
        }
        return map;
    }

    private int[][] ResizeWeightMap(char[][] map) // Изменение размера матрицы весов
    {
        int[][] newMap;
        if (map.length > WeightMap.length || map[0].length > WeightMap[0].length)
        {
            newMap = new int[map.length][map[0].length];
            for (int i = 0; i < newMap.length; i++)
            {
                for (int j = 0; j < newMap[0].length; j++)
                {
                    newMap[i][j] = 0;
                }
            }
            return newMap;
        }
        return WeightMap;
    }

    private int GetWeight(int x, int y, int weight, char[][] map) // Установка веса в матрицу весов
    {
        int newWeight;
        newWeight = weight + 1;
        int up = y - 1;
        int left = x - 1;
        int down = y + 1;
        int right = x + 1;

        if (GetPoint(x, up, newWeight, map) == -2)
        {
            return -2;
        }
        if (GetPoint(left, y, newWeight, map) == -2)
        {
            return -2;
        }
        if (GetPoint(x, down, newWeight, map) == -2)
        {
            return -2;
        }
        if (GetPoint(right, y, newWeight, map) == -2)
        {
            return -2;
        }

        return newWeight;
    }

    private int GetPoint(int x, int y, int newWeight, char[][] map) // Установка веса соседней точки
    {
        if (IsExist(y, x, map) && GetWeight(y, x) == 0 && !IsFinish(y, x, map))
        {
            if (IsWall(y, x, map))
            {
                WeightMap[y][x] = -1;
                return newWeight;
            }
            else
            {
                Point point = new Point(x, y, newWeight);
                list.add(point);
                WeightMap[y][x] = newWeight;
                if (IsStart(y, x, map))
                {
                    list.get(list.size() - 1).IsStart();
                    return -2;
                }
                return newWeight;
            }
        }
        return newWeight;
    }


    private boolean IsWall(int i, int j, char[][] map) // Проверка стена ли это
    {
        return map[i][j] == '#';
    }
    private boolean IsExist(int i, int j, char[][] map) // Проверка на существование в массиве элемента
    {
        return i < map.length && j < map[0].length && i >= 0 && j >= 0;
    }
    private boolean IsFinish(int i, int j, char[][] map) // Проверка финиш ли это
    {
        return map[i][j] == 'X';
    }
    private boolean IsStart(int i, int j, char[][] map) // Проверка старт ли это
    {
        return map[i][j] == '@';
    }
    private int GetWeight(int i, int j) // Получение веса из матрицы весов
    {
        return WeightMap[i][j];
    }


}

