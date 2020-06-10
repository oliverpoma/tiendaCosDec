package com.ompcweb.tiendaRocio.models.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ompcweb.tiendaRocio.models.entities.Articulo;

public interface ArticuloDao extends JpaRepository<Articulo, Long>{
	
}
