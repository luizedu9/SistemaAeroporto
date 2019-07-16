package aplicacao;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import interfaceGrafica.InterfaceMain;

public class Aeroporto {

	public static Map<Integer, CompanhiaAerea> companhiaAerea = new HashMap<Integer, CompanhiaAerea>(); 
	
	public static void main(String[] args) {

		InterfaceMain frame = new InterfaceMain();
	
	}
	
	public static void setCompanhiaAerea(int codigo, CompanhiaAerea companhia) {
		if (getCompanhiaAerea(codigo) != null) {
			JOptionPane.showMessageDialog(null, "ERRO - CODIGO JA EXISTE");
		}
		else {
			companhiaAerea.put(codigo, companhia);
		}
	}
	
	public static CompanhiaAerea getCompanhiaAerea(int codigo) {
		return(companhiaAerea.get(codigo));
	}
	
	public static void setMapCompanhia(Map<Integer, CompanhiaAerea> companhia) {
		companhiaAerea = companhia;
	}
	
	public static Map<Integer, CompanhiaAerea> getMapCompanhia() {
		return(companhiaAerea);
	}
	
	public static int getNumeroVoos() {
		int numeroVoos = 0;
		for (Integer key : companhiaAerea.keySet()) {
            numeroVoos += companhiaAerea.get(key).getQuantidadeVoo();
		}
		return(numeroVoos);
	}
	
	public static void excluirCompanhia(int codigo) {
		companhiaAerea.remove(getCompanhiaAerea(codigo));
	}
	
	public static void resetarAeroporto() {
		companhiaAerea = null;
	}
	
	public static double lucroAeroporto() {
		double lucroAeroporto = 0;
		for (Integer key : companhiaAerea.keySet()) {
			lucroAeroporto += companhiaAerea.get(key).getTributo();
		}
		return(lucroAeroporto);
	}
	
	public static int getNumeroCompanhia() {
		return(companhiaAerea.size());
	}
	
}