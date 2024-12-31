Chess Game
A fully functional chess game built in Java, utilizing object-oriented programming (OOP) principles to ensure clean, modular, and maintainable code.

Features
Object-Oriented Design: The game is designed with OOP principles, including encapsulation, inheritance, polymorphism, and abstraction.
Interactive GUI: A graphical user interface (GUI) built using Java Swing for a user-friendly experience.
Chess Rules Enforcement: Implements all standard chess rules, including piece-specific movements, turn-based gameplay, and basic validations.
Custom Player Classes: Separate classes for white and black players, encapsulating player-specific logic and attributes.
Dynamic Chessboard: A dynamic chessboard that adjusts based on game state, implemented through dedicated board and piece classes.
Extensibility: The modular structure makes it easy to add new features or make modifications.
Technical Details
Technologies Used
Programming Language: Java
GUI Framework: Java Swing
Development Environment: IntelliJ IDEA
OOP Principles Applied
Encapsulation:

Each chess piece and player is represented by a class that encapsulates its attributes and behaviors.
Classes are designed with clear responsibilities and private fields to protect data integrity.
Inheritance:

Base Piece class with specific piece types (e.g., Pawn, King, Queen, etc.) extending it.
Shared functionality is implemented in the base class, while specific behaviors are overridden in derived classes.
Polymorphism:

Each piece class overrides a method for movement logic, allowing dynamic behavior based on the piece type.
Simplifies the implementation of game logic by treating all pieces uniformly while allowing for unique behavior.
Abstraction:

Abstract classes and interfaces are used to define common functionality across different pieces and game components.
Project Structure
css
Copy code
src/
├── Bishop.java
├── ChessBoard.java
├── ChessGame.java
├── GUIManager.java
├── King.java
├── Knight.java
├── Pawn.java
├── Player.java
├── Queen.java
├── Rook.java
├── Piece.java
.gitignore
README.md
How to Run
Clone the repository:
bash
Copy code
git clone <repository-url>
Open the project in your preferred Java IDE (e.g., IntelliJ IDEA or Eclipse).
Compile the code.
Run the ChessGame class.
Screenshots
![image](https://github.com/user-attachments/assets/5a26407f-7259-40a7-8b44-a0f10f87b70e)


Future Enhancements
Add support for special moves like castling and en passant.
Implement a timer for turn-based gameplay.
Add AI to allow single-player mode.
Save and load game states.
Multiplayer support through network programming.
License
This project is open-source and available under the MIT License.
