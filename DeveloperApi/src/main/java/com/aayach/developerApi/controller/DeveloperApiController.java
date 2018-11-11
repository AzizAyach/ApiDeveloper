package com.aayach.developerApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aayach.developerApi.model.Developer;
import com.aayach.developerApi.model.Language;
import com.aayach.developerApi.service.DeveloperService;
import com.aayach.developerApi.service.LanguageService;
import com.aayach.developerApi.utility.Constants;


@RestController
public class DeveloperApiController {

	   @Autowired
	   private DeveloperService developerService;
	   
	   @Autowired
	   private LanguageService languageService;

	   /**
	    * Add new developer 
	    * 
	    * @param developer
	    * 
	    * @return ResponseEntity
	    * **/
	   @PostMapping("/developer")
	   public ResponseEntity<?> saveDeveloper(@RequestBody Developer developer) {
	      long id = developerService.saveDeveloper(developer);
	      return ResponseEntity.ok().body( Constants.SUCCESS_SAVE_MESSAGE + id);
	   }

	   /**
	    * Get developer by id
	    * 
	    * @param id
	    * 
	    * @return ResponseEntity
	    * **/
	   @GetMapping("/developer/{id}")
	   public ResponseEntity<Developer> getDeveloperbyId(@PathVariable("id") long id) {
		   Developer developer = developerService.getDeveloperbyId(id);
	      return ResponseEntity.ok().body(developer);
	   }

	   /**
	    * Get all developer
	    * 
	    * 
	    * @return ResponseEntity
	    * **/
	   @GetMapping("/developer")
	   public ResponseEntity<List<Developer>> getAllDeveloper() {
	      List<Developer> listDeveloper = developerService.getAllDeveloper();
	      return ResponseEntity.ok().body(listDeveloper);
	   }

	   /**
	    * Update developer using id 
	    * 
	    * @param id
	    * 
	    * @return ResponseEntity
	    * **/
	   @PutMapping("/developer/{id}")
	   public ResponseEntity<?> updateDeveloper(@PathVariable("id") long id, @RequestBody Developer developer) {
		   developerService.updateDeveloper(id, developer);
	      return ResponseEntity.ok().body(Constants.SUCCESS_UPDATE_MESSAGE);
	   }

	   /**
	    * Delete developer using id 
	    * 
	    * @param id
	    * 
	    * @return ResponseEntity
	    * **/
	   @DeleteMapping("/developer/{id}")
	   public ResponseEntity<?> deleteDeveloper(@PathVariable("id") long id) {
		   developerService.deleteDeveloper(id);
	      return ResponseEntity.ok().body(Constants.SUCCESS_DELETE_MESSAGE);
	   }
	   
	   /**
	    * Add new language 
	    * 
	    * @param language 
	    * 
	    * @return ResponseEntity
	    * **/
	   @PostMapping("/language")
	   public ResponseEntity<?> saveLanguage(@RequestBody Language language) {
	      String name = languageService.saveLanguage(language);
	      return ResponseEntity.ok().body( Constants.SUCCESS_SAVE_MESSAGE+ name);
	   }

	   /**
	    * Delete language using name 
	    * 
	    * @param name
	    * 
	    * @return ResponseEntity
	    * **/
	   @DeleteMapping("/language/{name}")
	   public ResponseEntity<?> deleteDeveloper(@PathVariable("name") String name) {
		   languageService.deleteLanguage(name);
	      return ResponseEntity.ok().body(Constants.SUCCESS_DELETE_MESSAGE);
	   }
	

}
