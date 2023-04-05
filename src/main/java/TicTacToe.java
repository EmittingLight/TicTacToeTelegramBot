/*
public class TicTacToe {
    private char[][] board;
    private char currentPlayer;
    public TicTacToe() {
        board = new char[3][3];
        resetBoard();
    }

    public void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
        currentPlayer = 'X';
    }

    public void makeMove(int row, int col, char player) {
        board[row][col] = player;
        currentPlayer = (player == 'X') ? 'O' : 'X';
    }

    public boolean checkForWin() {
        // Проверяем все возможные комбинации победы на игровом поле
        return (checkRowForWin(0) || checkRowForWin(1) || checkRowForWin(2) ||
                checkColForWin(0) || checkColForWin(1) || checkColForWin(2) ||
                checkDiagonalForWin());
    }

    private boolean checkRowForWin(int row) {
        return (board[row][0] == board[row][1] && board[row][1] == board[row][2] && board[row][0] != '-');
    }

    private boolean checkColForWin(int col) {
        return (board[0][col] == board[1][col] && board[1][col] == board[2][col] && board[0][col] != '-');
    }

    private boolean checkDiagonalForWin() {
        return ((board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') ||
                (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '-'));
    }

    public boolean checkForDraw() {
        // Проверяем, что все клетки на игровом поле заполнены
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public String printBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
                if (j < 2) {
                    sb.append("|");
                }
            }
            sb.append("\n");
            if (i < 2) {
                sb.append("-+-+-\n");
            }
        }
        return sb.toString();
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }
}

 */
public class TicTacToe {
    private char[][] board;
    private char currentPlayer;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        resetBoard();
    }

    public void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void makeMove(int row, int col, char player) {
        board[row][col] = player;
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public boolean checkForWin() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != '-' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        if (board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }

        return false;
    }

    public boolean checkForDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public String printBoard() {
        StringBuilder sb = new StringBuilder();
        sb.append("  1 2 3\n");
        for (int i = 0; i < 3; i++) {
            sb.append(i + 1).append(" ");
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}