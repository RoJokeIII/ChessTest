public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn)) {
            if ((toLine - line) * (toLine - line) == 1 && (toColumn - column) * (toColumn - column) == 1) return true;
            if ((toLine - line) * (toLine - line) == 1 && toColumn == column) return true;
            if (toLine == line && (toColumn - column) * (toColumn - column) == 1) return true;
        }
        return false;
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        if (board.checkPos(line) && board.checkPos(column)) {
            if (board.board[line][column] == null || !board.board[line][column].getSymbol().equals("K")) {
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (board.board[i][j] != null && !board.board[i][j].getColor().equals(board.nowPlayerColor())) {
                            if (board.board[i][j].canMoveToPosition(board, i, j, line, column)) return true;
                        }
                    }
                }
            } else {
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (board.board[i][j] != null && !board.board[i][j].getColor().equals(board.board[line][column].color)) {
                            if (board.board[i][j].canMoveToPosition(board, i, j, line, column)) return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }
}