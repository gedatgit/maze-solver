import java.util.ArrayList;
import java.util.List; 

public class RecursiveMazeSolver implements MazeSolverInterface{
    
    
    private  boolean[][] visited;    //A 2d boolean array of visited cells
    private  Maze maze; //this is the maze object
    private  List<Coordinate> path; //this is the open path

    //a constructor to initialize the class
    //public RecursiveMazeSolver(){
    //    this.visited = null;
    //    this.maze = null;
    //    this.path = null;
    //}

    @Override
    public List<Coordinate> solve(Maze maze){
        this.visited = new boolean[maze.getRowCount()][maze.getColumnCount()];
        this.maze = maze;
        this.path = new ArrayList<>();

        if(solveRecursively(maze.getStart())){
            return path; //return path if true
        }
        else {

            throw new IllegalStateException("No solution found for the maze!");
        }
    }



    private boolean solveRecursively(Coordinate current){
        
        //This checks if the current cell is out of bounds or already visited
        if(current.getRow()<0 || current.getRow()>= maze.getRowCount() ||
        current.getColumns() < 0 || current.getColumns() >= maze.getColumnCount() ||
        visited[current.getRow()][current.getColumns()] || maze.isWall(current)) {
            return false;
        }

        //we check if we have reached the end cell
        if(current.equals(maze.getEnd())){
            path.add(current);
            return true;
        }

        //Mark a visited cell as visited
        visited[current.getRow()][current.getColumns()] = true;

        //we add the current coordinate to the path
        path.add(current);

        //explore neighbors of current cell recursively
        if(solveRecursively(new Coordinate(current.getRow() -1, current.getColumns())) ||
            solveRecursively(new Coordinate(current.getRow()+1, current.getColumns())) ||
            solveRecursively(new Coordinate(current.getRow(), current.getColumns() -1))  ||
            solveRecursively(new Coordinate(current.getRow(), current.getColumns() +1))) {
                return true;
            }
            // if no soulution found back track
            path.remove(path.size() -1);
            return false;

        
    }

   
    /*@Override
    *public List<Coordinate> solve(Maze maze){
    *   this.visited = new boolean[maze.getRowCount()][maze.getColumnCount()];
    *  this.maze = maze;
    *  this.path = new ArrayList<>();
    */
        

    



}
