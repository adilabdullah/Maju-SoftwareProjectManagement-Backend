package com.print.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.print.model.Quotation;

@Repository
public interface QuotationRepo extends JpaRepository<Quotation,Integer>{

}
