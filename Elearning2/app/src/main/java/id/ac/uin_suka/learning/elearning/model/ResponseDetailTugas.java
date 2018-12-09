package id.ac.uin_suka.learning.elearning.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseDetailTugas {
    @SerializedName("detailtugas")
    private List<TugasItem> semuatugas;

    @SerializedName("error")
    private boolean error;

    @SerializedName("message")
    private String message;

    public void setDetailtugas(List<TugasItem> semuatugas) {
        this.semuatugas = semuatugas;
    }

    public List<TugasItem> getDetailtugas() {
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
                "ResponseDetailTugas{"+
                        "detailtugas ='"+semuatugas+'\''+
                        ",error = '"+error+'\''+
                        ",message='"+message+'\''+
                        "}";
    }
}
