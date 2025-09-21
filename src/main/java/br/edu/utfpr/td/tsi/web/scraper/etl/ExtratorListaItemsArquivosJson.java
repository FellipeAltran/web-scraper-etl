package br.edu.utfpr.td.tsi.web.scraper.etl;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ExtratorListaItemsArquivosJson<T> extends Extrator<T> {

	private String input;

	private Class<T> clazz;

	public void setListType(Class<T> clazz) {
		this.clazz = clazz;
	}

	public void setInput(String input) {
		this.input = input;
	}

	@Override
	public List<T> extrair() {
		System.out.println(input);
		Gson gson = new Gson();

		try (Reader reader = new FileReader(input)) {
			Type type = TypeToken.getParameterized(List.class, clazz).getType();
			return gson.fromJson(reader, type);

		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

}
