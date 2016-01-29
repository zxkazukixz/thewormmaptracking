package com.theworm.mymap;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.theworm.mymap.model.Item;
import com.theworm.mymap.model.Map;
import com.theworm.mymap.service.MapService;

@Controller
public class MapController {
	
	private static final Logger logger = LoggerFactory.getLogger(MapController.class);
	
	@Autowired
	private MapService mapService;
	
	@RequestMapping(value = "/showMap" , method = RequestMethod.GET)
	public String showMap(Model model){
		List<Map> maps = mapService.getCurrent();
		model.addAttribute("maps", maps);
		
		return "showMap";
	}
	
	@RequestMapping(value = "/addMap/{idmap}" , method = RequestMethod.GET)
	public String AddMap(Model model, HttpServletRequest session , @PathVariable(value = "idmap") int mapid){
		
		if (session.getAttribute("mapsSession") == null) {
			List<Item> maps = new ArrayList<Item>();
			maps.add(new Item(mapService.findId(mapid),1));
			session.setAttribute("mapsSession", maps);
		}else{
			List<Item> maps = (List<Item>) session.getAttribute("mapsSession");
			maps.add(new Item(mapService.findId(mapid),1));
			session.setAttribute("mapsSession", maps);
		}
		
		return "addMap";
	}
}
