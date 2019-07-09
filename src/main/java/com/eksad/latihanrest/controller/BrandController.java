package com.eksad.latihanrest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eksad.latihanrest.dao.BrandDao;
import com.eksad.latihanrest.model.Brand;

@RestController
@RequestMapping("brand")
public class BrandController {

	@Autowired
	BrandDao  brandDao;
	
	@RequestMapping("getAll")
	public List<Brand> getAll() {
		List<Brand> result = new ArrayList<Brand>();
				
		brandDao.findAll().forEach(result::add);
		
		return result;
	}
	
	@RequestMapping("getOne/{id}")
	public Brand getOne(@PathVariable Long id) {
		return brandDao.findById(id).orElse(null);
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(@RequestBody Brand brand) {
		try {
			brandDao.save(brand);
			return "berhasil tersimpan";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "gagal disimpan";
		}
	}
	
	
	@RequestMapping(value ="update/{id}",method = RequestMethod.PUT)
	public String update(@RequestBody Brand brand,@PathVariable Long id) {
		Brand brandSelected = brandDao.findById(id).orElse(null);
		
		if(brandSelected != null) {
			brandSelected.setName(brand.getName());
			brandSelected.setProductType(brand.getProductType());
			
			brandDao.save(brandSelected);
			return "berhasil memperbaharui";
		}else {
			return "gagal memperbaharui";
		}
	}
	
	@RequestMapping(value ="delete/{id}", method = RequestMethod.DELETE)
	public HashMap<String, Object> delete(@PathVariable Long id){
		HashMap<String, Object> result = new HashMap<String, Object>();
		brandDao.deleteById(id);
		result.put("message","Berhasil di hapus");
		return result;
	}
}
