public class Bishop extends ChessPiece {

    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.checkPos(toLine)&&chessBoard.checkPos(toColumn)) {
            if ((toLine - line)*(toLine - line) == (toColumn - column)*(toColumn - column) && toColumn != column && toLine!=line) {
                int i,j;
                if(toLine>line&&toColumn>column){
                    j=column+1;
                    for(i = line+1; i<toLine;i++){
                        if (chessBoard.board[i][j]!=null) return false;
                        j++;
                    }
                }
                if(toLine>line&&toColumn<column){
                    j=column-1;
                    for(i = line+1; i<toLine;i++){
                        if (chessBoard.board[i][j]!=null) return false;
                        j--;
                    }
                }
                if(toLine<line&&toColumn>column){
                    j=column+1;
                    for(i = line-1; i<toLine;i--){
                        if (chessBoard.board[i][j]!=null) return false;
                        j++;
                    }
                }
                if(toLine<line&&toColumn<column){
                    j=column-1;
                    for(i = line-1; i<toLine;i--){
                        if (chessBoard.board[i][j]!=null) return false;
                        j--;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
