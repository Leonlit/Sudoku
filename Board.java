public class Board {
    private int board[][] = new int[9][9];

    public void changeValue (int posX, int posY, int value) {
        this.board[posX][posY] = value;
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

    public int[][] getBoard(){
        return this.board;
    }

    public boolean validateBoard (int x, int y) {
        int[][] grid = this.board;
        String temp = "";
        int count = 0, idx = 0;
        for (int index = 0; index < 9; index++) {
            temp += Integer.toString(board[index][y]);  // Horizontal
            temp += Integer.toString(board[x][index]);  // vertical
            temp += Integer.toString(grid[(x/3) * 3 + index/3][(y/3) * 3 + index % 3]);
        }

        while ((idx = temp.indexOf(Integer.toString(grid[x][y]), idx)) != -1) {
            idx++;  count++;
        }
        System.out.println(temp);
        return count == 3;
    }

    private void boardLine() {
        for (int x = 0; x < 3 * 10 + 1;x++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
