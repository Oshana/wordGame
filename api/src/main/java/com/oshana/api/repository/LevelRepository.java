package com.oshana.api.repository;

import com.oshana.api.entity.Level;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelRepository extends JpaRepository<Level, Integer> {
   Level findByLevelNo(int levelNo);
}
