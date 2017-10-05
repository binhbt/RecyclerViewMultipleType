package demo.com.recyclerviewmultipletype;

/**
 * Created by leobui on 10/5/2017.
 */

public class TextMessage {
    private String senderName;
    private String smsContent;
    private String smsTime;

    public TextMessage(String senderName, String smsContent, String smsTime) {
        this.senderName = senderName;
        this.smsContent = smsContent;
        this.smsTime = smsTime;
    }
    public String getSenderName() {
        return senderName;
    }
    public String getSmsContent() {
        return smsContent;
    }
    public String getSmsTime() {
        return smsTime;
    }
}