package com.example.dz23;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondFragment extends Fragment {

    private ImageView ivFullscreen;
    private TextView tvText;

    //фрагмент привязывется к активности
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    // Фрвгмент создается
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //Создается содержимое фрагмента
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // inflater раздувает наши Вьюшки цмлки-возврощает наши вьюшки
        return inflater.inflate(R.layout.fragment_second, container, false);

    }

    // Содержимое уже было создано
    //onViewCreted нужен тогда когда все вьюшки были созданы
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        intialize(view);
        getData();

    }

    private void intialize(View view) {
        ivFullscreen = view.findViewById(R.id.iv_fullscreen);
        tvText = view.findViewById(R.id.tv_text);
    }

    private void getData() {
        Bundle data = getArguments();
        if(data!=null){
            // текст который я получаю из первого фрагмента
            String text = data.getString(FirstFragment.TEXT_BUNDLE_KEY);
            Uri imageForGet = Uri.parse(data.getString(FirstFragment.IMAGE_BUNDLE_KEY));
            tvText.setText(text);
            ivFullscreen.setImageURI(imageForGet);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    // Уничтожает содержимое фрагмента
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    // Фрагмент отвязывается от Активети
    @Override
    public void onDetach() {
        super.onDetach();
    }
}