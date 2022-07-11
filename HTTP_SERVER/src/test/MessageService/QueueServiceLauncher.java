package test.MessageService;



import java.util.HashMap;
import java.util.Scanner;

public class QueueServiceLauncher {

    static HashMap<String, Message> m = new HashMap();

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        Message targetQ;

        String[] recievedMessage;
        String line;
        while ((line = scanner.nextLine()) != null) {
            recievedMessage = convString(line);

            if (line.startsWith("SEND")) {

                String QueueName = recievedMessage[1];
                targetQ = m.get(QueueName);
                String Message = recievedMessage[2];
                if(targetQ.size == targetQ.m.size()){
                    System.out.println("Queue Full");
                }else {
                    targetQ.m.offer(Message);
                }

            } else if (line.startsWith("RECEIVE")) {
                String QueueName = recievedMessage[1];
                targetQ = m.get(QueueName);
                if(targetQ.m.size() !=0) {
                    System.out.println(targetQ.m.poll());
                }
            } else if (line.startsWith("CREATE")) {

                String QueueName = recievedMessage[1];
                int QueueSize = Integer.parseInt(recievedMessage[2]);
                LimitedQueue<String> q = new LimitedQueue(QueueSize);
                if(m.get(QueueName)==null) {
                    Message tm = new Message(QueueName, QueueSize, q);
                    m.put(QueueName, tm);
                }else{
                    System.out.println("Queue Exists");
                }

            }else if (line.startsWith("QUIT")) {
                break;
            }
        }

    }

    private static boolean searchQ(LimitedQueue<String> q, String message) {
        for (int i=0;i<q.size();i++){
            if(q.peek().equals(message)) {
                return true;
            }
        }
        return false;

    }

    private static String[] convString(String line){
        String[] tmp = line.split(" ");
        return tmp;
    }
}
