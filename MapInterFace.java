import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MapInterFace extends JFrame{

// Declare GUI components
   private JTextField jtfIP;
   private JTextField jtfLongtitude;
   private JTextField jtfLatitude;
   private JLabel jlblIP;
   private JLabel jlblLongtitude;
   private JLabel jlblLatitude;
   private JPanel entryPanel;
   private JPanel buttonPanel;
   private JButton jbtSubmit;
   private JButton jbtReset;

// main method to instantiate and customize frame
   public static void main(String[] args){

       InterFace frame = new InterFace();
       frame.setTitle( "Find The Location");
       frame.setSize( 350, 150 );
       frame.setLocation(400, 400);
       frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
       frame.setVisible(true);
   }

// GUI constructor
   public InterFace(){

       // Instantiate GUI components for top of frame
       jlblIP = new JLabel( "IP Address: ", JLabel.CENTER );
       jlblLongtitude = new JLabel( "Longtitude: ", JLabel.CENTER );
       jlblLatitude = new JLabel( "Latitude: ", JLabel.CENTER );
       jtfIP = new JTextField(12);
       jtfLongtitude = new JTextField(12);
       jtfLatitude = new JTextField(12);
       entryPanel = new JPanel();

       // make Latitude text field uneditable
       jtfLongtitude.setEditable( false );
	  jtfLatitude.setEditable( false );

       // Set layout manager of panel
       entryPanel.setLayout( new GridLayout(3,2));

       // add GUI components to panel
       entryPanel.add( jlblIP );
       entryPanel.add( jtfIP );
       entryPanel.add( jlblLongtitude );
       entryPanel.add( jtfLongtitude );
       entryPanel.add( jlblLatitude );
       entryPanel.add( jtfLatitude );

       // add entryPanel to frame
       add(entryPanel, BorderLayout.CENTER);

       // Instantiate GUI components for bottom of frame
       jbtSubmit = new JButton( "Submit" );
       jbtReset = new JButton( "Reset" );
       buttonPanel = new JPanel();

       // add buttons to panel
       buttonPanel.add( jbtSubmit );
       buttonPanel.add( jbtReset );

       // add buttonPanel to frame
       add( buttonPanel, BorderLayout.SOUTH);

       //Event Handler
       jbtSubmit.addMouseListener(new List_ButtonSUBMIT());
       jbtReset.addMouseListener(new List_ButtonRESET());
   }
   
   private class List_ButtonSUBMIT implements MouseListener{

       public void mouseClicked(MouseEvent event){
           String IP = jtfIP.getText();
		 GoogleMap main = new GoogleMap();
		 double [] points = main.Main(IP);

           jtfLongtitude.setText(String.valueOf(points[0]));
           jtfLatitude.setText(String.valueOf(points[1]));

       }public void mousePressed(MouseEvent event){

       }public void mouseReleased(MouseEvent event){

       }public void mouseEntered(MouseEvent event){

       }public void mouseExited(MouseEvent event){

       }
   }

   private class List_ButtonRESET implements MouseListener{

       public void mouseClicked(MouseEvent event){

           jtfIP.setText(String.valueOf(""));
		 jtfLongtitude.setText(String.valueOf(""));
           jtfLatitude.setText(String.valueOf(""));

       }public void mousePressed(MouseEvent event){

       }public void mouseReleased(MouseEvent event){

       }public void mouseEntered(MouseEvent event){

       }public void mouseExited(MouseEvent event){

       }
   }
}
