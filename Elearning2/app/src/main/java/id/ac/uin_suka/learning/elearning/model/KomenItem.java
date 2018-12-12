package id.ac.uin_suka.learning.elearning.model;

import com.google.gson.annotations.SerializedName;

public class KomenItem {
    @SerializedName("id")
    private String id;

    @SerializedName("nim")
    private String nim;

    @SerializedName("komen")
    private String  komen;

    @SerializedName("like")
    private String like;

    @SerializedName("tgl")
    private String tgl;

    public void setId(String id){this.id = id;}
    public String getId() {return id;}

    public void setNim(String nim){this.nim = nim;}
    public String getNim() {return nim;}

    public void setKomen(String komen){this.komen= komen;}
    public String getKomen() {return komen;}

    public void setLike(String like){this.like= like;}
    public String getLike() {return like;}

    public void setTgl(String tgl){this.tgl= tgl;}
    public String getTgl() {return tgl;}

    @Override
    public String toString(){
        return
                "komen{"+
                        "id = '"+id+'\''+
                        "nim='"+nim+'\''+
                        "komen='"+komen+'\''+
                        "like='"+like+'\''+
                        "tgl='" +like+'\''+
                        "}";
    }
}
