package com.khales.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.khales.myapplication.databinding.ActivityMain2Binding;


public class MainActivity2 extends AppCompatActivity {

    ActivityMain2Binding binding ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new HomeFragment());


//        NavController navController = Navigation.findNavController(this, R.id.frame_layout);
//        int id=navController.getCurrentDestination().getId();
//        if(id==R.id.homeFragment ){ // change the fragment id
//            selectedPosition(0);
//
//        }else if(id==R.id.gameFragment ){ // change the fragment id
//            selectedPosition(1);
//
//        }else if(id==R.id.endGameFragment ){ // change the fragment id
//            selectedPosition(2);
//
//        }
        binding.navigationBottom.setOnItemSelectedListener(item -> {
            Log.e("aaaaa", "asdasdahdkjahds");
            switch (item.getItemId()){
                case R.id.FirstFragment:
               //     if(id !=R.id.FirstFragment )
                    replaceFragment(new HomeFragment());
                    break;

                case R.id.ProfileFragment:
                  //  if(id !=R.id.ProfileFragment )
                        replaceFragment(new ProfileFragment());

                    break;


            }
            return true;

        });


    }

    private void replaceFragment (Fragment fragment)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

}