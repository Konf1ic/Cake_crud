package com.example.chungcake_db.repository;

import com.example.chungcake_db.model.Chung;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChungRepository extends CrudRepository<Chung, Integer> {
    public List<Chung> findChungByDetailsContaining(String keyword);
}
