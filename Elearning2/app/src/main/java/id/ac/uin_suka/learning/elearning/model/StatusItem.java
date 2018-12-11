package id.ac.uin_suka.learning.elearning.model;

import com.google.gson.annotations.SerializedName;

public class StatusItem {
    @SerializedName("id")
    private String id;

    @SerializedName("like")
    private String like;

    @SerializedName("nim")
    private String nim;

    @SerializedName("isi_status")
    private String isi_status;

    @SerializedName("tgl")
    private String tgl;

    @SerializedName("namaruang")
    private String namaruang;

    @SerializedName("ruang")
    private String ruang;

    public void setId(String id){this.id = id;}
    public String getId() {return id;}

    public void setLike(String like) {this.like = like;}
    public String getLike() {return like;}

    public void setIsiStatus(String status) {this.isi_status= status;}
    public String getIsiStatus() {return isi_status;}


    public void setNim(String nim) {this.nim = nim;}
    public String getNim() {return nim;}


    public void setTgl(String tgl) {this.tgl = tgl;}
    public String getTgl() {return tgl;}


    public void setNamaruang(String namaruang) {this.namaruang= namaruang;}
    public String getNamaruang() {return namaruang;}

    public void setRuang(String ruang) {this.namaruang= ruang;}
    public String getRuang() {return ruang;}

    @Override
    public String toString(){
        return
                "status{"+
                        "id = '"+id+'\''+
                        "nim='"+nim+'\''+
                        "isi_status='"+isi_status+'\''+
                        "like ='"+like+'\''+
                        "tgl='" +tgl+'\''+
                        "ruang ='"+ruang+'\''+
                        "namaruang ='"+namaruang+'\''+
                        "}";
    }
}
