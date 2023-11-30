package com.example.bottomnavigation;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.bottomnavigation.Fragments.FirstFragment;
import com.example.bottomnavigation.Fragments.SecondFragment;
import com.example.bottomnavigation.Fragments.ThirdFragment;
import com.example.bottomnavigation.R;
import com.example.bottomnavigation.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                if(id == R.id.person){
                    FirstFragment firstFragment = new FirstFragment();
                    replaceFragment(firstFragment);
                    return true;
                }else if(id == R.id.home){
                    SecondFragment secondFragment = new SecondFragment();
                    replaceFragment(secondFragment);
                }else {
                    ThirdFragment thirdFragment = new ThirdFragment();
                    replaceFragment(thirdFragment);
                }

                return true;
            }
        });




    }



    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutFragment, fragment);
        fragmentTransaction.commit();
    }
}
