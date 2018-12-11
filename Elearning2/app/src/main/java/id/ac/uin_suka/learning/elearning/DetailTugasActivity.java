package id.ac.uin_suka.learning.elearning;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ipaulpro.afilechooser.utils.FileUtils;

import java.util.ArrayList;
import java.util.List;

import id.ac.uin_suka.learning.elearning.apihelper.BaseApiService;
import id.ac.uin_suka.learning.elearning.apihelper.UtilsApi;
import id.ac.uin_suka.learning.elearning.model.TugasItem;

public class DetailTugasActivity extends AppCompatActivity implements View.OnClickListener {
    public  static  String EXTRA_ID = "extra_id";
    private TextView tvJudul, tvMulai, tvSelesai, tvNamaFile;
    private TextView tvDetail;
    private View upView;
    Button btnDwnld, btnPilihFIle;

    List<TugasItem> tugasItemList = new ArrayList<>();
    BaseApiService mApiService;
    Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tugas);

        mContext =this;
        mApiService = UtilsApi.getAPIService();

        String id = getIntent().getStringExtra(EXTRA_ID);

        tvJudul = (TextView)findViewById(R.id.tv_judul_tugas);
        tvDetail = (TextView)findViewById(R.id.desk_tugas);
        tvMulai = findViewById(R.id.dt_tv_mulai);
        tvSelesai = findViewById(R.id.dt_tv_selesai);
        btnPilihFIle = findViewById(R.id.bt__pilih_file);
        tvNamaFile = findViewById(R.id.tv_namafile_upload);
        upView = findViewById(R.id.view_upload);
        btnPilihFIle.setOnClickListener(this);

//        mApiService.getDetailTugas(id)
//                .enqueue(new Callback<ResponseDetailTugas>() {
//                    @Override
//                    public void onResponse(Call<ResponseDetailTugas> call, Response<ResponseDetailTugas> response) {
//                        if (response.isSuccessful()){
//                            final List<TugasItem> tugasItems = response.body().getDetailtugas();
//
//                            tvJudul.setText(tugasItems.get(0).getJudul());
//                            tvDetail.setText(tugasItems.get(0).getIsi());
//                            tvMulai.setText("Mulai: \t\t"+tugasItems.get(0).getMulai());
//                            tvSelesai.setText("Selesai \t: "+tugasItems.get(0).getSelesai());
//                        } else {
//                            Toast.makeText(DetailTugasActivity.this, "Gagal mengambil data", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<ResponseDetailTugas> call, Throwable t) {
//                        Toast.makeText(DetailTugasActivity.this, "Koneksi bermasalah", Toast.LENGTH_SHORT).show();
//                    }
//                });

    }

    private final int REQUEST_CHOOSER = 1234;

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt__pilih_file:
                Intent getContentIntent = FileUtils.createGetContentIntent();
                Intent intent = Intent
                        .createChooser(getContentIntent, "Pilih file");
                startActivityForResult(intent, REQUEST_CHOOSER);

                break;
                default:
                    break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode){
            case REQUEST_CHOOSER:
                if (resultCode == RESULT_OK){
                    final Uri uri = data.getData();
                    final String path = FileUtils.getPath(this, uri);
                    upView.setVisibility(View.GONE);
                    tvNamaFile.setText(path);
                } else {
                    tvNamaFile.setText("Gagal ambil file");
                }
                break;
        }
    }
}
