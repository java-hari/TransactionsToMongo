package com.app.mongo.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.app.mongo.entity.MasterSource;
import com.app.mongo.entity.MonthlyExpenditure;

//public interface StockRepo extends CrudRepository<StockDetails, Integer> {

public interface MonthlyExpenseRepo extends MongoRepository<MonthlyExpenditure, Integer> {
	/*
	public Iterable<MonthlyExpenditure> findBySource(String name);
	
	@Query("select t from MonthlyExpenditure t where t.source=:source order by t.id desc")
	public List<MonthlyExpenditure> findLatestSource(@Param("source") String source);

	@Query("select t from MonthlyExpenditure t where t.id in (select max(t2.id) from MonthlyExpenditure t2 group by t2.source)")
	public List<MonthlyExpenditure> findSourceDetails();*/
}
