package conversorMonedas;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

public class Conversor {

	private String opcionMenu;
	private String convertirDe;
	private Double monto;
	private String convertirA;
	
	String opciones[] = {"Conversor de moneda", "Conversor de Temperatura"};
	String monedas[] = {"De Pesos a Dolares", "De Pesos a Euros", "De Pesos a Libras",
			"De Pesos a Yenes", "De Pesos a Wones Coreanos", "De Dolares a Pesos", "De Euros a Pesos",
			"De Libras a Pesos", "De Yenes a Pesos", "De Wones Coreanos a Pesos"};
	Map<String, Double> divisa = new HashMap<>();
	
	public void elegirOpcionMenu() {
		//JOptionPane.showInputDialog(null, convertirDe, null, 0, null, null, convertirA)
		
		this.opcionMenu = (String)JOptionPane.showInputDialog(null, 
				"Seleccione una opción de conversión", 
				"Menú",
				JOptionPane.QUESTION_MESSAGE, 
				null,
				opciones,
				opciones[0]);
		
		//System.out.println(this.opcionMenu);
		eleccion(this.opcionMenu);
	}
	
	public void  eleccion(String eleccion) {
		
		if(eleccion == opciones[0]) {
			try{
				convertirDe = (String)JOptionPane.showInputDialog(null, 
						"Ingrese la cantidad de dinero que desea convertir:", 
			            "Monto", 
			            JOptionPane.INFORMATION_MESSAGE);
				//this.monto = Integer.parseInt(this.convertirDe) + 2.00;
				//System.out.println(this.monto);
				this.monto = Double.valueOf(convertirDe);
				moneda();
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Valor no valido");
				eleccion(this.opcionMenu);
			}			
		}else {
			System.out.println("Temperatura");
		}
		
	}
	
	public void moneda() {
		this.convertirA = (String)JOptionPane.showInputDialog(null, 
				"Seleccione una opción de conversión", 
				"Menú",
				JOptionPane.QUESTION_MESSAGE, 
				null,
				monedas,
				monedas[0]);
		
		conversion();
	}
	
	public void SetDivisas() {
		
		divisa.put("De Pesos a Dolares", 0.059);
		divisa.put("De Pesos a Euros", 0.054);
		divisa.put("De Pesos a Libras", 0.046);
		divisa.put("De Pesos a Yenes", 8.52);
		divisa.put("De Pesos a Wones Coreanos", 78.56);
		divisa.put("De Dolares a Pesos", 17.06);
		divisa.put("De Euros a Pesos", 18.55);
		divisa.put("De Libras a Pesos", 21.72);
		divisa.put("De Yenes a Pesos", 0.12);
		divisa.put("De Wones Coreanos a Pesos", 0.013);
		
	}
	
	public Double GetDivisas(String s) {
		return divisa.get(s);
	}
	
	public void conversion() {
		SetDivisas();
		System.out.println(convertirA);
		System.out.println("monto");
		System.out.println(monto);
		System.out.println(GetDivisas(convertirA) * monto);
		String[] m = convertirA.split(" ");
        JOptionPane.showMessageDialog(null, "Tienes $"+String.format("%.2f",GetDivisas(convertirA) * monto)+ " " +m[3]);
		continuar();
	}
	
	public void continuar() {
		String[] options = {"Yes","No","Cancel"};
		
        int continuar = JOptionPane.showOptionDialog(null, "¿Desea continuar?",
                "Continuar",
                JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, 
                null, 
                options, 
                options[0]);
        
        if(continuar > 0) {
        	JOptionPane.showMessageDialog(null, "Programa Terminado");
        }else {
        	elegirOpcionMenu();
        }

	}
}
