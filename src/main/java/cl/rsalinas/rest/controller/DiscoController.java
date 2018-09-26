package cl.rsalinas.rest.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import cl.rsalinas.mongolico.models.Disco;
import cl.rsalinas.mongolico.repositories.DiscoRepository;

@Controller
public class DiscoController {
	
	@Autowired
	private DiscoRepository repository;

    //http://localhost:8083/disco/all
    @GetMapping("/disco/all")
    @ResponseBody
    public List<Disco> getAllDiscos() {
	    return repository.findAll();
	  }
    
    
    //http://localhost:8083/disco/name?name=5babf44bd99f116e4b945f0d
    @GetMapping("/disco/name")
    @ResponseBody
    public Disco getDiscoName(@RequestParam(name="name", required=false, defaultValue="5babeb7bd99f116e4b945efc") ObjectId name) {
    	return repository.findBy_id(name);
    }
    
}
