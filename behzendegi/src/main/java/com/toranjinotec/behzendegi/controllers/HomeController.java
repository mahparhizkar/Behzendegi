package com.toranjinotec.behzendegi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toranjinotec.behzendegi.common_module.responses.HomeResponse;
import com.toranjinotec.behzendegi.persistent_manager.model.EtUsers;
import com.toranjinotec.behzendegi.persistent_manager.repos.IUserRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/Home/")
@CrossOrigin
@Api("Home Controller: Common User Actions")
public class HomeController {
	@Autowired
	private IUserRepository userRepository;
	
	
	@ApiOperation(value = "Return single user",response = EtUsers.class)
	@GetMapping(path = "get/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<EtUsers> getUser(@ApiParam("String of Username") @PathVariable String userId) {
		return Mono.just(userRepository.findById(userId).get());
	}
	
	
	@PostMapping(path = "create", produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Create new User",response = HomeResponse.class)
	@ApiResponses({
		@ApiResponse(code = 200,message = "OK Message"),
		@ApiResponse(code = 201,message = "Not-OK Message")
	})
	public Mono<HomeResponse> createUser(@RequestBody EtUsers user) {
		
		EtUsers puser = userRepository.save(user);
		
		return Mono.just(new HomeResponse("OK- User: "+puser.getUserId()+" is Ready",200));
	}

}
