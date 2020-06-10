package com.shared.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emart.exception.StockEXConstants;
import com.emart.exception.StockRequestException;
import com.shared.entity.SellerEntity;
import com.shared.service.SellerService;

@RestController
@RequestMapping("/api/seller")
//@CrossOrigin(origins="http://localhost:4200")
public class SellerController {
	@Autowired
	private SellerService sellerService;
	
	/**
	 * @return
	 */
	@GetMapping
	public List<SellerEntity> findAllSeller(){		
		return sellerService.findAllSeller();
	}
	// This is seller register
	@PostMapping(value="/register")
	//public ResponseEntity<SellerEntity> regist(SellerEntity seller){
	//	SellerEntity sellerEntity = sellerService.registSeller(seller);
	//	return ResponseEntity.status(HttpStatus.CREATED).body(sellerEntity); 
	//}
	public ResponseEntity<SellerEntity> regist(@RequestBody @Valid SellerEntity seller, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			throw new StockRequestException(StockEXConstants.ERROR_REQUEST_PARAM, bindingResult);
		}
		
		SellerEntity existedSeller = sellerService.findByUserName(seller.getUserName());
		if(existedSeller != null){
			bindingResult.rejectValue("sellerName", "400001", "the user name is existed.");
			throw new StockRequestException(StockEXConstants.ERROR_REQUEST_PARAM, bindingResult);
		}
		SellerEntity sellerEntity = sellerService.registSeller(seller);
		return ResponseEntity.status(HttpStatus.CREATED).body(sellerEntity); 
	}
	
	
	
	
	
}
