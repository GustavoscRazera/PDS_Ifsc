import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.management.StringValueExp;
import javax.swing.ButtonGroup;

public class Calc extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtValor1;
	private JTextField txtValor2;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calc frame = new Calc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Calc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][grow][][][grow]", "[][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Valor 1:");
		contentPane.add(lblNewLabel, "cell 1 0");
		
		txtValor1 = new JTextField();
		contentPane.add(txtValor1, "cell 3 0,growx");
		txtValor1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Valor 2:");
		contentPane.add(lblNewLabel_1, "cell 1 1");
		
		txtValor2 = new JTextField();
		contentPane.add(txtValor2, "cell 3 1,growx");
		txtValor2.setColumns(10);
		
		JRadioButton radioSoma = new JRadioButton("Somar");
		buttonGroup.add(radioSoma);
		contentPane.add(radioSoma, "cell 3 2");
		
		JRadioButton radioSubtrair = new JRadioButton("Subtrair");
		buttonGroup.add(radioSubtrair);
		contentPane.add(radioSubtrair, "cell 3 3");
		
		JLabel lblResultado = new JLabel("");
		contentPane.add(lblResultado, "cell 4 5");
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int valor1 = Integer.parseInt(txtValor1.getText());
				int valor2 = Integer.parseInt(txtValor2.getText());
				if (radioSoma.isSelected() ) {
					String resultado = String.valueOf(valor1 + valor2);
					lblResultado.setText(resultado);
				}
				else if(radioSubtrair.isSelected()) {
					String resultado = String.valueOf(valor1 - valor2);
					lblResultado.setText(resultado);
					
				}
			}
		});
		contentPane.add(btnCalcular, "cell 3 5");

	}

}
