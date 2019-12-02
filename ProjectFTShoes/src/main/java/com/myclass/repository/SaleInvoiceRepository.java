package com.myclass.repository;

import java.util.List;

import com.myclass.entity.SaleInvoice;


public interface SaleInvoiceRepository {
	List<SaleInvoice> findAll();
	SaleInvoice findById(String id);
	boolean save( SaleInvoice saleInvoice);
	boolean removeById(String id);
}
