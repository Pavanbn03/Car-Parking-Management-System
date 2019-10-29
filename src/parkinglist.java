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
import javax.swing.ImageIcon;
import java.awt.Color;
public class parkinglist
  extends JFrame
{
  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private JTable table;
  
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          parkinglist frame = new parkinglist();
          frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
  public parkinglist()
  {
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    setBounds(100, 100, 890, 477);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(12, 13, 848, 383);
    contentPane.add(scrollPane);
    
    table = new JTable();
    scrollPane.setViewportView(table);
    
    JButton btnNewButton = new JButton("Close");
    btnNewButton.setBackground(Color.GRAY);
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dispose();
       // Managemet.main(null);
      }
    });
    btnNewButton.setFont(new Font("Tahoma", 1, 18));
    btnNewButton.setBounds(12, 405, 848, 25);
    contentPane.add(btnNewButton);
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      String url = "jdbc:mysql://localhost:3306/sql?autoReconnet=true&useSSL=false";
      String uname = "root";
      String pass = "Pavanbn031998";
      Connection co = DriverManager.getConnection(url, uname, pass);
      String query = "select * from parking";
      Statement sp = co.createStatement();
      ResultSet rs = sp.executeQuery(query);
      table.setModel(DbUtils.resultSetToTableModel(rs));
    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog(null, e);
    }
  }
}