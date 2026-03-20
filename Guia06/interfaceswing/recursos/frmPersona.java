package interfaceswing.recursos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmPersona extends JFrame {
    private JPanel pnlPersona;
    private JTextField textIDE;
    private JTextField txtNombre;
    private JTextField txtEdad;
    private JTextField txtTelefono;
    private JComboBox cmbSexo;
    private JButton btnObtenerDatos;
    private JButton btnLimpiar;
    private JPanel pnlBotones;
    private JLabel txtID;
    private JLabel tdtNom;
    private JLabel txtEd;
    private JLabel txtTel;
    private JLabel txtSex;
    private JTable tblDatos;

    public frmPersona(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlPersona);
        this.setMinimumSize(new Dimension(600, 500));
        this.setLocationRelativeTo(getParent());
        btnObtenerDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnObtenerDatos();
                btnLimpiar();
            }
        });

        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnLimpiar();
            }
        });

        //Arreglo de objeto, para inicializar con vacio la tabla
        Object [][] data = null;
        //Arreglo de String para crear los nombres de las columnas
        String[] colums = {
                "Id", "Nombre", "Edad", "Telefono", "Sexo"
        };

        //Instancia del modelo
        modelo = new DefaultTableModel(data, colums);

        //seteo del modelo, el cual tendrá la estructura que permitirá
        // a la tabla representar los datos

        tblDatos.setModel(modelo);
        tblDatos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                tblObtenerFila(e);
            }
        });
    }

    private void btnObtenerDatos() {
        String id;
        String nombres;
        String edad;
        String telefono;
        String sexo;

        //Adquiere de controles del form a datos dados por usuario
        id = textIDE.getText();
        nombres = txtNombre.getText();
        edad = txtEdad.getText();
        telefono = txtTelefono.getText();
        sexo = cmbSexo.getSelectedItem().toString();

        JOptionPane.showMessageDialog(null, "Datos obtenidos: \n ID: " + id +
                "\n nombres: " + nombres + "\n Edad: " + edad +
                "\n Telefono: " + telefono + "\n Sexo: " + sexo);

        //Toma variables con datos recibidos del usuario
        //Y crea un vector genérico (tipo Object)
        Object[] newRow = {id, nombres, edad, telefono, sexo};
        //Agrega contenido del vector como una fila de tabla modelo
        modelo.addRow(newRow);
    }

    private void btnLimpiar() {
        //borra contenido actual de los controles del form
        textIDE.setText("");
        txtNombre.setText("");
        txtEdad.setText("");
        txtTelefono.setText("");
        // pone el combobox en su valor de índice 0
        cmbSexo.setSelectedIndex(0);
        txtID.requestFocus(); //Recibe el foco para que el cursor vuelva ahí
    }

    private DefaultTableModel modelo;

    private void tblObtenerFila(MouseEvent e) {
        //obtiene num. fila y columna de celda de tabla en
        //donde usuario hizo clic
        int fila = tblDatos.rowAtPoint(e.getPoint());
        int columna = tblDatos.columnAtPoint(e.getPoint());

        //traslada datos de fila hacia controles del form,
        //solo si la tabla ya tiene filas
        if ((fila > -1) && (columna > -1)) {
            textIDE.setText(modelo.getValueAt(fila, 0).toString());
            txtNombre.setText(modelo.getValueAt(columna, 1).toString());
            txtEdad.setText(modelo.getValueAt(columna, 2).toString());
            txtTelefono.setText(modelo.getValueAt(columna, 3).toString());
            cmbSexo.setSelectedItem(modelo.getValueAt(columna, 4).toString());
        }

    }

}

