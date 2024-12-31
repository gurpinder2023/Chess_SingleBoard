import javax.swing.ImageIcon;
import java.awt.Color;

public class Pawn extends Piece {
    private boolean hasMoved;
    public Pawn(Player player) {
        super(player, (player.getColor() == Color.WHITE) ? new ImageIcon("white-pawn.png") : new ImageIcon("black-pawn.png"));
        this.hasMoved = false;
    }

    public boolean isValidMove(Square source, Square target, ChessBoard chessBoard) {
        int sourceRow = source.getRow();
        int sourceCol = source.getCol();
        int targetRow = target.getRow();
        int targetCol = target.getCol();

        int direction = (getPlayer().getColor() == Color.WHITE) ? 1 : -1;

        // Check the direction of movement based on the player color
        int moveDirection = direction * (targetRow - sourceRow);

        // Check for the  double move
        if (!hasMoved && moveDirection == 2 && sourceCol == targetCol && chessBoard.getSquareAt(targetRow, targetCol).getPiece() == null) {
            // Check if the path is clear for the double move
            if (isPathForPawnClear(sourceRow, sourceCol, targetRow, targetCol, chessBoard)) {
                hasMoved = true;
                return true;
            }
        }

        // Check for a regular single move
        if (moveDirection == 1 && sourceCol == targetCol && chessBoard.getSquareAt(targetRow, targetCol).getPiece() == null) {
            hasMoved = true;
            return true;
        }


        return false;
    }
    private boolean isPathForPawnClear(int sourceRow, int sourceCol, int targetRow, int targetCol, ChessBoard chessBoard) {

        int middleRow = (sourceRow + targetRow) / 2;
        return chessBoard.getSquareAt(middleRow, sourceCol).getPiece() == null;
    }

}
