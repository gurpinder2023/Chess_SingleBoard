import javax.swing.ImageIcon;
import java.awt.Color;

public class Bishop extends Piece {
    public Bishop(Player player) {
        super(player, (player.getColor() == Color.WHITE) ? new ImageIcon("white-bishop.png") : new ImageIcon("black-bishop.png"));
    }

    public boolean isValidMove(Square source, Square target, ChessBoard chessBoard) {
        int sourceRow = source.getRow();
        int sourceCol = source.getCol();
        int targetRow = target.getRow();
        int targetCol = target.getCol();

        // Calculate the absolute difference in rows and columns
        int rowDiff = Math.abs(targetRow - sourceRow);
        int colDiff = Math.abs(targetCol - sourceCol);

        // Check if the move is diagonal (same absolute difference in rows and columns)
        boolean isDiagonalMove = rowDiff == colDiff;

        // Check if the target square is not occupied by a piece of the same player
        Piece targetPiece = target.getPiece();
        boolean isValidMove = isDiagonalMove &&
                (targetPiece == null || targetPiece.getPlayer() != this.getPlayer());

        // Check if the path is clear (no pieces in the way)
        boolean isPathClear = this.isPathClear(sourceRow, sourceCol, targetRow, targetCol, chessBoard);
        return isValidMove && isPathClear;
    }



}
