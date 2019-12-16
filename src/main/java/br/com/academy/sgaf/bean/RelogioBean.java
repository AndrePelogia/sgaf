package br.com.academy.sgaf.bean;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class RelogioBean {
	@SuppressWarnings("unused")
	private Date dataAtual = new Date();
	
	public void relogio() {
		dataAtual = Calendar.getInstance(new Locale("BR")).getTime();
	}
}
