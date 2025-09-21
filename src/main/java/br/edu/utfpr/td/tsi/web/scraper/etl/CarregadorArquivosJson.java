package br.edu.utfpr.td.tsi.web.scraper.etl;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CarregadorArquivosJson<T> extends Carregador<T> {

	private String output;

	public void setOutput(String output) {
		this.output = output;
	}

	@Override
	public void carregar(List<T> item) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		try (Writer writer = new FileWriter(output)) {
			gson.toJson(item, writer);

		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

}
