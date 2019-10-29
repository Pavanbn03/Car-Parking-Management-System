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
public class park
  extends JFrame
{
  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private JTextField vidf;
  private JTextField cin;
  private JTextField slot;
  private JTextField rslot;
  private JTextField datee;
  private JTextField vnof;
  private JLabel lblNewLabel_6;
  int hrs;
  int sec;
  int min;
  int remaning;
  ResultSet rs;
  private JLabel lblNewLabel_5;
  
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          park frame = new park();
         // frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
  


  public static Integer useLoop(int[] names, Integer targetValue)
  {
    int[] arrayOfInt = names;int j = names.length; 
    for (int i = 0; i < j; i++) { 
    	Integer s = Integer.valueOf(arrayOfInt[i]);
      if (s.equals(targetValue))
        return Integer.valueOf(1);
    }
    return Integer.valueOf(0);
  }
  
  @SuppressWarnings({ "deprecation", "deprecation", "deprecation" })
public park() {
    setDefaultCloseOperation(3);
    setBounds(100, 100, 922, 561);
 //   this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    contentPane = new JPanel();
    contentPane.setBackground(Color.BLACK);
    contentPane.setForeground(Color.BLACK);
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    vidf = new JTextField();
    vidf.setEditable(false);
    vidf.setBounds(293, 125, 116, 22);
    contentPane.add(vidf);
    vidf.setColumns(10);
    
    cin = new JTextField();
    cin.setEditable(false);
    cin.setBounds(293, 182, 188, 22);
    contentPane.add(cin);
    cin.setColumns(10);
    
    slot = new JTextField();
    slot.setEditable(false);
    slot.setBounds(293, 239, 116, 22);
    contentPane.add(slot);
    slot.setColumns(10);
    
    rslot = new JTextField();
    rslot.setEditable(false);
    rslot.setBounds(293, 296, 116, 22);
    contentPane.add(rslot);
    rslot.setColumns(10);
    
    JLabel lblNewLabel = new JLabel("VID");
    lblNewLabel.setForeground(Color.WHITE);
    lblNewLabel.setFont(new Font("Tahoma", 0, 18));
    lblNewLabel.setBounds(225, 126, 56, 16);
    contentPane.add(lblNewLabel);
    
    JLabel lblNewLabel_1 = new JLabel("Check_IN");
    lblNewLabel_1.setForeground(Color.WHITE);
    lblNewLabel_1.setFont(new Font("Tahoma", 0, 18));
    lblNewLabel_1.setBounds(181, 183, 91, 16);
    contentPane.add(lblNewLabel_1);
    
    JLabel lblNewLabel_2 = new JLabel("Parking Slot");
    lblNewLabel_2.setForeground(Color.WHITE);
    lblNewLabel_2.setFont(new Font("Tahoma", 0, 18));
    lblNewLabel_2.setBounds(181, 240, 100, 16);
    contentPane.add(lblNewLabel_2);
    
    JLabel lblNewLabel_3 = new JLabel("Remaning Slot");
    lblNewLabel_3.setForeground(Color.WHITE);
    lblNewLabel_3.setFont(new Font("Tahoma", 0, 18));
    lblNewLabel_3.setBounds(156, 295, 125, 21);
    contentPane.add(lblNewLabel_3);
    
    JButton btnNewButton = new JButton("Submit");
    btnNewButton.setBackground(Color.GRAY);
    btnNewButton.setIcon(new ImageIcon("C:\\Users\\Pavan\\Downloads\\icons8-upload-to-cloud-24.png"));
    btnNewButton.addActionListener(new ActionListener() {
      @SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent arg0) {
        int sl = 1;
        int rps = 0;
        
        int[] names = new int[5];
        try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          String url = "jdbc:mysql://localhost:3306/sql?autoReconnet=true&useSSL=false";
          String uname = "root";
          String pass = "Pavanbn031998";
          Connection co = DriverManager.getConnection(url, uname, pass);
          String query = "select * from customer where VehicleNo=?";
          PreparedStatement ps = co.prepareStatement(query);
          
          ps.setString(1, vnof.getText());
           rs = ps.executeQuery();
  
          if (rs.next()) {
        	 
            vidf.setText(rs.getString("VID"));
            Date da = new Date();
            da.setHours(da.getHours());
            cin.setText(da.toString());
            cin.setEnabled(false);
            rs.close();
            String par = "select parkingslot from parking";
            Statement stat = co.createStatement();
            ResultSet result = stat.executeQuery(par);
            int i = 0,j;
            while (result.next()) {
              String name = result.getString("ParkingSlot");
              int nme = Integer.parseInt(name);
              names[(i++)] = nme;
            }
            Integer[] b = new Integer[6];
            
            for ( j = 1; j <= 5; j++) {
              b[j] = park.useLoop(names, Integer.valueOf(j));
            }
            for ( j = 1; j <= 5; j++) {
              if (b[j].intValue() == 0) {
            	  String jj=j+"";
                slot.setText(jj);
              }
            }
            if (j == 5) {
              JOptionPane.showMessageDialog(null, "No space for parking");
            }
          }
          else
          {
            sl = 1;
            slot.setText(Integer.toString(sl));
          }
          rs.close();
          String s = "SELECT count(*) from parking";
          Statement ss = co.createStatement();
          ResultSet rrs = ss.executeQuery(s);
          if (rrs.next()) {
            rps = rrs.getInt("count(*)");
            remaning = (5 - rps - 1);
            if (remaning == 0) {
              JOptionPane.showMessageDialog(null, "Warning!This is the last ParkingSlot");
            }
            
            rslot.setText(Integer.toString(remaning));
          } else {
            JOptionPane.showMessageDialog(null, "Not Registered");
          }
        }
        catch (Exception e) {
          System.out.println(e);
        }
      }
    });
    btnNewButton.setBounds(293, 91, 116, 25);
    contentPane.add(btnNewButton);
    
    JLabel lblNewLabel_4 = new JLabel("Date");
    lblNewLabel_4.setForeground(Color.WHITE);
    lblNewLabel_4.setBounds(681, 44, 56, 16);
    contentPane.add(lblNewLabel_4);
    datee = new JTextField();
    datee.setBounds(747, 41, 116, 22);
    contentPane.add(datee);
    datee.setColumns(10);
    datee.setEditable(false);
    Calendar cal = new GregorianCalendar();
    int date = cal.get(5);
    int month = cal.get(2) + 1;
    int year = cal.get(1);
    sec = cal.get(13);
    hrs = cal.get(10);
    min = cal.get(12);
    datee.setText(date + "-" + month + "-" + year);
    Date s = new Date();
    s.setHours(s.getHours());
    
    vnof = new JTextField();
    vnof.setBounds(293, 56, 116, 22);
    contentPane.add(vnof);
    vnof.setColumns(10);
    
    lblNewLabel_6 = new JLabel("VehicleNO");
    lblNewLabel_6.setForeground(Color.WHITE);
    lblNewLabel_6.setFont(new Font("Tahoma", 0, 18));
    lblNewLabel_6.setBounds(187, 57, 85, 16);
    contentPane.add(lblNewLabel_6);
    
    JButton btnNewButton_1 = new JButton("CheckIN");
    btnNewButton_1.setBackground(Color.GRAY);
    btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Pavan\\Downloads\\car-repair-check (1).png"));
    btnNewButton_1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        try {
          if (remaning < 0)
          {
        	  
            JOptionPane.showMessageDialog(null, "no more space");
            dispose();
            Managemet.main(null);
          }
          else {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/sql?autoReconnet=true&useSSL=false";
            String uname = "root";
            String pass = "Pavanbn031998";
            Connection co = DriverManager.getConnection(url, uname, pass);
            String query = "insert into parking values(?,?,?,?)";
            PreparedStatement ps = co.prepareStatement(query);
            ps.setString(1, vidf.getText());
            ps.setString(2, cin.getText());
            ps.setString(3, slot.getText());
            ps.setString(4, rslot.getText());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Successfull checkin");
            dispose();
            Managemet.main(null);
          }
        }
        catch (Exception e) {
          JOptionPane.showMessageDialog(null, e);
        }
      }
    });
    btnNewButton_1.setBounds(293, 347, 116, 41);
    contentPane.add(btnNewButton_1);
    
    lblNewLabel_5 = new JLabel("New label");
    lblNewLabel_5.setIcon(new ImageIcon("D:\\software\\Car\\CarParking\\pics\\561cd1340faa7_thumb900.jpg"));
    lblNewLabel_5.setBounds(0, 0, 904, 514);
    contentPane.add(lblNewLabel_5);
  }
}