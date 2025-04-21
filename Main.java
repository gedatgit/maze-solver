import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try{
            MazeLoader loader = new MazeLoader();
            Maze maze = loader.loadMaze("C:\\Users\\gedeo\\OneDrive\\Documents\\GitHub\\maze-solver\\maze3.txt");

            MazeSolverInterface solver = new RecursiveMazeSolver();
            List<Coordinate> path = solver.solve(maze);
            MazeFrame.display(maze, path);

        }
        catch(IOException e){
            System.err.println("Failed to load the maze: " + e.getMessage());
        }
        catch(IllegalStateException e){
            System.err.println("Failed to solve the maze: " + e.getMessage());
        }
    }
}

