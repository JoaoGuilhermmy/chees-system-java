<div align="center">

# ♟️ Sistema de Xadrez em Java

### Jogo de Xadrez Completo desenvolvido em Java Puro com foco em Programação Orientada a Objetos

[![Java](https://img.shields.io/badge/Java-17+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![OOP](https://img.shields.io/badge/Paradigma-POO-blue?style=for-the-badge)](https://en.wikipedia.org/wiki/Object-oriented_programming)
[![Console](https://img.shields.io/badge/Interface-Console-green?style=for-the-badge)](https://en.wikipedia.org/wiki/Command-line_interface)
[![License](https://img.shields.io/badge/License-MIT-yellow?style=for-the-badge)](LICENSE)

[Sobre](#-sobre-o-projeto) •
[Conceitos POO](#-conceitos-de-poo-aplicados) •
[Arquitetura](#-arquitetura-do-projeto) •
[Instalação](#-instalação) •
[Como Jogar](#-como-jogar) •
[Estrutura](#-estrutura-de-classes) •
[Autor](#-autor)

<img src="https://img.shields.io/badge/♔-Chess-000000?style=for-the-badge" />

</div>

---

## 📋 Sobre o Projeto

Este projeto implementa um **jogo de xadrez completo e funcional** utilizando **Java puro** (sem frameworks), com foco total nos fundamentos da **Programação Orientada a Objetos (POO)**. O sistema foi desenvolvido para demonstrar conceitos avançados de OOP através de um problema real e complexo.

O jogo é executado via **console/terminal**, possui interface colorida usando códigos ANSI, implementa todas as regras oficiais do xadrez e demonstra na prática os 4 pilares da POO: **Encapsulamento**, **Herança**, **Polimorfismo** e **Abstração**.

### ✨ Funcionalidades do Jogo

- ✅ **Tabuleiro 8x8** com notação algébrica (a1-h8)
- ✅ **Todas as peças** - Rei, Rainha, Torre, Bispo, Cavalo, Peão
- ✅ **Movimentos válidos** - Cada peça segue suas regras específicas
- ✅ **Captura de peças** - Sistema de captura com histórico
- ✅ **Xeque e Xeque-Mate** - Detecção automática de situações de xeque
- ✅ **Movimentos especiais**:
  - 🏰 **Roque** (pequeno e grande)
  - 🎯 **En Passant** (captura especial do peão)
  - 👑 **Promoção do Peão** (transformação em rainha)
- ✅ **Interface colorida** - Cores ANSI para melhor visualização
- ✅ **Validação de movimentos** - Impede movimentos ilegais
- ✅ **Sistema de turnos** - Alternância automática entre jogadores
- ✅ **Contagem de jogadas** - Histórico completo da partida

---

## 🎯 Conceitos de POO Aplicados

Este projeto é uma **demonstração prática e completa** dos conceitos fundamentais da Programação Orientada a Objetos:

### 1️⃣ **Encapsulamento** 🔒

O encapsulamento protege os dados internos das classes, expondo apenas o necessário através de métodos públicos.

**Implementação:**
- Atributos privados (`private`) em todas as classes
- Métodos getters e setters controlados
- Validações internas nas classes
- Proteção do estado do tabuleiro

```java
public class ChessPiece {
    private Color color;           // Atributo privado
    private Position position;     // Encapsulado
    
    public Color getColor() {      // Acesso controlado
        return color;
    }
    
    protected void setPosition(Position position) {  // Modificação controlada
        this.position = position;
    }
}
```

**Benefícios:**
- ✅ Proteção dos dados internos
- ✅ Controle sobre modificações
- ✅ Manutenibilidade do código
- ✅ Redução de efeitos colaterais

---

### 2️⃣ **Herança** 👨‍👦

A herança permite criar hierarquias de classes, reutilizando código e estabelecendo relações "é-um".

**Hierarquia de Classes:**

```
         Piece (Abstrata)
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

**Exemplo de Implementação:**

```java
// Classe base abstrata
public abstract class Piece {
    protected Position position;
    protected Board board;
    
    public abstract boolean[][] possibleMoves();
}

// Classe intermediária
public abstract class ChessPiece extends Piece {
    private Color color;
    
    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }
}

// Classe concreta
public class Rook extends ChessPiece {
    public Rook(Board board, Color color) {
        super(board, color);
    }
    
    @Override
    public boolean[][] possibleMoves() {
        // Implementação específica da Torre
    }
}
```

**Benefícios:**
- ✅ Reutilização de código
- ✅ Hierarquia lógica e organizada
- ✅ Facilita manutenção e extensão
- ✅ Reduz duplicação de código

---

### 3️⃣ **Polimorfismo** 🎭

Polimorfismo permite que objetos de diferentes classes sejam tratados de forma uniforme através de uma interface comum.

**Implementação:**

```java
// Cada peça implementa seu próprio movimento
public class ChessMatch {
    private Piece[][] pieces;
    
    public boolean[][] possibleMoves(ChessPosition source) {
        Position position = source.toPosition();
        Piece piece = board.piece(position);
        
        // Polimorfismo: cada peça tem sua implementação
        return piece.possibleMoves();  
    }
}

// Torre se move em linhas e colunas
public class Rook extends ChessPiece {
    @Override
    public boolean[][] possibleMoves() {
        // Implementação específica: horizontal e vertical
    }
}

// Bispo se move em diagonais
public class Bishop extends ChessPiece {
    @Override
    public boolean[][] possibleMoves() {
        // Implementação específica: diagonal
    }
}
```

**Tipos de Polimorfismo Aplicados:**

1. **Sobrescrita (Override)** - Cada peça implementa `possibleMoves()` de forma única
2. **Polimorfismo de Inclusão** - Tratamento uniforme através da classe `Piece`
3. **Binding Dinâmico** - Decisão em tempo de execução sobre qual método chamar

**Benefícios:**
- ✅ Flexibilidade no design
- ✅ Código mais genérico e reutilizável
- ✅ Facilita adição de novas peças
- ✅ Manutenção simplificada

---

### 4️⃣ **Abstração** 🎨

Abstração esconde detalhes complexos, expondo apenas o essencial para o usuário.

**Níveis de Abstração:**

```
┌─────────────────────────────────────┐
│    INTERFACE DO USUÁRIO (UI)       │  ← Mais Alto Nível
│    - ChessMatch (gerencia partida) │
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│    LÓGICA DE NEGÓCIO               │
│    - Board (tabuleiro)             │
│    - Piece (peças abstratas)       │
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│    IMPLEMENTAÇÃO ESPECÍFICA        │  ← Mais Baixo Nível
│    - Rook, Bishop, Knight, etc.    │
└─────────────────────────────────────┘
```

**Classes Abstratas:**

```java
// Abstração: define o "contrato" sem implementação
public abstract class Piece {
    protected Position position;
    
    // Método abstrato: cada peça implementa
    public abstract boolean[][] possibleMoves();
    
    // Método concreto: comportamento comum
    public boolean possibleMove(Position position) {
        return possibleMoves()[position.getRow()][position.getColumn()];
    }
}
```

**Benefícios:**
- ✅ Simplifica o uso do sistema
- ✅ Oculta complexidade desnecessária
- ✅ Foca no "o que" ao invés do "como"
- ✅ Facilita entendimento do código

---

## 🏗 Arquitetura do Projeto

O projeto está organizado em **camadas lógicas** seguindo o padrão de **separação de responsabilidades**:

```
┌─────────────────────────────────────────────────────────┐
│                  CAMADA DE APLICAÇÃO                    │
│                   (application)                         │
│  • Program.java - Ponto de entrada                     │
│  • UI.java - Interface com o usuário                   │
└────────────────────────┬────────────────────────────────┘
                         │
┌────────────────────────▼────────────────────────────────┐
│              CAMADA DE XADREZ (NEGÓCIO)                │
│                   (chess)                               │
│  • ChessMatch - Coordena a partida                     │
│  • ChessPiece - Peça de xadrez abstrata               │
│  • ChessPosition - Posição notação algébrica           │
│  • Color - Enum de cores                               │
│  • pieces/ - Implementação específica das peças        │
│    ├── King, Queen, Rook, Bishop, Knight, Pawn        │
└────────────────────────┬────────────────────────────────┘
                         │
┌────────────────────────▼────────────────────────────────┐
│           CAMADA DE TABULEIRO (GENÉRICO)               │
│                 (boardgame)                            │
│  • Board - Tabuleiro genérico                          │
│  • Piece - Peça abstrata genérica                     │
│  • Position - Posição genérica (linha/coluna)         │
│  • BoardException - Exceções do tabuleiro             │
└─────────────────────────────────────────────────────────┘
```

### 📐 Princípios de Design Aplicados

#### **1. Single Responsibility Principle (SRP)**
Cada classe tem uma única responsabilidade bem definida:
- `Board` → Gerencia apenas o tabuleiro
- `ChessMatch` → Coordena apenas a partida
- `UI` → Cuida apenas da interface
- Cada peça → Implementa apenas seus movimentos

#### **2. Open/Closed Principle (OCP)**
- Aberto para extensão: Novas peças podem ser adicionadas
- Fechado para modificação: Código existente não precisa mudar

#### **3. Liskov Substitution Principle (LSP)**
- Qualquer `ChessPiece` pode substituir `Piece`
- Polimorfismo garante comportamento consistente

#### **4. Dependency Inversion Principle (DIP)**
- Depende de abstrações (`Piece`) não de implementações (`Rook`, `Bishop`)
- Facilita testes e manutenção

---

## 📂 Estrutura de Diretórios

```
chees-system-java/
│
├── 📁 src/
│   ├── 📁 application/              # Camada de Apresentação
│   │   ├── Program.java            # Classe principal (main)
│   │   └── UI.java                 # Interface do usuário
│   │
│   ├── 📁 boardgame/                # Camada de Tabuleiro Genérico
│   │   ├── Board.java              # Tabuleiro genérico
│   │   ├── Piece.java              # Peça abstrata genérica
│   │   ├── Position.java           # Posição no tabuleiro
│   │   └── BoardException.java     # Exceções do tabuleiro
│   │
│   └── 📁 chess/                    # Camada de Xadrez (Negócio)
│       ├── ChessMatch.java         # Gerenciador da partida
│       ├── ChessPiece.java         # Peça de xadrez (abstrata)
│       ├── ChessPosition.java      # Posição em notação algébrica
│       ├── ChessException.java     # Exceções de xadrez
│       ├── Color.java              # Enum: WHITE, BLACK
│       │
│       └── 📁 pieces/               # Implementação das Peças
│           ├── King.java           # Rei
│           ├── Queen.java          # Rainha
│           ├── Rook.java           # Torre
│           ├── Bishop.java         # Bispo
│           ├── Knight.java         # Cavalo
│           └── Pawn.java           # Peão
│
├── 📁 bin/                          # Arquivos compilados (.class)
│
├── 📄 .gitignore                    # Arquivos ignorados pelo Git
└── 📄 README.md                     # Este arquivo
```

---

## 🎲 Estrutura de Classes

### 📊 Diagrama de Classes Simplificado

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

### 🔗 Relacionamentos Entre Classes

```
ChessMatch  ◆───────→ Board
     |                  |
     | usa              | contém
     ↓                  ↓
ChessPiece         Position
     ↑
     | herda de
     |
┌────┴────┬──────┬──────┬──────┬──────┐
|         |      |      |      |      |
King   Queen  Rook  Bishop Knight Pawn
```

**Tipos de Relacionamento:**

1. **Composição** (◆) - `ChessMatch` possui `Board`
2. **Agregação** (◇) - `Board` contém `Pieces`
3. **Herança** (→) - Peças herdam de `ChessPiece`
4. **Associação** (→) - `ChessPiece` conhece `Position`
5. **Dependência** (--→) - `UI` depende de `ChessMatch`

---

## 💻 Instalação

### Pré-requisitos

- ☕ **Java JDK 17** ou superior instalado
- 🔧 **Terminal/Console** com suporte a cores ANSI
- 💾 **Git** (para clonar o repositório)

### 🚀 Passo a Passo

1️⃣ **Clone o repositório**
```bash
git clone https://github.com/JoaoGuilhermmy/chees-system-java.git
cd chees-system-java
```

2️⃣ **Compile o projeto**
```bash
# Navegue até a pasta src
cd src

# Compile todos os arquivos .java
javac application/Program.java
```

3️⃣ **Execute o jogo**
```bash
# Execute a partir da pasta src
java application.Program
```

### 🎨 Terminal com Suporte a Cores

**Windows:**
- Use o **Windows Terminal** (recomendado)
- CMD moderno com suporte ANSI
- PowerShell

**Linux/Mac:**
- Qualquer terminal padrão já tem suporte

---

## 🎮 Como Jogar

### 📝 Notação Algébrica

O tabuleiro usa notação algébrica padrão do xadrez:
- **Colunas:** a, b, c, d, e, f, g, h
- **Linhas:** 1, 2, 3, 4, 5, 6, 7, 8

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

### 🎯 Comandos do Jogo

1. **Iniciar o jogo** - Execute `java application.Program`

2. **Movimentar uma peça:**
   ```
   Source: e2        (Digite a posição de origem)
   Target: e4        (Digite a posição de destino)
   ```

3. **Peças Capturadas** - Exibidas no topo do tabuleiro

4. **Xeque** - O sistema avisa quando o rei está em xeque

5. **Xeque-Mate** - Fim de jogo automático

### 🏰 Movimentos Especiais

#### **Roque (Castling)**
- Rei move 2 casas em direção à torre
- Torre "pula" para o outro lado do rei
- Condições: Rei e torre não moveram, caminho livre, rei não está em xeque

```
Roque Pequeno (Kingside):
Antes:  e1=♔ h1=♖
Depois: g1=♔ f1=♖

Roque Grande (Queenside):
Antes:  e1=♔ a1=♖
Depois: c1=♔ d1=♖
```

#### **En Passant**
- Captura especial do peão
- Ocorre quando peão adversário avança 2 casas
- Seu peão captura "de passagem"

#### **Promoção**
- Peão que chega na última linha
- Automaticamente promovido a Rainha

---

## 🧩 Conceitos Avançados de Java

### 1. **Enumerações (Enums)**
```java
public enum Color {
    BLACK,
    WHITE;
}
```

### 2. **Exceções Personalizadas**
```java
public class ChessException extends BoardException {
    public ChessException(String msg) {
        super(msg);
    }
}
```

### 3. **Classes Abstratas**
```java
public abstract class Piece {
    // Força implementação nas subclasses
    public abstract boolean[][] possibleMoves();
}
```

### 4. **Modificadores de Acesso**
- `public` - Acessível de qualquer lugar
- `protected` - Acessível por subclasses
- `private` - Acessível apenas na própria classe
- (default) - Acessível no mesmo pacote

### 5. **Sobrescrita de Métodos**
```java
@Override  // Anotação que garante sobrescrita correta
public String toString() {
    return "K";  // Representação da peça
}
```

### 6. **Matrizes Multidimensionais**
```java
// Tabuleiro 8x8
private Piece[][] pieces = new Piece[8][8];

// Movimentos possíveis
boolean[][] mat = new boolean[8][8];
```

### 7. **Tratamento de Exceções**
```java
try {
    ChessPosition source = ui.readChessPosition(sc);
} catch (ChessException e) {
    System.out.println(e.getMessage());
}
```

---

## 🎨 Padrões de Projeto Utilizados

### 1. **Strategy Pattern**
Cada peça tem sua própria estratégia de movimento
```java
piece.possibleMoves()  // Comportamento específico por peça
```

### 2. **Template Method**
Método base com passos específicos nas subclasses
```java
public abstract class Piece {
    // Template
    public boolean possibleMove(Position position) {
        return possibleMoves()[position.getRow()][position.getColumn()];
    }
    
    // Passo específico
    public abstract boolean[][] possibleMoves();
}
```

### 3. **Factory Method** (Implícito)
Criação de peças específicas através de construtores

### 4. **Singleton** (Potencial)
Poderia ser aplicado ao `Board` para garantir única instância

---

## 🧪 Conceitos de Lógica Implementados

### ✅ **Validações de Movimento**
- Verifica se o caminho está livre
- Impede movimento para casa ocupada por peça aliada
- Valida movimentos específicos de cada peça

### ✅ **Detecção de Xeque**
- Simula movimento
- Verifica se o rei fica em xeque
- Desfaz movimento se inválido

### ✅ **Algoritmos de Busca**
- Busca em linhas, colunas e diagonais
- Verificação de casas ameaçadas
- Cálculo de movimentos possíveis

---

## 📚 Aprendizados do Projeto

Este projeto ensina:

1. **POO na Prática** - Aplicação real dos 4 pilares
2. **Pensamento Abstrato** - Modelagem de domínio complexo
3. **Design de Software** - Arquitetura em camadas
4. **Algoritmos** - Lógica de movimentos e validações
5. **Tratamento de Erros** - Exceções personalizadas
6. **Clean Code** - Código limpo e organizado
7. **Padrões de Projeto** - Strategy, Template Method

---

## 🔧 Possíveis Melhorias

- [ ] Interface gráfica (GUI) com JavaFX ou Swing
- [ ] Salvar e carregar partidas
- [ ] Modo multiplayer online
- [ ] IA para jogar contra o computador
- [ ] Histórico de movimentos completo
- [ ] Análise de jogadas (notação PGN)
- [ ] Timer de partida
- [ ] Diferentes níveis de dificuldade
- [ ] Estatísticas de jogo

---

## 👨‍💻 Autor

<div align="center">
  <img src="https://github.com/JoaoGuilhermmy.png" width="150px" style="border-radius: 50%;" alt="João Guilhermmy"/>
  
  ### João Guilhermmy
  
  💼 Backend developer | Java
  
  [![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/joão-guilhermmy-93661b29b)
  [![Email](https://img.shields.io/badge/Email-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:joaoguilherrmmy@gmail.com)
  [![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/JoaoGuilhermmy)
  
  📧 **Email:** joaoguilherrmmy@gmail.com
  
  🔗 **LinkedIn:** [linkedin.com/in/joão-guilhermmy-93661b29b](https://www.linkedin.com/in/joão-guilhermmy-93661b29b)
  
</div>

---

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

## 🎓 Referências e Recursos

- [Oracle Java Documentation](https://docs.oracle.com/en/java/)
- [Java OOP Concepts](https://www.oracle.com/java/technologies/oop.html)
- [Chess Rules (FIDE)](https://www.fide.com/fide/handbook.html?id=171&view=article)
- [Design Patterns](https://refactoring.guru/design-patterns)

---

<div align="center">
  
  **⭐ Se este projeto foi útil para você, considere dar uma estrela!**
  
  Desenvolvido com ❤️ e muito ☕ por [João Guilhermmy](https://github.com/JoaoGuilhermmy)
  
  ![Java](https://img.shields.io/badge/Made%20with-Java-ED8B00?style=flat-square&logo=openjdk)
  ![OOP](https://img.shields.io/badge/Powered%20by-OOP-blue?style=flat-square)
  
  ### ♟️ Xeque-Mate! ♟️
  
</div>
