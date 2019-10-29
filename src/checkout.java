import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

public class checkout
  extends JFrame
{
  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private JTextField covid;
  private JTextField coci;
  private JTextField coco;
  private JTextField amt;
  public String ckin;
  public String amount;
  public Date s;
  public String date;
  
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          checkout frame = new checkout();
         // frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
  public checkout()
  {
    setDefaultCloseOperation(3);
    setBounds(100, 100, 715, 499);
 //   this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    contentPane = new JPanel();
    contentPane.setBackground(Color.BLACK);
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    JButton btnNewButton = new JButton("Checkout");
    btnNewButton.setBackground(Color.GRAY);
    btnNewButton.setIcon(new ImageIcon("C:\\Users\\Pavan\\Downloads\\cashier.png"));
    btnNewButton.setFont(new Font("Tahoma", 0, 17));
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          String url = "jdbc:mysql://localhost:3306/sql?autoReconnet=true&useSSL=false";
          String uname = "root";
          String pass = "Pavanbn031998";
          Connection co = DriverManager.getConnection(url, uname, pass);
          String query = "delete from parking where VID=?";
          PreparedStatement ps = co.prepareStatement(query);
          ps.setString(1, covid.getText());
          if (!covid.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "CheckOut Successfull");
            ps.executeUpdate();
          }
          else {
            JOptionPane.showMessageDialog(null, "Enter VID"); }
          if (!covid.getText().isEmpty())
          {
            String qu = "insert into amount values (?,?,?,?)";
            PreparedStatement pps = co.prepareStatement(qu);
            pps.setString(1, covid.getText());
            pps.setString(2, ckin);
            pps.setString(3, date);
            pps.setString(4, amount);
            pps.execute();
            dispose();
            Managemet.main(null);
          }
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, e);
        }
        
      }
    });
    btnNewButton.setBounds(263, 399, 165, 40);
    contentPane.add(btnNewButton);
    
    covid = new JTextField();
    covid.setBounds(162, 73, 116, 22);
    contentPane.add(covid);
    covid.setColumns(10);
    
    JLabel lblNewLabel = new JLabel("VID");
    lblNewLabel.setForeground(Color.WHITE);
    lblNewLabel.setFont(new Font("Tahoma", 0, 18));
    lblNewLabel.setBounds(96, 79, 56, 16);
    contentPane.add(lblNewLabel);
    
    coci = new JTextField();
    coci.setEditable(false);
    coci.setBounds(162, 185, 190, 22);
    contentPane.add(coci);
    coci.setColumns(10);
    
    coco = new JTextField();
    coco.setEditable(false);
    coco.setBounds(162, 239, 190, 22);
    contentPane.add(coco);
    coco.setColumns(10);
    
    JButton btnNewButton_1 = new JButton("Verify");
    btnNewButton_1.setBackground(Color.GRAY);
    btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Pavan\\Downloads\\check-mark.png"));
    btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
    btnNewButton_1.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0)
      {
        try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          String url = "jdbc:mysql://localhost:3306/sql?autoReconnet=true&useSSL=false";
          String uname = "root";
          String pass = "Pavanbn031998";
          Connection co = DriverManager.getConnection(url, uname, pass);
          String query = "Select * from parking where VID=?";
          PreparedStatement sp = co.prepareStatement(query);
          

          sp.setString(1, covid.getText());
          ResultSet rs = sp.executeQuery();
          if (rs.next()) {
            ckin = rs.getString("CheckIN");
            int dayss = Integer.parseInt(ckin.substring(8, 10));
            int hourss = Integer.parseInt(ckin.substring(11, 13));
            int minn = Integer.parseInt(ckin.substring(14, 16));
            coci.setText(ckin);
            s = new Date();
            s.setHours(s.getHours());
            date = s.toString();
            coco.setText(s.toString());
            int days = Integer.parseInt(date.substring(8, 10));
            int hours = Integer.parseInt(date.substring(11, 13));
            int min = Integer.parseInt(date.substring(14, 16));
            int tday = (days - dayss) * 240;
            int thrs = (hours - hourss) * 10;
            double tmin = (min - minn) * 0.166D;
            double ammt = Math.ceil(tday + tmin + thrs);
            amount = Double.toString(ammt);
            amt.setText(amount);
          }
          else
          {
            JOptionPane.showMessageDialog(null, "Invalid VID");
            dispose();
            Managemet.main(null);
          }
        }
        catch (Exception e) {
          JOptionPane.showMessageDialog(null, e);
        }
      }
    });
    btnNewButton_1.setBounds(162, 118, 116, 32);
    contentPane.add(btnNewButton_1);
    
    amt = new JTextField();
    amt.setEditable(false);
    amt.setBounds(162, 306, 116, 22);
    contentPane.add(amt);
    amt.setColumns(10);
    
    JLabel lblNewLabel_1 = new JLabel("Checkin");
    lblNewLabel_1.setForeground(Color.WHITE);
    lblNewLabel_1.setFont(new Font("Tahoma", 0, 18));
    lblNewLabel_1.setBounds(64, 191, 97, 16);
    contentPane.add(lblNewLabel_1);
    
    JLabel lblNewLabel_2 = new JLabel("Checkout");
    lblNewLabel_2.setForeground(Color.WHITE);
    lblNewLabel_2.setFont(new Font("Tahoma", 0, 18));
    lblNewLabel_2.setBounds(64, 238, 79, 16);
    contentPane.add(lblNewLabel_2);
    
    JLabel lblNewLabel_4 = new JLabel("Amount");
    lblNewLabel_4.setForeground(Color.WHITE);
    lblNewLabel_4.setFont(new Font("Tahoma", 0, 18));
    lblNewLabel_4.setBounds(73, 305, 79, 16);
    contentPane.add(lblNewLabel_4);
    
    JLabel lblNewLabel_3 = new JLabel("New label");
    lblNewLabel_3.setIcon(new ImageIcon("D:\\software\\Car\\CarParking\\pics\\561cd1340faa7_thumb900.jpg"));
    lblNewLabel_3.setBounds(0, 0, 697, 452);
    contentPane.add(lblNewLabel_3);
  }
}