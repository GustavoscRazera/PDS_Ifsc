package Calcular;




import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Sobre1 extends ClaculadoraInvestimentosGrid {



	
	public void MostrarSobre() {
		JOptionPane.showMessageDialog(null,
				"Calculadora de Investimentos\n\n" +
				"Versão 1.0\n\n" +
				"Calcula o total investido com juros compostos.\n" +
				"Desenvolvido por Gustavo",
				"Sobre",
				JOptionPane.INFORMATION_MESSAGE);
	}

}
