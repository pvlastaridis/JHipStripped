package com.mycompany.myapp.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloResource {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public HelloResource(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * GET /activate -> activate the registered user.
	 */
	@RequestMapping(value = "/hello/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> hello(@PathVariable int id) {
		String name = null;
		try {
			name = this.jdbcTemplate.queryForObject(
					"select name from mytable where id = ?",
					new Object[] { id }, String.class);
		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<String>("Hello " + name, HttpStatus.OK);
	}
}
