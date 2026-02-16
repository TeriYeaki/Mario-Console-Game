# Mario Console Game 🍄🏰

**Mario Console Game** is a terminal-based recreation of the classic *Super Mario Bros.* platformer. It renders the game world entirely using ASCII characters/console graphics, featuring scrolling levels, physics-based jumping, and enemy interactions.

Developed by **TeriYeaki** as a university assignment in game loop architecture and console rendering.

---

## Features 🌟

- **Console Rendering Engine**
  Runs natively in the command line with double-buffering to prevent flickering.
- **Physics System**
  Implements gravity, velocity, and collision detection for smooth platforming.
- **Level Loading**
  Reads map layouts from text files or internal arrays.
- **Classic Gameplay**
  - Jump on enemies (Goombas) to defeat them.
  - Collect coins for score.
  - Power-up mechanics (Mushrooms).
  - Win condition (Reach the castle flag).

---

## Tech Stack 🧰

- **Language:** C++ (Standard 17 or higher)
- **Libraries:** Windows API (`windows.h`) for input/output handling
- **IDE:** Visual Studio / VS Code

*(Note: Requires a Windows environment for console handle manipulation)*

---

## Controls 🎮

| Action          | Key (Keyboard)      |
| :-------------- | :------------------ |
| **Move Left** | `A` or `Left Arrow` |
| **Move Right** | `D` or `Right Arrow`|
| **Jump** | `Space` or `W`      |
| **Sprint/Fire** | `Shift`             |
| **Quit Game** | `Esc`               |

---

## Screenshots 🖼️

---

## How to Run ⚙️

### Prerequisites

- Windows OS (Required for console handle manipulation)
- Visual Studio (2019/2022) **OR** a C++ Compiler (g++, clang)

### 1. Clone the repository

```bash
git clone [https://github.com/TeriYeaki/Mario-Console-Game.git](https://github.com/TeriYeaki/Mario-Console-Game.git)
cd Mario-Console-Game
```

### 2. Build and Run

#### Option A: Visual Studio
1. Open the `MarioConsoleGame.sln` solution file.
2. Set the build configuration to **Release** (for best performance).
3. Press **Ctrl + F5** to build and run without debugging.

#### Option B: Command Line (g++)

```bash
g++ main.cpp -o mario.exe -O2
./mario.exe
```

---

## Project Structure 🗂️

```text
Mario-Console-Game/
├── src/
│   ├── main.cpp          # Entry point & game loop
│   ├── Player.cpp        # Mario logic (physics, state)
│   ├── Level.cpp         # Map parsing & rendering
│   └── Enemy.cpp         # Goomba/Koopa logic
├── assets/
│   └── level1.txt        # Level layout file
├── include/              # Header files (.h)
├── README.md
└── MarioConsoleGame.sln  # Visual Studio Solution
```

---

## Learning Outcomes 🧠

- **Game Loop Implementation:** Built a custom loop handling input, update, and render phases.
- **Memory Management:** Managed dynamic objects (enemies, particles) in a C++ environment.
- **Collision Detection:** Implemented AABB (Axis-Aligned Bounding Box) collision for tiles and entities.
- **Screen Buffering:** Mastered direct console writing to achieve high frame rates (30+ FPS) in a terminal.

---

## Future Improvements 💭

- [ ] **Sound Effects:** Add 8-bit jump and coin sounds.
- [ ] **More Levels:** Implement a level editor or load multiple maps.
- [ ] **Cross-Platform Support:** Port rendering to `ncurses` for Linux/macOS support.
- [ ] **Color Support:** Enhance visuals with ANSI color codes.

---

## Contributing 🤝

Contributions are welcome! If you have ideas for optimization or new levels, feel free to fork and submit a Pull Request.

## License 🔑

This project is open-source. (Add your license here, e.g., MIT).

## Author ✍️

Created by **TeriYeaki**.
