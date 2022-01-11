package com.cg.movie.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.movie.entities.Show;

public interface IAdminShowDao extends JpaRepository<Show, Integer>{

}
