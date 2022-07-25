package rental.me.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import rental.me.model.Maquina;

import java.util.List;

public interface RepositorioMaquina extends CrudRepository<Maquina, Integer> {

	public Maquina findById (int id_maq);

	@Query(value = "select * from maquina inner join tipo_maquina on tipo_maquina.id_tipo = maquina.id_tipo  where tipo_maquina.id_tipo=?1",nativeQuery = true)
	List<Maquina> filtrarTipo(int tipo);
	}

	@Query(value = "select * from maquina inner join tipo_maquina on tipo_maquina.id_tipo = maquina.id_tipo inner join " +
			"subcategoria on tipo_maquina.id_subcat = subcategoria.id_subcat where subcategoria.id_subcat=?1",nativeQuery = true)
	List<Maquina> filtrarSubcategoria(int subcat);

	@Query(value = "select * from maquina inner join tipo_maquina on tipo_maquina.id_tipo = maquina.id_tipo inner join subcategoria on\n" +
			"tipo_maquina.id_subcat = subcategoria.id_subcat inner join categoria on \n" +
			"categoria.id_cat = subcategoria.id_cat\n" +
			"where categoria.id_cat=?1",nativeQuery = true)
	List<Maquina> filtrarCategoria(int subcat);

	@Query(value = "select count(*) from maquina where id_prop = ?1", nativeQuery = true)
	int cantidadMaquinas(int prop);

}
