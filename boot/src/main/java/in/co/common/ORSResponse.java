package in.co.common;

import java.util.HashMap;
import java.util.Map;

public class ORSResponse {
private static final String INPUT_ERROR = "inputerror";
private static final String MESSAGE = "message";
private static final String DATA = "data";

    public boolean success = false;
    public ORSResponse() {
    }
    public ORSResponse(boolean success) {
        this.success = success;
    }
private Map<String,Object> result = new HashMap<String,Object>();
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
    public Map<String, Object> getResult() {
        return result;
    }

    public void setResult(Map<String, Object> result) {
        this.result = result;
    }
    public  void addResult(String key , Object value){
    result.put(key,value);
    }
    public void addData(Object value){
    result.put(DATA,value);
    }
    public void addMessage(Object value){
    result.put(MESSAGE,value);
    }
    public void addInputError(Object value){
    result.put(INPUT_ERROR,value);
    }
}
