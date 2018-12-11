package id.ac.uin_suka.learning.elearning.model;

import com.google.gson.annotations.SerializedName;

public class MakulItem {
    @SerializedName("id")
    private String id;

    @SerializedName("nim")
    private String nim;

    @SerializedName("makul")
    private String makul;

    @SerializedName("semester")
    private String semester;

    @SerializedName("tahun")
    private String tahun;

    public void setId(String id){this.id = id;}
    public String getId() {return id;}

    public void setNim(String nim){this.nim = nim;}
    public String getNim() {return nim;}

    public void setMakul(String makul){this.id = makul;}
    public String getMakul() {return makul;}

    public void setSemester(String semester){this.semester = semester;}
    public String getSemester() {return semester;}

    public void setTahun(String tahun){this.tahun = tahun;}
    public String getTahun() {return tahun;}

    @Override
    public String toString(){
        return
                "listmakul{"+
                        "id = '"+id+'\''+
                        "nim='"+nim+'\''+
                        "makul ='"+makul+'\''+
                        "semester='"+semester+'\''+
                        "tahun ='" +tahun+'\''+
                        "}";
    }

}
