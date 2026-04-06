package com.app.mongo.services;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mongo.dao.UserDao;
import com.app.mongo.entity.Notifications;
import com.app.mongo.entity.UserDetails;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public Optional<UserDetails> findByUserName(String name){
		UserDetails ud = new UserDetails();
		ud.setUserId(1);
		ud.setUserName(name);
		ud.setUserStatus(true);
		ud.setUserPassword(name);
		return Optional.of(ud); //userDao.findByUserName(name);
	}
	
	public Optional<UserDetails> findById(Integer id) {
		return userDao.findById(id);
	}
	
	public Iterable<UserDetails> findAll(){
		 return userDao.findAll();
	}
	
	public UserDetails save(UserDetails userDetails) {
		return userDao.save(userDetails);
	}
	
	public UserDetails update(UserDetails userDetails) {
		return userDao.save(userDetails);
	}

	public void deleteById(Integer id) {
		userDao.deleteById(id);
	}
	public List<Notifications> getNotifications() {
		LocalDate today = LocalDate.now();
		List<Notifications> notificationData = getNotificationData();
		
		for(Notifications notes: notificationData) {
			LocalDate ld = today;
			if(today.getDayOfMonth() > notes.getNotificationDate()) {
			ld = LocalDate.of(today.getYear(), today.getMonthValue()+1, notes.getNotificationDate());
			}else {
				ld = LocalDate.of(today.getYear(), today.getMonthValue(), notes.getNotificationDate());
					
			}
			long dueDays = ChronoUnit.DAYS.between(today, ld);
			
			if(dueDays <= 5) {
				notes.setStatus(dueDays+" Days Attention");
			}else {
				notes.setStatus(dueDays+" Days Relax");
			}
			
			 if(today.getDayOfMonth() >= notes.getNotificationDate()) {
				 notes.setDesc(notes.getNotificationDate()+ "-" +ld.getMonth());
			 }else {
				 notes.setDesc(notes.getNotificationDate()+ "-" +today.getMonth());
			 }
			
			/*
			if(today.isBefore((ld.minusDays(5)))) {
				
			}
			
			System.out.println(today.compareTo(ld));
			System.out.println(ld.minusDays(5));
			System.out.println(today.isBefore(ld.minusDays(5)));
			LocalDate minusDays2 = ld.minusDays(6);
			if(today.isBefore(minusDays2)) {
				LocalDate minusDays = today.minusDays(ld.getDayOfMonth());
				if(today. getMonth().maxLength() - notes.getNotificationDate() > 5)
				notes.setStatus(today.getMonth().maxLength() - notes.getNotificationDate() +"-Days");
			}
			System.out.println(ld.compareTo(today));
			int diff = notes.getNotificationDate() - 7 ; //notes.getNotificationDate();
			if(today.getDayOfMonth() <= diff && (today.getDayOfMonth() - notes.getNotificationDate() <5) ) {
				notes.setStatus(diff+"-Days");
			}*/
			
		}
		
		
		return notificationData;
		
		
		/*
		 * Date d = new Date(); SimpleDateFormat formatter = new
		 * SimpleDateFormat("yyyy-MM-dd"); String format = formatter.format(new Date());
		 * String today = List<Notifications> notificationData = getNotificationData();
		 * 
		 * 
		 * 
		 * List<Notifications> noteList = new ArrayList<Notifications>(); Notifications
		 * note1 = new Notifications(1, "Mortage", 28); Notifications note2 = new
		 * Notifications(2, "HOA", 28); Notifications note3 = new Notifications(3,
		 * "Internet", 3); Notifications note4 = new Notifications(4, "Chase-CC", 3);
		 * Notifications note5 = new Notifications(5, "JEA", 5); Notifications note6 =
		 * new Notifications(6, "BOA-CC", 12); Notifications note7 = new
		 * Notifications(7, "StateForm", 21); Notifications note8 = new Notifications(8,
		 * "FPL", 24);
		 * 
		 * noteList.add(note1); noteList.add(note2); noteList.add(note3);
		 * noteList.add(note4); noteList.add(note5); noteList.add(note6);
		 * noteList.add(note7); noteList.add(note8);
		 * 
		 * return noteList;
		 */
	}
	
	public List<Notifications> getNotificationData() {
		List<Notifications> noteList = new ArrayList<Notifications>();
		Notifications note1 = new Notifications(1, "Mortage", "", 28,"");
		Notifications note2 = new Notifications(2, "HOA", "", 28,"");
		Notifications note3 = new Notifications(3, "Internet", "", 03,"");
		Notifications note4 = new Notifications(4, "Chase-CC", "", 03,"");
		Notifications note5 = new Notifications(5, "JEA", "", 05,"");
		Notifications note6 = new Notifications(6, "BOA-CC", "", 12,"");
		Notifications note7 = new Notifications(7, "StateForm", "", 21,"");
		Notifications note8 = new Notifications(8, "FPL", "", 24,"");
		
		noteList.add(note1);
		noteList.add(note2);
		noteList.add(note3);
		noteList.add(note4);
		noteList.add(note5);
		noteList.add(note6);
		noteList.add(note7);
		noteList.add(note8);
		
		return noteList;
	}

}
