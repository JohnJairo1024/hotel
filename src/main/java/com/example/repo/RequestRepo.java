package com.example.repo;

import com.example.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepo extends JpaRepository<Request, Long> {

    List<Request> findAllByChecked(boolean check);

}
