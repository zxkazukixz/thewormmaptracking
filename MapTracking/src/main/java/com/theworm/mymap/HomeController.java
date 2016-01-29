package com.theworm.mymap;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.junit.runners.Parameterized.Parameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.theworm.mymap.model.Map;
import com.theworm.mymap.service.MapService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private MapService mapService;
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

//		
		
		String formattedDate = dateFormat.format(date);
		List<Map> maps = mapService.getCurrent();
		model.addAttribute("maps", maps);
		model.addAttribute("serverTime", formattedDate );
		
		
		return "home";
	}
	
	@RequestMapping(value = "/Addmap", method = RequestMethod.GET)
	public @ResponseBody String updateMap(Model model,@RequestParam("longitude") String longitude, @RequestParam("latitude") String latitude){
		Map mapupdate = new Map();
		mapupdate.setName("Toan");
		mapupdate.setLongitude(longitude);
		mapupdate.setLatitude(latitude);
		mapService.updateMap(mapupdate);
		List<Map> maps = mapService.getCurrent();
		model.addAttribute("maps", maps);
		return "home";
	}
}
