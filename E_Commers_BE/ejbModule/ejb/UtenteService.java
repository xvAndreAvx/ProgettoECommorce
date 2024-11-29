package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import entity.Utente;

/**
 * Session Bean implementation class UtenteService
 */
@Stateless
@LocalBean
public class UtenteService implements UtenteServiceRemote {

    /**
     * Default constructor. 
     */
    public UtenteService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void insert(Utente u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Utente update(Utente u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Utente u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Utente> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utente findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
