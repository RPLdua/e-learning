package id.ac.uin_suka.learning.elearning.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseMakul {
    @SerializedName("listmakul")
    private List<MakulItem> listmakul;

    @SerializedName("error")
    private boolean error;

    @SerializedName("message")
    private String message;

    public void setListmakul(List<MakulItem> listmakul) {
        this.listmakul = listmakul;
    }

    public List<MakulItem> getListmakul() {
        return listmakul;
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
                        "listmakul='"+ listmakul +'\''+
                        ",error = '"+error+'\''+
                        ",message='"+message+'\''+
                        "}";
    }
}
