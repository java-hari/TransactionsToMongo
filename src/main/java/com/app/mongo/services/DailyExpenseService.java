package com.app.mongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.app.mongo.dao.DailyExpenseDao;
import com.app.mongo.entity.DailyExpense;


@Service
public class DailyExpenseService {

	@Autowired
	private DailyExpenseDao dailyExpenseDao;

	public Iterable<DailyExpense> findByItemName(String name) {
		return dailyExpenseDao.findByItemName(name);
	}

	public DailyExpense findFirstByOrderByIdFieldDesc() {
		return dailyExpenseDao.findFirstByOrderByIdFieldDesc();
	}

	public Optional<DailyExpense> findById(Integer id) {
		return dailyExpenseDao.findById(id);
	}

	public List<DailyExpense> findAll() {

		return dailyExpenseDao.findAll();
	}
	
	public void delete(DailyExpense monthlyExpenditure) {
		dailyExpenseDao.delete(monthlyExpenditure);
	}

	public DailyExpense save(DailyExpense monthlyExpenditure) {
		return dailyExpenseDao.save(monthlyExpenditure);
	}

	public DailyExpense update(DailyExpense monthlyExpenditure) {
		return dailyExpenseDao.save(monthlyExpenditure);
	}
	
	
	/*public Integer findMaxId() {
		return dailyExpenseDao.findMaxId();
	}*/
	public void deleteById(Integer id) {
		dailyExpenseDao.deleteById(id);
	}
	public List<DailyExpense> findAllByIdDesc() {
		return dailyExpenseDao.findAllByIdDesc();
	}

	public List<DailyExpense> getAllBySource() {
		
		
		return dailyExpenseDao.findAllByIdDesc();
	}
	
	public Page<DailyExpense> findAllByPageLimit(int start, int limit){
		return dailyExpenseDao.findAllByPageLimit(start, limit);
	}

	public Long findTotalCollection() {
		return dailyExpenseDao.findTotalCollection();
		
	}
	
	/*
	public DailyExpense getLatestBySource(String source) {
		return dailyExpenseDao.getLatestBySource(source);
	}

	
	public List<DailyExpense> getDataByDateRange(FilterData filterData) {
		
		return dailyExpenseDao.findDataByDateRange(filterData);
	}
	public List<DailyExpense> getSortedDataBySelectedItem(FilterData filterData) {
		
		return dailyExpenseDao.getSortedDataBySelectedItem(filterData);
	}
	public List<DailyExpense> getFilterdDataBySourceItem(FilterData filterData) {
		
		return dailyExpenseDao.getFilterdDataBySourceItem(filterData);
	}
	public List<DailyExpense> findAllExpenseByMonth() {
		
		List<DailyExpense> allExpenseByMonth = dailyExpenseDao.getAllExpenseByMonth();
		Map<String, DailyExpense>  mapList = new HashMap<String, DailyExpense>();
		for(DailyExpense de : allExpenseByMonth) {
			String ekey = de.getTransactionDate()+"-"+de.getTransactionType()+ "-"+de.getSource();
			System.out.println(de);
			if(de.getSource().equals("BOA-CA") && mapList.size() > 0 &&  mapList.containsKey(ekey)) {
				
					DailyExpense dailyExpense = mapList.get(ekey);
					de.setItemPrice(de.getItemPrice() + dailyExpense.getItemPrice());
					mapList.put(ekey, de);
				
			} else if(de.getSource().equals("BOA-CC") && mapList.size() > 0 &&  mapList.containsKey(ekey)) {
				DailyExpense dailyExpense = mapList.get(ekey);
				de.setItemPrice(de.getItemPrice() + dailyExpense.getItemPrice());
				mapList.put(ekey, de);
			} else if(de.getSource().equals("Chase-CC") && mapList.size() > 0 &&  mapList.containsKey(ekey)) {
				DailyExpense dailyExpense = mapList.get(ekey);
				double sum = de.getItemPrice() + dailyExpense.getItemPrice();
				de.setItemPrice(sum);
				mapList.put(ekey, de);
			} else {
				mapList.put(ekey, de);
			}
		}
		allExpenseByMonth = new ArrayList<DailyExpense>();
		for(DailyExpense dailyExpList : mapList.values()) {
			dailyExpList.setItemName(Month.of(Integer.parseInt(dailyExpList.getTransactionType()) ).toString());
			allExpenseByMonth.add(dailyExpList);
			
		}
		
		System.out.println(mapList);
		System.out.println(allExpenseByMonth);
		
		return allExpenseByMonth.stream().sorted(Comparator.comparing(DailyExpense :: getTransactionType).reversed()).collect(Collectors.toList());
	}
	*/
	
}
