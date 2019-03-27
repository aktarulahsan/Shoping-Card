package com.mysoft.auth.homebusiness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysoft.core.util.Response;

@Service
public class HomeBusinessService {
	@Autowired
	HomeBusinessRepository homeBusinessRepository;
	
	public Response save(String referal) {
		return homeBusinessRepository.save(referal);
	}
	
	
	public Response list(String reqObj) {
		
		return homeBusinessRepository.baseList(reqObj);
	}
	
	public List<HomeBusinessRepository> findByUserId(Long userId){
		return homeBusinessRepository.findByUserId(userId);
		
	}
	
	public Response update(String reqObj) {

		return homeBusinessRepository.update(reqObj);
	}

	public Response delete(Long id) {
		return homeBusinessRepository.delete(id);
	}

	

}
