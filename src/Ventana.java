import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JTabbedPane tabbedPane1;
    private JTextField txtCodigo;
    private JTextField textField2;
    private JLabel txtTitulo;
    private JTextField txtAutor;
    private JComboBox cboCategoria;
    private JSpinner spiAnio;
    private JButton btnAgregar;
    private Lista biblioteca = new Lista();

    public Ventana() {
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int codigo= 0;
                String titulo= null;
                String autor= null;
                String cat= null;
                int anio= 0;
                try {
                    codigo = Integer.parseInt(txtCodigo.getText());
                    titulo = txtTitulo.getText();
                    autor = txtAutor.getText();
                    cat = cboCategoria.getSelectedItem().toString();
                    anio = Integer.parseInt(spiAnio.getValue().toString());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null,"Datos inválidos");
                }
                Libro l1=new Libro(codigo, titulo, autor, cat, anio);

                try {
                    biblioteca.agregarDatos(l1);
                    JOptionPane.showMessageDialog(null,"Se agrego un libro");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }
}
