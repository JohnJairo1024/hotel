package com.example.service;

import com.example.entity.Faq;
import com.example.repo.FaqRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaqService {

    @Autowired
    private FaqRepo faqRepo;

    public FaqService(FaqRepo faqRepo) {
        this.faqRepo = faqRepo;
    }

    public Faq findById(long id) {
        return faqRepo.findOne(id);
    }

    public void saveFaq(Faq faq) {
        faqRepo.save(faq);
    }

    public void changeRate(Faq faq) {
        faq.setRate(faq.getRate() + 1);
        faqRepo.save(faq);
    }

    public List<Faq> findAll() {
        return faqRepo.findAll();
    }
}
