package com.example.service;

import com.example.entity.Role;
import com.example.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepo roleRepo;

    public List<Role> findAll() {
        return roleRepo.findAll();
    }

    public Role findBySubName(String subname) {
        return roleRepo.findBySubName(subname);
    }
}
