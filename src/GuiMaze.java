import javax.swing.*;
import java.awt.*;

public class GuiMaze {
    public static void main(String[] args) {
        JFrame jFrame=new JFrame();
        GenerateMaze maze=new GenerateMaze();
        maze.createMaze(3,3);

        JPanel jPanel=new JPanel(){
            @Override
            public void paint(Graphics graphics) {
                // 必须先调用父类的paint方法
                super.paint(graphics);
            }
        };
        jFrame.add(jPanel);
        jFrame.setSize(350,350);
        jFrame.setVisible(true);

    }
}
