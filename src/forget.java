import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

public class forget
  extends JFrame
{
  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private JTextField ans;
  private JTextField loginans;
  private JLabel lblLoginid;
  private JLabel lblNewLabel;
  
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          forget frame = new forget();
         // frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
  


  public forget()
  {
    setDefaultCloseOperation(3);
    setBounds(100, 100, 810, 494);
  //  this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    contentPane = new JPanel();
    contentPane.setBackground(Color.BLACK);
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    JLabel lblWhatIsYour = new JLabel("What is your Best Friend Name");
    lblWhatIsYour.setForeground(Color.WHITE);
    lblWhatIsYour.setFont(new Font("Tahoma", 0, 16));
    lblWhatIsYour.setBounds(80, 74, 254, 31);
    contentPane.add(lblWhatIsYour);
    
    ans = new JTextField();
    ans.setBounds(335, 79, 137, 22);
    contentPane.add(ans);
    ans.setColumns(10);
    
    JButton btnNewButton = new JButton("Verify");
    btnNewButton.setBackground(Color.GRAY);
    btnNewButton.setIcon(new ImageIcon("C:\\Users\\Pavan\\Downloads\\check-mark.png"));
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        String query = "select * from login where LoginID=? and question=?";
        try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          String url = "jdbc:mysql://localhost:3306/sql?autoReconnet=true&useSSL=false";
          String uname = "root";
          String pass = "Pavanbn031998";
          Connection co = DriverManager.getConnection(url, uname, pass);
          PreparedStatement ps = co.prepareStatement(query);
          ps.setString(1, loginans.getText());
          ps.setString(2, ans.getText());
          ResultSet rs = ps.executeQuery();
          if (rs.next()) {
            String passw = rs.getString("Password");
            JOptionPane.showMessageDialog(null, "Your password is " + passw);
            dispose();
            Login.main(null);
          }
          else {
            JOptionPane.showMessageDialog(null, "Invalid answer");
          }
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, e);
        }
        
      }
    });
    btnNewButton.setBounds(355, 131, 117, 31);
    contentPane.add(btnNewButton);
    
    loginans = new JTextField();
    loginans.setBounds(336, 27, 116, 22);
    contentPane.add(loginans);
    loginans.setColumns(10);
    
    lblLoginid = new JLabel("LoginID");
    lblLoginid.setFont(new Font("Tahoma", 0, 16));
    lblLoginid.setForeground(Color.WHITE);
    lblLoginid.setBounds(246, 22, 56, 31);
    contentPane.add(lblLoginid);
    
    lblNewLabel = new JLabel("New label");
    lblNewLabel.setIcon(new ImageIcon("D:\\software\\Car\\CarParking\\pics\\561cd1340faa7_thumb900.jpg"));
    lblNewLabel.setBounds(0, 0, 792, 447);
    contentPane.add(lblNewLabel);
  }
}