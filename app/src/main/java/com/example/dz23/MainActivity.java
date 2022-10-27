package com.example.dz23;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirstFragment firstFragment = new FirstFragment();

        //Фрагмент менеджер отвечает за фрагменты
        FragmentManager fragmentManager = getSupportFragmentManager();
        //beginTransaction это метод для того что бы начать переход
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_conteiner,firstFragment)
                //commit метод для сохранения изменений
                .commit();


    }
}