package com.example.repo;


import com.example.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepo extends JpaRepository<Image, Long> {

    Image findOneByUserId(long id);

    Image findOneById(long id);

}
