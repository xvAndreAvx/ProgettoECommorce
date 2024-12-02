package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Utente;

/**
 * Session Bean implementation class UtenteService
 */
@Stateless
@LocalBean
public class UtenteService implements UtenteServiceRemote {

    @PersistenceContext(unitName = "MySqlDS")
    private EntityManager entityManager;

    /**
     * Default constructor.
     */
    public UtenteService() {
    }

    @Override
    public void insert(Utente u) {
        try {
            entityManager.persist(u);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Utente update(Utente u) {
        try {
            return entityManager.merge(u);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void delete(Utente u) {
        try {
            u = entityManager.merge(u);
            entityManager.remove(u);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Utente> findAll() {
        return entityManager.createQuery("SELECT u FROM Utente u", Utente.class).getResultList();
    }

    @Override
    public Utente findById(Long id) {
        return entityManager.find(Utente.class, id);
    }
}
