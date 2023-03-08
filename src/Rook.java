public class Rook extends ChessPiece {
    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.checkPos(toLine)&&chessBoard.checkPos(toColumn)) {
            if(toLine!=line&&toColumn==column){
                int i;
                if (toLine>line){
                    for (i=line+1;i<toLine;i++)
                    {
                        if (chessBoard.board[i][column]!=null) return false;
                    }
                }else {
                    for (i=toLine+1;i<line;i++)
                    {
                        if (chessBoard.board[i][column]!=null) return false;
                    }
                }
                return true;
            }
            if(toLine==line&&toColumn!=column){
                int i;
                if (toColumn>column){
                    for (i=column+1;i<toColumn;i++)
                    {
                        if (chessBoard.board[line][i]!=null) return false;
                    }
                }else {
                    for (i=toColumn+1;i<column;i++)
                    {
                        if (chessBoard.board[line][i]!=null) return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
