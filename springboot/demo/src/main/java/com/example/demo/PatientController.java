      package com.example.demo;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
                   
 import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
  import org.springframework.web.bind.annotation.RestController;     
  

  
  //@CrossOrigin(origins ="*")
     @CrossOrigin(origins = "http://localhost:4200")
     @RestController
         @RequestMapping("/api/v1/")                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
           public class PatientController {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
                   	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
    	@Autowired                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
   public PatientRepository patientRepository;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
                   	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
                   	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
  //get all patient                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
   	@GetMapping("/patients")                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
   	public List<Patient> getAllPatients(){                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
   return patientRepository.findAll(); 
  
   	}
                   	
  	//create patient rest api
   	
      	@PostMapping("/patients")
       public Patient createPatient(@RequestBody Patient patient) {
    System.out.println("Im working Im pos mapping");
      return patientRepository.save(patient);
          }
   	//get patient by id rest api
      	
   @GetMapping("/patients/{id}")
   	public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
	   System.out.println("I worked Im get by ID");
    Patient patient=patientRepository.findById(id)
   .orElseThrow(()->new ResourceNotFoundException ("Patient not exist with id:"+ id)); 
      return ResponseEntity.ok(patient);
                   	}
   
    // update patient rest api
   @PutMapping("/patients/{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patientDetails){
	   System.out.println("I m working put mapping ");
		Patient patient = patientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		patient.setFirstName(patientDetails.getFirstName());
		patient.setLastName(patientDetails.getLastName());
		patient.setAge(patientDetails.getAge());
		//patient.setAppointmentDate((String) patientDetails.getAppointmentDate());
		
		Patient updatedPatient = patientRepository.save(patient);
		return ResponseEntity.ok(updatedPatient);
	}
    
    //delete patient rest api
    
    @DeleteMapping("/patients/{id}")
      public ResponseEntity<Map<String, Boolean>> deletePatient(@PathVariable Long id){
      Patient patient = patientRepository.findById(id)
      .orElseThrow(() -> new ResourceNotFoundException("Patient not exist with id :" + id));
                		
    patientRepository.delete(patient);
    Map<String, Boolean> response = new HashMap<>();
     response.put("deleted", Boolean.TRUE);
     return ResponseEntity.ok(response);
          	}
          
     }