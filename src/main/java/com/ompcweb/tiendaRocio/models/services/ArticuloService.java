package com.ompcweb.tiendaRocio.models.services;

import java.util.List;

import com.ompcweb.tiendaRocio.models.entities.Articulo;

public interface ArticuloService {
	
	public List<Articulo> findAll();
	public void save(Articulo articulo);
	public Articulo findById(Long id);
	public void deleteById(Long id);

}
