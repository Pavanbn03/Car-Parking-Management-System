import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ImageIcon;



public class Login
{
  private static JFrame Login;
  public static JTextField id;
  private JPasswordField password;
  
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Login window = new Login();
          Login.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
  






  public static String getdata()
  {
    String a = id.getText();
    return a;
  }
  
  public Login() {
    initialize();
  }
  


  private void initialize()
  {
    Login = new JFrame();
   Login.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Pavan BN\\Desktop\\car.jpg"));
    Login.setBackground(Color.BLACK);
    Login.getContentPane().setBackground(Color.BLACK);
   Login.setTitle("Login");
    Login.setBounds(100, 100, 800, 600);
   // Login.setExtendedState(JFrame.MAXIMIZED_BOTH); 
   // Login.setUndecorated(true);
    Login.setDefaultCloseOperation(3);
    Login.getContentPane().setLayout(null);
    
    id = new JTextField();
    id.setFont(new Font("Tahoma", 0, 18));
    id.setBounds(380, 177, 145, 38);
    Login.getContentPane().add(id);
    id.setColumns(10);
    
    JLabel lblNewLabel = new JLabel("LoginID");
    lblNewLabel.setForeground(Color.WHITE);
    lblNewLabel.setFont(new Font("Arial Black", 1, 16));
    lblNewLabel.setBounds(276, 190, 80, 25);
    Login.getContentPane().add(lblNewLabel);
    
    JLabel lblNewLabel_1 = new JLabel("Password");
    lblNewLabel_1.setForeground(Color.WHITE);
    lblNewLabel_1.setFont(new Font("Arial Black", 1, 17));
    lblNewLabel_1.setBounds(247, 253, 102, 30);
    Login.getContentPane().add(lblNewLabel_1);
    
    JButton idb = new JButton("Login");
    idb.setIcon(new ImageIcon("C:\\Users\\Pavan\\Downloads\\icons8-password-50.png"));
    idb.setFont(new Font("Tahoma", 0, 20));
    idb.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          String url = "jdbc:mysql://localhost:3306/sql?autoReconnet=true&useSSL=false";
          String uname = "root";
          String pass = "Pavanbn031998";
          Connection co = DriverManager.getConnection(url, uname, pass);
          String query = "select * from login where LoginID=? and Password=?";
          PreparedStatement ps = co.prepareStatement(query);
          String loginid = id.getText();
          
          String pas = password.getText();
          ps.setString(1, loginid);
          ps.setString(2, pas);
          ResultSet rs = ps.executeQuery();
          if (rs.next()) {
            JOptionPane.showMessageDialog(null, "Login successfull");
            
            Login.dispose();
            Managemet mg = new Managemet();
            mg.setVisible(true);
          } else {
            JOptionPane.showMessageDialog(null, "Invalid username and Password ");
          }
        }
        catch (Exception e)
        {
          System.out.println(e);
        }
      }
    });
    idb.setBackground(Color.WHITE);
    idb.setBounds(380, 402, 145, 38);
    Login.getContentPane().add(idb);
    
    password = new JPasswordField();
    password.addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent arg0) {
        if (arg0.getKeyCode() == 10) {
          try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/sql?autoReconnet=true&useSSL=false";
            String uname = "root";
            String pass = "Pavanbn031998";
            Connection co = DriverManager.getConnection(url, uname, pass);
            String query = "select * from login where LoginID=? and Password=?";
            PreparedStatement ps = co.prepareStatement(query);
            String loginid = id.getText();
            
            String pas = password.getText();
            ps.setString(1, loginid);
            ps.setString(2, pas);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
              JOptionPane.showMessageDialog(null, "Login successfull");
              
              Login.dispose();
              Managemet mg = new Managemet();
              mg.setVisible(true);
            } else {
              JOptionPane.showMessageDialog(null, "Invalid username and Password ");
            }
          }
          catch (Exception e)
          {
            JOptionPane.showMessageDialog(null, e);
          }
          
        }
      }
    });
    password.setEchoChar('*');
    password.setBounds(382, 244, 151, 39);
    Login.getContentPane().add(password);
    
    final JCheckBox chckbxNewCheckBox = new JCheckBox("Show Password");
    chckbxNewCheckBox.setForeground(Color.BLACK);
    chckbxNewCheckBox.setBackground(Color.WHITE);
    chckbxNewCheckBox.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        if (chckbxNewCheckBox.isSelected()) {
          password.setEchoChar('\000');
        } else {
          password.setEchoChar('*');
        }
      }
    });
    chckbxNewCheckBox.setBounds(380, 330, 153, 39);
    Login.getContentPane().add(chckbxNewCheckBox);
    
    JButton forget = new JButton("Forget Password");
    forget.setFont(new Font("Tahoma", 0, 16));
    forget.setBackground(Color.WHITE);
    forget.setForeground(Color.BLACK);
    forget.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        forget f = new forget();
        f.setVisible(true);
      }
    });
    forget.setBounds(568, 406, 188, 35);
    Login.getContentPane().add(forget);
    
    JLabel lblNewLabel_2 = new JLabel("New label");
    lblNewLabel_2.setIcon(new ImageIcon("D:\\software\\Car\\CarParking\\pics\\561cd1340faa7_thumb900.jpg"));
    lblNewLabel_2.setBounds(0, 0, 782, 553);
    Login.getContentPane().add(lblNewLabel_2);
  }
}