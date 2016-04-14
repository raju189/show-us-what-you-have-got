package com.olms.services;

import java.util.List;

import com.olms.models.ApprovedRequest;
import com.olms.models.User;

public interface ApprovedRequestService {

	public List<ApprovedRequest> allApprovedRequests();

	public List<ApprovedRequest> allApprovedRequestsByMember(User user);

	public List<ApprovedRequest> allApprovedRequestsByLibrarian(User user);
	
	public List<ApprovedRequest> allApprovedRequestsByDueDate();
}
