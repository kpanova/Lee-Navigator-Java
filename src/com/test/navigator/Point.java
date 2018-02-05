package com.test.navigator;

public class Point {
    private int x;

    int GetX()
    {
        return x;
    }

    private void SetX(int value)
    {
        x = value;
    }

    private int y;

    int GetY()
    {
        return y;
    }

    private void SetY(int value)
    {
        y = value;
    }

    private int weight;

    int Getweight()
    {
        return weight;
    }

    private void Setweight(int value)
    {
        weight = value;
    }

    private boolean isFinish;

    public boolean GetisFinish()
    {
        return isFinish;
    }

    private void SetisFinish()
    {
        isFinish = true;
    }

    private boolean isStart;

    public boolean GetIsStart()
    {
        return isStart;
    }

    private void SetisStart()
    {
        isStart = true;
    }

    Point(int x, int y, int weight)
    {
        this.SetX(x);
        this.SetY(y);
        this.Setweight(weight);
    }
    void IsFinish()
    {
        this.SetisFinish();
    }
    void IsStart()
    {
        this.SetisStart();
    }
}
