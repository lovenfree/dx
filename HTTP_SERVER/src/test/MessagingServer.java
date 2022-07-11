package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import test.MessageService.MessageService;


public class MessagingServer  extends HttpServlet{

	private static final long serialVersionUID = 1L;
	Gson gson = new Gson();
	JsonParser parser = new JsonParser();
	MessageService service = new MessageService();


	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//Request : http://127.0.0.1:8080/CREATE/test
		
		String url = req.getRequestURI();
    	
        if (url.startsWith ("/CREATE")) {
        	String qName = req.getRequestURI().split("/")[2];
        	String body = req.getReader().readLine();
        	
        	JsonElement element = parser.parse(body);
        	int size = element.getAsJsonObject().get("QuerySize").getAsInt();

        
        	service.processCreate(qName,size);
      
        	sendResponse(res);


        }else if(url.startsWith ("/SEND")) {
        	String qName = req.getRequestURI().split("/")[2];
        	String body = req.getReader().readLine();
        	
        	JsonElement element = parser.parse(body);
        	String message = element.getAsJsonObject().get("Message").getAsString();

        
        	service.processSend(qName,message);
      
        	sendResponse(res);
        	
        }else if(url.startsWith ("/RECEIVE")) {
        	
        }


//		String data = req.getReader().readLine();
//		System.out.println(data);
////			res.getWriter().write("Hello!");
	}
	
  	static void sendResponse(HttpServletResponse res) throws IOException {
        res.setStatus(200);
        res.getWriter().write("Test");
  	}
  	
  	static String objToJson(Object obj) {
  		Gson gson = new Gson();
  		return gson.toJson(obj);
  	}
  	
  	
//  	static String JsonToObject(Object obj) {
//  		Gson gson = new Gson();
//  	  Student student = gson.fromJson(jsonStr, Student.class);
//  
//  	}
}


