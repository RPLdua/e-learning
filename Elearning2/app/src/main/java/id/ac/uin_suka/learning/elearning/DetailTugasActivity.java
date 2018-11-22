package id.ac.uin_suka.learning.elearning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailTugasActivity extends AppCompatActivity {
    public  static  String EXTRA_ID = "extra_id";
    private TextView tvJudul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tugas);

        tvJudul = (TextView)findViewById(R.id.tv_judul_tugas);
        String ids = getIntent().getStringExtra(EXTRA_ID);

        tvJudul.setText(ids);
    }
}
