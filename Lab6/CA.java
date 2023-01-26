import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Arrays;

public class CA {
    private boolean cell[];
    private int size;
    private int rule;
    private boolean ttable[] = new boolean[8];
    private int check=0;

    public CA(int size , int rule) {
        this.size = size;
        this.rule = rule;
        cell = new boolean[size];
        cell[size / 2] = true;
        if (rule > 0 && rule <= 255) {
            int x = rule;
            for (int j = 0; j < 8; j++) {
                if (x % 2 == 0)
                    ttable[j] = false;
                else
                    ttable[j] = true;
                x /= 2;
            }
        }
    }
    public boolean[] getFirstState() {
        if (check == 0) {
            check++;
            return cell;
        }
        else return new boolean[size];
    }
    public boolean[] getState(){
        boolean[] temp = new boolean[size];
        for(int j = 0; j<temp.length;j++){
            temp[j] = cell[j];

        }
        for(int i =0;i<temp.length;i++){
            int a = i-1; int b = i+1; if(i==0) a = temp.length-1; if(i == temp.length-1) b = 0;
            if(temp[a] == true && temp[i] == true && temp[b] == true) cell[i] = ttable[7];
            else if(temp[a] == true && temp[i] == true &&  temp[b] == false) cell[i]= ttable[6];
            else if(temp[a] == true && temp[i] == false && temp[b] == true) cell[i] = ttable[5];
            else if(temp[a] == true && temp[i] == false && temp[b] == false) cell[i] = ttable[4];
            else if(temp[a] == false && temp[i] == true && temp[b] == true) cell[i] = ttable[3];
            else if(temp[a] == false && temp[i] == true && temp[b] == false) cell[i] = ttable[2];
            else if(temp[a] == false && temp[i] == false && temp[b] == true) cell[i] = ttable[1];
            else cell[i] = ttable[0];
        }
        return cell;
    }
public String toString(){
    return(Arrays.toString(cell).replace("false", " ")
            .replace("true", "x").replace(",","")
            .replace("[","").replace("]",""));
}

}
  class CAS extends JPanel {
      private static final int WINDOW_WIDTH = 400;
      private static final int WINDOW_HEIGHT = 600;
      private static int rule;

      public CAS(int r) {
          rule = r;
          setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
      }
      protected void paintComponent(Graphics g) {
          super.paintComponent(g);
          Graphics2D g2d = (Graphics2D) g;
          int size = 400;
          CA ca = new CA(size, rule);
          boolean[] cell = new boolean[size];
          boolean[] firstCell = ca.getFirstState();
          for (int i = 0; i < 400; i++) {
              if (firstCell[i] == false)
                  g2d.setColor(Color.WHITE);
              else g2d.setColor(Color.BLACK);
              Rectangle2D rect = new Rectangle2D.Double(i, 0, 1, 1);
              g2d.fill(rect);
          }
          for (int j = 0; j < 600; j++) {
              cell = ca.getState();
              for (int a = 0; a < 400; a++) {
                  if (cell[a] == false)
                      g2d.setColor(Color.WHITE);
                  else g2d.setColor(Color.BLACK);
                  Rectangle2D rect = new Rectangle2D.Double(a,j, 10, 10);
                  g2d.fill(rect);
              }
          }
      }
      public void runApp(JPanel app) {
          JFrame frame = new JFrame("Swing CA");
          frame.setSize(getPreferredSize());
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.add(app);
          frame.setVisible(true);
      }
  }



