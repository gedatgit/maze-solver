/*
 * loads maze from a source
 * @param, the maze source
 */

import java.io.IOException;

public interface MazeLoaderInterface {
    Maze loadMaze(String source) throws IOException; //don't forget to throw exception
}
