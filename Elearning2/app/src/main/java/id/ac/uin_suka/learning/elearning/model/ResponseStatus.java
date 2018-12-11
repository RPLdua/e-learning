package id.ac.uin_suka.learning.elearning.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseStatus {
    @SerializedName("status")
    private List<StatusItem> status;

    @SerializedName("error")
    private boolean error;

    @SerializedName("message")
    private String message;

    public void setStatus(List<StatusItem> status) {
        this.status = status;
    }

    public List<StatusItem> getStatus() {
        return status;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public boolean isError(){
        return error;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    @Override
    public String toString(){
        return
                "ResponseTugas{"+
                        "status='"+status+'\''+
                        ",error = '"+error+'\''+
                        ",message='"+message+'\''+
                        "}";
    }
}
