import javax.swing.*;
import java.util.List;

public class MazeFrame {
    public static void display(Maze maze, List<Coordinate> path) {
        JFrame frame = new JFrame("Maze Solver");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new MazePanel(maze, path));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
