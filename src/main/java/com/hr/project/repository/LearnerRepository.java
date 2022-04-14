package com.hr.project.repository;



import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hr.project.entity.Learner;



@Repository
public interface LearnerRepository extends CrudRepository<Learner, Integer> {
	
	
	List<Learner> findAll();
	@Transactional
	@Modifying(flushAutomatically = true)
	@Query(value = "update Learner l set l.salary=:sal where l.mobile=:mbl", nativeQuery = true)
    public int updateLearnerByLid(@Param(value = "sal") double sal,@Param(value="mbl") long mbl); 
	@Transactional
	@Modifying(flushAutomatically = true)
	@Query(value = "delete Learner l where l.mobile=:mbl", nativeQuery=true)
	public int deleteLearnerByMobile(@Param(value="mbl") long mbl);
 
	@Query(value="select * From Learner l where l.email=?1", nativeQuery=true)
	List<Learner> findByEmail(String email);
	
	
   // Learner findByMobile(long mb);
	
	
}
