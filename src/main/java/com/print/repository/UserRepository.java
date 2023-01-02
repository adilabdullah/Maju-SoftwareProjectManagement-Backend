package com.print.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.print.model.FileUpload;
import com.print.model.Users;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<Users,Integer>{

	@Query("SELECT COUNT(*) from Users"+ 
			" where pass=:password" + 
			" and (username=:username or email=:username)")
	         int checkUser(@Param("username") String username,
	        		 @Param("password") String password);
}
