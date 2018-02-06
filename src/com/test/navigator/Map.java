package com.test.navigator;

class Map {
    private char[][] map;
    private Navigator navigator = new LeeNavigator();
    Map(char[]... array){
        map = array;
    }

    char[][] GetWay(){
        return navigator.searchRoute(map);
    }


}
