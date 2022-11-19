import java.util.Scanner;

public class TicTacToe
{
    private static final int ROW = 3;
    private static final int COL = 3;
    private static final String[][] board = new String[ROW][COL];

    /**
     *
     * @param args - Command line arguments
     */
    public static void main(String[] args)
    {
        boolean finished = false;
        boolean playing = true;
        Scanner in = new Scanner(System.in);
        String player = "X";
        int moveCnt = 0;
        int row = -1;
        int col = -1;
        final int MOVES_FOR_WIN = 5;
        final int MOVES_FOR_TIE = 7;

        do // program loop
        {
            player = "X";
            playing = true;
            moveCnt = 0;
            clearBoard();
            do // game loop
            {
                do // Get the move
                {
                    display();
                    System.out.println("Enter move for " + player);
                    row = SafeInput.getRangedInt(in, "Enter row ", 1,3);
                    col = SafeInput.getRangedInt(in,"Enter col", 1, 3);
                    row--; col--;
                }while(!isValidMove(row, col));
                board[row][col] = player;
                moveCnt++;

                if(moveCnt >= MOVES_FOR_WIN)
                {
                    if(isWin(player))
                    {
                        display();
                        System.out.println("Player " + player + " wins!");
                        playing = false;
                    }
                }
                if(moveCnt >= MOVES_FOR_TIE)
                {
                    if(isTie())
                    {
                        display();
                        System.out.println("It's a tie!");
                        playing = false;
                    }
                }
                if(player.equals("X"))
                {
                    player = "O";
                }
                else
                {
                    player = "X";
                }

            }while(playing);

            finished = SafeInput.getYNConfirm(in, "Done playing? ");
        }while(!finished);

    }

    /**
     * This will clear the entire board, making all cells spaces
     *
     */
    private static void clearBoard()
    {
        for(int row=0; row < ROW; row++)
        {
            for (int col=0; col < COL; col++)
            {
                board[row][col] = " "; // This makes the cell a space
            }
        }
    }

    /**
     *
     * This will display the board within the console
     */
    private static void display()
    {
        for(int row=0; row < ROW; row++)
        {
            System.out.print("| ");
            for(int col=0; col < COL; col++)
            {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }

    /**
     * This determines if the row and col coordinates are valid
     *
     * @param row - Row index between 0 - 2
     * @param col - Col index between 0 - 2
     * @return - This is true if this is a valid index for a move
     */
    private static boolean isValidMove(int row, int col) // This will check if the move is valid or not
    {

        if (board[row][col].equals(" ")) // Is it a space?
            return true;

        return false;
    }

    /**
     * This will determine if there is a win for a specific player
     *
     * @param player - The player to check for a win with either X or O
     * @return
     */
    private static boolean isWin(String player) // Checks for win from specific player
    {
        if(isColWin(player) || isRowWin(player) || isDiagonalWin(player))
        {
            return true;
        }
        return false;
    }

    /**
     * This will determine if there is a column win for a specific player
     *
     * @param player
     * @return - True if there is a column win, false otherwise
     */
    private static boolean isColWin(String player) // Checks for a column win
    {
        // This will check for a col win
        for(int col=0; col < COL; col++)
            if(board[0][col].equals(player) &&
                    board[1][col].equals(player) &&
                    board[2][col].equals(player))
                return true;

        return false; // No col win
    }
    /**
     * This will determine if there is a row win for a specific player
     *
     * @param player
     * @return - True if there is a row win, false otherwise
     */
    private static boolean isRowWin(String player) // Checks for a row win
    {
        // This will check for a row win
        for(int row=0; row < ROW; row++)
            if(board[row][0].equals(player) &&
                    board[row][1].equals(player) &&
                    board[row][2].equals(player))
                return true;
        return false; //no row win
    }
    /**
     * This will determine if there is a diagonal win for a specific player
     *
     * @param player
     * @return - True if there is a diagonal win, false otherwise
     */
    private static boolean isDiagonalWin(String player) // Checks for a diagonal win
    {
        // This will check for a diagonal win
        if(board[0][0].equals(player) &&
                board[1][1].equals(player) &&
                board[2][2].equals(player) )
            return true;

        if(board[0][2].equals(player) &&
                board[1][1].equals(player) &&
                board[2][0].equals(player) )
            return true;

        return false; // No diagonal win
    }

    /**
     * This will determine if there is a tie before the board is completely filled up
     *
     * @return - True if there is an early tie, false if not
     */
    private static boolean isTie() // Checks for a tie before board is filled
    {
        boolean xFlag = false;
        boolean oFlag = false;

        for(int row=0; row < ROW; row++)
        {
            if(board[row][0].equals("X") ||
                    board[row][1].equals("X") ||
                    board[row][2].equals("X"))
            {
                xFlag = true; // There is in fact an X in this row
            }
            if(board[row][0].equals("O") ||
                    board[row][1].equals("O") ||
                    board[row][2].equals("O"))
            {
                oFlag  = true; // There is in fact an O in this row
            }

            if(! (xFlag && oFlag) )
            {
                return false; // There is no possibility of a tie with a row win
            }

            xFlag = oFlag = false;
        }
        for(int col=0; col < COL; col++)
        {
            if(board[0][col].equals("X") ||
                    board[1][col].equals("X") ||
                    board[2][col].equals("X"))
                xFlag = true; // There is in fact an X in this col

            if(board[0][col].equals("O") ||
                    board[1][col].equals("O") ||
                    board[2][col].equals("O"))
                oFlag = true; // There is in fact an O in this col

            if(! (xFlag && oFlag) )
                return false; // There is no possibility of a tie with a col win

        }
        // Check for diagonals
        xFlag = oFlag = false;

        if(board[0][0].equals("X") ||
                board[1][1].equals("X") ||
                board[2][2].equals("X") )
            xFlag = true;

        if(board[0][0].equals("O") ||
                board[1][1].equals("O") ||
                board[2][2].equals("O") )
            oFlag = true;

        if(! (xFlag && oFlag) )
            return false; // No tie can still get a diagonal win

        xFlag = oFlag = false;

        if(board[0][2].equals("X") ||
                board[1][1].equals("X") ||
                board[2][0].equals("X") )
            xFlag = true;

        if(board[0][2].equals("O") ||
                board[1][1].equals("O") ||
                board[2][0].equals("O") )
            oFlag = true;

        if(! (xFlag && oFlag) )
            return false; // No ties can still have a diagonal win


        return true; // Checked every win vector so we have tie
    }
}
