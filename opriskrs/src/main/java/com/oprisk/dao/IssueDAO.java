package com.oprisk.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oprisk.dmo.IssueDMO;
public interface IssueDAO extends JpaRepository<IssueDMO, Long>
{
	
}
