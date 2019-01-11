package com.example.repo;

import com.example.entity.Localization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocalizationRepo extends JpaRepository<Localization, Long> {


    /**
     * Gives list of cities where rooms are located without repetitions.
     *
     * @return
     */
    @Query(value = "select distinct city from localization", nativeQuery = true)
    List<String> findAllCities();
}
