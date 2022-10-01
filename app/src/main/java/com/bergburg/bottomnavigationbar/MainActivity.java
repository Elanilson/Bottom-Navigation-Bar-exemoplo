package com.bergburg.bottomnavigationbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.bergburg.bottomnavigationbar.fragments.HomerFragment;
import com.bergburg.bottomnavigationbar.fragments.LikeFragment;
import com.bergburg.bottomnavigationbar.fragments.SearchFragment;
import com.bergburg.bottomnavigationbar.fragments.ShopFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        getWindow().addFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        bottomNavigationView = findViewById(R.id.buttonNavigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.body_container,new HomerFragment()).commit();
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;
                switch (item.getItemId()){
                    case R.id.home:
                        fragment = new HomerFragment();
                        break;
                    case R.id.like:
                        fragment = new LikeFragment();
                        break;
                    case R.id.search:
                        fragment = new SearchFragment();
                        break;
                    case R.id.shop:
                        fragment = new ShopFragment();
                        break;

                }

                getSupportFragmentManager().beginTransaction().replace(R.id.body_container,fragment).commit();


                return true;
            }
        });
    }
}