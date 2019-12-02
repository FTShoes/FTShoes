package com.myclass.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.dto.DetailInvoiceDto;
import com.myclass.entity.DetailInvoices;
import com.myclass.repository.DetailInvoicesRepository;
import com.myclass.service.DetailInvoicesService;

@Service
public class DetailInvoicesServiceImpl implements DetailInvoicesService{

	@Autowired
	private DetailInvoicesRepository detailInvoicesRepository;
	
	public List<DetailInvoices> getAll() {
		return detailInvoicesRepository.findAll();
	}
	
	public List<DetailInvoices> findBySaleId(String sale_id) {
		return detailInvoicesRepository.findBySaleId(sale_id);
	}

	public boolean Update(String sale_id , DetailInvoiceDto detailInvoicesDto) {
		
		DetailInvoices detailInvoices = (DetailInvoices) detailInvoicesRepository.findBySaleId(sale_id);
		if(detailInvoices == null) {
			return false;
		}
		
		detailInvoices.setAmount(detailInvoicesDto.getAmount());
		detailInvoices.setTotal(detailInvoicesDto.getTotal());
		
		return detailInvoicesRepository.saveOrUpdate(detailInvoices);
	}

	public boolean removeBySaleId(String sale_id) {
		return detailInvoicesRepository.removeBySaleId(sale_id);
	}


}
