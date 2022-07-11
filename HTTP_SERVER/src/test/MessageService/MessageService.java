package test.MessageService;

import java.util.HashMap;

import test.dto.ResultResponse;

public class MessageService {
	
	
	
	
	
    static HashMap<String, Message> m = new HashMap();
    
    
	static public ResultResponse processCreate( String QueueName, int size) {
		
	   Message targetQ = m.get(QueueName);
       String Message = recievedMessage[2];
       if(targetQ.size == targetQ.m.size()){
           System.out.println("Queue Full");
       }else {
           targetQ.m.offer(Message);
       }
	}
	
	
    
	static public ResultResponse processSend( String QueueName, String message) {
		
	   Message targetQ = m.get(QueueName);
       String Message = message;
       if(targetQ.size == targetQ.m.size()){
    	   return new ResultResponse("Queue Full");
       }else {
           targetQ.m.offer(Message);
           return new ResultResponse("OK");
       }
	}

}
