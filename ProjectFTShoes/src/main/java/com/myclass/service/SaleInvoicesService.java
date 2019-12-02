package com.myclass.service;

import java.util.List;

import com.myclass.dto.SaleInvoicesDto;
import com.myclass.entity.SaleInvoice;

public interface SaleInvoicesService {
	
	List<SaleInvoice> getAll();
	boolean save(SaleInvoicesDto saleInvoicesDto);
	
}
