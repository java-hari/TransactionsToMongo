package com.app.mongo.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.mongo.entity.DailyExpense;
import com.app.mongo.entity.FilterData;

@Service
public class PaginationService {

	@Autowired
	DailyExpenseService dailyExpenseService;

	/*public List<DailyExpense> getDailyExpenseResult(HttpSession session, Integer currentPage) {

		if (currentPage > 0) {
			return (List<DailyExpense>) session.getAttribute("myObject");

		} else {
			List<DailyExpense> resultDailyExpense = dailyExpenseService.findAllByIdDesc();
			session.setAttribute("myObject", resultDailyExpense);
			return resultDailyExpense;
		}

	}*/

	/*public Page<DailyExpense> findPaginated(HttpSession session, Pageable pageable) {
		// List<DailyExpense> resultDailyExpense =
		// dailyExpenseService.findAllByIdDesc();

		List<DailyExpense> resultDailyExpense = getDailyExpenseResult(session, pageable.getPageNumber());

		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<DailyExpense> list;

		if (resultDailyExpense.size() < startItem) {
			list = Collections.emptyList();
		} else {
			int toIndex = Math.min(startItem + pageSize, resultDailyExpense.size());
			list = resultDailyExpense.subList(startItem, toIndex);
		}

		Page<DailyExpense> bookPage = new PageImpl<DailyExpense>(list, PageRequest.of(currentPage, pageSize),
				resultDailyExpense.size());

		return bookPage;
	}*/

	/*public List<DailyExpense> getMonthlyExpenseResult(HttpSession session, Integer currentPage) {

		if (currentPage > 0) {
			return (List<DailyExpense>) session.getAttribute("myObject");

		} else {
			List<DailyExpense> resultMonthlyExpense = dailyExpenseService.findAllExpenseByMonth();
			session.setAttribute("myObject", resultMonthlyExpense);
			return resultMonthlyExpense;
		}

	}*/

	/*public Page<DailyExpense> getMonthlyExpensePaginated(HttpSession session, Pageable pageable) {
		// List<DailyExpense> resultDailyExpense =
		// dailyExpenseService.findAllByIdDesc();

		List<DailyExpense> resultDailyExpense = getMonthlyExpenseResult(session, pageable.getPageNumber());

		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<DailyExpense> list;

		if (resultDailyExpense.size() < startItem) {
			list = Collections.emptyList();
		} else {
			int toIndex = Math.min(startItem + pageSize, resultDailyExpense.size());
			list = resultDailyExpense.subList(startItem, toIndex);
		}

		Page<DailyExpense> bookPage = new PageImpl<DailyExpense>(list, PageRequest.of(currentPage, pageSize),
				resultDailyExpense.size());

		return bookPage;
	}*/

	/*public Page<DailyExpense> findDataByDateRange(HttpSession session, FilterData filterData, PageRequest pageable) {
		List<DailyExpense> resultDailyExpense = null;
		if (filterData.getSortSelectItem().equals("select") && filterData.getSourceSelect().equals("select")) {
			resultDailyExpense = dailyExpenseService.getDataByDateRange(filterData);
		} else if (filterData.getSourceSelect().equals("select")) {
			resultDailyExpense = dailyExpenseService.getSortedDataBySelectedItem(filterData);
		} else {
			resultDailyExpense = dailyExpenseService.getFilterdDataBySourceItem(filterData);
		}
		session.setAttribute("myObject", resultDailyExpense);
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<DailyExpense> list;

		if (resultDailyExpense.size() < startItem) {
			list = Collections.emptyList();
		} else {
			int toIndex = Math.min(startItem + pageSize, resultDailyExpense.size());
			list = resultDailyExpense.subList(startItem, toIndex);
		}

		Page<DailyExpense> bookPage = new PageImpl<DailyExpense>(list, PageRequest.of(currentPage, pageSize),
				resultDailyExpense.size());

		return bookPage;
	}*/

	public String getSystemDateTime() {

		Date trnDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		return formatter.format(trnDate);
	}
}
