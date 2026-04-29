	import java.awt.EventQueue;
	import javax.swing.*;
	import javax.swing.border.EmptyBorder;
	import net.miginfocom.swing.MigLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	public class Academia extends JFrame {

	    private JPanel contentPane;
	    private JTextField txtNome;
	    private JTextField txtTelefone;
	    private JLabel lblResultado;

	    private JRadioButton tipoBasico, tipoIntermediario, tipoPremium;
	    private JRadioButton duraMensal, duraSemestral, duraAnual;
	    private JRadioButton freq2, freq3, freq5;

	    private ButtonGroup grupoPlano = new ButtonGroup();
	    private ButtonGroup grupoDuracao = new ButtonGroup();
	    private ButtonGroup grupoFreq = new ButtonGroup();

	    public static void main(String[] args) {
	        EventQueue.invokeLater(() -> {
	            try {
	            	Academia frame = new Academia();
	                frame.setVisible(true);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        });
	    }

	    public Academia() {
	        setTitle("Plano de Academia");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 600, 280);

	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
	        setContentPane(contentPane);

	        contentPane.setLayout(new MigLayout(
	                "",
	                "[right][grow][grow][grow]",
	                "[][][][][][][]"
	        ));

	     
	        JLabel titulo = new JLabel("Cadastro de Cliente - Academia TREINO FIT");
	        titulo.setHorizontalAlignment(SwingConstants.CENTER);
	        contentPane.add(titulo, "span, align center, wrap");

	     
	        contentPane.add(new JLabel("Nome"), "cell 0 1");
	        txtNome = new JTextField();
	        contentPane.add(txtNome, "cell 1 1 3 1, growx, wrap");

	      
	        contentPane.add(new JLabel("Telefone"), "cell 0 2");
	        txtTelefone = new JTextField();
	        contentPane.add(txtTelefone, "cell 1 2 3 1, growx, wrap");

	       
	        contentPane.add(new JLabel("Tipo de Plano:"), "cell 0 3");

	        tipoBasico = new JRadioButton("Básico");
	        tipoIntermediario = new JRadioButton("Intermediário");
	        tipoPremium = new JRadioButton("Premium");

	        grupoPlano.add(tipoBasico);
	        grupoPlano.add(tipoIntermediario);
	        grupoPlano.add(tipoPremium);

	        contentPane.add(tipoBasico, "cell 1 3");
	        contentPane.add(tipoIntermediario, "cell 2 3");
	        contentPane.add(tipoPremium, "cell 3 3, wrap");

	     
	        contentPane.add(new JLabel("Duração:"), "cell 0 4");

	        duraMensal = new JRadioButton("Mensal");
	        duraSemestral = new JRadioButton("Semestral");
	        duraAnual = new JRadioButton("Anual");

	        grupoDuracao.add(duraMensal);
	        grupoDuracao.add(duraSemestral);
	        grupoDuracao.add(duraAnual);

	        contentPane.add(duraMensal, "cell 1 4");
	        contentPane.add(duraSemestral, "cell 2 4");
	        contentPane.add(duraAnual, "cell 3 4, wrap");

	      
	        contentPane.add(new JLabel("Frequência semanal:"), "cell 0 5");

	        freq2 = new JRadioButton("2x por semana");
	        freq3 = new JRadioButton("3x por semana");
	        freq5 = new JRadioButton("5x por semana");

	        grupoFreq.add(freq2);
	        grupoFreq.add(freq3);
	        grupoFreq.add(freq5);

	        contentPane.add(freq2, "cell 1 5");
	        contentPane.add(freq3, "cell 2 5");
	        contentPane.add(freq5, "cell 3 5, wrap");

	       
	        JButton btnCalcular = new JButton("Calcular");
	        contentPane.add(btnCalcular, "cell 1 6, align right");

	        contentPane.add(new JLabel("Valor final:"), "cell 2 6,alignx center");
	        lblResultado = new JLabel("");
	        contentPane.add(lblResultado, "cell 3 6");

	       
	        btnCalcular.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {

	                double valor = 0;
	               if(tipoBasico.isSelected()) valor = 80;
	               else if(tipoIntermediario.isSelected()) valor = 120;
	               else if (tipoPremium.isSelected()) valor = 180;
	               
	               if(duraSemestral.isSelected()) valor = valor * 0.9;
	               else if(duraAnual.isSelected()) valor = valor * 0.8;

	               if(freq3.isSelected()) valor = valor * 1.2;
	               else if(freq5.isSelected()) valor = valor * 1.5;
	               

	                lblResultado.setText("R$ " + String.format("%.2f / Mês", valor ));
	            }
	        });
	    }
	}