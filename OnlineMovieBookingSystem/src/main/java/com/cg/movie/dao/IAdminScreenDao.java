package com.cg.movie.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.movie.entities.Screens;

public interface IAdminScreenDao extends JpaRepository<Screens, Integer>{

}
