package monedas;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

public class ConversorMonedas {
	private static final Map<String, Double> FACTOR_CONVERSION = new HashMap<String, Double>();
	 static {
	        FACTOR_CONVERSION.put("Peso/s a Dolar/es", 0.0036);
	        FACTOR_CONVERSION.put("Peso/s a Euro/s", 0.0033);
	        FACTOR_CONVERSION.put("Peso/s a Libra/s", 0.028);
	        FACTOR_CONVERSION.put("Peso/s a Yen/es", 0.52);
	        FACTOR_CONVERSION.put("Peso/s a Won/es", 4.69);
	        FACTOR_CONVERSION.put("Dolar/es a Peso/s", 1 / 0.0036);
	        FACTOR_CONVERSION.put("Euro/s a Peso/s", 1 / 0.0033);
	        FACTOR_CONVERSION.put("Libra/s a Peso/s", 1 / 0.028);
	        FACTOR_CONVERSION.put("Yen/es a Peso/s", 1 / 0.52);
	        FACTOR_CONVERSION.put("Won/es a Peso/s", 1 / 4.69);
	    }
	
	 
	public static void convertir(double input) {
		String opcion = (String) (JOptionPane.showInputDialog(null, "Seleccione la moneda que quieres convertir", "Moneda,", JOptionPane.PLAIN_MESSAGE, null, FACTOR_CONVERSION.keySet().toArray(), "Seleccion"));
		
		if(opcion == null) {
			JOptionPane.showMessageDialog(null, "No eligio una opcion, el programa terminará");
			System.exit(0);
		}
		
		double out = FACTOR_CONVERSION.get(opcion) * input;
		out = Math.floor(out * 1000) / 1000; //para darle al resultado tres digitos luego de la coma
		
		JOptionPane.showMessageDialog(null, input + " " + controlMoneda(opcion)[0] + " son " + out + " " + controlMoneda(opcion)[1].toLowerCase());
	}

	
	/**
	 * 	Este metodo se usa para saber con que moneda se esta trabajando
	 * @param opcion
	 * @return un arreglo con los tipos de monedas usados 
	 */
	private static String[] controlMoneda(String opcion) {
		String[] data = {"", ""};
		char[] opcionChar = opcion.toCharArray();
		
		for(int i = 0; i < opcion.indexOf(" "); i++)
			data[0] += opcionChar[i];
		
		for(int i = opcion.lastIndexOf(" ") + 1; i < opcionChar.length; i++)
			data[1] += opcionChar[i];
		
		return data;
	}
}
