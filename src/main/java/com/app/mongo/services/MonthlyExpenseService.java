package com.app.mongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.app.mongo.dao.MonthlyExpenseDao;
import com.app.mongo.entity.DailyExpense;
import com.app.mongo.entity.MasterSource;
import com.app.mongo.entity.MonthlyExpenditure;

@Service
public class MonthlyExpenseService {

	@Autowired
	private MonthlyExpenseDao monthlyExpenseDao;

	@Autowired
	PaginationService paginationService;

	

	public Optional<MonthlyExpenditure> findById(Integer id) {
		return monthlyExpenseDao.findById(id);
	}

	public Page<MonthlyExpenditure> findAll() {

		return monthlyExpenseDao.findAll();
	}

	public MonthlyExpenditure save(MonthlyExpenditure monthlyExpenditure) {
		return monthlyExpenseDao.save(monthlyExpenditure);
	}

	public MonthlyExpenditure update(MonthlyExpenditure monthlyExpenditure) {
		return monthlyExpenseDao.save(monthlyExpenditure);
	}

	public void delete(MonthlyExpenditure monthlyExpenditure) {
		monthlyExpenseDao.delete(monthlyExpenditure);
	}

	public void deleteById(Integer id) {
		monthlyExpenseDao.deleteById(id);
	}
	
	/*public Iterable<MonthlyExpenditure> findByItemName(String name) {
		return monthlyExpenseDao.findByItemName(name);
	}
	public MonthlyExpenditure getLatestSource(DailyExpense dailyExpense) {
		MonthlyExpenditure findLatestSource = monthlyExpenseDao.findLatestSource(dailyExpense.getSource());

		double availableAmt = 0.00;
		double totalAmt = 0.00;
		if (findLatestSource != null) {
			if (dailyExpense.getTransactionType().equals("CR")) {
				availableAmt = findLatestSource.getAvailable() + Math.abs(dailyExpense.getItemPrice());
				totalAmt = findLatestSource.getTotalAmt() - Math.abs(dailyExpense.getItemPrice());
			} else {
				availableAmt = findLatestSource.getAvailable() - dailyExpense.getItemPrice();
				totalAmt = findLatestSource.getTotalAmt() + dailyExpense.getItemPrice();
			}
		} else {
			if (dailyExpense.getTransactionType().equals("CR")) {
				availableAmt = dailyExpense.getItemPrice();
				// totalAmt = dailyExpense.getItemPrice();
			} else {
				// totalAmt = dailyExpense.getItemPrice();
				availableAmt = -dailyExpense.getItemPrice();
			}
		}
		MonthlyExpenditure me = new MonthlyExpenditure();
		me.setAvailable(availableAmt);
		me.setExpense(dailyExpense.getItemPrice());
		me.setSource(dailyExpense.getSource());
		me.setTotalAmt(totalAmt);
		if (dailyExpense.getTransactionDate().isEmpty()) {
			me.setTransactionDate(paginationService.getSystemDateTime());
			// me.setTransactionDate(new Date());
		} else {
			me.setTransactionDate(dailyExpense.getTransactionDate());
		}

		return me;

	}

	public List<MonthlyExpenditure> findAllAvailableSource() {
		return monthlyExpenseDao.findAllAvailableSourceDetails();
	}*/
}
