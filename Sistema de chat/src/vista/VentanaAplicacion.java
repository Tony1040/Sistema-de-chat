package vista;

import control.ControlAplicacion;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class VentanaAplicacion extends JFrame
        implements Observer {

    public VentanaAplicacion(ControlAplicacion gestor) {
        super("Chat");
        gestorPrincipal = gestor;
        configurar();
    }

    private void configurar() {
        ajustarComponentes(getContentPane());

        setSize(new Dimension(400, 600));
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void ajustarComponentes(Container c) {
        c.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 6, 8, 6);

        JPanel panel = new JPanel();//la idea es en este panel poner el campo de los mensajes
        panel.setLayout(new FlowLayout());//para asi salga bien la forma
        panel.setSize(200, 200);
        //panel.add();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.gridheight = 1;
        gbc.weightx = 0.1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(new JScrollPane(
                campoMensajes = new JTextArea(),
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.1;
        add(new JScrollPane(
                campoMensaje = new JTextField(),
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), gbc);

        gbc.gridx = 2;
        gbc.weightx = 0;
        add(btnEnviar = new JButton("Enviar"), gbc);
    }

    public void init() {
        setVisible(true);
    }

    @Override
    public void update(Observable o, Object o1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private final ControlAplicacion gestorPrincipal;
    private JTextArea campoMensajes;
    private JTextField campoMensaje;
    private JButton btnEnviar;

}
