package com.oshana.api.repository;

import com.oshana.api.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordsRepository extends JpaRepository<Word, Long>  {
    Word findByWord(String word);
}

