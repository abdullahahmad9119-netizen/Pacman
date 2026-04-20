# Pac-Man Overview (Console Version)
A lightweight Pacman game implementation written in Java.  . It utilizes OOP principles (Encapsulation and
Association) to treat the player and ghosts as independent entities, allowing for dynamic game
state management.This version runs entirely in the console and uses text-based rendering to display the game board.

---
## Features
<img width="418" height="188" alt="Screenshot 2026-04-20 223059" src="https://github.com/user-attachments/assets/1808ccec-81e6-410a-9979-9e60cdeddff8" />


## Gameplay
- Control Pac-Man using the keyboard:
  - **a** -> Move Left
  - **s** -> Move Down
  - **w** -> Move Up
  - **d** -> Move Right
- Eat pellets to increase your score.
- Avoid ghosts.
- Clear the board to win.
## Important Functions
*Movement (move_up/down/left/right)*: Validates map boundaries and wall collision ('X').
Updates grid indices and increments score on food ('*') consumption.
*Ghost Random Walk (random_walk)*: Uses Math.random() to decide the next
coordinate. Includes error handling to ensure the ghost stays within legal bounds.
*Recovery (setting_ghost_after_life_lost)*: A cleanup and reset function that clears current
entity positions and returns them to start locations upon collision.
*Input Handling (walk)*: Captures keyboard input and delegates to the appropriate
movement method, effectively decoupling input from game logic.

---
## Architure Diagram
*game Class*: Acts as the 'God' class or controller. It instantiates the Pacman and Ghost
objects, initializes the map, and houses the main loop that refreshes the console screen.
*Pacman Class*: An independent entity that tracks its own score, lives, and (x,y)
coordinates. It handles the movement logic and collision detection.
*Ghost Class*: An autonomous entity that performs the AI behavior. It tracks its position and
handles the 'random walk' logic independently of the player.
*gamemap (Association)*: A 2D String array that represents the physical space. The entities
associate with this map by passing it as a parameter to their movement functions.
<img width="843" height="524" alt="Screenshot 2026-04-20 223021" src="https://github.com/user-attachments/assets/0516ba10-41df-4660-b471-8cf3763f6ceb" />

## Flow Diagram
<img width="410" height="186" alt="Screenshot 2026-04-20 223028" src="https://github.com/user-attachments/assets/399bc416-cfbb-43f6-aeeb-ab90f6482096" />



