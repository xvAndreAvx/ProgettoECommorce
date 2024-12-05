package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import entity.Prodotto;
import entity.Utente;

/**
 * Session Bean implementation class ProdottoService
 */
@Stateless
@LocalBean
public class ProdottoService implements ProdottoServiceRemote {

	@PersistenceContext(unitName = "exolab2")
	private EntityManager entityManager;

	private static ProdottoService instance = null;

	public static ProdottoService getInstance() {

		if (instance == null) {
			ProdottoService instance = new ProdottoService();
		}

		return instance;
	}

	/**
	 * Default constructor.
	 */
	public ProdottoService() {
		// TODO Auto-generated constructor stub
	}

	@Transactional
	@Override
	public void insert(Prodotto p) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(p);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		} finally {
			entityManager.close();
		}
	}

	@Transactional
	@Override
	public Prodotto update(Prodotto p) {
		try {
			entityManager.getTransaction().begin();
			Prodotto prodotto = entityManager.merge(p);
			entityManager.getTransaction().commit();
			return prodotto;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		} finally {
			entityManager.close();
		}
		return null;

	}

	@Transactional
	@Override
	public void delete(Prodotto p) {
		try {
			entityManager.getTransaction().begin();
			p = entityManager.merge(p);
			entityManager.remove(p);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		} finally {
			entityManager.close();
		}

	}

	@Transactional
	@Override
	public List<Prodotto> findAll() {
		try {
			entityManager.getTransaction().begin();
			List<Prodotto> prodotti = entityManager.createQuery("SELECT p FROM Prodotto p", Prodotto.class)
					.getResultList();
			return prodotti;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		} finally {
			entityManager.close();
		}
		return null;
	}

	@Transactional
	@Override
	public Prodotto findById(Long id) {
		try {
			entityManager.getTransaction().begin();
			Prodotto prodotto = entityManager.find(Prodotto.class, id);
			return prodotto;
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		} finally {
			entityManager.close();
		}
		return null;
	}

}
