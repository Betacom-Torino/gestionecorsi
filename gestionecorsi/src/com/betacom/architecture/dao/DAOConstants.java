package com.betacom.architecture.dao;

public interface DAOConstants {

	// ALERT: DA TESTARE

	String SELECT_CORSI = "Select * from corso";
	String SELECT_CORSI_BY_COD = "Select * from corso where codcorso = ?";

	String SELECT_CORSISTI = "Select * from corsista";  //USATO ANCHE PER STATISCTICA N.6
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
	String NUM_CORSISTI_TOT = "Select count(*) from corsista";
	String DATA_INIZIO_ULTIMO_CORSO = "Select max(datainizio) from corso";
	String NUM_COMMENTI = "Select count(commentocorso) from corso";
	String DOC_PIU_CORSI = "Select c.coddocente, d.nomedocente, d.cognomedocente, d.cvdocente from corso c,docente d where c.coddocente=d.coddocente group by c.coddocente, d.nomedocente, d.cognomedocente, d.cvdocente having count(*) >2";

	String NUMERO_ISCRITTI_CORSI = "Select * from numero_iscritti_corso";
	
	// STATISTICHE PARI
	String MAX_ISCRITTI = " Select nomecorso,max(num_iscritti) from numero_iscritti_corso nic, corso c where nic.codcorso=c.codcorso group by nomecorso having max(num_iscritti)=(select max(num_iscritti) from numero_iscritti_corso)";
	String DURATA_MEDIA_CORSI = "Select ROUND(AVG(((datafine-datainizio)/7)*5)) as media from corso c";
	String CORSO_ISCRITTI = "Select * from corso c where c.codcorso in (select codcorso from numero_iscritti_corso where num_iscritti<12)";

	String SELECT_CORSI_BY_CORSISTA="Select * from corso c, corso_corsista cc where c.codcorso=cc.codcorso and cc.codcorsista=?";
	
	String DELETE_CORSO_CORSISTA="Delete from corso_corsista where codcorsista=?";
	String CORSI_NON_INIZIATI="select * from corso where datainizio > sysdate";

String DELETE_CORSO_CORSISTA_BY_CORSO="Delete from corso_corsista where codcorso=?";

}
