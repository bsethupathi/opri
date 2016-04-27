package com.oprisk.services;

import com.oprisk.dto.Issue;

public interface IssueServices {

	public Issue getIssueById(long id);
	
	public Issue saveOrupdateIssue(Issue issueDTO);


	
}
