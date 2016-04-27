package com.oprisk.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import com.oprisk.dto.Issue;
import com.oprisk.services.IssueServices; 

@Controller  
public class IssueController {
	
	@Autowired
	IssueServices issueServices;
	
	@RequestMapping(value="/getIssue/{issueId}", method = RequestMethod.GET)
	@ResponseBody public ResponseEntity<Issue> getIssueById(@PathVariable long issueId) {
		Issue issue = issueServices.getIssueById(issueId);
	        if(issue == null){
	            return new ResponseEntity<Issue>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<Issue>(issue, HttpStatus.OK);
    }
}
