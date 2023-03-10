

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class ConvertirMedidas extends JFrame {

    public int showConfirmDialog = 0;

    public ConvertirMedidas() {
        Object[] tipos = {"KM", "HM", "DAM", "M", "DM", "CM", "MM"};
        Object medida1 = null;
        Object medida2 = null;
        do {
            medida1 = (String) JOptionPane.showInputDialog(null, "Seleccione la unidad de origen", "Conversor", JOptionPane.QUESTION_MESSAGE, null, tipos, tipos[0]);
            medida2 = (String) JOptionPane.showInputDialog(null, "Seleccione a que unidad desea convertir", "Conversor", JOptionPane.QUESTION_MESSAGE, null, tipos, tipos[0]);
        } while (medida1 == medida2 && !(medida1 == null || medida2 == null));

        if (medida1 == null || medida2 == null) {
            JOptionPane.showMessageDialog(null, "Falla el en dato");
            return;
        }

        double monto = 0;
        double resultado = 0;
        boolean bandera = true;

        do {
            String entrada = JOptionPane.showInputDialog("Valor? " + medida1);
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
            double resultadoMetros = convertirMetros(monto, medida1.toString());

            switch (medida2.toString()) {
                case "KM":
                    resultado = convertirKilometros(resultadoMetros);
                    JOptionPane.showMessageDialog(null, String.format("%.2f ", monto) + medida1 + " son " + String.format("%.2f", resultado) + " KM.");
                    break;

                case "HM":
                    resultado = convertirHectometros(resultadoMetros);
                    JOptionPane.showMessageDialog(null, String.format("%.2f ", monto) + medida1 + " son " + String.format("%.2f", resultado) + " HM.");
                    break;

                case "DAM":
                    resultado = convertirDecametros(resultadoMetros);
                    JOptionPane.showMessageDialog(null, String.format("%.2f ", monto) + medida1 + " son " + String.format("%.2f", resultado) + " DAM.");
                    break;

                case "M":
                    JOptionPane.showMessageDialog(null, String.format("%.2f ", monto) + medida1 + " son " + String.format("%.2f", resultadoMetros) + " M.");
                    break;

                case "DM":
                    resultado = convertirDecimetros(resultadoMetros);
                    JOptionPane.showMessageDialog(null, String.format("%.2f ", monto) + medida1 + " son " + String.format("%.2f", resultado) + " DM.");
                    break;

                case "CM":
                    resultado = convertirCentimetros(resultadoMetros);
                    JOptionPane.showMessageDialog(null, String.format("%.2f ", monto) + medida1 + " son " + String.format("%.2f", resultado) + " CM.");
                    break;

                case "MM":
                    resultado = convertirMilimetros(resultadoMetros);
                    JOptionPane.showMessageDialog(null, String.format("%.2f ", monto) + medida1 + " son " + String.format("%.2f", resultado) + " MM.");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Error, cerrando programa");
                    break;
            }
        }

        showConfirmDialog = JOptionPane.showConfirmDialog(null, "Continuar?");
    }

    public static double convertirMetros(double longitud, String unidadOrigen) {
        switch (unidadOrigen) {
            case "KM":
                return longitud * 1000.0;
            case "HM":
                return longitud * 100.0;
            case "DAM":
                return longitud * 10.0;
            case "M":
                return longitud;
            case "DM":
                return longitud / 10.0;
            case "CM":
                return longitud / 100.0;
            case "MM":
                return longitud / 1000.0;
            default:
                System.out.println("Error en el dato");
                return 0;
        }
    }

    public static double convertirKilometros(double longitud) {
        return longitud / 1000.0;
    }

    public static double convertirHectometros(double longitud) {
        return longitud / 100.0;
    }

    public static double convertirDecametros(double longitud) {
        return longitud / 10.0;
    }

    public static double convertirDecimetros(double longitud) {
        return longitud * 10.0;
    }

    public static double convertirCentimetros(double longitud) {
        return longitud * 100.0;
    }

    public static double convertirMilimetros(double longitud) {
        return longitud * 1000.0;
    }

}