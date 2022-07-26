
package Vistas;

import Modelo.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

public class UserMenu extends javax.swing.JFrame {
    //Crear una instancia de la clase "Conexion"
    Conexion conexion = new Conexion();
    //Crear una instacia de la clase connection que trae el JAR
    Connection connection;
    Statement st; // es la ejecucion de los QUERY
    ResultSet rs; // el que nos va a traer el resultado de la conexion 
    DefaultTableModel contenidoTablaEmpleados;
    //constructor        
    public UserMenu() {
        initComponents();
        this.setLocationRelativeTo(null);
        listarEmpleados(); //llamamos el metodo de listar empleados para cargar la informacion
        
    }
    //crear los metodos de listar y traer todos los empleados en la base de datos  y borrar registros tablas 
    private void listarEmpleados(){
        String filtroBusqueda = txtSearch.getText();
        //Si no hay nada en el campo de busqueda se cargaran todos los empleados
        if (filtroBusqueda.isEmpty()){
            String query = "SELECT * FROM empleados";
        //Intentar conexion con la tabla y ver que tipo de respuesta me da 
        try {
            connection = conexion.getConnection();
            //Creamos la consulta QUERY para la base de datos
            st = connection.createStatement();
            rs = st.executeQuery(query);// Ya estamos ejecutando esa consulta 
            //Asignar a un objeto los datos que devuelve de cada registro
            Object [] empleado = new Object [6]; //El 5 es el tamaño de claves que recibe, 
                                                  // los datos de la tabla UserMenu de columnas 
            contenidoTablaEmpleados = (DefaultTableModel)tblEmpleados.getModel();
            // el resultado de la consulta del QUERY nos determinara la cantidad 
            // de empleados que existe se ingresa al WHILE.
            while (rs.next()){//Next explica que q va a ver otros resultados de la consulta (REGISTROS)
                //se realiza la captura de cada dato.
                empleado[0] = rs.getInt("idEmp");
                empleado[1] = rs.getString("nombreEmp");
                empleado[2] = rs.getString("apellidos");
                empleado[3] = rs.getString("tipoDocumento");
                empleado[4] = rs.getString("documento");
                empleado[5] = rs.getString("correo");
                //en la tabla creamos una nueva fila con los 5 atributos del objeto "empleado"
                contenidoTablaEmpleados.addRow(empleado);
                tblEmpleados.setModel(contenidoTablaEmpleados);
                System.out.println("idEmp: " +  empleado[0] + ", nombre: " +  empleado[1] +" "
                           + ", documento: " +  empleado[2] + " " +  empleado[3]
                           + ", correo: " +  empleado[4]);
            }
        }catch (SQLException e){
            System.out.println("No se pudo cargar informacion de los empleados");
        }
    }else {
            String query = "SELECT * FROM `empleados` WHERE nombreEmp like `%"+filtroBusqueda+"%` OR apellidos like `%"+filtroBusqueda+"%`;";
            //Intentar conexion con la tabla y ver que tipo de respuesta me da 
        try {
            connection = conexion.getConnection();
            //Creamos la consulta QUERY para la base de datos
            st = connection.createStatement();
            rs = st.executeQuery(query);// Ya estamos ejecutando esa consulta 
            //Asignar a un objeto los datos que devuelve de cada registro
            Object [] empleado = new Object [6]; //El 5 es el tamaño de claves que recibe, 
                                                  // los datos de la tabla UserMenu de columnas 
            contenidoTablaEmpleados = (DefaultTableModel)tblEmpleados.getModel();
            // el resultado de la consulta del QUERY nos determinara la cantidad 
            // de empleados que existe se ingresa al WHILE.
            while (rs.next()){//Next explica que q va a ver otros resultados de la consulta (REGISTROS)
                //se realiza la captura de cada dato.
                empleado[0] = rs.getInt("idEmp");
                empleado[1] = rs.getString("nombreEmp");
                empleado[2] = rs.getString("apellidos");
                empleado[3] = rs.getString("tipoDocumento");
                empleado[4] = rs.getString("documento");
                empleado[5] = rs.getString("correo");
                //en la tabla creamos una nueva fila con los 5 atributos del objeto "empleado"
                contenidoTablaEmpleados.addRow(empleado);
                tblEmpleados.setModel(contenidoTablaEmpleados);
                System.out.println("idEmp: " +  empleado[0] + ", nombre: " +  empleado[1] +" "
                           + ", documento: " +  empleado[2] + " " +  empleado[3]
                           + ", correo: " +  empleado[4]);
            }
        }catch (SQLException e){
            System.out.println("No se pudo cargar informacion de los empleados");
        }
    }
}
        
    
    private void borrarRegistrosTabla(){
        //El getRowCount devuelve la cantidad de filas qu tiene la tabla, en este caso a eliminar
        for (int i = 0; i < tblEmpleados.getRowCount(); i++) {
            contenidoTablaEmpleados.removeRow(i);
            //Cada vez que se elimina una fila deben quedar menos filas por eliminar
            i = i - 1;
        }
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        btnAddUser = new javax.swing.JButton();
        btnShow = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/logo (3).png"))); // NOI18N

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "IdEmp", "Nombre", "Apellido (s)", "Tipo Documento", "Documento", "Correo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmpleados);

        btnAddUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/avatar (3).png"))); // NOI18N
        btnAddUser.setText("Añadir");
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });

        btnShow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/showUser.png"))); // NOI18N
        btnShow.setText("Consultar");
        btnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/editUser (1).png"))); // NOI18N
        btnEdit.setText("Editar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/deleteUser (1).png"))); // NOI18N
        btnRemove.setText("Eliminar");

        jLabel2.setText("Empleados");

        jLabel3.setText("Mision TIC 2022");

        jLabel4.setText("Nombre:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/showUser.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(169, 169, 169))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(154, 154, 154)))
                        .addComponent(btnAddUser))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(btnShow)
                                .addGap(34, 34, 34)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(btnRemove))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 41, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3))
                            .addComponent(btnAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnShow)
                    .addComponent(btnEdit)
                    .addComponent(btnRemove))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Empleados", jPanel1);
        jTabbedPane1.addTab("tab2", jTabbedPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnShowActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed
        AddUserForm addUserForm = new AddUserForm(this, true);
        addUserForm.setVisible(true);
        //llamar el metodo de listar empleados y borrar para actualizar los datos.
        borrarRegistrosTabla();
        listarEmpleados();
    }//GEN-LAST:event_btnAddUserActionPerformed

    private void tblEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleadosMouseClicked
        int filaSeleccionada = tblEmpleados.getSelectedRow(); //nos devuleve el numero de la fila seleccionada 
        System.out.println("Fila seleccionada: " + filaSeleccionada);
        //se convierte el texto que se captura de la tabla en entero 
        int idEmp = Integer.parseInt(tblEmpleados.getValueAt(filaSeleccionada,0).toString());
        String nombreEmp = tblEmpleados.getValueAt(filaSeleccionada,1).toString();
        String apellidos = tblEmpleados.getValueAt(filaSeleccionada,2).toString();
        String tipoDocumento = tblEmpleados.getValueAt(filaSeleccionada,3).toString();
        String documento = tblEmpleados.getValueAt(filaSeleccionada,4).toString();
        String correo = tblEmpleados.getValueAt(filaSeleccionada,5).toString();
        String empleadoSeleccionado = "{\n      idEmp: " + idEmp + ",\n     nombre: " + nombreEmp + " "
                + apellidos + ",\n      documento: " + tipoDocumento + " " + documento + ",\n       correo: " 
                + correo + "\n}";
        System.out.println(empleadoSeleccionado);
        
        ShowUserForm showUserForm = new ShowUserForm(this,true);
        showUserForm.recibirDatosDeUserMenu(idEmp, nombreEmp, apellidos, tipoDocumento, documento, correo);
        showUserForm.setVisible(true);
    }//GEN-LAST:event_tblEmpleadosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        borrarRegistrosTabla();
        listarEmpleados();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnShow;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable tblEmpleados;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
