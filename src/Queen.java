import javax.swing.ImageIcon;
import java.awt.Color;

public class Queen extends Piece {
    public Queen(Player player) {
        super(player, (player.getColor() == Color.WHITE) ? new ImageIcon("white-queen.png") : new ImageIcon("black-queen.png"));
    }

    public boolean isValidMove(Square source, Square target, ChessBoard chessBoard) {
        int sourceRow = source.getRow();
        int sourceCol = source.getCol();
        int targetRow = target.getRow();
        int targetCol = target.getCol();

        boolean isHorizontalMove = sourceRow == targetRow && sourceCol != targetCol;
        boolean isVerticalMove = sourceCol == targetCol && sourceRow != targetRow;
        boolean isDiagonalMove = Math.abs(targetRow - sourceRow) == Math.abs(targetCol - sourceCol);
        // Check if the path is clear (no pieces in the way)
        boolean isPathClear = this.isPathClear(sourceRow, sourceCol, targetRow, targetCol, chessBoard);

        // Check if the target square is not occupied by a piece of the same player
        Piece targetPiece = target.getPiece();
        boolean isValidMove = (isHorizontalMove || isVerticalMove || isDiagonalMove) && isPathClear &&
                (targetPiece == null || targetPiece.getPlayer() != this.getPlayer());

        return isValidMove;
    }



}
