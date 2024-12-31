import javax.swing.ImageIcon;
import java.awt.Color;

public class Knight extends Piece {
    public Knight(Player player) {
        super(player, (player.getColor() == Color.WHITE) ? new ImageIcon("white-knight.png") : new ImageIcon("black-Knight.png"));
    }

    public boolean isValidMove(Square source, Square target, ChessBoard chessBoard) {
        // Return true for any move
        int sourceRow = source.getRow();
        int sourceCol = source.getCol();
        int targetRow = target.getRow();
        int targetCol = target.getCol();

        // Calculate the absolute difference in rows and columns
        int rowDiff = Math.abs(targetRow - sourceRow);
        int colDiff = Math.abs(targetCol - sourceCol);

        // Check if the move is an L-shape: 2-1 or 1-2 in any direction
        boolean isLShapeMove = (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2);

        // Check if the target square is not occupied by a piece of the same player
        Piece targetPiece = target.getPiece();
        boolean isValidMove = isLShapeMove && (targetPiece == null || targetPiece.getPlayer() != this.getPlayer());

        return isValidMove;
    }
}
