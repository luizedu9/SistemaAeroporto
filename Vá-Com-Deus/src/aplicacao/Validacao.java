package aplicacao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class Validacao {

	private static int tempo[][] = new int[31][48]; // MARCAÇÃO DOS HORARIOS USADOS PELOS AVIOES;

	public static boolean validaCpf(String cpf) {
		String aux = new String();
		int i, j, verificador;
		char c;

		String pattern = "^\\d{3,3}.*\\d{3,3}.*\\d{3,3}-\\d{2,2}";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(cpf);

		if (m.find()) {
			for (j = 0; j < cpf.length(); j++) {
				c = cpf.charAt(j);
				if ((c >= 48) && (c <= 57)) {
					aux = aux + c;
				}
			}
			cpf = aux;
			// VALIDA PRIMEIRO DIGITO
			j = 0;
			for (i = 0; i < 9; i++)
				j = j + (Character.getNumericValue(cpf.charAt(i)) * (10 - i));
			verificador = 11 - (j % 11);
			if (verificador == 10 || verificador == 11)
				verificador = 0;
			if (verificador != (Character.getNumericValue(cpf.charAt(9))))
				return (false);
			// VALIDA SEGUNDO DIGITIO
			j = 0;
			for (i = 0; i < 10; i++)
				j = j + (Character.getNumericValue(cpf.charAt(i)) * (11 - i));
			verificador = 11 - (j % 11);
			if (verificador == 10 || verificador == 11)
				verificador = 0;
			if (verificador != (Character.getNumericValue(cpf.charAt(10))))
				return (false);
			return (true);
		}
		return (m.find());
	}

	public static boolean validaEmail(String email) {
		String pattern = ("^[a-zA-Z0-9_\\.-]+@([a-zA-Z0-9]\\.)*([a-zA-Z0-9])*\\.");
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(email);
		return (m.find());
	}

	public static boolean validaHorario(String horario) {
		String pattern = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(horario);
		return (m.find());
	}

	public static boolean validaData(String data) {
		String pattern = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/[12][0-9]{3}$";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(data);
		return (m.find());
	}

	public static boolean reservaHorario(String data, String hora) {
		int dia,  horario = tranformaHora(hora);
		dia = Integer.parseInt(data.substring(0, 2));
		// DIA = LINHA / HORARIO - COLUNA;
		if (tempo[dia][horario] <= 3) {
			tempo[dia][horario]++;
			return (true);
		}
		return (false);
	}
	
	public static void desmarcaHorario(String data, String hora) {
		int dia,  horario = tranformaHora(hora);
		dia = Integer.parseInt(data.substring(0, 2));
		tempo[dia][horario]--;
	}

	private static int tranformaHora(String hora) {
		int horario;
		// TRANSFORMA HORA EM POSIÇÃO DA MATRIZ
		horario = Character.getNumericValue(hora.charAt(3)); // PEGA MINUTOS;
		if (horario < 3) {
			horario = 0;
		} else
			horario = 1;
		horario += Integer.parseInt(hora.substring(0, 2));
		return (horario);
	}
	
	public static String sha1(String input) throws NoSuchAlgorithmException {
		MessageDigest mDigest = MessageDigest.getInstance("SHA1");
	    byte[] result = mDigest.digest(input.getBytes());
	    StringBuffer sb = new StringBuffer();
	    for (int i = 0; i < result.length; i++) {
	    	sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
	    }
	    return sb.toString();
	}

}

   