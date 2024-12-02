package ejb;

import java.util.List;

import javax.ejb.Remote;

import entity.Prodotto;

@Remote
public interface ProdottoServiceRemote {
	
	void insert(Prodotto p);
	Prodotto update(Prodotto p);
	void delete(Prodotto p);
	List<Prodotto> findAll();
	Prodotto findById(Long id);

}
