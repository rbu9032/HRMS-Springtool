package com.hr.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hr.project.entity.Learner;
import com.hr.project.repository.LearnerRepository;




@RequestMapping("api/")
@CrossOrigin(origins="http://localhost:4200/")
@RestController
public class LearnerController {
	

	@Autowired
	LearnerRepository repo;
	
	@GetMapping("learner")
	public List<Learner> getAllLearners(){
		return repo.findAll();
	}
	
	
	@PostMapping("save")
	public String storeData(@RequestBody Learner learner) {
		repo.save(learner);
		return "success";
	}
	
	
	@PutMapping("update")
	public String updateData(@RequestBody Learner learner) {
		//repo.save(learner);
		repo.updateLearnerByLid(learner.getSalary(), learner.getMobile());
		return "success";
	}
	/*@PutMapping("update/{mb}")
	public String updateData(@PathVariable(value="mb") long mb, @RequestBody Learner learner) {
	 Learner lrn = repo.findByMobile(mb);
	 lrn.setDomain(learner.getDomain());
	 lrn.setSalary(learner.getSalary());
	 final Learner updateData=repo.save(lrn);
	 return "success";
	}*/
	
	@DeleteMapping("removelearner/{phn}")
	public List<Learner> deleteData(@PathVariable("phn")  long phn) {
		repo.deleteLearnerByMobile(phn);
		return repo.findAll();
	}
	@GetMapping("msg")
	public String getMsg() {
		return "Hello world";
	}
	/*@GetMapping("getlearner/{pn}")
	public Learner getLearnerByMobile(
	        @PathVariable(value = "pn") long pn)
	    {
	        return repo.findByMobile(pn);
	    }
	@GetMapping("getlearner/{nme}")
	public List<Learner> getLearnerByName(@PathVariable(value="nme") String nme){
	return  repo.findByEmail(eml);
	}*/
	/*@GetMapping("getlearner/{eml}")
	public List<Learner> getLearnersByEmail(@PathVariable(value="eml") String eml){
		System.out.println(eml);
		return repo.findByEmail(eml);
	}*/
	@GetMapping("getlearner/{eml}")
		public List<Learner> getLearnerByEmail(@PathVariable(value="eml") String eml){
		return repo.findByEmail(eml);
	}
}
