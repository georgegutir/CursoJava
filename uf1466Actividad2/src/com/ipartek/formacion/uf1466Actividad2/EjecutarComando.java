package com.ipartek.formacion.uf1466Actividad2;

import java.io.IOException;

public class EjecutarComando {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("Iniciando restauración");
		String usuario = "root";
		String password = "";
		String archivo ="C:/Users/JORGE/UF1466_2.sql";
		String[] restoreCmd = new String[] { "mysql ", "--user=" + usuario, "--password=" + password, "-e",
				"source " + archivo };

		 Process runProcess = Runtime.getRuntime().exec(restoreCmd);
		 int processComplete = runProcess.waitFor();
		 
		 if(processComplete == 0) {
			 System.out.println("Restaurado con éxito");
		 } else {
			 System.out.println("Ha habido algún error");
		 }
	}
}
