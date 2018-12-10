package id.ac.uin_suka.learning.elearning;

import android.content.Intent;
        import android.os.Handler;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //private Button btnMoveActivity;
    private int waktu_loading=3000;

    //4000=4 detik

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //btnMoveActivity = (Button)findViewById(R.id.btn_move);
        //btnMoveActivity.setOnClickListener(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //setelah loading maka akan langsung berpindah ke home activity
                Intent Home=new Intent(MainActivity.this, LoginActivity.class);
                startActivity(Home);
                finish();
            }
        },waktu_loading);
    }

    /*@Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_move:
                Intent moveIntent = new Intent(MainActivity.this, Home.class);
                startActivity(moveIntent);
                break;
        }
    }*/
}