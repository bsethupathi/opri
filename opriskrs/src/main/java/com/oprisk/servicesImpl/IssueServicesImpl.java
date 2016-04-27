package com.oprisk.servicesImpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.oprisk.dao.IssueDAO;
import com.oprisk.dmo.IssueDMO;
import com.oprisk.dto.Issue;
import com.oprisk.services.IssueServices;

public class IssueServicesImpl implements IssueServices{

	@Autowired 
	private IssueDAO issueDAO;
	public Issue getIssueById(long id) {
		IssueDMO issueDMO = issueDAO.findOne(id);
		Issue issue = new Issue();
		issue.setDescription(issueDMO.getIssueName());
		issue.setId(issueDMO.getId());
		// TODO Auto-generated method stub
		return issue;
	}
	@Override
	public Issue saveOrupdateIssue(Issue issueDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
