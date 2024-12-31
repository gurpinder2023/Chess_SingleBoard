import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChessGame {

    private final ChessBoard chessBoard ;
    private final Player whitePlayer = new Player(Color.WHITE);
    private final Player blackPlayer = new Player(Color.BLACK);
    private Player currentPlayer;
    public ChessGame() {
        chessBoard = new ChessBoard(8, 8, this);

        currentPlayer = whitePlayer;


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });

    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Chess Board");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ChessGame chessGame = new ChessGame(); // Create an instance of your ChessGame class
        chessGame.currentPlayer = chessGame.whitePlayer;
        // Set the preferred size of the ChessBoard
        int boardSize = 700;
        chessGame.chessBoard.setPreferredSize(new Dimension(boardSize, boardSize));

        // Create a JPanel to hold the ChessBoard and center it
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.add(chessGame.chessBoard);

        // Add the centerPanel to the frame with BorderLayout.CENTER
        frame.add(centerPanel, BorderLayout.CENTER);

        // Initialize chess pieces
        chessGame.settingPieces();

        frame.pack();
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }

    public void settingPieces() {
        // Initialize chess pieces on the board
        setPiece(0, 0, new Rook(whitePlayer));
        setPiece(0, 1, new Bishop(whitePlayer));
        setPiece(0, 2, new Knight(whitePlayer));
        setPiece(0, 3, new King(whitePlayer));
        setPiece(0, 4, new Queen(whitePlayer));
        setPiece(0, 5, new Knight(whitePlayer));
        setPiece(0, 6, new Bishop(whitePlayer));
        setPiece(0, 7, new Rook(whitePlayer));

        for (int i = 0; i < chessBoard.rows; i++)
            setPiece(1, i, new Pawn(whitePlayer));

        for (int i = 0; i < chessBoard.cols; i++)
            setPiece(6, i, new Pawn(blackPlayer));

        setPiece(7, 0, new Rook(blackPlayer));
        setPiece(7, 1, new Bishop(blackPlayer));
        setPiece(7, 2, new Knight(blackPlayer));
        setPiece(7, 3, new King(blackPlayer));
        setPiece(7, 4, new Queen(blackPlayer));
        setPiece(7, 5, new Knight(blackPlayer));
        setPiece(7, 6, new Bishop(blackPlayer));
        setPiece(7, 7, new Rook(blackPlayer));


    }

    private void setPiece(int row, int col, Piece p) {
        this.chessBoard.getSquareAt(row, col).setPiece(p);
    }

public ChessBoard getBoard(){
        return this.chessBoard;
}

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void switchPlayers() {
        if (this.currentPlayer == this.blackPlayer) {
            this.currentPlayer = this.whitePlayer;
        } else {
            this.currentPlayer = this.blackPlayer;
        }
    }
}

