

//This is the maze structure that we will be solving
public class Maze {
    protected final int[][] grid;
    protected final  Coordinate start;
    protected final  Coordinate end;
   


    /**
     * Constructor for the maze
     * @param grid, here 0 would represent a path and 1 would represent a wall
     * @param start, the starting point
     * @param end, the end point 
     * 
     * 
     */
    public Maze(int[][] grid, Coordinate start, Coordinate end){

        if(grid == null || grid.length == 0){
            throw new IllegalArgumentException("Grid cannot be empty");
        }
        this.grid = grid;
        this.start = start;
        this.end = end;
        

        validateCoordinate(start, "start");
        validateCoordinate(end, "End");
    }
    /**
     * chech if current item is wall or not
     * @param cord the coordinate to check
     * @return a boolean value if it is wall or not
     */
    public boolean isWall(Coordinate cord){
        return grid[cord.getRow()][cord.getColumns()]==1;
    }

    /**
     * getter for the grid
     * @return a copy of two dimensional grid array
     */
    public int[][] getGrid(){
        int[][] gridCopy = new int[grid.length][];

        for(int i = 0; i<grid.length; i++){

            gridCopy[i] = new int[grid[i].length];
            //copy each element from source to destination and iterate through the rows
            System.arraycopy(grid[i], 0, gridCopy[i], 0, grid[i].length);
        }
        return gridCopy;
    }

    //getters
   
    public Coordinate getStart(){
        return start;
    }

    public Coordinate getEnd(){
        return end;
    }
    public int getRowCount(){
        return grid.length;
    }
    public int getColumnCount(){
        return grid[0].length;
    }

    /**validate the start and end coordinates are workable for the maze
     * this throws exceptions if the maze we are trying to solve is not 
     * workable or we are starting and ending on a wall
     *@param coOrd is the coordinate to validate
     *@param name, the name of the coordinate
     *
     */    
    private void validateCoordinate(Coordinate cord, String name){
        if(cord == null){
            throw new IllegalArgumentException(name + "coordinate cannot be null");
            
        }
        if(cord.getRow() < 0 || cord.getRow() >= grid.length ||
            cord.getColumns()<0 || cord.getColumns()>= grid[0].length){
                throw new IllegalArgumentException(name + " coordinate is out of bounds");
        }
        if(isWall(cord)){
            throw new IllegalArgumentException(name + " coordinate is on a wall");
        }
    }


}
