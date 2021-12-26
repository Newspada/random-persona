package com.facchinil.manager.main;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.facchinil.dto.NomeDTO;
import com.facchinil.dto.PersonaDTO;
import com.facchinil.es.ComuneES;
import com.facchinil.es.IndirizzoES;
import com.facchinil.es.PersonaES;
import com.facchinil.manager.CognomeManager;
import com.facchinil.manager.DominioManager;
import com.facchinil.manager.IndirizzoManager;
import com.facchinil.manager.NomeManager;
import com.facchinil.manager.PersonaManager;
import com.facchinil.repository.PersonaRepositoryES;

@Component
public class PersonaManagerMain implements PersonaManager {
	
	private static final Long DATA_MIN_EPOCH_DAY = LocalDate.of(1950, Month.JANUARY, 1).toEpochDay();
	private static final Long DATA_MAX_EPOCH_DAY = LocalDate.of(2003, Month.JANUARY, 1).toEpochDay();
	
	@Autowired
	private NomeManager nomeManager;
	
	@Autowired
	private CognomeManager cognomeManager;
	
	@Autowired
	private IndirizzoManager indirizzoManager;
	
	@Autowired
	private DominioManager dominioManager;
	
	@Autowired
	private PersonaRepositoryES personaRepositoryES;
	
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
		saveES(persona);
		return persona;
	}

	private void saveES(PersonaDTO persona) {
		PersonaES personaES = new PersonaES();
		personaES.setNome(persona.getNome());
		personaES.setCognome(persona.getCognome());
		personaES.setSesso(persona.getSesso());
		personaES.setEmail(persona.getEmail());
		personaES.setNumeroTelefono(persona.getNumeroTelefono());
		IndirizzoES indirizzoES = new IndirizzoES();
		indirizzoES.setToponimo(persona.getIndirizzo().getToponimo());
		indirizzoES.setDenominazione(persona.getIndirizzo().getDenominazione());
		ComuneES comuneES = new ComuneES();
		comuneES.setComune(persona.getIndirizzo().getComune().getComune());
		comuneES.setCap(persona.getIndirizzo().getComune().getCap());
		comuneES.setPrefisso(persona.getIndirizzo().getComune().getPrefisso());
		comuneES.setProvincia(persona.getIndirizzo().getComune().getProvincia());
		comuneES.setRegione(persona.getIndirizzo().getComune().getRegione());
		indirizzoES.setComune(comuneES);
		personaES.setIndirizzo(indirizzoES);
		personaRepositoryES.save(personaES);
	}

	private String getRandomEmail(String nome, String cognome, Integer annoNascita) {
		StringBuilder email = new StringBuilder();
		email.append(getRandomUserName(nome, cognome, annoNascita));
		email.append("@");
		email.append(dominioManager.getRandom().getDominio());
		return email.toString().toLowerCase().replaceAll("[ ']", "");
	}
	
	private String getRandomUserName(String nome, String cognome, Integer annoNascita) {
		switch (ThreadLocalRandom.current().nextInt(9)) {
		case 0:
			return nome + "." + cognome;
		case 1:
			return cognome + "." + nome;
		case 2:
			return nome + cognome + annoNascita;
		case 3:
			return cognome + nome + annoNascita;
		case 4:
			return nome.charAt(0) + cognome + annoNascita;
		case 5:
			return nome.charAt(0) + cognome + annoNascita.toString().substring(2);
		case 6:
			return nome + cognome + annoNascita.toString().substring(2);
		case 7:
			return cognome + nome + annoNascita.toString().substring(2);
		case 8:
			return nome + "." + cognome + "." + annoNascita;
		default:
			throw new IllegalStateException();
		}
	}
	
	private String getRandomNumero(String prefisso) {
		StringBuilder numeroTelefono = new StringBuilder();
		switch (ThreadLocalRandom.current().nextInt(2)) {
		case 0:
			numeroTelefono.append("3");
			numeroTelefono.append(ThreadLocalRandom.current().nextInt(6) + 2);
			for (int i = 0; i < 8; i++)
				numeroTelefono.append(ThreadLocalRandom.current().nextInt(10));
			break;
		case 1:
			numeroTelefono.append(prefisso);
			for (int i = 0; i < 9 - prefisso.length(); i++)
				numeroTelefono.append(ThreadLocalRandom.current().nextInt(10));
			break;
		default:
			throw new IllegalStateException();
		}
		return numeroTelefono.toString();
	}

	private Date getRandomData() {
		return Date.from(LocalDate.ofEpochDay(ThreadLocalRandom.current().nextLong(DATA_MIN_EPOCH_DAY, DATA_MAX_EPOCH_DAY))
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