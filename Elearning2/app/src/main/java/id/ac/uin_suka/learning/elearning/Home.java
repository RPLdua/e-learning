package id.ac.uin_suka.learning.elearning;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        BottomNavigationView botnav = findViewById(R.id.navigation);
        botnav.setOnNavigationItemSelectedListener(this);

        //loadFragment(new HomeFragment());
        //Manually displaying the first fragment - one time only
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fl_container, HomeFragment.newInstance());
        transaction.commit();

    }

    // method untuk load fragment yang sesuai
    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        Fragment fragment = null;

        switch (item.getItemId()){
            case R.id.nav_home:
                fragment = new HomeFragment();
                break;
            case R.id.nav_makul:
                fragment = new MataKuliahFragment();
                //Intent intent = new Intent(Home.this, CobaActivity.class);
                //startActivity(intent);
                break;
            case R.id.nav_tugas:
                fragment = new TugasActivity();
                //Intent intent2 = new Intent(Home.this, TugasActivity.class);
                //startActivity(intent2);
                break;
            case R.id.nav_akun:
                fragment = new AkunFragment();
                //Intent intent3 = new Intent(Home.this, CobaActivity.class);
                //startActivity(intent3);
                break;
        }
        return loadFragment(fragment);
    }
}
