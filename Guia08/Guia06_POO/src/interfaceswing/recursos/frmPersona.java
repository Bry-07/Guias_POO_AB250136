package interfaceswing.recursos;

import beans.PersonaBeans;
import datos.OcupacionesDatos;
import datos.PersonasDatos;

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
    private JTextField txtFechaNacimiento;
    private JLabel lbl1;
    private JComboBox cmbOcupacion;
    private JButton btnEliminar;
    private JLabel lbl2;

    PersonaBeans personabeans = null;
    PersonasDatos personadatos = new PersonasDatos();
    OcupacionesDatos ocupacionesDatos = new OcupacionesDatos();

    public frmPersona(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlPersona);
        this.setMinimumSize(new Dimension(750, 600));
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

        /*//Arreglo de objeto, para inicializar con vacio la tabla
        Object [][] data = null;
        //Arreglo de String para crear los nombres de las columnas
        String[] colums = {
                "Id", "Nombre", "Edad", "Telefono", "Sexo"
        };

        //Instancia del modelo
        modelo = new DefaultTableModel(data, colums);

        //seteo del modelo, el cual tendrá la estructura que permitirá
        // a la tabla representar los datos

        tblDatos.setModel(modelo);*/

        modelo = personadatos.selectPersona();
        tblDatos.setModel((modelo));
        cmbOcupacion.setModel(ocupacionesDatos.selectOcupaciones());

        tblDatos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                tblObtenerFila(e);
            }
        });

        btnEliminar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                EliminarDatos();
            }
        });
    }

    private void btnObtenerDatos() {
        int id = 0;
        String nombres = txtNombre.getText();
        String telefono = txtTelefono.getText();
        String sexo = cmbSexo.getSelectedItem().toString();
        int idOcupacion = ocupacionesDatos.getIdOcupacion(cmbOcupacion.getSelectedItem().toString());
        String fechaNacimiento = txtFechaNacimiento.getText();
        int edad;

        try {
            // Validamos la edad (obligatoria siempre)
            edad = Integer.parseInt(txtEdad.getText());

            if (btnObtenerDatos.getText().equals("Guardar")) {
                // Para guardar no necesitamos ID, mandamos 0 (la BD lo ignora y crea el siguiente)
                personabeans = new PersonaBeans(0, nombres, edad, telefono, sexo, idOcupacion, fechaNacimiento);
                personadatos.insert(personabeans);
                JOptionPane.showMessageDialog(this, "Registro guardado correctamente");
            }
            else if (btnObtenerDatos.getText().equals("Editar")) {
                // Para editar SÍ necesitamos el ID que está en el cuadro de texto
                id = Integer.parseInt(textIDE.getText());
                personabeans = new PersonaBeans(id, nombres, edad, telefono, sexo, idOcupacion, fechaNacimiento);
                personadatos.update(personabeans);
                JOptionPane.showMessageDialog(this, "Registro actualizado correctamente");
            }

            // Refrescar tabla
            modelo = personadatos.selectPersona();
            tblDatos.setModel(modelo);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: La edad debe ser un número. Si está editando, asegúrese de que el ID sea válido.");
        }
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

        cmbOcupacion.setSelectedIndex(0);
        txtFechaNacimiento.setText("");
        btnObtenerDatos.setText("Guardar");

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
            txtNombre.setText(modelo.getValueAt(fila, 1).toString());
            txtEdad.setText(modelo.getValueAt(fila, 2).toString());
            txtTelefono.setText(modelo.getValueAt(fila, 3).toString());
            cmbSexo.setSelectedItem(modelo.getValueAt(fila, 4).toString());

            cmbOcupacion.setSelectedItem(modelo.getValueAt(fila, 5).toString());
            txtFechaNacimiento.setText(modelo.getValueAt(fila, 6).toString());
            btnObtenerDatos.setText("Editar");

        }

    }

    public void EliminarDatos() {
        personadatos.delete(Integer.parseInt(textIDE.getText()));
        btnLimpiar();
        modelo = personadatos.selectPersona();
        tblDatos.setModel(modelo);
    }

}

