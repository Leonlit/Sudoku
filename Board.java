public class Board {
    private int board[][] = new int[9][9];

    public Board (int[][] newBoard) {
        this.board = newBoard;
    }

    public int[][] getBoard(){ 
        return this.board;
    }

    public void printBoard () {
        for (int rows = 0; rows < board.length; rows++) {
            if (rows % 3 == 0)
            boardLine();
            for (int columns = 0;columns < board[rows].length; columns++) {
                if (columns % 3 == 0) {
                    System.out.print("|");
                }
                System.out.print(" " + board[rows][columns] + " ");
            }
            System.out.print( "|");
            System.out.println();
        }
        boardLine();
    }

    private void boardLine() {
        for (int x = 0; x < 3 * 10 + 1;x++) {
            System.out.print("-");
        }
        System.out.println();
    }
}


class Solver {
    private int[][] board;

    public void setBoard (int[][] board) {
        this.board = board;
    }


    public boolean solveBoard() {
        int pos[] = findEmpty(this.board);
        int rows = pos[0];
        int columns = pos[1];
        if (pos[0] == -1) {
            return true;
        }
        for (int num = 1; num < 10  ;num++) {
            this.board[rows][columns] = num;
            boolean result = this.validateBoard(rows, columns, this.board);
            if (result) {
                if (solveBoard()) {
                    return true;
                }
            }
            this.board[rows][columns] = 0;
        }
        return false;
    }

    private boolean validateBoard (int x, int y, int board[][]) {
        String temp = "";
        int count = 0, idx = 0;
        for (int index = 0; index < 9; index++) {
            temp += Integer.toString(board[index][y]);  // Horizontal
            temp += Integer.toString(board[x][index]);  // vertical
            temp += Integer.toString(board[(x/3) * 3 + index/3][(y/3) * 3 + index % 3]); // sub-section
        }

        while ((idx = temp.indexOf(Integer.toString(board[x][y]), idx)) != -1) {
            idx++;  count++;
        }
        return count == 3;
    }

    private int[] findEmpty (int[][] board) {
        for (int rows = 0; rows < 9; rows++) {
            for (int columns = 0; columns < 9; columns++) {
                if (board[rows][columns] == 0) {
                    return new int[] {rows, columns};
                }
            }
        }
        return new int[] {-1, -1};
    }
}