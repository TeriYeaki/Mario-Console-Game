# Mario Console Game 🍄🏰

**Mario Console Game** is a terminal-based Mario-style platformer built in Java. It uses ASCII characters to render the game world, featuring a turn-based menu system, jumping mechanics, enemy interactions, and dynamic level elements (trees that grow and spawn enemies).

Built on the **Monash game engine** as a university assignment in object-oriented design and game architecture.

---

## Features 🌟

- **Turn-Based Gameplay**
  - Menu-driven action selection each turn.
  - 8-directional movement (numpad or letter keys).
- **Console Rendering**
  - ASCII map display with characters for terrain, actors, and items.
- **Physics & Mechanics**
  - Jump onto high ground (trees, walls) with success chance and fall damage.
  - Jump on enemies (Goombas, Koopas) to defeat them.
- **Level System**
  - Maps defined as ASCII strings in code or loaded from text files.
  - Multiple terrain types: dirt, floor, walls, trees (sprout → sapling → mature).
- **Dynamic World**
  - Trees grow over time and can spawn Goombas (sprouts) or Koopas (mature trees).
  - Sapling trees occasionally drop coins.
- **Items & Score**
  - Collect coins for score.
  - Power-up mechanics (Super Mushroom – see `Status` enum).

---

## Screenshot

<img width="601" height="395" alt="image" src="https://github.com/user-attachments/assets/ea8af4a0-1562-4cd1-93fa-c6f3e15651f2" />
<img width="588" height="448" alt="image" src="https://github.com/user-attachments/assets/b0b2a8f9-006b-4f15-ac2a-457347f3aa40" />


---

## Tech Stack 🧰

- **Language:** Java
- **Engine:** Monash game engine (educational use)
- **Build:** Standard Java toolchain (no Maven/Gradle; compile and run manually or via IDE)

*Cross-platform: runs on any system with a Java runtime.*

---

## Controls 🎮

| Action          | Key                          |
| :-------------- | :--------------------------- |
| **Move North**  | `8` (numpad)                 |
| **Move South**  | `2` (numpad)                 |
| **Move East**   | `6` (numpad)                 |
| **Move West**   | `4` (numpad)                 |
| **Diagonals**   | `7`, `9`, `1`, `3` (numpad)  |
| **Other actions** | Letters (`a`–`z`) assigned in the menu |

Each turn, the game shows available actions (move, jump, attack, pick up, etc.) with their hotkeys. Type the key for the action you want.

---

## Map Legend 🗺️

| Symbol | Meaning        |
| :----- | :------------- |
| `.`    | Dirt           |
| `#`    | Wall           |
| `_`    | Floor          |
| `+`    | Sprout tree    |
| `t`    | Sapling tree   |
| `T`    | Mature tree    |
| `$`    | Coin           |
| `g`    | Goomba         |
| `K`    | Koopa          |
| `m`    | Mario (player) |

---

## How to Run ⚙️

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Terminal or IDE (IntelliJ, Eclipse, VS Code, etc.)

### 1. Clone the repository

```bash
git clone https://github.com/TeriYeaki/Mario-Console-Game.git
cd Mario-Console-Game
```

### 2. Build and Run

#### Option A: Command line

```bash
# Compile (from project root)
javac -d out $(find src -name "*.java")

# Run
java -cp out game.Application
```

*Alternatively, use your IDE’s build.*

#### Option B: IDE

1. Import the project as a Java project.
2. Set `src/` as the source root.
3. Run `game.Application`.

---

## Project Structure 🗂️

```text
Mario-Console-Game/
├── src/
│   ├── game/
│   │   ├── Application.java       # Entry point & level setup
│   │   ├── actors/
│   │   │   ├── Player.java        # Mario logic
│   │   │   └── enemies/           # Goomba, Koopa
│   │   ├── actions/               # Jump, attack, pick up, etc.
│   │   ├── ground/                # Dirt, floor, wall, trees
│   │   ├── items/                 # Coin
│   │   └── Status.java            # Capabilities (CAN_JUMP, etc.)
│   └── engine/                    # Monash game engine
│       ├── actors/
│       ├── positions/             # GameMap, World, Location
│       ├── displays/              # Display, Menu
│       ├── actions/
│       ├── items/
│       └── capabilities/
├── README.md
└── LICENSE
```

---

## Learning Outcomes 🧠

- **Object-oriented design:** Actors, actions, capabilities, and ground types.
- **Game loop:** Turn-based update cycle (display → process actors → tick).
- **Collision & movement:** Grid-based movement and 8-directional navigation.
- **Extensible architecture:** Engine supports new actors, items, and terrain via the engine APIs.

---

## Future Improvements 💭

- [ ] **Sound effects:** 8-bit jump and coin sounds.
- [ ] **More levels:** Level editor or multiple map files.
- [ ] **Win condition:** Explicit goal (e.g. reach castle/flag).
- [ ] **ANSI colours:** Better visuals in supported terminals.
- [ ] **Build automation:** Add Maven or Gradle.

---

## Contributing 🤝

Contributions are welcome. Ideas for optimisation, new levels, or features can be submitted via Pull Requests.

## License 🔑

MIT License – see [LICENSE](LICENSE) for details. The Monash game engine is for educational use; see the LICENSE file for its terms.

## Author ✍️

Created by **Tharith Yeak**.
