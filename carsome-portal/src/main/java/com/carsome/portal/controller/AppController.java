package com.carsome.portal.controller;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.carsome.portal.configuration.ConfigConstants;
import com.carsome.portal.model.PopupBox;
import com.carsome.portal.model.Slots;
import com.carsome.portal.persist.entity.Inspection;
import com.carsome.portal.service.InspectionService;
import com.carsome.portal.util.DateUtil;



@Controller
@RequestMapping("/")
public class AppController {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired InspectionService inspectionService;
	
	@Value("${" + ConfigConstants.WEEKDAY_SLOTS + "}")
	private String weknSlot;
	
	@Value("${" + ConfigConstants.SATDAY_SLOTS + "}")
	private String satrdaySlot;
	
	@Value("${" + ConfigConstants.DIVIDENT_TIME + "}")
	private String diviTime;
	
	/**
	 * home page method
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
	public String homePage(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		return "home";
	}

	
/**
 * About page Method
 * @param model
 * @param request
 * @param response
 * @return
 */
	@RequestMapping(value = { "/about"}, method = RequestMethod.GET)
	public String aboutPage(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		return "about";
	}
	/**
	 * contact page method
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = { "/contact"}, method = RequestMethod.GET)
	public String contactPage(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		return "contact";
	}
	/**
	 * method used for finding slot dates
	 * @param request
	 * @param response
	 * @param category
	 * @return
	 */
	@RequestMapping(value = {"/findslotDates"}, method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<String> findslotDates(HttpServletRequest request, HttpServletResponse response,@RequestParam String category) {
		logger.info("find slot for given category################" +category);
		//String category1 = request.getParameter("category");
		List<String> dateSlots=new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar start = Calendar.getInstance();
		//Number of Days to add
		start.add(Calendar.DAY_OF_MONTH, 1);
		
		Calendar end = Calendar.getInstance();
		//Number of Days to add
		end.add(Calendar.DAY_OF_MONTH, 21);
		Map<String,String>  dayDate=getWeekDayNames(start.getTime(),end.getTime());
		
		if(category!=null && !StringUtils.isEmpty(category) && category.equalsIgnoreCase("WEK")){
			//2 inspection slot every 30mins, from 9AM to 6PM
			for (Map.Entry<String, String> entry : dayDate.entrySet()) {
			    if(entry.getValue().equalsIgnoreCase("Sunday") || entry.getValue().equalsIgnoreCase("Saturday")) {
			    	//dont add
			    	System.out.println("Not added in list 1st condition-->"+entry.getKey() + "/" + entry.getValue());
			    }else {
			    	dateSlots.add(entry.getKey());
			    }
			    
			}
			
		}else if(category!=null && !StringUtils.isEmpty(category) && category.equalsIgnoreCase("SAT")) {
			//4 inspection slot every 30mins, from 9AM to 6PM
			for (Map.Entry<String, String> entry : dayDate.entrySet()) {
			    if(entry.getValue().equalsIgnoreCase("Saturday")) {
			    	dateSlots.add(entry.getKey());
			    	//System.out.println("Not added in list 1st condition-->"+entry.getKey() + "/" + entry.getValue());
			    }
			    
			}
		}
		return dateSlots;
	}
	
	
	@RequestMapping(value = {"/findslots"}, method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Slots> findslots(HttpServletRequest request, HttpServletResponse response,@RequestParam String category,@RequestParam String dateSlot) {
		System.out.println("dateSlot-->>" +dateSlot);
		//String category1 = request.getParameter("category");
		List<Slots> dateSlots=new ArrayList<>();
		List<String> dbList=new ArrayList<>();
		//time frame 9AM to 6PM =9*60min=540min
		int perdayTotaltime=540;
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		String strDate=dateSlot.split("\\_")[0]; 
		//SimpleDateFormat date_format = new SimpleDateFormat("HH:mm:ss");
		System.out.println("strDate-->>" +strDate);
		if(category!=null && !StringUtils.isEmpty(category) && category.equalsIgnoreCase("WEK")){
			//2 inspection slot every 30mins, from 9AM to 6PM
			String startTime = "09:00:00";
			int totalSlotWk=(perdayTotaltime/(Integer.parseInt(diviTime)))*(Integer.parseInt(weknSlot));
			//int addTime=perdayTotaltime/totalSlotWk;
			double addTime = (double) perdayTotaltime / totalSlotWk;
			String strTime=String.valueOf(addTime);
			String mint = strTime.split("\\.")[0]; 
			String secnd = strTime.split("\\.")[1];
			int actSec=(Integer.parseInt(secnd)*60)/10;
			Date d;
			try {
				Date reqDate=DateUtil.getFormatDate(strDate, "yyyy-MM-dd");
				List<Inspection> dbInspection=inspectionService.findbyslotDate(reqDate);
				if(dbInspection!=null && dbInspection.size()>0) {
					for(Inspection objTemp:dbInspection) {
						Date date = new Date(objTemp.getSlotStartTime().getTime());
						Calendar c1Temp = Calendar.getInstance();
						c1Temp.setTime(date);
						dbList.add(df.format(c1Temp.getTime()));
						
						
					}
				}
				
				
				for(int i=1;i<=totalSlotWk;i++) {
					d = df.parse(startTime);
					Calendar cal = Calendar.getInstance();
					 cal.setTime(d);
					 cal.add(Calendar.MINUTE, Integer.parseInt(mint));
					 cal.add(Calendar.SECOND, actSec);
					 String newTime = df.format(cal.getTime());
					 if(!dbList.contains(startTime)) {
						 Slots slot=new Slots();
						 slot.setStarTime(startTime);
						 slot.setEndTime(newTime);
						 slot.setAvailable(true);
						 dateSlots.add(slot); 
					 }
					 
					 startTime=newTime;
				}
				
				 
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			
		}else if(category!=null && !StringUtils.isEmpty(category) && category.equalsIgnoreCase("SAT")) {
			//4 inspection slot every 30mins, from 9AM to 6PM
			SimpleDateFormat dfSat = new SimpleDateFormat("HH:mm:ss");
			int totalSlotSat=(perdayTotaltime/(Integer.parseInt(diviTime)))*(Integer.parseInt(satrdaySlot));
			//int addTime=perdayTotaltime/totalSlotSat;
			double addTime = (double) perdayTotaltime / totalSlotSat;
			String strTime=String.valueOf(addTime);
			String mint = strTime.split("\\.")[0]; 
			String secnd = strTime.split("\\.")[1];
			int actSec=(Integer.parseInt(secnd)*60)/10;
			
			Date d;
			String startTime = "09:00:00";
			try {
				Date reqDate=DateUtil.getFormatDate(strDate, "yyyy-MM-dd");
				List<Inspection> dbInspection=inspectionService.findbyslotDate(reqDate);
				
				if(dbInspection!=null && dbInspection.size()>0) {
					for(Inspection objTemp:dbInspection) {
						Date date = new Date(objTemp.getSlotStartTime().getTime());
						Calendar c1Temp = Calendar.getInstance();
						c1Temp.setTime(date);
						dbList.add(df.format(c1Temp.getTime()));
					}
				}
				
				for(int i=1;i<=totalSlotSat;i++) {
					d = dfSat.parse(startTime);
					Calendar cal = Calendar.getInstance();
					 cal.setTime(d);
					 cal.add(Calendar.MINUTE, Integer.parseInt(mint));
					 cal.add(Calendar.SECOND, actSec);
					 String newTime = dfSat.format(cal.getTime());
					 //dateSlots.add(startTime+"-"+newTime);
					 if(!dbList.contains(startTime)) {
						 Slots slot=new Slots();
						 slot.setStarTime(startTime);
						 slot.setEndTime(newTime);
						 slot.setAvailable(true);
						 dateSlots.add(slot); 
					 }
					
					 startTime=newTime;
				}
				
				 
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}
		return dateSlots;
	}
	
	
	
	@RequestMapping(value = {"/saveslots"}, method = RequestMethod.POST)
	public ModelAndView saveslots(ModelMap model,HttpServletRequest request, HttpServletResponse response,@RequestParam String slotCategory,
			@RequestParam String slotDate,@RequestParam String slotTime,
			@RequestParam String userName,@RequestParam String userEmail,@RequestParam String userPhone) {
		System.out.println("dateSlot-->>" +slotDate);
		System.out.println("slotTime-->>" +slotTime);
		ModelAndView mav =new ModelAndView("popup");
		Inspection inspection =new Inspection();
		String strDate = slotDate.split("\\_")[0];
		String strTime= slotTime.split("\\_")[0]; 
		
		try {
			String startTime=strTime.split("\\-")[0];
			String endTime=strTime.split("\\-")[1];
			
			Date reqDate=DateUtil.getFormatDate(strDate, "yyyy-MM-dd");
			
			
			// Get today's date and time.
		    Calendar c1 = Calendar.getInstance();
		    c1.setTime(reqDate); 

		    // Get the required time of day, copy year, month, day.
		    Calendar c2 = Calendar.getInstance();
		    c2.setTime(java.sql.Time.valueOf(startTime));
		    c2.set(Calendar.YEAR, c1.get(Calendar.YEAR));
		    c2.set(Calendar.MONTH, c1.get(Calendar.MONTH));
		    c2.set(Calendar.DAY_OF_MONTH, c1.get(Calendar.DAY_OF_MONTH));

		    // Construct required java.sql.Timestamp object.
		    Timestamp startTimestamp = new Timestamp(c2.getTimeInMillis());
			
			
		    
		 // Get today's date and time.
		    Calendar c3 = Calendar.getInstance();
		    c3.setTime(reqDate); 

		    // Get the required time of day, copy year, month, day.
		    Calendar c4 = Calendar.getInstance();
		    c4.setTime(java.sql.Time.valueOf(endTime));
		    c4.set(Calendar.YEAR, c3.get(Calendar.YEAR));
		    c4.set(Calendar.MONTH, c3.get(Calendar.MONTH));
		    c4.set(Calendar.DAY_OF_MONTH, c3.get(Calendar.DAY_OF_MONTH));

		    // Construct required java.sql.Timestamp object.
		    Timestamp endTimestamp = new Timestamp(c4.getTimeInMillis());
		    
			inspection.setSlotCategory(slotCategory);
			inspection.setSlotDate(reqDate);
			inspection.setSlotStartTime(startTimestamp);
			inspection.setSlotEndTime(endTimestamp);
			inspection.setUserEmail(userEmail);
			inspection.setUserName(userName);
			inspection.setUserPhone(userPhone);
			inspection.setCrtTs(DateUtil.getSQLTimestamp());
			inspection.setUpdateTs(DateUtil.getSQLTimestamp());
			System.out.println("JSON submit-"+slotCategory+"###"+reqDate);
			inspectionService.createInspectionSlot(inspection);
			mav.addAllObjects(PopupBox.success(null, null,"Slot booked Successfully","home"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return mav;	
		}
		

	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	protected Map<String,String> getWeekDayNames(Date startDate, Date endDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Map<String,String> dayDateMap=new HashMap<String,String>();
        Calendar startCal = Calendar.getInstance();
        startCal.setTime(startDate);

        Calendar endCal = Calendar.getInstance();
        endCal.setTime(endDate);

        if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
        	dayDateMap.put(sdf.format(startCal.getTime()), this.formatDayOfWeek(startCal.getTime()));
        }
        // swap values
        if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
            startCal.setTime(endDate);
            endCal.setTime(startDate);
        }

        do {
        	dayDateMap.put(sdf.format(startCal.getTime()), this.formatDayOfWeek(startCal.getTime()));
        	startCal.add(Calendar.DAY_OF_MONTH, 1);

        } while (startCal.getTimeInMillis() <= endCal.getTimeInMillis());

        return dayDateMap;
    }



	private String formatDayOfWeek(Date time) {
		DateFormat f = new SimpleDateFormat("EEEE");
	      try {
	        return f.format(time);
	      }
	      catch(Exception e) {
	        e.printStackTrace();
	        return "";
	      }
		
		
	}
	
}