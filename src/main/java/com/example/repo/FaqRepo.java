package com.example.repo;

import com.example.entity.Faq;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaqRepo extends JpaRepository<Faq, Long> {


}
