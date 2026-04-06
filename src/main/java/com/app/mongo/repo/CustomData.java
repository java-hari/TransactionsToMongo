package com.app.mongo.repo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.mongo.entity.DailyExpense;

@Repository
public class CustomData
 {

	//private final SessionFactory sessionFactory = null;
	private static final String HQL_MAX_COUNT = "SELECT COUNT(e.id) FROM daily_expense e";
	private static final String CUSTOM_1 = "SELECT EXTRACT(YEAR FROM transaction_date) AS year, EXTRACT(MONTH FROM transaction_date) AS month, item_name, item_price FROM familybudget.daily_expense where item_name in ('Chase-CC', 'BOA-CC','Mortage','JEA', 'HOA', 'PVK', 'Internet') ORDER BY year, month desc";

    /*public Integer findMaxCountOfId() {
    	String hibernateQuery = HibernateUtils.getHibernateQuery(HQL_MAX_COUNT); 
    	
        try (Session session = sessionFactory.openSession()) {
            String hql = "SELECT COUNT(e.id) FROM daily_expense e";
            Query<Long> query = session.createQuery(hql, Long.class);
            query.setMaxResults(1);
            List<Long> results = query.list();
            return results.isEmpty() ? 0 : results.get(0).intValue();
        }
    }*/
    
    public String getSystemDateTime() {
    	LocalDateTime myDateObj = LocalDateTime.now();
        System.out.println("Before formatting: " + myDateObj);
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String formattedDate = myDateObj.format(myFormatObj);
        System.out.println("After formatting: " + formattedDate);
        
        return formattedDate;
    }
    

	/*public List<Object> getAllExpenseByMonth(){
		String hibernateQuery = HibernateUtils.getHibernateQuery(CUSTOM_1); 
    	
        try (Session session = sessionFactory.openSession()) {
           
            Query<Object> query = session.createQuery(hibernateQuery, Object.class);
            
            List<Object> results = query.list();
            return null;
            //return results.isEmpty() ? 0 : results.get(0).intValue();
        }
	}*/
	

}
