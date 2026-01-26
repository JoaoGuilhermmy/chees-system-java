<div align="center">

# ♟️ Chess System in Java

### Complete Chess Game developed in Pure Java with focus on Object-Oriented Programming

[![Java](https://img.shields.io/badge/Java-17+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![OOP](https://img.shields.io/badge/Paradigm-OOP-blue?style=for-the-badge)](https://en.wikipedia.org/wiki/Object-oriented_programming)
[![Console](https://img.shields.io/badge/Interface-Console-green?style=for-the-badge)](https://en.wikipedia.org/wiki/Command-line_interface)
[![License](https://img.shields.io/badge/License-MIT-yellow?style=for-the-badge)](LICENSE)

[About](#-about-the-project) •
[OOP Concepts](#-oop-concepts-applied) •
[Architecture](#-project-architecture) •
[Installation](#-installation) •
[How to Play](#-how-to-play) •
[Structure](#-class-structure) •
[Author](#-author)

<img src="https://img.shields.io/badge/♔-Chess-000000?style=for-the-badge" />

</div>

---

## 📋 About the Project

This project implements a **complete and functional chess game** using **pure Java** (no frameworks), with total focus on the fundamentals of **Object-Oriented Programming (OOP)**. The system was developed to demonstrate advanced OOP concepts through a real and complex problem.

The game runs via **console/terminal**, features a colorful interface using ANSI codes, implements all official chess rules, and demonstrates in practice the 4 pillars of OOP: **Encapsulation**, **Inheritance**, **Polymorphism**, and **Abstraction**.

### ✨ Game Features

- ✅ **8x8 Board** with algebraic notation (a1-h8)
- ✅ **All Pieces** - King, Queen, Rook, Bishop, Knight, Pawn
- ✅ **Valid Moves** - Each piece follows its specific rules
- ✅ **Piece Capture** - Capture system with history
- ✅ **Check and Checkmate** - Automatic detection of check situations
- ✅ **Special Moves**:
  - 🏰 **Castling** (kingside and queenside)
  - 🎯 **En Passant** (special pawn capture)
  - 👑 **Pawn Promotion** (transformation to queen)
- ✅ **Colored Interface** - ANSI colors for better visualization
- ✅ **Move Validation** - Prevents illegal moves
- ✅ **Turn System** - Automatic alternation between players
- ✅ **Move Counter** - Complete match history

---

## 🎯 OOP Concepts Applied

This project is a **practical and complete demonstration** of the fundamental concepts of Object-Oriented Programming:

### 1️⃣ **Encapsulation** 🔒

Encapsulation protects the internal data of classes, exposing only what's necessary through public methods.

**Implementation:**
- Private attributes (`private`) in all classes
- Controlled getters and setters methods
- Internal validations in classes
- Board state protection

```java
public class ChessPiece {
    private Color color;           // Private attribute
    private Position position;     // Encapsulated
    
    public Color getColor() {      // Controlled access
        return color;
    }
    
    protected void setPosition(Position position) {  // Controlled modification
        this.position = position;
    }
}
```

**Benefits:**
- ✅ Internal data protection
- ✅ Control over modifications
- ✅ Code maintainability
- ✅ Side effects reduction

---

### 2️⃣ **Inheritance** 👨‍👦

Inheritance allows creating class hierarchies, reusing code and establishing "is-a" relationships.

**Class Hierarchy:**

```
         Piece (Abstract)
              ↑
              |
         ChessPiece
              ↑
              |
    ┌─────────┴─────────┐
    |                   |
BoardPiece         SpecialPiece
    ↑                   ↑
    |                   |
┌───┴───┐           ┌───┴───┐
|       |           |       |
Rook  Bishop      King   Knight
Pawn  Queen
```

**Implementation Example:**

```java
// Abstract base class
public abstract class Piece {
    protected Position position;
    protected Board board;
    
    public abstract boolean[][] possibleMoves();
}

// Intermediate class
public abstract class ChessPiece extends Piece {
    private Color color;
    
    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }
}

// Concrete class
public class Rook extends ChessPiece {
    public Rook(Board board, Color color) {
        super(board, color);
    }
    
    @Override
    public boolean[][] possibleMoves() {
        // Rook-specific implementation
    }
}
```

**Benefits:**
- ✅ Code reusability
- ✅ Logical and organized hierarchy
- ✅ Facilitates maintenance and extension
- ✅ Reduces code duplication

---

### 3️⃣ **Polymorphism** 🎭

Polymorphism allows objects of different classes to be treated uniformly through a common interface.

**Implementation:**

```java
// Each piece implements its own movement
public class ChessMatch {
    private Piece[][] pieces;
    
    public boolean[][] possibleMoves(ChessPosition source) {
        Position position = source.toPosition();
        Piece piece = board.piece(position);
        
        // Polymorphism: each piece has its implementation
        return piece.possibleMoves();  
    }
}

// Rook moves in lines and columns
public class Rook extends ChessPiece {
    @Override
    public boolean[][] possibleMoves() {
        // Specific implementation: horizontal and vertical
    }
}

// Bishop moves diagonally
public class Bishop extends ChessPiece {
    @Override
    public boolean[][] possibleMoves() {
        // Specific implementation: diagonal
    }
}
```

**Types of Polymorphism Applied:**

1. **Override** - Each piece implements `possibleMoves()` uniquely
2. **Inclusion Polymorphism** - Uniform treatment through `Piece` class
3. **Dynamic Binding** - Runtime decision on which method to call

**Benefits:**
- ✅ Design flexibility
- ✅ More generic and reusable code
- ✅ Facilitates adding new pieces
- ✅ Simplified maintenance

---

### 4️⃣ **Abstraction** 🎨

Abstraction hides complex details, exposing only what's essential to the user.

**Abstraction Levels:**

```
┌─────────────────────────────────────┐
│    USER INTERFACE (UI)             │  ← Highest Level
│    - ChessMatch (manages match)    │
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│    BUSINESS LOGIC                  │
│    - Board (board)                 │
│    - Piece (abstract pieces)       │
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│    SPECIFIC IMPLEMENTATION         │  ← Lowest Level
│    - Rook, Bishop, Knight, etc.    │
└─────────────────────────────────────┘
```

**Abstract Classes:**

```java
// Abstraction: defines the "contract" without implementation
public abstract class Piece {
    protected Position position;
    
    // Abstract method: each piece implements
    public abstract boolean[][] possibleMoves();
    
    // Concrete method: common behavior
    public boolean possibleMove(Position position) {
        return possibleMoves()[position.getRow()][position.getColumn()];
    }
}
```

**Benefits:**
- ✅ Simplifies system usage
- ✅ Hides unnecessary complexity
- ✅ Focuses on "what" instead of "how"
- ✅ Facilitates code understanding

---

## 🏗 Project Architecture

The project is organized in **logical layers** following the **separation of concerns** pattern:

```
┌─────────────────────────────────────────────────────────┐
│                  APPLICATION LAYER                      │
│                   (application)                         │
│  • Program.java - Entry point                          │
│  • UI.java - User interface                            │
└────────────────────────┬────────────────────────────────┘
                         │
┌────────────────────────▼────────────────────────────────┐
│              CHESS LAYER (BUSINESS)                    │
│                   (chess)                              │
│  • ChessMatch - Coordinates the match                 │
│  • ChessPiece - Abstract chess piece                  │
│  • ChessPosition - Algebraic notation position        │
│  • Color - Color enum                                 │
│  • pieces/ - Specific piece implementation            │
│    ├── King, Queen, Rook, Bishop, Knight, Pawn       │
└────────────────────────┬────────────────────────────────┘
                         │
┌────────────────────────▼────────────────────────────────┐
│           BOARD LAYER (GENERIC)                        │
│                 (boardgame)                            │
│  • Board - Generic board                               │
│  • Piece - Generic abstract piece                     │
│  • Position - Generic position (row/column)           │
│  • BoardException - Board exceptions                  │
└─────────────────────────────────────────────────────────┘
```

### 📐 Applied Design Principles

#### **1. Single Responsibility Principle (SRP)**
Each class has a single well-defined responsibility:
- `Board` → Manages only the board
- `ChessMatch` → Coordinates only the match
- `UI` → Handles only the interface
- Each piece → Implements only its movements

#### **2. Open/Closed Principle (OCP)**
- Open for extension: New pieces can be added
- Closed for modification: Existing code doesn't need to change

#### **3. Liskov Substitution Principle (LSP)**
- Any `ChessPiece` can replace `Piece`
- Polymorphism ensures consistent behavior

#### **4. Dependency Inversion Principle (DIP)**
- Depends on abstractions (`Piece`) not implementations (`Rook`, `Bishop`)
- Facilitates testing and maintenance

---

## 📂 Directory Structure

```
chees-system-java/
│
├── 📁 src/
│   ├── 📁 application/              # Presentation Layer
│   │   ├── Program.java            # Main class (main)
│   │   └── UI.java                 # User interface
│   │
│   ├── 📁 boardgame/                # Generic Board Layer
│   │   ├── Board.java              # Generic board
│   │   ├── Piece.java              # Generic abstract piece
│   │   ├── Position.java           # Board position
│   │   └── BoardException.java     # Board exceptions
│   │
│   └── 📁 chess/                    # Chess Layer (Business)
│       ├── ChessMatch.java         # Match manager
│       ├── ChessPiece.java         # Chess piece (abstract)
│       ├── ChessPosition.java      # Algebraic notation position
│       ├── ChessException.java     # Chess exceptions
│       ├── Color.java              # Enum: WHITE, BLACK
│       │
│       └── 📁 pieces/               # Piece Implementation
│           ├── King.java           # King
│           ├── Queen.java          # Queen
│           ├── Rook.java           # Rook
│           ├── Bishop.java         # Bishop
│           ├── Knight.java         # Knight
│           └── Pawn.java           # Pawn
│
├── 📁 bin/                          # Compiled files (.class)
│
├── 📄 .gitignore                    # Git ignored files
└── 📄 README.md                     # This file
```

---

## 🎲 Class Structure

### 📊 Simplified Class Diagram

```
┌─────────────────────┐
│    <<abstract>>     │
│       Piece         │
├─────────────────────┤
│ - position: Position│
│ - board: Board      │
├─────────────────────┤
│ + possibleMoves()   │
│ + possibleMove()    │
│ + isThereAnyMove()  │
└──────────┬──────────┘
           │ extends
           ↓
┌─────────────────────┐
│    <<abstract>>     │
│    ChessPiece       │
├─────────────────────┤
│ - color: Color      │
│ - moveCount: int    │
├─────────────────────┤
│ + getColor()        │
│ + increaseMoveCount│
└──────────┬──────────┘
           │ extends
     ┌─────┴─────┐
     ↓           ↓
┌─────────┐ ┌─────────┐
│  King   │ │ Rook    │
├─────────┤ ├─────────┤
│ castled │ │ movements│
└─────────┘ └─────────┘
```

### 🔗 Relationships Between Classes

```
ChessMatch  ◆───────→ Board
     |                  |
     | uses             | contains
     ↓                  ↓
ChessPiece         Position
     ↑
     | inherits from
     |
┌────┴────┬──────┬──────┬──────┬──────┐
|         |      |      |      |      |
King   Queen  Rook  Bishop Knight Pawn
```

**Relationship Types:**

1. **Composition** (◆) - `ChessMatch` owns `Board`
2. **Aggregation** (◇) - `Board` contains `Pieces`
3. **Inheritance** (→) - Pieces inherit from `ChessPiece`
4. **Association** (→) - `ChessPiece` knows `Position`
5. **Dependency** (--→) - `UI` depends on `ChessMatch`

---

## 💻 Installation

### Prerequisites

- ☕ **Java JDK 17** or higher installed
- 🔧 **Terminal/Console** with ANSI color support
- 💾 **Git** (to clone the repository)

### 🚀 Step by Step

1️⃣ **Clone the repository**
```bash
git clone https://github.com/JoaoGuilhermmy/chees-system-java.git
cd chees-system-java
```

2️⃣ **Compile the project**
```bash
# Navigate to src folder
cd src

# Compile all .java files
javac application/Program.java
```

3️⃣ **Run the game**
```bash
# Execute from src folder
java application.Program
```

### 🎨 Terminal with Color Support

**Windows:**
- Use **Windows Terminal** (recommended)
- Modern CMD with ANSI support
- PowerShell

**Linux/Mac:**
- Any standard terminal already has support

---

## 🎮 How to Play

### 📝 Algebraic Notation

The board uses standard chess algebraic notation:
- **Columns:** a, b, c, d, e, f, g, h
- **Rows:** 1, 2, 3, 4, 5, 6, 7, 8

```
  a b c d e f g h
8 ♜ ♞ ♝ ♛ ♚ ♝ ♞ ♜  8
7 ♟ ♟ ♟ ♟ ♟ ♟ ♟ ♟  7
6 - - - - - - - -  6
5 - - - - - - - -  5
4 - - - - - - - -  4
3 - - - - - - - -  3
2 ♙ ♙ ♙ ♙ ♙ ♙ ♙ ♙  2
1 ♖ ♘ ♗ ♕ ♔ ♗ ♘ ♖  1
  a b c d e f g h
```

### 🎯 Game Commands

1. **Start the game** - Run `java application.Program`

2. **Move a piece:**
   ```
   Source: e2        (Enter source position)
   Target: e4        (Enter target position)
   ```

3. **Captured Pieces** - Displayed at the top of the board

4. **Check** - The system warns when the king is in check

5. **Checkmate** - Automatic game over

### 🏰 Special Moves

#### **Castling**
- King moves 2 squares toward the rook
- Rook "jumps" to the other side of the king
- Conditions: King and rook haven't moved, clear path, king not in check

```
Kingside Castling:
Before:  e1=♔ h1=♖
After:   g1=♔ f1=♖

Queenside Castling:
Before:  e1=♔ a1=♖
After:   c1=♔ d1=♖
```

#### **En Passant**
- Special pawn capture
- Occurs when opponent's pawn advances 2 squares
- Your pawn captures "in passing"

#### **Promotion**
- Pawn reaching the last row
- Automatically promoted to Queen

---

## 🧩 Advanced Java Concepts

### 1. **Enumerations (Enums)**
```java
public enum Color {
    BLACK,
    WHITE;
}
```

### 2. **Custom Exceptions**
```java
public class ChessException extends BoardException {
    public ChessException(String msg) {
        super(msg);
    }
}
```

### 3. **Abstract Classes**
```java
public abstract class Piece {
    // Forces implementation in subclasses
    public abstract boolean[][] possibleMoves();
}
```

### 4. **Access Modifiers**
- `public` - Accessible from anywhere
- `protected` - Accessible by subclasses
- `private` - Accessible only in own class
- (default) - Accessible in same package

### 5. **Method Override**
```java
@Override  // Annotation ensures correct override
public String toString() {
    return "K";  // Piece representation
}
```

### 6. **Multidimensional Arrays**
```java
// 8x8 Board
private Piece[][] pieces = new Piece[8][8];

// Possible moves
boolean[][] mat = new boolean[8][8];
```

### 7. **Exception Handling**
```java
try {
    ChessPosition source = ui.readChessPosition(sc);
} catch (ChessException e) {
    System.out.println(e.getMessage());
}
```

---

## 🎨 Design Patterns Used

### 1. **Strategy Pattern**
Each piece has its own movement strategy
```java
piece.possibleMoves()  // Specific behavior per piece
```

### 2. **Template Method**
Base method with specific steps in subclasses
```java
public abstract class Piece {
    // Template
    public boolean possibleMove(Position position) {
        return possibleMoves()[position.getRow()][position.getColumn()];
    }
    
    // Specific step
    public abstract boolean[][] possibleMoves();
}
```

### 3. **Factory Method** (Implicit)
Specific piece creation through constructors

### 4. **Singleton** (Potential)
Could be applied to `Board` to ensure single instance

---

## 🧪 Logic Concepts Implemented

### ✅ **Move Validations**
- Checks if path is clear
- Prevents movement to square occupied by ally
- Validates specific movements for each piece

### ✅ **Check Detection**
- Simulates movement
- Verifies if king is in check
- Undoes movement if invalid

### ✅ **Search Algorithms**
- Search in rows, columns, and diagonals
- Verification of threatened squares
- Calculation of possible moves

---

## 📚 Project Learnings

This project teaches:

1. **OOP in Practice** - Real application of the 4 pillars
2. **Abstract Thinking** - Complex domain modeling
3. **Software Design** - Layered architecture
4. **Algorithms** - Movement logic and validations
5. **Error Handling** - Custom exceptions
6. **Clean Code** - Clean and organized code
7. **Design Patterns** - Strategy, Template Method

---

## 🔧 Possible Improvements

- [ ] Graphical interface (GUI) with JavaFX or Swing
- [ ] Save and load games
- [ ] Online multiplayer mode
- [ ] AI to play against computer
- [ ] Complete move history
- [ ] Move analysis (PGN notation)
- [ ] Game timer
- [ ] Different difficulty levels
- [ ] Game statistics

---

## 👨‍💻 Author

<div align="center">
  <img src="https://github.com/JoaoGuilhermmy.png" width="150px" style="border-radius: 50%;" alt="João Guilhermmy"/>
  
  ### João Guilhermmy
  
  💼 Java Developer | OOP and Clean Code Enthusiast
  
  [![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/joão-guilhermmy-93661b29b)
  [![Email](https://img.shields.io/badge/Email-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:joaoguilherrmmy@gmail.com)
  [![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/JoaoGuilhermmy)
  
  📧 **Email:** joaoguilherrmmy@gmail.com
  
  🔗 **LinkedIn:** [linkedin.com/in/joão-guilhermmy-93661b29b](https://www.linkedin.com/in/joão-guilhermmy-93661b29b)
  
</div>

---

## 📄 License

This project is under the MIT license. See the [LICENSE](LICENSE) file for more details.

---

## 🎓 References and Resources

- [Oracle Java Documentation](https://docs.oracle.com/en/java/)
- [Java OOP Concepts](https://www.oracle.com/java/technologies/oop.html)
- [Chess Rules (FIDE)](https://www.fide.com/fide/handbook.html?id=171&view=article)
- [Design Patterns](https://refactoring.guru/design-patterns)

---

<div align="center">
  
  **⭐ If this project was useful to you, consider giving it a star!**
  
  Developed with ❤️ and lots of ☕ by [João Guilhermmy](https://github.com/JoaoGuilhermmy)
  
  ![Java](https://img.shields.io/badge/Made%20with-Java-ED8B00?style=flat-square&logo=openjdk)
  ![OOP](https://img.shields.io/badge/Powered%20by-OOP-blue?style=flat-square)
  
  ### ♟️ Checkmate! ♟️
  
</div>
