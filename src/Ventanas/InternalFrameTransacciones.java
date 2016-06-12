/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import dao.CategoriaDao;
import dao.CuentaDao;
import dao.TransaccionesDao;
import dto.Categoria;
import dto.Cuenta;
import dto.Transacciones;
import dto.TransaccionesListas;
import factory.FactoryDao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author usuario
 */
public class InternalFrameTransacciones extends javax.swing.JInternalFrame implements Runnable {

    private DefaultTableModel modelo;
    private DefaultComboBoxModel model;
    Calendar calendario;
    String hora, minutos, segundos, ampm;
    TransaccionesDao objDao;
    Thread h1;

    /**
     * Creates new form Transacciones
     */
    public InternalFrameTransacciones() {
        initComponents();
        CargarComboBoxCategoria();
        CargarComboBoxCuenta();
        setUpTableData();
        h1 = new Thread(this);
        h1.start();
        mostrarfecha();
        DefaultTabla();
        setUpTableData();
        jPanel2.setVisible(false);

    }

    public void DefaultTabla() {

        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false; //Con esto conseguimos que la tabla no se pueda editar
            }
        };

        jTableTranssaciomes = new JTable(modelo); //Metemos el modelo dentro de la tabla

        modelo.addColumn("id_transacciones"); //Añadimos las columnas a la tabla (tantas como queramos)
        modelo.addColumn("Categoria");
        modelo.addColumn("monto"); //Añadimos las columnas a la tabla (tantas como queramos)
        modelo.addColumn("fecha");
        modelo.addColumn("descripcion");
        modelo.addColumn("Cuenta");
        //Llamamos al método que rellena la tabla con los datos de la base de datos

        jScrollPane1.setViewportView(jTableTranssaciomes);//Esto añade la tabla al portView del scrollPane, si estaba puesto anteriormente
        //hay que borrarlo del otro sitio, sino puede dar error de NullPointerException
    }

    void rellenarTabla() {

        TransaccionesDao objDao = FactoryDao.getFactoryInstance().getNewTransaccionesDao();
        ArrayList<TransaccionesListas> id = objDao.getList();
        for (TransaccionesListas transaccionesListas : id) {
            Object[] fila = new Object[6];
            fila[0] = transaccionesListas.getIdTransacciones();
            fila[1] = transaccionesListas.getNombreCategoria();
            fila[2] = transaccionesListas.getMonto();
            fila[3] = transaccionesListas.getFecha();
            fila[4] = transaccionesListas.getDescripcion();
            fila[5] = transaccionesListas.getNombreCuenta();
            modelo.addRow(fila);
        }

    }

    /**
     * Métode per vaciar la un Jtable con modelo
     *
     */
    void vaciarTabla() {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    public void setUpTableData() {
        DefaultTableModel tableModel = (DefaultTableModel) jTableTranssaciomes.getModel();
        TransaccionesDao objDao = FactoryDao.getFactoryInstance().getNewTransaccionesDao();
        /**
         * additional code.
         *
         */
        tableModel.setRowCount(0);
        /**/
        ArrayList<TransaccionesListas> list = new ArrayList<TransaccionesListas>();
        list = objDao.getList();
        for (int i = 0; i < list.size(); i++) {
            Object[] data = new Object[6];

            data[0] = list.get(i).getIdTransacciones();
            data[1] = list.get(i).getNombreCategoria();
            data[2] = list.get(i).getMonto();
            data[3] = list.get(i).getFecha();
            data[4] = list.get(i).getDescripcion();
            data[5] = list.get(i).getNombreCuenta();

            tableModel.addRow(data);
        }
        jTableTranssaciomes.setModel(tableModel);
        /**
         * additional code.
         *
         */
        tableModel.fireTableDataChanged();
        /**/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaDescripcion = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxCuenta = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldMonto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxCategorias = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldHora = new javax.swing.JTextField();
        jTextFieldFecha = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTranssaciomes = new javax.swing.JTable();
        jButtonEliminar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();
        jButtonNuevo = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 153));
        setClosable(true);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextAreaDescripcion.setColumns(20);
        jTextAreaDescripcion.setRows(5);
        jScrollPane2.setViewportView(jTextAreaDescripcion);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 31, 290, 204));

        jLabel6.setText("Descripcion");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 11, -1, -1));

        jComboBoxCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCuentaActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBoxCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 31, 163, -1));

        jLabel5.setText("Cuenta");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 11, -1, -1));
        jPanel2.add(jTextFieldMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 77, 163, -1));

        jLabel1.setText("Monto");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 57, -1, -1));

        jLabel2.setText("Categorias");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 103, -1, -1));

        jPanel2.add(jComboBoxCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 123, 163, -1));

        jLabel3.setText("Fecha");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 149, -1, -1));

        jLabel4.setText("Hora");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 195, -1, -1));

        jTextFieldHora.setEditable(false);
        jPanel2.add(jTextFieldHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 215, 163, -1));
        jPanel2.add(jTextFieldFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 169, 163, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 0, 590, 250));

        jPanel3.setBackground(new java.awt.Color(102, 153, 255));

        jTableTranssaciomes.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTableTranssaciomes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableTranssaciomes);

        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jButtonEditar.setText("Editar");

        jButtonGuardar.setText("Guardar");
        jButtonGuardar.setEnabled(false);
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jButtonNuevo.setText("Nuevo");
        jButtonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButtonNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEliminar)
                        .addGap(137, 137, 137))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNuevo)
                    .addComponent(jButtonGuardar)
                    .addComponent(jButtonEditar)
                    .addComponent(jButtonEliminar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 560, 250));

        getContentPane().add(jPanel1, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed

        TransaccionesDao objDao = FactoryDao.getFactoryInstance().getNewTransaccionesDao();

        try {
            Transacciones trans = new Transacciones();
            Categoria categoria = (Categoria) jComboBoxCategorias.getSelectedItem();
            Cuenta cuenta = (Cuenta) jComboBoxCuenta.getSelectedItem();

            trans.setIdCategoria(categoria.getIdCategoria());
            trans.setMonto(Integer.parseInt(jTextFieldMonto.getText()));

            String fechaString = jTextFieldFecha.getText();

            trans.setFecha(fechaString);
            trans.setDescripcion(jTextAreaDescripcion.getText());
            trans.setIdCuenta(cuenta.getId_cuenta());
            objDao.insert(trans);
            setUpTableData();
        } catch (ParseException ex) {

            ex.printStackTrace();

        } catch (Exception ex) {
            Logger.getLogger(InternalFrameTransacciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        rellenarTabla();
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jComboBoxCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCuentaActionPerformed
        try {

            Cuenta value = (Cuenta) jComboBoxCuenta.getSelectedItem();
            System.out.println(value.getId_cuenta());
        } catch (Exception e) {
            System.out.println(e);

        }


    }//GEN-LAST:event_jComboBoxCuentaActionPerformed

    private void jButtonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevoActionPerformed
        String a = jButtonNuevo.getText();
        System.out.println(a);
        if (a.equalsIgnoreCase("Cancelar")) {
            jButtonGuardar.setEnabled(false);
            jPanel2.setVisible(false);
            jButtonNuevo.setText("Nuevo");

        } else {
            jButtonGuardar.setEnabled(true);
            jButtonNuevo.setText("Cancelar");
            jPanel2.setVisible(true);

        }

    }//GEN-LAST:event_jButtonNuevoActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTableTranssaciomes.getModel();
        TransaccionesDao transaccionFactory = FactoryDao.getFactoryInstance().getNewTransaccionesDao();
        CuentaDao DaocuentaFactory = FactoryDao.getFactoryInstance().getNewCuentaDao();
        Cuenta entidadCuenta = new Cuenta();
        int a = jTableTranssaciomes.getSelectedRow();

        if (a < 0) {

            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila de la tabla");

        } else {

            int confirmar = JOptionPane.showConfirmDialog(null, "Esta seguro que desea Eliminar el registro? ");

            //Sección 5 
            if (JOptionPane.OK_OPTION == confirmar) {

                Object id = jTableTranssaciomes.getValueAt(a, 0);
                Object Monto = jTableTranssaciomes.getValueAt(a, 2);
                transaccionFactory.delete((int) id);
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                setUpTableData();

            }

        }

    }//GEN-LAST:event_jButtonEliminarActionPerformed

    public void CargarComboBoxCuenta() {
        CuentaDao objDao = FactoryDao.getFactoryInstance().getNewCuentaDao();
        ArrayList<Cuenta> id = objDao.getList();

        for (int i = 0; i < id.size(); i++) {
            jComboBoxCuenta.addItem(id.get(i));

        }
    }

    public void CargarComboBoxCategoria() {
        CategoriaDao objDao = FactoryDao.getFactoryInstance().getNewCategoriasDao();
        ArrayList<Categoria> id = objDao.getList();
        for (int i = 0; i < id.size(); i++) {

            jComboBoxCategorias.addItem(id.get(i));
        }
    }

    public void mostrarfecha() {
        calendario = new GregorianCalendar();
        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        int mes = calendario.get(Calendar.MONTH);
        int año = calendario.get(Calendar.YEAR);
        jTextFieldFecha.setText(año + "-" + mes + "-" + dia);
    }

    public void calcula() {
        Calendar calendario = new GregorianCalendar();
        Date fechaHoraActual = new Date();

        calendario.setTime(fechaHoraActual);
        ampm = calendario.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";

        if (ampm.equals("PM")) {
            int h = calendario.get(Calendar.HOUR_OF_DAY) - 12;
            hora = h > 9 ? "" + h : "0" + h;
        } else {
            hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY) : "0" + calendario.get(Calendar.HOUR_OF_DAY);
        }
        minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" + calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND) : "0" + calendario.get(Calendar.SECOND);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonNuevo;
    private javax.swing.JComboBox<Categoria> jComboBoxCategorias;
    private javax.swing.JComboBox<Cuenta> jComboBoxCuenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableTranssaciomes;
    private javax.swing.JTextArea jTextAreaDescripcion;
    private javax.swing.JTextField jTextFieldFecha;
    private javax.swing.JTextField jTextFieldHora;
    private javax.swing.JTextField jTextFieldMonto;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        Thread ct = Thread.currentThread();
        while (ct == h1) {
            calcula();
            jTextFieldHora.setText(hora + ":" + minutos + ":" + segundos + " " + ampm);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}