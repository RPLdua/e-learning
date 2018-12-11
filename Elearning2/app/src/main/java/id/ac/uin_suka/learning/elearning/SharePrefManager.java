package id.ac.uin_suka.learning.elearning;

import android.content.Context;
import android.content.SharedPreferences;

public class SharePrefManager {
    public static final String SP_MAHASISWA_APP = "spMahasiswaApp";

    public static final String SP_NAMA = "spNama";
    public static final String SP_EMAIL = "spEmail";

    public static final String SP_SUDAH_LOGIN = "spSudahLogin";
    public static final String SP_JUMLAH_TUGAS = "spJumlahTugas";
    public static final String SP_JUMLAH_STATUS = "spJumlahStatus";
    public static final String SP_TAHUN_AJARAN = "spTahunAjaran";
    public static final String SP_SEMESTER = "spSemester";

    SharedPreferences sp;
    SharedPreferences.Editor spEditor;

    public SharePrefManager(Context context){
        sp = context.getSharedPreferences(SP_MAHASISWA_APP, Context.MODE_PRIVATE);
        spEditor = sp.edit();
    }

    public void saveSPString(String keySP, String value){
        spEditor.putString(keySP, value);
        spEditor.commit();
    }

    public void saveSPInt(String keySP, int value){
        spEditor.putInt(keySP, value);
        spEditor.commit();
    }

    public void saveSPBoolean(String keySP, boolean value){
        spEditor.putBoolean(keySP, value);
        spEditor.commit();
    }

    public String getSPNama(){
        return sp.getString(SP_NAMA, "");
    }

    public String getSPEmail(){
        return sp.getString(SP_EMAIL, "");
    }

    public Boolean getSPSudahLogin(){
        return sp.getBoolean(SP_SUDAH_LOGIN, false);
    }

    public Integer getJumlahTugas(){return sp.getInt(SP_JUMLAH_STATUS, 0);}

    public Integer getTahunAjaran() {return sp.getInt(SP_TAHUN_AJARAN, 0);}

    public String getSpSemester() {return sp.getString(SP_SEMESTER, "");}
}
