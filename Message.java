package Practice.whatsapp;

public class Message {
    private int messageId;
    private int senderId;
    private int receiverId;
    private String messageText;

    public Message(int senderId, int receiverId, String messageText) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.messageText = messageText;
    }

    public int getSenderId() { return senderId; }
    public int getReceiverId() { return receiverId; }
    public String getMessageText() { return messageText; }
}
