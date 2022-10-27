package com.example.dz23;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;


public class FirstFragment extends Fragment {

    public static final String TEXT_BUNDLE_KEY = "text";
    public static final String IMAGE_BUNDLE_KEY = "image";
    private ImageView ivImage;
    private EditText etInput;
    private MaterialButton btnSend;
    private Uri imageForSend;

    //активети это окно
    //Фрагмент не может жить без активети,а Активети может жить без фрагмента
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ferst, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ivImage = view.findViewById(R.id.iv_image);
        etInput = view.findViewById(R.id.et_input);
        btnSend = view.findViewById(R.id.btn_send);

        setUpListeners();
    }

    private void setUpListeners() {
        ivImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                activityResultLauncher.launch(intent);

            }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = etInput.getText().toString().trim();
                Bundle bundle = new Bundle();
                bundle.putString(TEXT_BUNDLE_KEY, text);
                bundle.putString(IMAGE_BUNDLE_KEY, imageForSend.toString());
                getParentFragmentManager().beginTransaction()
                        .add(R.id.fragment_conteiner, SecondFragment.class, bundle)
                        .addToBackStack("FirstFragment")
                        .commit();
            }
        });

    }

    private final ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
        if (result.getResultCode() == Activity.RESULT_OK) {
            @Nullable Intent data = result.getData();
            if (data != null) {
                @Nullable Uri imageFromGallery = data.getData();
                if (imageFromGallery != null) {
                    ivImage.setImageURI(imageFromGallery);
                    imageForSend = imageFromGallery;
                }
            }
        }
    });
}