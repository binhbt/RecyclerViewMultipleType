package demo.com.recyclerviewmultipletype;

/**
 * Created by leobui on 10/5/2017.
 */

public class PhotoMessage {
    private String callerName;
    private String callTime;

    public PhotoMessage(String callerName, String callTime) {
        this.callerName = callerName;
        this.callTime = callTime;
    }

    public String getCallerName() {
        return callerName;
    }

    public void setCallerName(String callerName) {
        this.callerName = callerName;
    }

    public String getCallTime() {
        return callTime;
    }

    public void setCallTime(String callTime) {
        this.callTime = callTime;
    }
}
