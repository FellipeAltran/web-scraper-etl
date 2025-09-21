package br.edu.utfpr.td.tsi.web.scraper.etl;

import java.util.List;

public abstract class Extrator<T> {

	public abstract List<T> extrair();

}
