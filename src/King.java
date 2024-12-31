import javax.swing.ImageIcon;
import java.awt.Color;

public class King extends Piece {
    public King(Player player) {
        super(player, (player.getColor() == Color.WHITE) ? new ImageIcon("white-king.png") : new ImageIcon("black-king.png"));
    }
    public boolean isValidMove(Square source, Square target, ChessBoard chessBoard) {
    int sourceRow = source.getRow();;
    int sourceCol = source.getCol();
    int targetRow = target.getRow();
    int targetCol = target.getCol();

        boolean isValidMove = Math.abs(targetRow - sourceRow) <= 1 && Math.abs(targetCol - sourceCol) <= 1;

        if (isValidMove) {
            // Check if the target square is not occupied by a piece of the same player
            Piece targetPiece = target.getPiece();
            if (targetPiece == null || targetPiece.getPlayer() != this.getPlayer()) {
                return true;
            }
        }

        return false;
    }

}
