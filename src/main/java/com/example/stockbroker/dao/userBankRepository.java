package com.example.stockbroker.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface userBankRepository extends JpaRepository<bankdetails,Long> {
    List<bankdetails> findBankDetailsByEmail(String email);
}
