package quill;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;                                                        //events such as click event //mouse event,mouse event etc...
import javax.swing.filechooser.*;
import java.io.*;
                                                         
public class Quill extends JFrame implements ActionListener{
JTextArea area;                                                                 //globally defining the text area
String text; 
 class Board extends JPanel {
    private Color penColor = Color.BLACK;
    private boolean drawing = false;
    private int prevX, prevY;

     public Board() {
        setPreferredSize(new Dimension(500, 500));
        setBackground(Color.WHITE);

        addMouseListener(new MouseAdapter() {
            
            @Override
            public void mousePressed(MouseEvent e)
            {
                drawing = true;
                prevX = e.getX();
                prevY = e.getY();
            }
            
            
            @Override
            public void mouseReleased(MouseEvent e) {
                drawing = false;
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
          @Override
            public void mouseDragged(MouseEvent e) {
                if (drawing) {
                    int x = e.getX();
                    int y = e.getY();
                    drawLine(prevX, prevY, x, y);
                    prevX = x;
                    prevY = y;
                }
            }
        });
        
        
    }


 class Board extends JPanel {
    private Color penColor = Color.BLACK;
    private boolean drawing = false;
    private int prevX, prevY;

     public Board() {
        setPreferredSize(new Dimension(500, 500));
        setBackground(Color.WHITE);

        addMouseListener(new MouseAdapter() {
            
            @Override
            public void mousePressed(MouseEvent e)
            {
                drawing = true;
                prevX = e.getX();
                prevY = e.getY();
            }
            
            
            @Override
            public void mouseReleased(MouseEvent e) {
                drawing = false;
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
          @Override
            public void mouseDragged(MouseEvent e) {
                if (drawing) {
                    int x = e.getX();
                    int y = e.getY();
                    drawLine(prevX, prevY, x, y);
                    prevX = x;
                    prevY = y;
                }
            }
        });
        
        
    }
    
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    private void drawLine(int x1, int y1, int x2, int y2) {
        Graphics g = getGraphics();
        g.setColor(penColor);
        g.drawLine(x1, y1, x2, y2);
        g.dispose();
    }

    public void clear() {
        Graphics g = getGraphics();
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
        g.dispose();
    }

    public void setPenColor(Color color) {
        penColor = color;
    }
public static void hatit()
{
 JFrame frame = new JFrame("Whiteboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Board board = new Board();
        frame.add(board, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(e -> board.clear());
        controlPanel.add(clearButton);

        JButton colorButton = new JButton("Choose Color");
        colorButton.addActionListener(e -> {
            Color selectedColor = JColorChooser.showDialog(frame, "Choose Pen Color", board.penColor);
            if (selectedColor != null) {
                board.setPenColor(selectedColor);
            }
        });
        controlPanel.add(colorButton);

        frame.add(controlPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
}






    
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    private void drawLine(int x1, int y1, int x2, int y2) {
        Graphics g = getGraphics();
        g.setColor(penColor);
        g.drawLine(x1, y1, x2, y2);
        g.dispose();
    }

    public void clear() {
        Graphics g = getGraphics();
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
        g.dispose();
    }

    public void setPenColor(Color color) {
        penColor = color;
    }
public static void hatit()
{
 JFrame frame = new JFrame("Whiteboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Board board = new Board();
        frame.add(board, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(e -> board.clear());
        controlPanel.add(clearButton);

        JButton colorButton = new JButton("Choose Color");
        colorButton.addActionListener(e -> {
            Color selectedColor = JColorChooser.showDialog(frame, "Choose Pen Color", board.penColor);
            if (selectedColor != null) {
                board.setPenColor(selectedColor);
            }
        });
        controlPanel.add(colorButton);

        frame.add(controlPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
}   
Quill(){

        setTitle("Quill");                                                      //title of the application
        ImageIcon quillIcon=new ImageIcon(ClassLoader.getSystemResource("quill/npd_icon.jpeg"));
        Image icon=quillIcon.getImage();                                        //icon of the application
        setIconImage(icon);
        
        
        JMenuBar menubar=new JMenuBar();                                        //making menubar
        menubar.setBackground( Color.lightGray);                                //color of the menubar

       
        JMenu file= new JMenu("File");
        file.setFont(new Font("AERIAL",Font.PLAIN,15));                         //style of menubar font
      
       
        JMenuItem newfile = new JMenuItem("NEW");                               //drop down menu
        newfile.addActionListener(this);
        newfile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N , ActionEvent.CTRL_MASK));
        
        
        JMenuItem open = new JMenuItem("OPEN");    
        open.addActionListener(this);
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O , ActionEvent.CTRL_MASK));

        
        JMenuItem save = new JMenuItem("SAVE");  
        save.addActionListener(this);
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S , ActionEvent.CTRL_MASK));

        
        JMenuItem print=new JMenuItem("PRINT");    
         print.addActionListener(this);
        print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P , ActionEvent.CTRL_MASK));

        
        JMenuItem exit = new JMenuItem("EXIT");
        exit.addActionListener(this);
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));

            file.add(newfile);
              file.add(open);
                file.add(save);
                  file.add(print);
                    file.add(exit);
      
        menubar.add(file);
      
        JMenu edit= new JMenu("Edit");
        edit.setFont(new Font("AERIAL",Font.PLAIN,15));                         //style of menubar font
      
