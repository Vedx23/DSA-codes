package com.dsa.codes;

import java.util.Stack;

class Cell{
    public int x;
    public int y;

    Cell(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return x == cell.x && y == cell.y;
    }
}

public class Example01 {

    public static boolean isCellValid(Cell c, int[][] maze){

        int size = maze.length;
        if (c.x < 0 || c.y >= size) return false;
        if (c.x >= size || c.y < 0) return false;
        if (maze[c.x][c.y] == 1) return false;
        return true;//obstacle
    }
    public static boolean isCellMarked(Cell c, boolean[][] marked){
        return marked[c.x][c.y];
    }

    public static void markCell(Cell c, boolean[][] marked){
        marked[c.x][c.y] = true;
    }

    public static Cell[] getNeighbours(Cell c){
        Cell[] n = new Cell[]{
                new Cell(c.x + 1, c.y),
                new Cell(c.x-1,c.y),
                new Cell(c.x, c.y+1),
                new Cell(c.x, c.y-1)};

        return n;
    }

    public static boolean doesPathExist(int[][] maze, Cell start, Cell end){

        boolean[][] marked = new boolean[maze.length][maze.length];

        Stack<Cell> tracer = new Stack<Cell>();

        tracer.push(start);

        while(!tracer.isEmpty()){
            Cell c = tracer.pop();

            if (c.equals(end)) return true;

            Cell[] neighbours = getNeighbours(c);

            for(Cell n : neighbours){
                if (isCellValid(n,maze) && !isCellMarked(n, marked)){
                    markCell(n,marked);
                    tracer.push(n);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[][] maze = {{0,1,0,0,1},
                        {0,1,0,1,0},
                        {0,1,0,0,0},
                        {0,0,0,1,0},
                        {1,1,0,1,0}};

        Cell start = new Cell(0,0);
        Cell end = new Cell(4,4);

        boolean res = doesPathExist(maze,start,end);
        String outcome = res ? "The path does exist!" : "The path does not exist";
        System.out.println(outcome);
    }
}
