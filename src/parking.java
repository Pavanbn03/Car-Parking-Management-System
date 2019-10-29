import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;






public class parking
  extends JFrame
{
  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private JTextField fn;
  private JTextField ln;
  private JTextField age;
  private JTextField vno;
  private JTextField vt;
  private JTextField pn;
  private JTextField add;
  private JButton submit;
  private JLabel lblDate;
  private JTextField datee;
  private JTextField time;
  private int vid = 0;
  
  private JTextField lid;
  
  private JLabel lblLoginid;
  private JButton btnNewButton;
  private JLabel lblNewLabel_1;
  
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          parking frame = new parking();
          //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }



  @SuppressWarnings("deprecation")
public parking()
  {
    setDefaultCloseOperation(3);
    setBounds(100, 100, 822, 575);
   // this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    contentPane = new JPanel();
    contentPane.setBackground(Color.BLACK);
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    fn = new JTextField();
    fn.setBounds(279, 43, 116, 22);
    contentPane.add(fn);
    fn.setColumns(10);
    
    ln = new JTextField();
    ln.setBounds(279, 87, 116, 22);
    contentPane.add(ln);
    ln.setColumns(10);
    
    age = new JTextField();
    age.setBounds(279, 127, 116, 22);
    contentPane.add(age);
    age.setColumns(10);
    
    vno = new JTextField();
    vno.setColumns(10);
    vno.setBounds(279, 165, 116, 22);
    contentPane.add(vno);
    
    vt = new JTextField();
    vt.setColumns(10);
    vt.setBounds(279, 218, 116, 22);
    contentPane.add(vt);
    
    pn = new JTextField();
    pn.setColumns(10);
    pn.setBounds(279, 267, 116, 22);
    contentPane.add(pn);
    
    add = new JTextField();
    add.setColumns(10);
    add.setBounds(279, 313, 116, 22);
    contentPane.add(add);
    
    JLabel lblNewLabel = new JLabel("Fname");
    lblNewLabel.setForeground(Color.WHITE);
    lblNewLabel.setFont(new Font("Tahoma", 0, 18));
    lblNewLabel.setBounds(211, 44, 56, 16);
    contentPane.add(lblNewLabel);
    
    JLabel lblLname = new JLabel("Lname");
    lblLname.setForeground(Color.WHITE);
    lblLname.setBackground(Color.WHITE);
    lblLname.setFont(new Font("Tahoma", 0, 18));
    lblLname.setBounds(211, 88, 56, 16);
    contentPane.add(lblLname);
    
    JLabel lblAge = new JLabel("Age");
    lblAge.setForeground(Color.WHITE);
    lblAge.setFont(new Font("Tahoma", 0, 18));
    lblAge.setBounds(211, 124, 56, 25);
    contentPane.add(lblAge);
    
    JLabel lblVehicleno = new JLabel("VehicleNo");
    lblVehicleno.setForeground(Color.WHITE);
    lblVehicleno.setFont(new Font("Tahoma", 0, 18));
    lblVehicleno.setBounds(193, 166, 78, 16);
    contentPane.add(lblVehicleno);
    
    JLabel lblVehicletype = new JLabel("VehicleType");
    lblVehicletype.setForeground(Color.WHITE);
    lblVehicletype.setFont(new Font("Tahoma", 0, 18));
    lblVehicletype.setBounds(165, 219, 102, 21);
    contentPane.add(lblVehicletype);
    
    JLabel lblPhno = new JLabel("Phno");
    lblPhno.setForeground(Color.WHITE);
    lblPhno.setFont(new Font("Tahoma", 0, 18));
    lblPhno.setBounds(227, 268, 40, 16);
    contentPane.add(lblPhno);
    
    JLabel lblAddress = new JLabel("Address");
    lblAddress.setForeground(Color.WHITE);
    lblAddress.setFont(new Font("Tahoma", 0, 18));
    lblAddress.setBounds(200, 314, 67, 16);
    contentPane.add(lblAddress);
    
    submit = new JButton("Submit");
    submit.setBackground(Color.GRAY);
    submit.setIcon(new ImageIcon("C:\\Users\\Pavan\\Downloads\\icons8-upload-to-cloud-24.png"));
    submit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          String url = "jdbc:mysql://localhost:3306/sql?autoReconnet=true&useSSL=false";
          String uname = "root";
          String pass = "Pavanbn031998";
          Connection co = DriverManager.getConnection(url, uname, pass);
          String query = "insert into customer values(?,?,?,?,?,?,?,?,?)";
          PreparedStatement ps = co.prepareStatement(query);
          ps.setString(1, fn.getText());
          ps.setString(2, ln.getText());
          ps.setString(3, age.getText());
          ps.setString(4, vno.getText());
          ps.setString(5, vt.getText());
          ps.setString(6, pn.getText());
          ps.setString(7, add.getText());
          lid.setText(Login.getdata());
          lid.setEnabled(false);
          String q = "SELECT vid from customer order by vid desc limit 1";
          Statement s = co.createStatement();
          ResultSet rs = s.executeQuery(q);
          rs.next();
          String vidnum = rs.getString("VID");
          vid = Integer.parseInt(vidnum);
          vid += 1;
          if ((!fn.getText().isEmpty()) && (!ln.getText().isEmpty()) && (!age.getText().isEmpty()) && (!vno.getText().isEmpty()) && (!vt.getText().isEmpty()) && (!pn.getText().isEmpty()) && (!add.getText().isEmpty()) && (!lid.getText().isEmpty())) {
            ps.setString(8, Integer.toString(vid));
            ps.setString(9, Login.getdata());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Successfull");
            JOptionPane.showMessageDialog(null, "Your VID" + vid);
            park pa = new park();
            pa.setVisible(true);
            dispose();
          } else {
            JOptionPane.showMessageDialog(null, "Enter all details");
          }
        }
        catch (Exception e)
        {
          JOptionPane.showMessageDialog(null, e);
        }
      }
    });
    submit.setFont(new Font("Tahoma", 0, 15));
    submit.setBounds(279, 394, 116, 25);
    contentPane.add(submit);
    
    lblDate = new JLabel("Date:");
    lblDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
    lblDate.setForeground(Color.WHITE);
    lblDate.setBounds(564, 46, 40, 16);
    contentPane.add(lblDate);
    
    datee = new JTextField();
    datee.setBounds(611, 43, 116, 22);
    contentPane.add(datee);
    datee.setColumns(10);
    datee.setEditable(false);
    Calendar cal = new GregorianCalendar();
    int date = cal.get(5);
    int month = cal.get(2) + 1;
    int year = cal.get(1);
    
    datee.setText(date + "-" + month + "-" + year);
    
    time = new JTextField();
    time.setBounds(490, 78, 302, 22);
    contentPane.add(time);
    time.setColumns(10);
    time.setEditable(false);
    Date s = new Date();
    s.setHours(s.getHours());
	time.setText(s.toString());
    time.setEditable(false);
    
    lid = new JTextField();
    lid.setEditable(false);
    lid.setBounds(279, 359, 116, 22);
    contentPane.add(lid);
    lid.setColumns(10);
    
    lblLoginid = new JLabel("StaffLoginID");
    lblLoginid.setForeground(Color.WHITE);
    lblLoginid.setFont(new Font("Tahoma", 0, 18));
    lblLoginid.setBounds(165, 362, 102, 22);
    contentPane.add(lblLoginid);
    
    btnNewButton = new JButton("IF registred");
    btnNewButton.setBackground(Color.GRAY);
    btnNewButton.setIcon(new ImageIcon("C:\\Users\\Pavan\\Downloads\\icons8-add-user-male-50.png"));
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        park pa = new park();dispose();
        pa.setVisible(true);
      }
      
    });
    btnNewButton.setBounds(263, 443, 153, 36);
    contentPane.add(btnNewButton);
    
    lblNewLabel_1 = new JLabel("New label");
    lblNewLabel_1.setBackground(Color.GRAY);
    lblNewLabel_1.setIcon(new ImageIcon("D:\\software\\Car\\CarParking\\pics\\561cd1340faa7_thumb900.jpg"));
    lblNewLabel_1.setBounds(0, 0, 804, 528);
    contentPane.add(lblNewLabel_1);
  }
}