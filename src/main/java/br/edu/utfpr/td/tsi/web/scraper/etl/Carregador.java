package br.edu.utfpr.td.tsi.web.scraper.etl;

import java.util.List;

public abstract class Carregador<T> {

	public abstract void carregar(List<T> item);

}
