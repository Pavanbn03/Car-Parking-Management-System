import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import java.awt.Color;








public class list
  extends JFrame
{
  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private JTable table;
  private JButton btnNewButton;
  
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          list frame = new list();
          frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
  


  public list()
  {
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    setBounds(100, 100, 878, 431);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(0, 13, 860, 338);
    contentPane.add(scrollPane);
    
    table = new JTable();
    scrollPane.setViewportView(table);
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      String url = "jdbc:mysql://localhost:3306/sql?autoReconnet=true&useSSL=false";
      String uname = "root";
      String pass = "Pavanbn031998";
      Connection co = DriverManager.getConnection(url, uname, pass);
      String query = "Select * from customer";
      Statement sp = co.createStatement();
      ResultSet rs = sp.executeQuery(query);
      table.setModel(DbUtils.resultSetToTableModel(rs));
      
      btnNewButton = new JButton("Close");
      btnNewButton.setBackground(Color.GRAY);
      btnNewButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          dispose();
          //Managemet.main(null);
        }
      });
      btnNewButton.setFont(new Font("Tahoma", 0, 16));
      btnNewButton.setBounds(0, 350, 860, 34);
      contentPane.add(btnNewButton);
    }
    catch (Exception e) {
      JOptionPane.showMessageDialog(null, e);
    }
  }
}