import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import java.awt.Color;



public class checkoutlist
  extends JFrame
{
  private static final long serialVersionUID = 1L;
  private JTable table;
  
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          checkoutlist frame = new checkoutlist();
        //  frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
  


  public checkoutlist()
  {
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    setBounds(100, 100, 792, 558);
    getContentPane().setLayout(null);
    
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(0, 0, 774, 457);
    getContentPane().add(scrollPane);
    
    table = new JTable();
    scrollPane.setViewportView(table);
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      String url = "jdbc:mysql://localhost:3306/sql?autoReconnet=true&useSSL=false";
      String uname = "root";
      String pass = "Pavanbn031998";
      Connection co = DriverManager.getConnection(url, uname, pass);
      String query = "Select * from amount";
      Statement sp = co.createStatement();
      ResultSet rs = sp.executeQuery(query);
      table.setModel(DbUtils.resultSetToTableModel(rs));
      
      JButton btnClose = new JButton("Close");
      btnClose.setBackground(Color.GRAY);
      btnClose.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
          dispose();
          //Managemet.main(null);
        }
      });
      btnClose.setBounds(0, 456, 762, 42);
      getContentPane().add(btnClose);

    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog(null, e);
    }
  }
}