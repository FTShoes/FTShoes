package com.myclass.service;

import java.util.List;

import com.myclass.dto.DetailInvoiceDto;
import com.myclass.entity.DetailInvoices;

public interface DetailInvoicesService {
	
	List<DetailInvoices> getAll();
	
	List<DetailInvoices> findBySaleId(String sale_id);

	boolean Update(String sale_id, DetailInvoiceDto detailInvoices);

	boolean removeBySaleId(String sale_id);
}
