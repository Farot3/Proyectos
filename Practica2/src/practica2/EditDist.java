package practica2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditDist extends JFrame implements ActionListener {
    private JTextField txtId, txtNuevaDistancia;
    private JButton btnConfirmar, btnCancelar;
    private Ventana ventanaPadre;

    public EditDist(Ventana ventanaPadre) {
        this.ventanaPadre = ventanaPadre;

        setTitle("Editar Distancia");
        setSize(400, 200);
        setLayout(null);

        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(20, 20, 50, 25);
        add(lblId);

        txtId = new JTextField();
        txtId.setBounds(80, 20, 150, 25);
        add(txtId);

        JLabel lblNuevaDistancia = new JLabel("Nueva Distancia:");
        lblNuevaDistancia.setBounds(20, 50, 150, 25);
        add(lblNuevaDistancia);

        txtNuevaDistancia = new JTextField();
        txtNuevaDistancia.setBounds(150, 50, 150, 25);
        add(txtNuevaDistancia);

        btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setBounds(50, 90, 100, 25);
        btnConfirmar.addActionListener(this);
        add(btnConfirmar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(160, 90, 100, 25);
        btnCancelar.addActionListener(this);
        add(btnCancelar);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnConfirmar) {
            int id = Integer.parseInt(txtId.getText());
            int nuevaDistancia = Integer.parseInt(txtNuevaDistancia.getText());
            // Actualizar la distancia en la tabla de rutas
            ventanaPadre.actualizarDistancia(id, nuevaDistancia);
            // Cerrar la ventana de edición de distancia
            dispose();
        } else if (e.getSource() == btnCancelar) {
            // Cerrar la ventana de edición de distancia sin hacer cambios
            dispose();
        }
    }
}
