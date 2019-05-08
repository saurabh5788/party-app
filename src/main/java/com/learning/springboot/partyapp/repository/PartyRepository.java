package com.learning.springboot.partyapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learning.springboot.partyapp.entity.PartyEntity;

@Repository
public interface PartyRepository extends CrudRepository<PartyEntity, Long> {
 
    /*public List<PartyEntity> findById(Integer id);
 
    @Query("SELECT e FROM PARTY p WHERE p.email = :email")
    public List findByEmail(@Param("email") String email);*/
 
}