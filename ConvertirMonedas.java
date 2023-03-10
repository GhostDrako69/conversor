

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ConvertirMonedas extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	public int showConfirmDialog = 0;

    public ConvertirMonedas() {
        Object[] tipos = {"CRC", "USD", "EUR", "GBP", "JPY", "KRW"};
        Object moneda1 = null;
        Object moneda2 = null;
        do {
            moneda1 = (String) JOptionPane.showInputDialog(null, "Moneda a convertir", "Conversor", JOptionPane.QUESTION_MESSAGE, null, tipos, tipos[0]);
            moneda2 = (String) JOptionPane.showInputDialog(null, "Moneda para convertir", "Conversor", JOptionPane.QUESTION_MESSAGE, null, tipos, tipos[0]);
        } while (moneda1 == moneda2 && !(moneda1 == null || moneda2 == null));

        if (moneda1 == null || moneda2 == null) {
            JOptionPane.showMessageDialog(null, "Selecciona opción");
            return;
        }

        double monto = 0;
        double resultado = 0;
        boolean bandera = true;

        do {
            String entrada = JOptionPane.showInputDialog("Ingrese cantidad " + moneda1);
            if (entrada == null) {
                bandera = false;
                monto = 0;
            } else {
                try {
                    monto = Double.parseDouble(entrada);
                    bandera = false;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error en el dato");
                }
            }
        } while (bandera);

        if (monto != 0) {
            double resultadoCRC = convertirAColones(monto, moneda1.toString());

            switch (moneda2.toString()) {
                case "EUR":
                    resultado = convertirAEuros(resultadoCRC);
                    JOptionPane.showMessageDialog(null, String.format("%.2f ", monto) + moneda1 + " son " + String.format("%.2f", resultado) + " EUR.");
                    break;

                case "GBP":
                    resultado = convertirALibras(resultadoCRC);
                    JOptionPane.showMessageDialog(null, String.format("%.2f ", monto) + moneda1 + " son " + String.format("%.2f", resultado) + " GBP.");
                    break;

                case "JPY":
                    resultado = convertirAYenes(resultadoCRC);
                    JOptionPane.showMessageDialog(null, String.format("%.2f ", monto) + moneda1 + " son " + String.format("%.2f", resultado) + " JPY.");
                    break;

                case "KRW":
                    resultado = convertirAWones(resultadoCRC);
                    JOptionPane.showMessageDialog(null, String.format("%.2f ", monto) + moneda1 + " son " + String.format("%.2f", resultado) + " KRW.");
                    break;

                case "USD":
                    resultado = convertirADolares(resultadoCRC);
                    JOptionPane.showMessageDialog(null, String.format("%.2f ", monto) + moneda1 + " son " + String.format("%.2f", resultado) + " USD.");
                    break;

                case "CRC":
                    JOptionPane.showMessageDialog(null, String.format("%.2f ", monto) + moneda1 + " son " + String.format("%.2f", resultadoCRC) + " CRC.");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Error, cerrando programa");
                    break;
            }
        }

        showConfirmDialog = JOptionPane.showConfirmDialog(null, "Continuar?");
    }

    public static double convertirAColones(double cantidad, String monedaOrigen) {
        switch (monedaOrigen) {
            case "CRC":
                return cantidad;
            case "USD":
                return cantidad * 561.45;
            case "EUR":
                return cantidad * 594.32;
            case "GBP":
                return cantidad * 670.65;
            case "JPY":
                return cantidad * 4.11;
            case "KRW":
                return cantidad * 0.43;
            default:
                System.out.println("ERROR");
                return 0;
        }
    }

    public static double convertirADolares(double cantidad) {
        return cantidad / 561.45;
    }

    public static double convertirAEuros(double cantidad) {
        return cantidad / 594.32;
    }

    public static double convertirALibras(double cantidad) {
        return cantidad / 670.65;
    }

    public static double convertirAYenes(double cantidad) {
        return cantidad / 4.11;
    }

    public static double convertirAWones(double cantidad) {
        return cantidad / 0.43;
    }

}