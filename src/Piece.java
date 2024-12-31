import javax.swing.ImageIcon;
import java.awt.*;

public class Piece {
    private Player player;
    private ImageIcon pieceImage;
    private Square square;

    public Piece(Player player, ImageIcon imagePath) {
        this.player = player;
        this.pieceImage = imagePath;
//        System.out.println("Piece created with image: " + imagePath.toString());
        Image resizedImage = imagePath.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        this.pieceImage = new ImageIcon(resizedImage);
    }

    public ImageIcon getPieceImage() {

        return pieceImage;
    }
    public void setSquare(Square square){
        this.square = square;
    }
    public Square getSquare(){
        return this.square;
    }
    public Player getPlayer(){
        return this.player;
    }

    public boolean isValidMove(Square sourceSquare, Square targetSquare, ChessBoard chessBoard) {
        return true;
    }

    public boolean isPathClear(int sourceRow, int sourceCol, int targetRow, int targetCol, ChessBoard chessBoard) {
        int rowDirection = Integer.compare(targetRow, sourceRow);
        int colDirection = Integer.compare(targetCol, sourceCol);

        int currentRow = sourceRow + rowDirection;
        int currentCol = sourceCol + colDirection;

        while (currentRow != targetRow || currentCol != targetCol) {
            if (chessBoard.getSquareAt(currentRow, currentCol).getPiece() != null) {
                // There is a piece in the path
                return false;
            }

            currentRow += rowDirection;
            currentCol += colDirection;
        }

        // The path is clear
        return true;
    }


}
