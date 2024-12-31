import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class GUIManager extends MouseAdapter {
    private Square startSquare;
    private ChessGame game;
    private Color originalBackgroundColor;
    public GUIManager(ChessGame chess){
        this.game = chess;
    }

    public void mouseClicked(MouseEvent e) {
        Square square = (Square) e.getSource();

        if (startSquare == null) {
            Piece piece = square.getPiece();
            if (piece != null && piece.getPlayer() == this.game.getCurrentPlayer()) {
                startSquare = square;
                originalBackgroundColor = square.getBackground();
                startSquare.setBackground(new Color(186,202,68));
            }
        } else {
            Piece p1 = square.getPiece();
            Piece p2 = this.startSquare.getPiece();
//            System.out.println(p2);
            if (p2.isValidMove(startSquare, square,this.game.getBoard())) {
                square.setPiece(startSquare.getPiece());
                startSquare.removePiece();
                startSquare.setBackground(originalBackgroundColor);
                square.repaint();
                startSquare.repaint();
                startSquare = null;
                game.switchPlayers();
            }
            else {
                // If the selected piece has no valid moves, reset startSquare to null
                startSquare.setBackground(originalBackgroundColor);
                startSquare = null;
            }
        }
    }

    private boolean isValidMove(Square sourceSquare, Square targetSquare) {
        if (targetSquare.isOccupied()) {
            return targetSquare.getPiece().getPlayer() != sourceSquare.getPiece().getPlayer();
        }
        return true;
    }
}
