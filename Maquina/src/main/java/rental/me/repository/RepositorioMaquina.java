package rental.me.repository;


import org.springframework.data.repository.CrudRepository;
import rental.me.model.Maquina;

public interface RepositorioMaquina extends CrudRepository<Maquina, Integer> {

	public Maquina findById (int id_maq);
	
}
