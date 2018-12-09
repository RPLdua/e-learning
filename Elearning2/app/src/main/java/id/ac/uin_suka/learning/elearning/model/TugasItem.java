package id.ac.uin_suka.learning.elearning.model;

import com.google.gson.annotations.SerializedName;

public class TugasItem {
    @SerializedName("id")
    private String id;

    @SerializedName("judul")
    private String judul;

    @SerializedName("mulai")
    private String mulai;

    @SerializedName("selesai")
    private String selesai;

    @SerializedName("makul")
    private String makul;

    @SerializedName("namadosen")
    private String dosen;

    @SerializedName("foto")
    private String foto;

    @SerializedName("isi")
    private String isi;

    @SerializedName("file")
    private String file;

    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }
    public String getJudul() {
        return judul;
    }

    public void setMulai(String mulai) {
        this.mulai = mulai;
    }
    public String getMulai() {
        return mulai;
    }

    public void setSelesai(String selesai) {
        this.selesai = selesai;
    }
    public String getSelesai() {
        return selesai;
    }

    public void setMakul(String makul) {
        this.makul = makul;
    }
    public String getMakul() {
        return makul;
    }

    public void setDosen(String dosen) {
        this.dosen = dosen;
    }
    public String getDosen() {
        return dosen;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    public String getFoto() {
        return foto;
    }

    public void setIsi(String isi) {this.isi = isi;}
    public String getIsi() {return isi;}

    public void setFile(String file) {this.file = file; }
    public String getFile() {return file; }

    @Override
    public String toString(){
        return
                "detailtugas{"+
                        "id = '"+id+'\''+
                        "judul='"+judul+'\''+
                        "mulai='"+mulai+'\''+
                        "selesai='"+selesai+'\''+
                        "makul='" +makul+'\''+
                        "namadosen='"+dosen+'\''+
                        "foto='"+foto+'\''+
                        "isi='"+isi+'\''+
                        "file='"+file+'\''+
                        "}";
    }
}
