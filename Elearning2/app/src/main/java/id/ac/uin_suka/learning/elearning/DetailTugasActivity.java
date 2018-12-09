package id.ac.uin_suka.learning.elearning;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import id.ac.uin_suka.learning.elearning.apihelper.BaseApiService;
import id.ac.uin_suka.learning.elearning.apihelper.UtilsApi;
import id.ac.uin_suka.learning.elearning.model.ResponseDetailTugas;
import id.ac.uin_suka.learning.elearning.model.TugasItem;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailTugasActivity extends AppCompatActivity {
    public  static  String EXTRA_ID = "extra_id";
    private TextView tvJudul, tvMulai, tvSelesai;
    private TextView tvDetail;

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

        tvJudul.setText(id);

        mApiService.getDetailTugas(id)
                .enqueue(new Callback<ResponseDetailTugas>() {
                    @Override
                    public void onResponse(Call<ResponseDetailTugas> call, Response<ResponseDetailTugas> response) {
                        if (response.isSuccessful()){
                            final List<TugasItem> tugasItems = response.body().getDetailtugas();

                            tvJudul.setText(tugasItems.get(0).getJudul());
                            tvDetail.setText(tugasItems.get(0).getIsi());
                            tvMulai.setText("Mulai: \t\t"+tugasItems.get(0).getMulai());
                            tvSelesai.setText("Selesai \t: "+tugasItems.get(0).getSelesai());
                        } else {
                            Toast.makeText(DetailTugasActivity.this, "Gagal mengambil data", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseDetailTugas> call, Throwable t) {
                        Toast.makeText(DetailTugasActivity.this, "Koneksi bermasalah", Toast.LENGTH_SHORT).show();
                    }
                });


        //data sementara, nanti diganti API
//        listTgs = new ArrayList<>();
//        listTgs.addAll(TugasData.getListData());
//
//        tvJudul = (TextView)findViewById(R.id.tv_judul_tugas);
//        tvJudul2 = (TextView)findViewById(R.id.tv_judul_tugas_dtl);
//        tvDetail = (TextView)findViewById(R.id.desk_tugas);
//
//        //String ids = getIntent().getStringExtra(EXTRA_ID);
//        int ids = getIntent().getIntExtra(EXTRA_ID, 0);
//
//        tvJudul2.setText(listTgs.get(ids).getRemarks());
//        tvDetail.setText(listTgs.get(ids).getName());
//
//        String txt = "ini "+ids;
//
//        tvJudul.setText(txt);
    }
}
