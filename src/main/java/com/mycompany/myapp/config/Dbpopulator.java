package com.mycompany.myapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class Dbpopulator {

	    private final JdbcTemplate jdbcTemplate;

	    @Autowired
	    public Dbpopulator(JdbcTemplate jdbcTemplate) {
	        this.jdbcTemplate = jdbcTemplate;
	    }

	    public void doCreateTable() {
	    	jdbcTemplate.execute("create table mytable (id integer, name varchar(100))");
	    }
	    
	    public void doInsert() {
	    	jdbcTemplate.update("insert into mytable (id, name) values (?, ?)",
	            "1", "Panos");
	    	jdbcTemplate.update("insert into mytable (id, name) values (?, ?)",
		            "2", "Chris");

	}
}