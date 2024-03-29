package rental.me.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rental.me.model.Maquina;

import java.util.List;

@Repository
public interface RepositorioMaquina extends CrudRepository<Maquina, Integer> {

	Maquina findById (int id_maq);

	@Query(value = "select * from maquina inner join tipo_maquina on tipo_maquina.id_tipo = maquina.id_tipo  where tipo_maquina.id_tipo=?1 and maquina.disponible = true",nativeQuery = true)
	List<Maquina> filtrarTipo(int tipo);


	@Query(value = "select * from maquina inner join tipo_maquina on tipo_maquina.id_tipo = maquina.id_tipo inner join " +
			"subcategoria on tipo_maquina.id_subcat = subcategoria.id_subcat where subcategoria.id_subcat=?1 and maquina.disponible = true",nativeQuery = true)
	List<Maquina> filtrarSubcategoria(int subcat);

	@Query(value = "select * from maquina inner join tipo_maquina on tipo_maquina.id_tipo = maquina.id_tipo inner join subcategoria on\n" +
			"tipo_maquina.id_subcat = subcategoria.id_subcat inner join categoria on \n" +
			"categoria.id_cat = subcategoria.id_cat\n" +
			"where categoria.id_cat=?1 and maquina.disponible",nativeQuery = true)
	List<Maquina> filtrarCategoria(int subcat);

	@Query(value = "select count(*) from maquina where id_prop = ?1", nativeQuery = true)
	int cantidadMaquinas(int prop);

	@Query(value = "select * from maquina where id_prop = ?1", nativeQuery = true)
	List<Maquina> maquinasDeUsuario(int id);

	@Query(value = "select * from maquina where id_man = ?1 and disponible = true", nativeQuery = true)
	List<Maquina> maquinasManufacturador(int id);

	@Query(value = "select * from maquina where ubicacion = ?1 and disponible = true", nativeQuery = true)
	List<Maquina> maquinaCiudad(int id);
	@Query(value = "select * from maquina inner join ciudad on ciudad.id_ciudad = maquina.ubicacion where ciudad.id_dep = ?1 and maquina.disponible = true", nativeQuery = true)
	List<Maquina> maquinaDept(int id);

	@Query(value="select * from maquina inner join tipo_maquina on tipo_maquina.id_tipo = maquina.id_tipo inner join subcategoria on \n" +
			"tipo_maquina.id_subcat = subcategoria.id_subcat inner join categoria on \n" +
			"categoria.id_cat = subcategoria.id_cat \n" +
			"where categoria.id_cat =:categoria_id " +
			"and maquina.ubicacion =:ciudad_id " +
			"and maquina.id_man =:manofacturador_id and maquina.disponible = true" ,nativeQuery = true)
	List<Maquina> maquinaDinamica( int ciudad_id,int categoria_id,int manofacturador_id);

	@Query(value="select * from maquina inner join tipo_maquina on tipo_maquina.id_tipo = maquina.id_tipo inner join subcategoria on \n" +
			"tipo_maquina.id_subcat = subcategoria.id_subcat inner join categoria on \n" +
			"categoria.id_cat = subcategoria.id_cat \n" +
			"where categoria.id_cat =:categoria_id \n" +
			"and maquina.ubicacion =:ciudad_id and maquina.disponible = true",nativeQuery = true)
	List<Maquina> maquinaCuidadCategoria(int ciudad_id,int categoria_id);

	@Query(value="select * from maquina inner join tipo_maquina on tipo_maquina.id_tipo = maquina.id_tipo inner join subcategoria on \n" +
			"tipo_maquina.id_subcat = subcategoria.id_subcat inner join categoria on \n" +
			"categoria.id_cat = subcategoria.id_cat \n" +
			"where maquina.id_man =:manofacturador_id \n" +
			"and maquina.ubicacion =:ciudad_id and maquina.disponible = true",nativeQuery = true)
	List<Maquina> maquinaCuidadManofacturador(int ciudad_id,int manofacturador_id);

	@Query(value="select * from maquina inner join tipo_maquina on tipo_maquina.id_tipo = maquina.id_tipo inner join subcategoria on \n" +
			"tipo_maquina.id_subcat = subcategoria.id_subcat inner join categoria on \n" +
			"categoria.id_cat = subcategoria.id_cat \n" +
			"where maquina.id_man =:manofacturador_id \n" +
			"and categoria.id_cat =:categoria_id and maquina.disponible = true",nativeQuery = true)
	List<Maquina> maquinaCategoriaManofacturador(int categoria_id,int manofacturador_id);

}
