package test.MessageService;

public class Message {
    String name;
    int size;
    LimitedQueue<String> m;

    public Message(String name, int size, LimitedQueue<String> m) {
        this.name = name;
        this.size = size;
        this.m = m;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public LimitedQueue<String> getM() {
        return m;
    }

    public void setM(LimitedQueue<String> m) {
        this.m = m;
    }
}
