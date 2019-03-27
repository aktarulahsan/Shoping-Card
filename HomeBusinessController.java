package com.mysoft.auth.homebusiness;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysoft.core.util.Response;

/**
 * created aktar
 *
 */


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/homebusiness")
public class HomeBusinessController {
	
	@Autowired
	HomeBusinessService homeBusinessService;

	@PostMapping("/save")
	public Response save(@RequestBody String reqObj) {
		return homeBusinessService.save(reqObj);
	}

	@PutMapping("/update")
	public Response update(@RequestBody String reqObj) {
		return homeBusinessService.update(reqObj);
	}
	
	@PostMapping("/delete")
	public Response delete(@RequestBody Long id) {
		return homeBusinessService.delete(id);
	}

	@PostMapping("/list")
	public Response getAll(@RequestBody(required = false) String reqObj) {
		return homeBusinessService.list(reqObj);
	}
}
