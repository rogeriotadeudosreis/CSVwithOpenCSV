package com.rogerioreis.csv;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.opencsv.CSVWriter;

@SpringBootApplication
public class CsVcomOpenCsvApplication implements CommandLineRunner {

	private static final String CSV_PATH = "C:\\AmbienteDeEstudo_ADS4\\Exercicios\\CSVcomOpenCSV\\ArquivoCSVcomOpenCSV.csv";

	public static void main(String[] args) {
		SpringApplication.run(CsVcomOpenCsvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		try {

			System.out.println("Iniciando geração do arquivo CSV");

			FileWriter fw = new FileWriter(new File(CSV_PATH));
			CSVWriter cw = new CSVWriter(fw);

			String[] headers = { "name", "email", "telephone" };

			List<String[]> data = new ArrayList<String[]>();
			String[] item1 = { "rogerio", "rogerio@gmail.com", "1234-5678" };
			String[] item2 = { "ricardo", "ricardo@gmail.com", "9876-5678" };
			String[] item3 = { "fabio", "fabio@gmail.com", "8956-5678" };

			data.add(headers);
			data.add(item1);
			data.add(item2);
			data.add(item3);

			cw.writeAll(data);

			cw.close();
			fw.close();

			System.out.println("Escrita do arquivo finalizada");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
