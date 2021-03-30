package com.betacom.architecture.dao;

public interface DAOConstants {

	// ALERT: DA TESTARE

	String SELECT_CORSI = "Select * from corso";
	String SELECT_CORSI_BY_ID = "Select * from corso where codcorso = ?";

	String SELECT_CORSISTI = "Select * from corsista";
	String SELECT_CORSISTA_BY_ID = "Select * from corsista where codcorsista = ?";

	String SELECT_AMMINISTRATORE = "Select * from amministratore where codadmin = ?";

	String SELECT_DOCENTI = "Select * from docente";
	String SELECT_DOCENTE_BY_ID = "Select * from docente where coddocente = ?";

	String SELECT_CORSO_CORSISTA = "Select * from corso_corsista";

	String SELECT_ADMINCOD = "Select codadmin from amministratore where nomeadmin = ? and cognomeadmin = ?";

	String SELECT_CORSOSEQ = "Select corso_seq.nextval from dual";
	String SELECT_CORSISTASEQ = "Select corsista_seq.nextval from dual";

	String UPDATE_CORSO = "Update corso set nomecorso = ?, datainiziocorso = ?, datafinecorso = ?, costocorso = ?, commenticorso = ?, aulacorso = ? where codcorso = ?";
	String UPDATE_CORSISTA = "Update corsista set nomecorsista = ?, cognomecorsista = ?, precedentiformativi = ? where codcorsista = ?";

	String DELETE_CORSO = "Delete from corso where codcorso = ?";
	String DELETE_CORSISTA = "Delete from corsista where codcorsista = ?";

	// STATISTICHE DISPARI
	String NUM_CORSI_TOT = "Select count(*) from corso";
	String DATA_INIZIO_ULTIMO_CORSO = "Select max(datainiziocorso) from corso";
	String NUM_COMMENTI = "Select count(commenti) from corso";
	String DOC_PIU_CORSI = "Select d.nomedocente,c.coddocente from corso,docente where c.coddocente=d.coddocente gropu by c.coddocente having count(*) >2";

}
