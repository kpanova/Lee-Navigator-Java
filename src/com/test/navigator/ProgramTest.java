package com.test.navigator;

public class ProgramTest {
    @org.junit.Test
    public void main() throws Exception {
        char[][] map = new  char[][]
        {
            {'@', '.', '.', '.','.'},
            {'.', '.', '.', '.','.'},
            {'.', '.', '.', '.','.'},
            {'.', '.', '.', '.','.'},
            {'.', '.', '.', '.','.'},
            {'.', '.', '.', '.','X'}
        };
        Program.RunSearch(map);
    }
    public void main(char[][] map) throws Exception {
        Program.RunSearch(map);
    }

}