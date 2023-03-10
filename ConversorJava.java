import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ConversorJava extends JFrame {
	/**
	 * 
	 */

    public static void main(String[] args) {

        Object[] tiposconv = {"Monedas", "Medidas"};
        boolean salir = false;
        do {
            Object tselect = JOptionPane.showInputDialog(null, "Seleccione tipo de conversión", "Menu", JOptionPane.QUESTION_MESSAGE, null, tiposconv, tiposconv[0]);

            if (tselect == null) {
                JOptionPane.showMessageDialog(null, "Se termina el programa");
                return;
            }

            
            switch (tselect.toString()) {
                case "Monedas":
                    ConvertirMonedas op1 = new ConvertirMonedas();
                    if (op1.showConfirmDialog == 1 || op1.showConfirmDialog == 2) {
                        salir = true;
                        JOptionPane.showMessageDialog(null, "Fin del Programa");
                    }
                    break;

                    
                case "Medidas":
                    ConvertirMedidas op2= new ConvertirMedidas();
                    if (op2.showConfirmDialog == 1 || op2.showConfirmDialog == 2) {
                        salir = true;
                        JOptionPane.showMessageDialog(null, "Fin del Programa");
                    }
                    break;

                default:
                    System.out.println("Seleccione opción");
                    break;
            }
        } while (!salir);
    }

}