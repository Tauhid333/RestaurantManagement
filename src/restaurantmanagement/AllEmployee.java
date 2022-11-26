
package restaurantmanagement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


  




public class AllEmployee extends javax.swing.JFrame {

    
      public AllEmployee() {
        initComponents();
        show_emp();
    }
      public ArrayList<Employee> employeeList(){
        ArrayList<Employee>employeeList =new ArrayList<>();
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=ProjectDB;selectMethod=cursor", "sa", "123456");
        
            String query1= "SELECT EmployeeId,Employee_Name,Employee_Address,Employee_Phone,Salary FROM EMPLOYEE";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query1);
            Employee emp;
            while(rs.next())
            {
                emp = new Employee(rs.getInt("EmployeeId"),rs.getString("Employee_Name"),rs.getString("Employee_Address"),rs.getString("Employee_Phone"),rs.getFloat("Salary"));
                employeeList.add(emp);
            }
        
        
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        return employeeList;
    }
        
  
          
            public void show_emp()
    {
        ArrayList<Employee> list = employeeList();
        DefaultTableModel model = (DefaultTableModel)jTable_Display_emp.getModel();
        Object[] row = new Object[5];
        for(int i=0;i<list.size();i++)
        {
            row[0]=list.get(i).getEmployeeId();
            row[1]=list.get(i).getEmployee_Name();
            row[2]=list.get(i).getEmployee_Address();
            row[3]=list.get(i).getEmployee_Phone();
            row[4]=list.get(i).getSalary();
            model.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Display_emp = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable_Display_emp.setBackground(new java.awt.Color(131, 193, 233));
        jTable_Display_emp.setForeground(new java.awt.Color(160, 120, 200));
        jTable_Display_emp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Emp_Name", "Emp_Address", "Emp_Phone", "Salary"
            }
        ));
        jScrollPane2.setViewportView(jTable_Display_emp);

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Show");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1129, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        
        

    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
 
      java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AllEmployee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_Display_emp;
    // End of variables declaration//GEN-END:variables
}
