package id.ac.uin_suka.learning.elearning;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActivityTahunAjaran extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tahun_ajaran);
        ActionBar menu = getSupportActionBar();
        menu.setDisplayHomeAsUpEnabled(true);
        this.setTitle("Tahun Ajaran");
    }
}
