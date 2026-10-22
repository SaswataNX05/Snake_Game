# 🐍 Snake Game

A classic 2D Snake game developed in **Java** utilizing **Swing** and **AWT** for GUI rendering and animation. The player navigates a growing snake around a bounded board, consuming apples to increase in length while dodging collisions with walls and its own body.

---

## 🎮 Gameplay & Features

- **Classic Arcade Mechanics**: Guide the snake to eat apples and grow as long as possible.
- **Custom Sprites**: Uses distinct 2D graphical sprites for the snake's head, body segments, and apples.
- **Responsive Controls**: Arrow-key directional navigation with built-in turn validation (prevents instant 180° self-collisions).
- **Collision Detection**: Real-time checks for:
  - Arena wall boundaries (300 × 300 px)
  - Self-intersection / tail collision
- **Game Over Display**: Visually alerts the player upon death with a centered "Game Over !" notice.
- **Fixed Aspect Ratio & Centered Window**: Prevents distortion by disabling resizing and automatically centering the window on screen.

---

## 🕹️ Controls

| Key | Action |
| :---: | :--- |
| <kbd>▲</kbd> **Up Arrow** | Turn snake upwards |
| <kbd>▼</kbd> **Down Arrow** | Turn snake downwards |
| <kbd>◄</kbd> **Left Arrow** | Turn snake to the left |
| <kbd>►</kbd> **Right Arrow** | Turn snake to the right |

> **Note**: Opposite turns (e.g., pressing Left while moving Right) are disabled to prevent accidental immediate self-collision.

---

## ⚙️ Game Specifications

- **Arena Dimensions**: 300 × 300 pixels
- **Grid Unit / Dot Size**: 10 × 10 pixels
- **Initial Snake Length**: 3 dots
- **Tick Speed**: 140 ms interval (`javax.swing.Timer`)
- **Apple Spawning**: Random coordinate aligned to the 10 px grid

---

## 📁 Project Structure

```text
Snake_Game/
├── build.xml                     # Apache Ant build scri:pt
├── manifest.mf                   # JAR manifest metadata
├── src/
│   ├── icons/                    # Sprite assets
│   │   ├── apple.png             # Food sprite
│   │   ├── dot.png               # Body segment sprite
│   │   └── head.png              # Snake head sprite
│   └── snake_game/               # Java source packages
│       ├── Board.java            # Game loop, rendering, input handling, and collision logic
│       └── Snake_Game.java       # Main entry point (JFrame configuration)
└── README.md                     # Project documentation
```

---

## 🚀 Getting Started

### Prerequisites

- **Java Development Kit (JDK)**: Version 8 or newer (JDK 17, 21, or 24 supported).
- *(Optional)* **Apache NetBeans** or **Apache Ant** for IDE / automated build workflows.

---

### Running the Game

#### Method 1: Using NetBeans IDE (Recommended)
1. Open **Apache NetBeans**.
2. Go to **File** > **Open Project...** and choose the `Snake_Game` folder.
3. Click the green **Run Project** button (or press `F6`).

---

#### Method 2: Command Line (CLI without IDE)
From the root of the project directory:

```bash
# 1. Compile Java source files to a build directory
javac -d build/classes -sourcepath src src/snake_game/*.java

# 2. Copy asset icons to the classpath
cp -r src/icons build/classes/

# 3. Run the application
java -cp build/classes snake_game.Snake_Game
```

---

#### Method 3: Using Apache Ant
If you have `ant` installed on your system:

```bash
# Compile and build the project
ant compile

# Run the game
ant run
```

---

## 🛠️ Built With

- **Java Standard Edition (SE)**
- **Java Swing (`javax.swing.*`)** – Window management and game loop timer
- **Java AWT (`java.awt.*`)** – 2D canvas drawing and keyboard event listening
