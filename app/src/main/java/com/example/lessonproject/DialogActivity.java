package com.example.lessonproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {

    private AlertDialog.Builder builder;
    private static final int pic_id = 123;
    private ImageView pictureImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        pictureImage = findViewById(R.id.imageView2);
        findViewById(R.id.button).setOnClickListener(v -> {
//            Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();

//            openCustomDialog();

            Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            // Start the activity with camera_intent, and request pic id
            startActivityForResult(camera_intent, pic_id);
        });
    }

    // this function is triggered when
    // the Select Image Button is clicked
    void imageChooser() {

        // create an instance of the
        // intent of the type image
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        // pass the constant to compare it
        // with the returned requestCode
//        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
    }

    // this function is triggered when user
    // selects the image from the imageChooser
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//
//        if (resultCode == RESULT_OK) {
//
//            // compare the resultCode with the
//            // SELECT_PICTURE constant
//            if (requestCode == SELECT_PICTURE) {
//                // Get the url of the image from data
//                Uri selectedImageUri = data.getData();
//                if (null != selectedImageUri) {
//                    // update the preview image in the layout
//                    IVPreviewImage.setImageURI(selectedImageUri);
//                }
//            }
//        }
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        Bitmap photo = (Bitmap) data.getExtras().get("data");
//        // Set the image in imageview for display
//        pictureImage.setImageBitmap(photo);
//
//    }

    private void openCustomDialog() {
        builder = new AlertDialog.Builder(this);
        View inflatedView = getLayoutInflater().inflate(R.layout.custom_view, null);
        Button submitButton = inflatedView.findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(DialogActivity.this, "Hello again clicked", Toast.LENGTH_SHORT).show();
                openCustomDialog2();
            }
        });


        builder.setView(inflatedView);
        builder.show();
    }

    private void openCustomDialog2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View inflatedView = getLayoutInflater().inflate(R.layout.custom_view2, null);
        Button submitButton = inflatedView.findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DialogActivity.this, "Inside the second one", Toast.LENGTH_SHORT).show();
            }
        });


        builder.setView(inflatedView);
        builder.show();
    }
}