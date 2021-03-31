package com.betacom.architecture.dao;

public interface DAOConstants {

	// ALERT: DA TESTARE

	String SELECT_CORSI = "Select * from corso";
	String SELECT_CORSI_BY_COD = "Select * from corso where codcorso = ?";

	String SELECT_CORSISTI = "Select * from corsista";
	String SELECT_CORSISTA_BY_COD = "Select * from corsista where codcorsista = ?";

	String SELECT_AMMINISTRATORE = "Select * from amministratore where codadmin = ?";

	String SELECT_DOCENTI = "Select * from docente";
	String SELECT_DOCENTE_BY_COD = "Select * from docente where coddocente = ?";

	String SELECT_CORSO_CORSISTA = "Select * from corso_corsista";

	String SELECT_ADMINCOD = "Select codadmin from amministratore where nomeadmin = ? and cognomeadmin = ?";

	String SELECT_CORSOSEQ = "Select corso_seq.nextval from dual";
	String SELECT_CORSISTASEQ = "Select corsista_seq.nextval from dual";

	String UPDATE_CORSO = "Update corso set nomecorso = ?, datainizio = ?, datafine = ?, costocorso = ?, commentocorso = ?, aulacorso = ? where codcorso = ?";
	String UPDATE_CORSISTA = "Update corsista set nomecorsista = ?, cognomecorsista = ?, precedentiformativi = ? where codcorsista = ?";

	String DELETE_CORSO = "Delete from corso where codcorso = ?";
	String DELETE_CORSISTA = "Delete from corsista where codcorsista = ?";

	// STATISTICHE DISPARI
	String NUM_CORSISTI_TOT = "Select count(*) from corsisti";
	String DATA_INIZIO_ULTIMO_CORSO = "Select max(datainiziocorso) from corso";
	String NUM_COMMENTI = "Select count(commenti) from corso";
	String DOC_PIU_CORSI = "Select c.coddocente, d.nomedocente, d.cognomedocente, d.cvdocente from corso c,docente d where c.coddocente=d.coddocente group by c.coddocente, d.nomedocente, d.cognomedocente, d.cvdocente having count(*) >2";

	
	// STATISTICHE PARI
	String MAX_ISCRITTI = " Select nomecorso,max(num_iscritti) from numero_iscritti_corso nic, corso c where nic.codcorso=c.codcorso group by nomecorso having max(num_iscritti)=(select max(num_iscritti) from numero_iscritti_corso)";	 
	String CORSO_ISCRITTI = "Select count(codcorsista) from corso_corsista where codcorso = ? ";
	String CORSI_ISCRITTI = "Select * from corso c where codcorso in (select codcorso from corso_corsista group by codcorso having Count(*)< 12)";
	String DURATA_MEDIA_CORSI = "Select ROUND(AVG(((datafine-datainizio)/7)*5)) as media from corso c";
}
