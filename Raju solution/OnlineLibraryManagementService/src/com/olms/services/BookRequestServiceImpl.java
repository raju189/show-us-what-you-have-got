package com.olms.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.olms.models.RequestForBook;
import com.olms.models.RequestStatus;

public class BookRequestServiceImpl implements BookRequestService {

	private List<RequestForBook> requestForBookRepo = new ArrayList<>();

	@Override
	public List<RequestForBook> allBookRequests() {
		return requestForBookRepo.stream().filter(rb -> rb.getStatus() == RequestStatus.Pending)
				.collect(Collectors.toList());
	}

}
