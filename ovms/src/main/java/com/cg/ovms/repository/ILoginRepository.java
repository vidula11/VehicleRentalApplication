package com.cg.ovms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ovms.entities.Login;

//import com.cg.ovms.entity.Login;

/*
 * Created By Titas Sarkar
 */
@Repository
public interface ILoginRepository extends JpaRepository<Login, Integer> {

}
