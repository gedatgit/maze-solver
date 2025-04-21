 Maze Solver

A Java-based maze-solving application with a graphical user interface (GUI) using Swing. The app reads a maze from a `.txt` file, finds a path using Depth-First Search (DFS), and displays the result visually.


Reads maze structure from a text file
- Solves the maze using a recursive DFS algorithm
- GUI visualization with start, end, walls, and path
- Object-Oriented Design:
  - Interface for maze solvers
  - Abstraction, encapsulation, and polymorphism
- Handles unsolvable mazes gracefully

The program:
1. Loads the maze grid from `maze.txt` using `MazeFileLoader`
2. Constructs a `Maze` object with the loaded data
3. Passes the maze to a class that implements `MazeSolver` (currently DFS)
4. Displays the maze and the solution path (if found) in the GUI

Each row is a line, and each cell is either:
- `0` — Open path
- `1` — Wall
