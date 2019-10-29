import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
public class Registor
  extends JFrame
{
  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private JTextField loginid;
  private JTextField passwordfield;
  private JTextField fname;
  private JTextField lname;
  private JTextField address;
  private JTextField phno;
  private JTextField age;
  private JTextField email;
  private JLabel lblIsOptional;
  private JTextField question;
  private JLabel lblNewLabel_8;
  
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Registor frame = new Registor();
         // frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
  
  public Registor()
  {
    setDefaultCloseOperation(3);
    setBounds(100, 100, 933, 704);
    //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    contentPane = new JPanel();
    contentPane.setBackground(Color.BLACK);
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    

    loginid = new JTextField();
    loginid.setBounds(341, 43, 116, 22);
    contentPane.add(loginid);
    loginid.setColumns(10);
    
    passwordfield = new JTextField();
    passwordfield.setBounds(341, 89, 116, 22);
    contentPane.add(passwordfield);
    passwordfield.setColumns(10);
    
    fname = new JTextField();
    fname.setBounds(341, 173, 116, 22);
    contentPane.add(fname);
    fname.setColumns(10);
    
    lname = new JTextField();
    lname.setBounds(341, 242, 116, 22);
    contentPane.add(lname);
    lname.setColumns(10);
    
    address = new JTextField();
    address.setBounds(341, 297, 296, 59);
    contentPane.add(address);
    address.setColumns(10);
    
    phno = new JTextField();
    phno.setBounds(341, 380, 116, 22);
    contentPane.add(phno);
    phno.setColumns(10);
    
    age = new JTextField();
    age.setBounds(341, 452, 116, 22);
    contentPane.add(age);
    age.setColumns(10);
    
    email = new JTextField();
    email.setBounds(341, 514, 116, 22);
    contentPane.add(email);
    email.setColumns(10);
    
    JLabel lblNewLabel = new JLabel("LoginID");
    lblNewLabel.setForeground(Color.WHITE);
    lblNewLabel.setFont(new Font("Tahoma", 1, 15));
    lblNewLabel.setBounds(251, 46, 654, 16);
    contentPane.add(lblNewLabel);
    
    JLabel lblNewLabel_1 = new JLabel("Password");
    lblNewLabel_1.setForeground(Color.WHITE);
    lblNewLabel_1.setFont(new Font("Tahoma", 1, 15));
    lblNewLabel_1.setBounds(224, 91, 679, 16);
    contentPane.add(lblNewLabel_1);
    
    JLabel lblNewLabel_2 = new JLabel("F_name");
    lblNewLabel_2.setForeground(Color.WHITE);
    lblNewLabel_2.setFont(new Font("Tahoma", 1, 15));
    lblNewLabel_2.setBounds(251, 176, 654, 16);
    contentPane.add(lblNewLabel_2);
    
    JLabel lblNewLabel_3 = new JLabel("*L_name");
    lblNewLabel_3.setForeground(Color.WHITE);
    lblNewLabel_3.setFont(new Font("Tahoma", 1, 15));
    lblNewLabel_3.setBounds(251, 245, 654, 16);
    contentPane.add(lblNewLabel_3);
    
    JLabel lblNewLabel_4 = new JLabel("Address");
    lblNewLabel_4.setForeground(Color.WHITE);
    lblNewLabel_4.setFont(new Font("Tahoma", 1, 15));
    lblNewLabel_4.setBounds(251, 318, 654, 16);
    contentPane.add(lblNewLabel_4);
    
    JLabel lblNewLabel_5 = new JLabel("Phno");
    lblNewLabel_5.setForeground(Color.WHITE);
    lblNewLabel_5.setFont(new Font("Tahoma", 1, 15));
    lblNewLabel_5.setBounds(251, 383, 654, 16);
    contentPane.add(lblNewLabel_5);
    
    JLabel lblNewLabel_6 = new JLabel("Age");
    lblNewLabel_6.setForeground(Color.WHITE);
    lblNewLabel_6.setFont(new Font("Tahoma", 1, 15));
    lblNewLabel_6.setBounds(251, 455, 654, 16);
    contentPane.add(lblNewLabel_6);
    
    JLabel lblNewLabel_7 = new JLabel("E-mail");
    lblNewLabel_7.setForeground(Color.WHITE);
    lblNewLabel_7.setFont(new Font("Tahoma", 1, 15));
    lblNewLabel_7.setBounds(251, 517, 654, 16);
    contentPane.add(lblNewLabel_7);
    
    JButton registor = new JButton("Registor");
    registor.setBackground(Color.GRAY);
    registor.setForeground(Color.BLACK);
    registor.setIcon(new ImageIcon("C:\\Users\\Pavan\\Downloads\\icons8-add-user-male-50.png"));
    registor.setFont(new Font("Tahoma", 1, 13));
    registor.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          String url = "jdbc:mysql://localhost:3306/sql?autoReconnet=true&useSSL=false";
          String uname = "root";
          String pass = "Pavanbn031998";
          Connection co = DriverManager.getConnection(url, uname, pass);
          String query = "insert into login values (?,?,?,?,?,?,?,?,?)";
          PreparedStatement ps = co.prepareStatement(query);
          ps.setString(1, loginid.getText());
          ps.setString(2, passwordfield.getText());
          ps.setString(3, fname.getText());
          ps.setString(4, lname.getText());
          ps.setString(5, address.getText());
          ps.setString(6, phno.getText());
          ps.setString(7, age.getText());
          ps.setString(8, email.getText());
          ps.setString(9, question.getText());
          if ((!loginid.getText().isEmpty()) && (!passwordfield.getText().isEmpty()) && (!fname.getText().isEmpty()) && (!address.getText().isEmpty()) && (!phno.getText().isEmpty()) && (!age.getText().isEmpty()) && (!email.getText().isEmpty()) && (!question.getText().isEmpty())) {
            ps.execute();
            JOptionPane.showMessageDialog(null, "Registored successfull");
            dispose();
            Login.main(null);
          }
          else {
            JOptionPane.showMessageDialog(null, "Enter All details ");
          }
        }
        catch (Exception e) {
          JOptionPane.showMessageDialog(null, e);
        }
      }
    });
    registor.setBounds(301, 584, 193, 37);
    contentPane.add(registor);
    
    lblIsOptional = new JLabel("* is Optional");
    lblIsOptional.setBackground(Color.YELLOW);
    lblIsOptional.setFont(new Font("Tahoma", 1, 17));
    lblIsOptional.setBounds(716, 612, 146, 29);
    contentPane.add(lblIsOptional);
    
    JLabel lblWhatIsBest = new JLabel("What is Best friend Name");
    lblWhatIsBest.setForeground(Color.WHITE);
    lblWhatIsBest.setBackground(Color.ORANGE);
    lblWhatIsBest.setFont(new Font("Tahoma", 0, 16));
    lblWhatIsBest.setBounds(93, 132, 240, 16);
    contentPane.add(lblWhatIsBest);
    
    question = new JTextField();
    question.setBounds(341, 124, 116, 22);
    contentPane.add(question);
    question.setColumns(10);
    
    lblNewLabel_8 = new JLabel("New label");
    lblNewLabel_8.setIcon(new ImageIcon("D:\\software\\Car\\CarParking\\pics\\561cd1340faa7_thumb900.jpg"));
    lblNewLabel_8.setBounds(0, 0, 915, 657);
    contentPane.add(lblNewLabel_8);
  }
}