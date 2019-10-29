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
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.jdbc.CallableStatement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class Managemet
  extends JFrame
{
  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
       Managemet frame = new Managemet();
          
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
  


  public Managemet()
  {
    setTitle("management");
  // this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    setDefaultCloseOperation(3);
    setBounds(100, 100, 916, 740);
    contentPane = new JPanel();
    contentPane.setBackground(Color.BLACK);
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    JButton staff = new JButton("Regester NewStaff");
    staff.setIcon(new ImageIcon("C:\\Users\\Pavan\\Downloads\\user.png"));
    staff.setFont(new Font("Tahoma", 1, 16));
    staff.setBackground(Color.GRAY);
   // staff.setIcon(new ImageIcon("C:\\Users\\Pavan BN\\eclipse-workspace\\CarParkingManagement\\icons8-add-user-male-filled-50.png"));
    staff.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        
       Registor r = new Registor();
        r.setVisible(true);
      }
    });
    staff.setBounds(88, 68, 246, 54);
    contentPane.add(staff);
    
    JButton car = new JButton("ParkingManagement");
    car.setIcon(new ImageIcon("C:\\Users\\Pavan\\Downloads\\parking.png"));
    car.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        parking pk = new parking();
       
        pk.setVisible(true);
        
      }
    });
    car.setFont(new Font("Tahoma", 1, 16));
    car.setBackground(Color.GRAY);
    car.setBounds(505, 68, 280, 54);
    contentPane.add(car);
    
    JButton btnLogout = new JButton("LogOut");
    btnLogout.setIcon(new ImageIcon("C:\\Users\\Pavan\\Downloads\\exit.png"));
    btnLogout.setFont(new Font("Tahoma", 1, 16));
    btnLogout.setBackground(Color.GRAY);
    btnLogout.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        
        Login.main(null);
      }
    });
    btnLogout.setBounds(347, 519, 138, 38);
    contentPane.add(btnLogout);
    
    JButton btnNewButton = new JButton("CheckOut");
    btnNewButton.setIcon(new ImageIcon("C:\\Users\\Pavan\\Downloads\\cashier.png"));
    btnNewButton.setBackground(Color.GRAY);
    btnNewButton.setFont(new Font("Tahoma", 1, 18));
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
       checkout co = new checkout();
        
       co.setVisible(true);
      }
    });
    btnNewButton.setBounds(88, 192, 246, 54);
    contentPane.add(btnNewButton);
    
    JButton btnNewButton_1 = new JButton("CheckOut List");
    btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Pavan\\Downloads\\shopping-list.png"));
    btnNewButton_1.setBackground(Color.GRAY);
    btnNewButton_1.setForeground(Color.BLACK);
    btnNewButton_1.setFont(new Font("Tahoma", 1, 18));
    btnNewButton_1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        checkoutlist cc = new checkoutlist();
        
      cc.setVisible(true);
      }
    });
    btnNewButton_1.setBounds(504, 192, 281, 54);
    contentPane.add(btnNewButton_1);
    
    JButton btnNewButton_2 = new JButton("CustomerList");
    btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\Pavan\\Downloads\\shopping-list.png"));
    btnNewButton_2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        list l = new list();
        
        l.setVisible(true);
      }
    });
    btnNewButton_2.setBackground(Color.GRAY);
    btnNewButton_2.setFont(new Font("Tahoma", 1, 18));
    btnNewButton_2.setBounds(96, 332, 238, 49);
    contentPane.add(btnNewButton_2);
    
    JButton btnNewButton_3 = new JButton("Parkinglist");
    btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\Pavan\\Downloads\\car.png"));
    btnNewButton_3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
       parkinglist plist = new parkinglist();
       
        plist.setVisible(true);
      }
    });
    btnNewButton_3.setBackground(Color.GRAY);
    btnNewButton_3.setFont(new Font("Tahoma", 1, 18));
    btnNewButton_3.setBounds(505, 332, 280, 49);
    contentPane.add(btnNewButton_3);
    
    JButton btnNewButton_4 = new JButton("Total Amount");
    btnNewButton_4.setBackground(Color.GRAY);
    btnNewButton_4.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		 try {
    	            Class.forName("com.mysql.cj.jdbc.Driver");
    	            String url = "jdbc:mysql://localhost:3306/sql?autoReconnet=true&useSSL=false";
    	            String uname = "root";
    	            String pass = "Pavanbn031998";
    	            Connection co = DriverManager.getConnection(url, uname, pass);
    	            CallableStatement cstm =(CallableStatement) co.prepareCall("{call proc()}");
    	            ResultSet rs=cstm.executeQuery();
    	            rs.next();
    	            String tot=rs.getString(1);
    	            JOptionPane.showMessageDialog(null, "Total amount collected by parking is:"+tot);
    	            rs.close();
    	            cstm.close();
    	            co.close();
    	       
    	          }
    	          catch (Exception e)
    	          {
    	            JOptionPane.showMessageDialog(null, e);
    	          }
    	}
    });
    btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\Pavan\\Downloads\\cashier.png"));
    btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 18));
    btnNewButton_4.setBounds(96, 448, 238, 38);
    contentPane.add(btnNewButton_4);
  }
}
