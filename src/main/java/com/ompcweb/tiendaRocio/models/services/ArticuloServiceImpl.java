package com.ompcweb.tiendaRocio.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ompcweb.tiendaRocio.models.daos.ArticuloDao;
import com.ompcweb.tiendaRocio.models.entities.Articulo;

@Service
public class ArticuloServiceImpl implements ArticuloService {
	
	@Autowired
	private ArticuloDao articuloDao;

	@Override
	@Transactional(readOnly = true)
	public List<Articulo> findAll() {
		return articuloDao.findAll();
	}

	@Override
	@Transactional
	public void save(Articulo articulo) {
		articuloDao.save(articulo);
	}

	@Override
	@Transactional(readOnly = true)
	public Articulo findById(Long id) {
		return articuloDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		articuloDao.deleteById(id);
	}

}
