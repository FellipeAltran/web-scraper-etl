package br.edu.utfpr.td.tsi.web.scraper.etl;

import java.util.List;

public class Job<T, O> {

	private Extrator<T> extrator;
	private Transformador<T, O> transformador;
	private Carregador<T> carregador;

	public void setExtrator(Extrator<T> extrator) {
		this.extrator = extrator;
	}

	public void setTransformador(Transformador<T, O> transformador) {
		this.transformador = transformador;
	}

	public void setCarregador(Carregador<T> carregador) {
		this.carregador = carregador;
	}

	public void executar() {

		List<T> lista = extrator.extrair();

		for (T item : lista) {
			transformador.transformar(item);
		}
		carregador.carregar(lista);

	}

}
