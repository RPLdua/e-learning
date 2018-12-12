package id.ac.uin_suka.learning.elearning.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseKomen {
    @SerializedName("komen")
    private List<KomenItem> komen;

    @SerializedName("error")
    private boolean error;

    @SerializedName("message")
    private String message;

    public void setKomen(List<KomenItem> komen) {
        this.komen= komen;
    }

    public List<KomenItem> getKomen() {
        return komen;
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
                "ResponseKomen{"+
                        "komen ='"+komen+'\''+
                        ",error = '"+error+'\''+
                        ",message='"+message+'\''+
                        "}";
    }
}
