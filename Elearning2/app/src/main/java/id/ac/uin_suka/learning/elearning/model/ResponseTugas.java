package id.ac.uin_suka.learning.elearning.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseTugas {
    @SerializedName("semuatugas")
    private List<SemuatugasItem> semuatugas;

    @SerializedName("error")
    private boolean error;

    @SerializedName("message")
    private String message;

    public void setSemuatugas(List<SemuatugasItem> semuatugas) {
        this.semuatugas = semuatugas;
    }

    public List<SemuatugasItem> getSemuatugas() {
        return semuatugas;
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
                        "semuatugas ='"+semuatugas+'\''+
                        ",error = '"+error+'\''+
                        ",message='"+message+'\''+
                        "}";
    }
}
