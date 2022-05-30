package com.example.myapplication_study;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication_study.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    Button btn_login;

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        //버튼 연결
        btn_login=findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, loginfrom.class);
                startActivity(intent);
            }
        });
        */

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new Reservation());
        binding.bottomNavi.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.resvation:
                    replaceFragment(new Reservation());
                    break;
                case R.id.voucher:
                    replaceFragment(new Voucher());
                    break;
                case R.id.notice:
                    replaceFragment(new Notice());
                    break;
                case R.id.myfage:
                    replaceFragment(new Myfage());
                    break;
            }

            return true;
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();
    }
}
//수정