package id.ac.uin_suka.learning.elearning.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseMakul {
    @SerializedName("makul")
    private List<MakulItem> makul;

    @SerializedName("error")
    private boolean error;

    @SerializedName("message")
    private String message;

    public void setMakul(List<MakulItem> makul) {
        this.makul= makul;
    }

    public List<MakulItem> getMakul() {
        return makul;
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
                "ResponseMakul{"+
                        "listmakul='"+makul+'\''+
                        ",error = '"+error+'\''+
                        ",message='"+message+'\''+
                        "}";
    }
}
