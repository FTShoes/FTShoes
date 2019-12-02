package com.myclass.repository;

import java.util.List;

import com.myclass.entity.DetailInvoices;

public interface DetailInvoicesRepository {
	
	List<DetailInvoices> findAll();
	
	List<DetailInvoices> findBySaleId(String sale_id);

	boolean saveOrUpdate(DetailInvoices detailInvoices);

	boolean removeBySaleId(String sale_id);
}
