package com.oa.company.visa;

public class Question3 {
    private static char[][] solution(char [][]field){
        int rows, cols, a_index, b_index, mid_index, ab_row;
        rows = field.length;
        cols = field[0].length;
        a_index = b_index = mid_index = 0;
        ab_row = -1;
        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                if(field[row][col] == 'A'){
                    a_index = col;
                    ab_row = row;
                }
                if(field[row][col] == 'B'){
                    b_index = col;
                }
                
            }
            if(ab_row != -1){
                    mid_index = (a_index + b_index)/2;
                    changeXtoO(field, a_index, mid_index, ab_row);
                    changeXtoO(field, mid_index, b_index, ab_row);
                    changeOtoX(field, mid_index, ab_row);
                    ab_row = -1;
                }
        }
        return field;
    }
    private static void changeXtoO(char [][]field, int from_index, int to_index, int row){
        for(int i=from_index;i<=to_index;i++){
            field[row][i] = 'O';
        }
    }
    private static void changeOtoX(char [][]field, int col, int row){
        field[row][col-1] = 'X';
        field[row][col] = 'X';
        field[row][col+1] = 'X';
        if(row > 0){
            field[row-1][col] = 'X';
            field[row-1][col+1] = 'X';
            field[row-1][col-1] = 'X';
        }
        if(row < field.length){
            field[row+1][col] = 'X';
            field[row+1][col-1] = 'X';
            field[row+1][col+1] = 'X';
        }
    }
}
