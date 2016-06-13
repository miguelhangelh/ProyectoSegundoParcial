/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import static Ventanas.InternalFrameTransacciones.log;
import dao.CategoriaDao;
import dao.TransaccionesDao;
import dto.Categoria;
import dto.TransaccionesListas;
import factory.FactoryDao;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

/**
 *
 * @author usuario
 */
public class InterfalFrameCategorias extends javax.swing.JInternalFrame {

    static Logger log = Logger.getLogger(VentanaPrincipal.class.getName());
    private DefaultTableModel modelo;

    public InterfalFrameCategorias() {
        initComponents();
        DefaultTabla();
        rellenarTabla();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxTipo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));

        jLabel1.setText("Nombre");

        jLabel2.setText("Tipo");

        jComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gastos" }));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jTextFieldNombre)
                            .addComponent(jComboBoxTipo, 0, 102, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void DefaultTabla() {
        log.debug("Iniciando la configuracion de las tablas");
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false; //Con esto conseguimos que la tabla no se pueda editar
            }
        };

        jTable1 = new JTable(modelo); //Metemos el modelo dentro de la tabla

        modelo.addColumn("id_categoria");
        modelo.addColumn("Nombre");
        modelo.addColumn("Tipo");

        //Llamamos al método que rellena la tabla con los datos de la base de datos
        jScrollPane1.setViewportView(jTable1);//Esto añade la tabla al portView del scrollPane, si estaba puesto anteriormente
        //hay que borrarlo del otro sitio, sino puede dar error de NullPointerException
    }

    void rellenarTabla() {
        log.debug("Rellenando Datos de la tabla");

        CategoriaDao objDao = FactoryDao.getFactoryInstance().getNewCategoriasDao();

        ArrayList<Categoria> id = objDao.getList();
        for (Categoria categoria : id) {
            Object[] fila = new Object[3];

            fila[0] = categoria.getIdCategoria();
            fila[1] = categoria.getNombreCategoria();
            fila[2] = categoria.getTipoCategoria();
            modelo.addRow(fila);
        }
        jTable1.updateUI();
    }

    public void ActualizarTabla() {
        log.debug("Actualizacion de datos de la tabla");
        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
        CategoriaDao objDao = FactoryDao.getFactoryInstance().getNewCategoriasDao();
        /**
         * additional code.
         *
         */
        tableModel.setRowCount(0);
        /**/
        ArrayList<Categoria> list = new ArrayList<Categoria>();
        list = objDao.getList();
        for (int i = 0; i < list.size(); i++) {
            Object[] fila = new Object[3];

            fila[0] = list.get(i).getIdCategoria();
            fila[1] = list.get(i).getNombreCategoria();
            fila[2] = list.get(i).getTipoCategoria();
            ;

            tableModel.addRow(fila);
        }
        jTable1.setModel(tableModel);
        /**
         * additional code.
         *
         */
        tableModel.fireTableDataChanged();
        /**/
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            InternalFrameTransacciones a = new InternalFrameTransacciones();
            CategoriaDao objDao = FactoryDao.getFactoryInstance().getNewCategoriasDao();
            Categoria entidadCategoria = new Categoria();
            String value = (String) jComboBoxTipo.getSelectedItem();
            entidadCategoria.setNombreCategoria(jTextFieldNombre.getText());
            entidadCategoria.setTipoCategoria(value);
            objDao.insert(entidadCategoria);
            ActualizarTabla();
            a.CargarComboBoxCategoria();
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        CategoriaDao objDao = FactoryDao.getFactoryInstance().getNewCategoriasDao();
        int a = jTable1.getSelectedRow();

        if (a < 0) {
            log.debug("No se seleccion ningun dato de la tablas");
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila de la tabla");

        } else {

            int confirmar = JOptionPane.showConfirmDialog(null, "Esta seguro que desea Eliminar el registro? ");

            //Sección 5 
            if (JOptionPane.OK_OPTION == confirmar) {

                try {
                    Object id = jTable1.getValueAt(a, 0);

                    objDao.delete((int) id);
                    ActualizarTabla();

                    JOptionPane.showMessageDialog(null, "Registro Eliminado");
                    log.debug("Se Se elimino  Correctamente");

                } catch (Exception ex) {
                    log.error("Error al momento de elimino por cualquier tipo de error" + ex);
                }

            }

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    public void OcultarColumnas() {
        //Ocultar Id Transacciones
        log.debug("Ocultando Colummas de las llaves primeria y foraneas de la tabla");
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBoxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables
}