        JMenuItem cut = new JMenuItem("Cut");                                   //drop down menu
        cut.addActionListener(this);
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X , ActionEvent.CTRL_MASK));
        
        
        JMenuItem copy = new JMenuItem("Copy");                      
        copy.addActionListener(this);
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C , ActionEvent.CTRL_MASK));

        
        JMenuItem paste = new JMenuItem("Paste");                  
        paste.addActionListener(this);
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V , ActionEvent.CTRL_MASK));

        
        JMenuItem select_all=new JMenuItem("Select All");            
        select_all.addActionListener(this);
        select_all.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A , ActionEvent.CTRL_MASK));

        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(select_all);
        
        menubar.add(edit);
        
        JMenu penMenu = new JMenu("Pen");                                       //pen function
        penMenu.setFont(new Font("AERIAL", Font.PLAIN, 15));

        JMenuItem choosePenColor = new JMenuItem("Choose Color");
        choosePenColor.addActionListener(this);

        penMenu.add(choosePenColor);
        menubar.add(penMenu);
       
        
        JMenu white_board= new JMenu("Board");
        white_board.setFont(new Font("AERIAL",Font.PLAIN,15));
        menubar.add(white_board);
        
       // JMenuItem boardMenuItem = new JMenuItem("Board");
        //boardMenuItem.addActionListener(this); 
        //white_board.add(boardMenuItem);

        setJMenuBar(menubar);
       
        
        JMenu helpmenubar= new JMenu("Help");
        helpmenubar.setFont(new Font("AERIAL",Font.PLAIN,15));                  //style of menubar font
      
        JMenuItem help = new JMenuItem("About");                                //drop down menu
        help.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
        
        helpmenubar.add(help);
        
        menubar.add(helpmenubar);
        
        
        area = new JTextArea();                                                 //text area
        
        
        area.setFont(new Font("COMIC SANS",Font.PLAIN,18));
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        
        
        JScrollPane pane = new JScrollPane(area);                               //scroll bar
        pane.setBorder(BorderFactory.createEmptyBorder());
        add(pane);
        setExtendedState(JFrame.MAXIMIZED_BOTH);                                //by default opens as fullscreen opens
        
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae){
       if(ae.getActionCommand().equals("NEW")){
            area.setText("");
       }
       else if(ae.getActionCommand().equals("OPEN")){
           JFileChooser chooser =  new JFileChooser();                                                     // a swing class that enables choosing files
           chooser.setAcceptAllFileFilterUsed(false);                                                      //adding ecxeption on file acceptance
           FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only.txt files","txt");         //accepting only .txt files
           chooser.addChoosableFileFilter(restrict);
           
           int action = chooser.showOpenDialog(this);                                                      //dialog from which the user can choose files
           
           if(action != JFileChooser.APPROVE_OPTION){
            return ;
            }

           File file =chooser.getSelectedFile();
           
           try{
           BufferedReader reader = new BufferedReader(new FileReader(file));                                  //reads text files
           area.read(reader, null);
           }
           catch(Exception e){
           e.printStackTrace();
           }
       } else if(ae.getActionCommand().equals("SAVE")){
       JFileChooser saveas = new JFileChooser();
       saveas.setApproveButtonText("SAVE");
       
       int action = saveas.showOpenDialog(this);                                                                //dialog from which the user can choose files
           
           if(action != JFileChooser.APPROVE_OPTION){
            return ;
            }
           
           File filename = new File(saveas.getSelectedFile() + ".txt");
           BufferedWriter outfile = null;
           
           try{
               outfile = new BufferedWriter( new FileWriter(filename));
               area.write(outfile);
           }
           
           catch(Exception e) {
           e.printStackTrace();
           }
       }
       else if(ae.getActionCommand().equals("PRINT")){
       try {
           area.print();
       }catch(Exception e){
       e.printStackTrace();
       }
       }
       else if(ae.getActionCommand().equals("EXIT")){
       System.exit(0);
       }
       
       else if(ae.getActionCommand().equals("Copy")){
       text = area.getSelectedText();
       }
       else if(ae.getActionCommand().equals("Cut")){
       text = area.getSelectedText();
      area.replaceRange("",area.getSelectionStart(),area.getSelectionEnd());
       }
       else if(ae.getActionCommand().equals("Paste")){
       area.insert(text, area.getCaretPosition());
       }
      else if(ae.getActionCommand().equals("Select All")){
       area.selectAll();
       } 
      else if(ae.getActionCommand().equals("About")){
    JOptionPane.showMessageDialog(this, "Quill - A Simple Text Editor \nDeveloped for educational purposes.", "About Quill", JOptionPane.INFORMATION_MESSAGE);
}
       else if (ae.getActionCommand().equals("Choose Color")) {
    Color selectedColor = JColorChooser.showDialog(this, "Choose Pen Color", Color.BLACK);                          // Open color chooser dialog
    if (selectedColor != null) {
        area.setForeground(selectedColor);                                                                          // Set the selected color as the text color of the JTextArea
    }
}
      else if (ae.getActionCommand().equals("Board")) {
       Board.hatit();
  }

       
    }
    
    public static void main(String[] args) {
        new Quill();
        
       
    }
    
}