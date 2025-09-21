package br.edu.utfpr.td.tsi.web.scraper.etl;

public abstract class Transformador<I, O> {

	public abstract O transformar(I item);

}
