public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.checkPos(toLine)&&chessBoard.checkPos(toColumn)) {

            if (color.equals("White")){
                if(toLine==line+1&&(toColumn==column+1||toColumn==column-1)&&chessBoard.board[toLine][toColumn]!=null) return true;
                if(line==1&&toColumn==column){
                    if (toLine==line+2 && chessBoard.board[line + 1][column] == null && chessBoard.board[line + 2][column] == null) return true;
                    if (toLine==line+1 && chessBoard.board[line + 1][column] == null) return true;
                }else if (toLine==line+1 && chessBoard.board[line + 1][column] == null) return true;
            } else {
                if(toLine==line-1&&(toColumn==column+1||toColumn==column-1)&&chessBoard.board[toLine][toColumn]!=null) return true;
                if(line==6&&toColumn==column){
                    if (toLine==line-2 && chessBoard.board[line - 1][column] == null && chessBoard.board[line - 2][column] == null) return true;
                    if (toLine==line-1 && chessBoard.board[line - 1][column] == null) return true;
                }else if (toLine==line-1 && chessBoard.board[line - 1][column] == null) return true;
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
