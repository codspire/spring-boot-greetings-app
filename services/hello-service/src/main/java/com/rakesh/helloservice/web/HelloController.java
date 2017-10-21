package com.rakesh.helloservice.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rakesh.helloservice.HelloService;
import com.rakesh.helloservice.domain.Greeting;

@RestController
@RequestMapping(value = "/greeting/v1/hello")
public class HelloController {

	@Autowired
	private HelloService helloService;

	@RequestMapping(value = "", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseStatus(HttpStatus.OK)
	// @ApiOperation(value = "Get a paginated list of all hotels.", notes = "The
	// list is paginated. You can provide a page number (default 0) and a page size
	// (default 100)")
	public @ResponseBody Greeting getDefaultGreeting(
			// @ApiParam(value = "The page number (zero-based)", required = true)
			// @RequestParam(value = "page", required = true, defaultValue =
			// DEFAULT_PAGE_NUM) Integer page,
			// @ApiParam(value = "Tha page size", required = true) @RequestParam(value =
			// "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
			HttpServletRequest request, HttpServletResponse response) {
		return this.helloService.getGreeting(null);
	}

	@RequestMapping(value = "/{subject}", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseStatus(HttpStatus.OK)
	// @ApiOperation(value = "Get a single hotel.", notes = "You have to provide a
	// valid hotel ID.")
	public @ResponseBody Greeting getGreeting(
			// @ApiParam(value = "The ID of the hotel.", required = true)
			@PathVariable("subject") String subject, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return this.helloService.getGreeting(subject);
	}
}
