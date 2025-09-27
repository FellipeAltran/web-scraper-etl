package br.edu.utfpr.td.tsi.web.scraper.etl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Job<T, O> {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

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
		
		if(lista.size() == 0) {
			this.logger.info("Nenhum dado encontrado");
		}
		
		this.logger.info("Iniciando transformação de dados de " + lista.getFirst().getClass().getSimpleName());

		for (T item : lista) {
			transformador.transformar(item);
		}
		
		this.logger.info("Transformação de " + lista.getFirst().getClass().getSimpleName() + " finalizado");


		this.logger.info("Iniciando gravação de dados de " + lista.getClass().getSimpleName());

		carregador.carregar(lista);
		
		this.logger.info("Gravação de " + lista.getFirst().getClass().getSimpleName() + " finalizado");
		
	}

}
