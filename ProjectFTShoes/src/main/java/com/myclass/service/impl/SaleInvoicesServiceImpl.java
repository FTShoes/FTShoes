package com.myclass.service.impl;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.dto.SaleInvoicesDto;
import com.myclass.entity.SaleInvoice;
import com.myclass.repository.SaleInvoiceRepository;
import com.myclass.service.SaleInvoicesService;
@Service
public class SaleInvoicesServiceImpl implements SaleInvoicesService{

	@Autowired
	SaleInvoiceRepository saleInvoiceRepository;
	public List<SaleInvoice> getAll() {
		// TODO Auto-generated method stub
		return saleInvoiceRepository.findAll();
	}

	public boolean save(SaleInvoicesDto saleInvoicesDto) {
		Double TotalAll = saleInvoicesDto.getTotalInput()- saleInvoicesDto.getTotalMoney();
		
		SaleInvoice saleInvoice = new SaleInvoice(
			 saleInvoicesDto.getSale_id(), 
			 saleInvoicesDto.getEmployees_id(), 
			 saleInvoicesDto.getCustomer_id(),
			 saleInvoicesDto.getNameCustomer(),
			 saleInvoicesDto.getPhoneCustomer(),
			 saleInvoicesDto.getDayOutput(),
			 saleInvoicesDto.getTotalMoney(),
			 saleInvoicesDto.getTotalInput(),
			 TotalAll
			 ); 
		return saleInvoiceRepository.save(saleInvoice);
	}

}
