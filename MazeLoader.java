import java.io.*;
import java.util.*;

public class MazeLoader implements MazeLoaderInterface{
    @Override
    public Maze loadMaze(String filePath) throws IOException{
        //initialize a list to store each row of the maze as an int array
        List<int[]> rows = new ArrayList<>();

        Coordinate start = null;
        Coordinate end = null;


        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line; //store each line read from the file
            int currentRow = 0; //keep track of current row

        
            while((line = reader.readLine()) != null){

                int[] row = new int[line.length()];
                
                //every next character in the string is conidered an entry into the column
                //we itterate through each character counting the column at the same time
                for (int column = 0; column < line.length(); column++){
                    char c = line.charAt(column);

                    // we handle a character to interpret what it is
                    switch (c){
                        case 'S' ->{
                            start = new Coordinate(currentRow, column);
                            row[column] = 0; //Row at that specific col
                        }
                        case 'E' ->{
                            end = new Coordinate(currentRow, column);
                            row[column] = 0;
                        }
                        case '0' -> row[column] =0;
                        case '1' -> row[column] =1;
                        default -> throw new IOException(
                            "invalid character ' " +c + " ' at (" + currentRow + ", " +column+")");

                    } 

                }

                //once the row is complete, add it to the list
                rows.add(row);
                currentRow++;

            }
        }
        
        //here we convert the list into a 2d array
        int[][]grid = rows.toArray(new int[0][]);
        if(start ==null || end == null){
            throw new IOException("Maze must have a start (s) and end (E) point.");
        }
        return new Maze(grid, start, end);


    }
}
