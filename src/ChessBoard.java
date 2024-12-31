import javax.swing.*;
import java.awt.Color;
import java.awt.GridLayout;
public class ChessBoard extends JPanel {
    public final int rows;
    public final int cols;
    private final Square[][] squares;
    private ChessGame chessGame;

    public ChessBoard(int rows, int cols, ChessGame chessGame) {
        this.rows = rows;
        this.cols = cols;
        this.squares = new Square[rows][cols];
        this.chessGame = chessGame;
        initializeSquares(new GUIManager(chessGame));


    }

    private void initializeSquares(GUIManager squareMouseListener) {
        setLayout(new GridLayout(rows, cols));
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Color color = (row + col) % 2 == 0 ? new Color(118,150,86) : new Color(238,238,210);
                squares[row][col] = new Square(row, col, color);
                add(squares[row][col]);
                this.squares[row][col].addMouseListener(squareMouseListener);

            }
        }
    }

    public Square getSquareAt(int r, int c) {
        return this.squares[r][c];
    }


}
