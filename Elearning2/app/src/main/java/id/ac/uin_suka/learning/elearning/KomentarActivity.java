package id.ac.uin_suka.learning.elearning;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import id.ac.uin_suka.learning.elearning.apihelper.BaseApiService;
import id.ac.uin_suka.learning.elearning.apihelper.UtilsApi;
import id.ac.uin_suka.learning.elearning.model.KomenItem;

public class KomentarActivity extends AppCompatActivity {
    public  static  String EXTRA_ID = "extra_id";
    public  static  String EXTRA_NAMA = "extra_nama";
    public  static  String EXTRA_STATUS = "extra_status";
    public  static  String EXTRA_TGL = "extra_tgl";
    public  static  String EXTRA_FOTO = "extra_foto";

    TextView tvNama, tvStatus, tvTgl, tvNamaKomen, tvKomen, tvTglKomen;
    ImageView fotoKomen;

    Context mContext;
    BaseApiService mApiService;
    List<KomenItem> komenItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar menu = getSupportActionBar();
        menu.setDisplayHomeAsUpEnabled(true);
        this.setTitle("Komentar");
        setContentView(R.layout.activity_komentar);

        mContext = this;
        mApiService = UtilsApi.getAPIService();

        String id = getIntent().getStringExtra(EXTRA_ID);
        String nama = getIntent().getStringExtra(EXTRA_NAMA);
        String status = getIntent().getStringExtra(EXTRA_STATUS);
        String tgl = getIntent().getStringExtra(EXTRA_TGL);
        String foto = getIntent().getStringExtra(EXTRA_FOTO);

        tvNama = findViewById(R.id.namaStatusK);
        tvStatus =  findViewById(R.id.isiStatusK);
        tvTgl = findViewById(R.id.statusTglK);
        fotoKomen = findViewById(R.id.photoMhsK1);

        tvNama.setText(nama);
        tvStatus.setText(status);
        tvTgl.setText(tgl);
//
//        Glide.with(mContext)
//                .load(foto)
//                .override(55,55)
//                .crossFade()
//                .into(fotoKomen);

    }
}
