package com.cg.movie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.movie.entities.Screens;
@Repository
public interface IScreenDao extends JpaRepository<Screens, Integer>{

}
