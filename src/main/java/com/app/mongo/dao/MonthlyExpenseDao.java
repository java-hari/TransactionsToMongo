package com.app.mongo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.app.mongo.entity.MasterSource;
import com.app.mongo.entity.MonthlyExpenditure;
import com.app.mongo.repo.MonthlyExpenseRepo;

@Repository
public class MonthlyExpenseDao {

	@Autowired
	private MonthlyExpenseRepo monthlyExpenditureRepo;

	/*public Iterable<MonthlyExpenditure> findByItemName(String name) {
		return monthlyExpenditureRepo.findBySource(name);

	}*/

	public Optional<MonthlyExpenditure> findById(Integer id) {
		return monthlyExpenditureRepo.findById(id);
	}

	public Page<MonthlyExpenditure> findAll() {
		Pageable pageable = PageRequest.of(0, 5);
		return monthlyExpenditureRepo.findAll(pageable);
	}

	public MonthlyExpenditure save(MonthlyExpenditure monthlyExpenditure) {
		return monthlyExpenditureRepo.save(monthlyExpenditure);
	}

	public MonthlyExpenditure update(MonthlyExpenditure monthlyExpenditure) {
		return monthlyExpenditureRepo.save(monthlyExpenditure);
	}

	public void delete(MonthlyExpenditure monthlyExpenditure) {
		monthlyExpenditureRepo.delete(monthlyExpenditure);
	}

	public void deleteById(Integer id) {
		monthlyExpenditureRepo.deleteById(id);
	}

	/*public MonthlyExpenditure findLatestSource(String source) {
		List<MonthlyExpenditure> findLatestSource = monthlyExpenditureRepo.findLatestSource(source);
		if (!findLatestSource.isEmpty())
			return findLatestSource.get(0);
		else
			return null;
	}

	public List<MonthlyExpenditure> findAllAvailableSourceDetails() {
		return monthlyExpenditureRepo.findSourceDetails();
	}*/
}
