/*
 * Dawn Myers
 * ITDEV 140 Mequon 2016
 */
package View;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.text.DecimalFormat;

/**
 *
 * @author Dawn
 */

//Creates GUI for application
public class PokemonView extends JFrame {
    
    private JButton prevBtn;
    private JButton nextBtn;
    private JLabel nameLabel;
    private JLabel idLabel;
    private JLabel heightLabel;
    private JLabel weightLabel;
    private JTextField nameText;
    private JTextField idText;
    private JTextField heightText;
    private JTextField weightText;

    
    private static final int FRAME_WIDTH = 250;         //width of frame
    private static final int FRAME_HEIGHT = 200;        //height of frame
    private static final int VERTICAL_MARGIN = 10;      //vertical padding between components
    private static final int HORIZONTAL_MARGIN = 10;    //horizontal padding between compoenents
    
    //creates components, sets the frame size, and frame title
    public PokemonView()
    {
        createComponents();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setTitle("Pokedex");
    }
    
    //calls all methods creating components of GUI
    private void createComponents()
    {
        createButtons();
        createLabels();
        createTextFields();
        createGrid();
    }
    
    //creates buttons
    public void createButtons()
    {
        prevBtn = new JButton("Previous");       
        nextBtn = new JButton("Next");
    }
    
    //creates labels
    public void createLabels()
    {
        nameLabel = new JLabel("Name");
        idLabel = new JLabel("ID");
        heightLabel = new JLabel("Height");
        weightLabel = new JLabel("Weight");
    }    
    
    //creates the grid, and adds components to it
    public void createGrid()
    {
        setLayout(new GridLayout(5, 2, HORIZONTAL_MARGIN, VERTICAL_MARGIN));
        add(nameLabel);
        add(nameText);
        
        add(idLabel);
        add(idText);
        
        add(heightLabel);
        add(heightText);
        
        add(weightLabel);
        add(weightText);   
        
        add(prevBtn);
        add(nextBtn); 
        
        pack();
    }

    //creates text fields 
    public void createTextFields()
    {
        nameText = new JTextField();
        idText = new JTextField();
        heightText = new JTextField();
        weightText = new JTextField();
    }
    
    //listens for input on button
    public void prevButtonActionListener(ActionListener listener)
    {
        prevBtn.addActionListener(listener);
    }
    
    //listens for input on button
    public void nextButtonActionListener(ActionListener listener)
    {
        nextBtn.addActionListener(listener);
    }
    
    //sets the text value of the text fields
    public void setPokemonText(int id, String name, int height, int weight)
    {
        DecimalFormat df = new DecimalFormat("#.0");
        
        nameText.setText(name.substring(0, 1).toUpperCase() + name.substring(1));
        idText.setText(Integer.toString(id));
        heightText.setText(df.format(height/10.0) + " meters");
        weightText.setText(df.format(weight/10.0) + " kg");
    }
    
}
