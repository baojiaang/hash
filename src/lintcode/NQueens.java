package lintcode;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        // write your code here
        List<List<String>> rst = new ArrayList<>();
        if (n <= 0) {
            return rst;
        }
        ArrayList<Integer> list = new ArrayList<Integer>(); //1D array
        helper(rst, list, n);

        return rst;
    }

    /*
      Validate the board with given input.
    */
    public boolean validate(ArrayList<Integer> list, int rowNum) {
        int colNum = list.size(); // the column that rowNum is going to be put on
        for (int col = 0; col < list.size(); col++) {
            //check row
            if (list.get(col) == rowNum) {
                return false;
            }
            //check diagnal
            //q1 col - newQ col == q1 row - newQ row
            if (col - colNum == list.get(col) - rowNum) {
                return false;
            }
            //q1 col - newQ col == -(q1 row - newQ row)
            if (col - colNum == -(list.get(col) - rowNum)) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<String> createBoard(ArrayList<Integer> list){
        ArrayList<String> board = new ArrayList<String>();
        for (int row = 0; row < list.size(); row++) {
            StringBuffer sb = new StringBuffer();
            for (int col : list) {
                if (row == col) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            board.add(sb.toString());
        }
        return board;
    }
    public void helper(List<List<String>> rst, ArrayList<Integer> list, int n){
        if (list.size() == n) {
            rst.add(createBoard(list));
            return;
        }
        //For next Queen, which row to put? Now do recursive:
        for (int i = 0; i < n; i++) {
            if (validate(list, i)) {
                list.add(i);
                helper(rst, list, n);
                list.remove(list.size() - 1);
            }
        }
    }
}
