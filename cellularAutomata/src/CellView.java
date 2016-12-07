import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.*;
import java.util.Scanner;

/**
 *
 * @author Kayger Duran-Mateo
 * CellView class represents the graphical version of the 2d array of cells 
 */
public class CellView extends JFrame{
    private String visual;
    private JButton[][]buttons;
    private JFrame frame;
    
    /**
     *Empty constructor for CellView class
     */
    public CellView()
    {  
       
    }
        
    /**
     *View method that creates JFrame and JPanel aesthetics. JButtons are created to represent the 50X30 GridLayout of the 2d array
     */
    public void View()
       {
         frame = new JFrame("Cell Automata: Key{Healthy(0) = GREEN, Diseased(1) = RED, Dead(2) = BLACK}");
        JPanel panel = new JPanel();
        frame.add(panel);
        frame.setSize (700,650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        buttons = new JButton[50][30];
        
            for(int i = 0; i < buttons.length; i++) {
                for(int j = 0; j < buttons[i].length; j++){
               buttons[i][j] = new JButton();
               panel.add(buttons[i][j]);
               buttons[i][j].setBorderPainted(false);
               buttons[i][j].setMargin(new Insets(3,3,3,3));
              }
            }
            frame.setVisible (true);
       }
       
    /**
     *displayColor method reads in string representation of the array values and 
     * assigns colors to buttons based on those values
     * @param finalString contains the toString() representation of the 2d array values
     */
    public void displayColor(String finalString)
      { 
        visual = finalString;
        System.out.println(finalString);
        Scanner scan = new Scanner(visual);
        for(int i = 0; i < buttons.length; i++)
        {
           for(int j = 0; j < buttons[i].length; j++)
           {
               int colorValue = scan.nextInt();
               if(colorValue == 0)
               {
                   buttons[i][j].setBackground(Color.GREEN); 
                   buttons[i][j].setOpaque(true);
                   buttons[i][j].setBorderPainted(false);
                   //key = "Healthy(0) = GREEN";
               }
               else if(colorValue == 1)
               {
                   buttons[i][j].setBackground(Color.RED);
                    //key = "Diseased(1) = RED";
               }
               if(colorValue == 2)
               {
                   buttons[i][j].setBackground(Color.BLACK);
                   //key = "Dead(2) = BLACK"; 
               }
               
           }
        }
        frame.repaint();
      
       }  
    }   