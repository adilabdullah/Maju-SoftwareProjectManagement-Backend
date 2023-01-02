package com.print.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import com.print.model.Quotation;
import com.print.model.UserContact;

@Repository
public interface UserContactRepo extends JpaRepository<UserContact,Integer>{

}
