package com.facchinil.manager.main;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

import com.facchinil.dto.ComuneDTO;
import com.facchinil.dto.IndirizzoDTO;
import com.facchinil.dto.NomeDTO;
import com.facchinil.dto.PersonaDTO;
import com.facchinil.manager.CognomeManager;
import com.facchinil.manager.ComuneManager;
import com.facchinil.manager.DominioManager;
import com.facchinil.manager.IndirizzoManager;
import com.facchinil.manager.NomeManager;
import com.facchinil.manager.PersonaManager;

@Component
public class PersonaManagerMain implements PersonaManager {
	
	@Autowired
	private NomeManager nomeManager;
	
	@Autowired
	private CognomeManager cognomeManager;
	
	@Autowired
	private IndirizzoManager indirizzoManager;
	
	@Autowired
	private DominioManager dominioManager;
	
	@Override
	public PersonaDTO getRandom() {
		PersonaDTO persona = new PersonaDTO();
		persona.setDataNascita(getRandomData());
		NomeDTO nome = nomeManager.getRandomByYear(getYear(persona.getDataNascita()));
		persona.setNome(nome.getNome());
		persona.setCognome(cognomeManager.getRandom().getCognome());
		persona.setSesso(nome.getSesso());
		persona.setIndirizzo(indirizzoManager.getRandom());
		persona.setEmail(getRandomEmail(persona.getNome(), persona.getCognome(), getYear(persona.getDataNascita())));
		persona.setNumeroTelefono(getRandomNumero(persona.getIndirizzo().getComune().getPrefisso()));
		return persona;
	}

	private String getRandomEmail(String nome, String cognome, Integer annoNascita) {
		String email = "";
		switch (ThreadLocalRandom.current().nextInt(10)) {
		case 0:
			email += nome + "." + cognome;
			break;
		case 1:
			email += cognome + "." + nome;
			break;
		case 3:
			email += nome + cognome + annoNascita;
			break;
		case 4:
			email += cognome + nome + annoNascita;
			break;
		case 5:
			email += nome.charAt(0) + cognome + annoNascita;
			break;
		case 6:
			email += nome.charAt(0) + cognome + annoNascita.toString().substring(2);
			break;
		case 7:
			email += nome + cognome + annoNascita.toString().substring(2);
			break;
		case 8:
			email += cognome + nome + annoNascita.toString().substring(2);
			break;
		case 9:
			email += nome + "." + cognome + "." + annoNascita;
			break;
		}
		email += "@";
		email += dominioManager.getRandom().getDominio();
		return email.toLowerCase().replaceAll("[ ']", "");
	}

	private String getRandomNumero(String prefisso) {
		String numeroTelefono = "";
		switch (ThreadLocalRandom.current().nextInt(2)) {
		case 0:
			numeroTelefono += "3";
			numeroTelefono += String.valueOf(ThreadLocalRandom.current().nextInt(6) + 2);
			for (int i = 0; i < 8; i++)
				numeroTelefono += String.valueOf(ThreadLocalRandom.current().nextInt(10));
			break;
		case 1:
			numeroTelefono += prefisso;
			for (int i = 0; i < 9 - prefisso.length(); i++)
				numeroTelefono += String.valueOf(ThreadLocalRandom.current().nextInt(10));
			break;
		}
		return numeroTelefono;
	}

	private Date getRandomData() {
		long dataMin = LocalDate.of(1950, Month.JANUARY, 1).toEpochDay();
		long dataMax = LocalDate.of(2003, Month.JANUARY, 1).toEpochDay();
		return Date.from(LocalDate.ofEpochDay(ThreadLocalRandom.current().nextLong(dataMin, dataMax))
				.atStartOfDay()
				.atZone(ZoneId.systemDefault())
			    .toInstant());
	}
	
	private Integer getYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.YEAR);
	}
}