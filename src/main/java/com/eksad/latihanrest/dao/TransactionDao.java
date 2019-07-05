package com.eksad.latihanrest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.eksad.latihanrest.model.Transaction;

public interface TransactionDao extends CrudRepository <Transaction, Long> {
	
	@Query("Select sum(quantity) from TransactionDetail where"
			+ " product.id = ?1")
	public Integer findTotalItemByTransactionId(Long id);
	
	@Query("Select td.transaction.id as transactionId, SUM(td.quantity * pr.price) as total "
			+ "from TransactionDetail td "
			+ "join td.product pr "
			+ "group by td.transaction.id")
	public List<Object[]> findTotalNominalPerTransaction();
}
