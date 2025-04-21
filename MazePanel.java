import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MazePanel extends JPanel {
    private final Maze maze;
    private final List<Coordinate> path; //this is a list of coordinates for the solved path
    private final int cellSize = 10;

    public MazePanel(Maze maze, List<Coordinate> path){
        this.maze = maze;
        this.path = path; //
        setPreferredSize(new Dimension(
            maze.getColumnCount() * cellSize,
            maze.getRowCount()* cellSize
        ));
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int row = 0; row < maze.getRowCount(); row++){
            for(int col = 0; col < maze.getColumnCount(); col++){
                Coordinate currentCord = new Coordinate(row, col);
                if(maze.isWall(currentCord)){
                    g.setColor(Color.BLACK);
                }
                else if(currentCord.equals(maze.getStart()) || currentCord.equals(maze.getEnd())){
                    g.setColor(Color.RED);
                }
                else if(path != null && path.contains(currentCord)){
                    g.setColor(Color.GREEN);
                }
                else{
                    g.setColor(Color.WHITE);
                }
                
                g.fillRect(col*cellSize, row*cellSize, cellSize, cellSize);



            }
        }
    }
}
