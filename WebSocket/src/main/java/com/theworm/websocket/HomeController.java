package com.theworm.websocket;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.theworm.websocket.service.Greeting;
import com.theworm.websocket.service.HelloMessage;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	List<String> listTest = new ArrayList<String>();
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		
		return "test";
	}
	
	 @MessageMapping("/hello")
	 @SendTo("/topic/greetings")
	    public Greeting greeting(HelloMessage message) throws Exception {
		 	listTest.add("Toan");
		 	listTest.add("Nam");
	        Thread.sleep(3000); // simulated delay
	        return new Greeting("Hello, " + listTest + "And " + message.getName() + "!");
	    }
}
