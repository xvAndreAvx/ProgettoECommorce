package ejb;

import java.util.List;

import javax.ejb.Remote;

import entity.Utente;

@Remote
public interface UtenteServiceRemote {
	
	void insert(Utente u);
	Utente update(Utente u);
	void delete(Utente u);
	List<Utente> findAll();
	Utente findById(Long id);

}
