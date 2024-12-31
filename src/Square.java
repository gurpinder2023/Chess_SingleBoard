import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Square extends JPanel {
    private final int row;
    private final int col;
    private JLabel pieceLabel;
    private Piece piece;
    private boolean isPieceBeingDragged = false;



    public Square(int row, int col, Color colorOfSquare) {
        this.row = row;
        this.col = col;
        this.pieceLabel = new JLabel();
        setBackground(colorOfSquare);
        setLayout(new BorderLayout());
        add(pieceLabel, BorderLayout.CENTER);

//
    }

    public boolean isOccupied() {
        return pieceLabel.getIcon() != null;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
        pieceLabel.setIcon(piece.getPieceImage());
    }

    public ImageIcon getPieceImage() {
        if (piece != null) {
            return piece.getPieceImage();
        } else {
            return null;
        }
    }

    public Piece getPiece() {
        return piece;
    }

    public void removePiece() {
        piece = null;
        pieceLabel.setIcon(null);
    }


    private boolean isValidMove(Square targetSquare) {
        return true;
    }


}
