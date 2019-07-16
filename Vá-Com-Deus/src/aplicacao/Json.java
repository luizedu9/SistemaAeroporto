package aplicacao;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Json {
	
	//Aeroporto
	public boolean importarJson(String diretorio) {
		Map<Integer, CompanhiaAerea> companhiaAerea = new HashMap<>();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Type listType = new TypeToken<Map<Integer, CompanhiaAerea>>() {}.getType();
		
        try (Reader reader = new FileReader(diretorio)) {
        	companhiaAerea = gson.fromJson(reader, listType);
            Aeroporto.setMapCompanhia(companhiaAerea);  
            return(true);
        } 
        catch (IOException e) {
            return(false);
        }
	}
	
	//Aeroporto
	public void exportarJson(String diretorio) {
		Gson gson = new Gson();
		Map<Integer, CompanhiaAerea> companhiaAerea;
		companhiaAerea = Aeroporto.getMapCompanhia();
		
		String stringGson = gson.toJson(companhiaAerea);
		
		FileWriter arq = null;
		try {
			arq = new FileWriter(diretorio);
		} catch (IOException e) {
			e.printStackTrace();
		}
	    PrintWriter gravarArq = new PrintWriter(arq);
	    gravarArq.printf(stringGson);
	    try {
			arq.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Companhia
	public boolean importarJson(String diretorio, String codigoCompanhia) {
		CompanhiaAerea companhiaAerea = new CompanhiaAerea();
		Gson gson = new Gson();

        try (Reader reader = new FileReader(diretorio)) {
            companhiaAerea = gson.fromJson(reader, CompanhiaAerea.class);
            Aeroporto.setCompanhiaAerea(companhiaAerea.getCodigo(), companhiaAerea);  
            return(true);
        } 
        catch (IOException e) {
            e.printStackTrace();
            return(false);
        }
	}
	
	//Companhia
	public void exportarJson(String diretorio, String codigoCompanhia) {
			Gson gson = new Gson();
			int codigo = Integer.parseInt(codigoCompanhia);
			CompanhiaAerea companhiaAerea = new CompanhiaAerea();
			companhiaAerea = Aeroporto.getCompanhiaAerea(codigo);
			String stringGson = gson.toJson(companhiaAerea);
			
			FileWriter arq = null;
			try {
				arq = new FileWriter(diretorio);
			} catch (IOException e) {
				e.printStackTrace();
			}
		    PrintWriter gravarArq = new PrintWriter(arq);
		    gravarArq.printf(stringGson);
		    try {
				arq.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
		
}