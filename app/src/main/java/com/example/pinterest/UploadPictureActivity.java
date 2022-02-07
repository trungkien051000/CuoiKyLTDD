package com.example.pinterest;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

public class UploadPictureActivity extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST = 1;
    private Button mBtnUpload;
    private TextView btnShow;
    private ImageView mChooseImage, icBack;
    private EditText mEdtTieude, mEdtMota;
    private ProgressBar mProgressBar;
    private long time;
    private Uri mImageUri;
    private String fileExtension,name;

    private StorageReference mStorageRef;
    private DatabaseReference mDatabaseRef;

    private StorageTask mUploadTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_picture);

        mBtnUpload = findViewById(R.id.btn_upload);
        mChooseImage = findViewById(R.id.chooseImage);
        mEdtTieude = findViewById(R.id.edt_upload_tieude);
        mEdtMota = findViewById(R.id.edt_upload_mota);
        mProgressBar = findViewById(R.id.progress_bar);
        icBack = findViewById(R.id.back_upload_picture);
        btnShow = findViewById(R.id.btn_Showall);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");

        mStorageRef = FirebaseStorage.getInstance().getReference("uploads");
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("uploads");


        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UploadPictureActivity.this, LayoutTrangchuActivity.class);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });
        icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UploadPictureActivity.this, MainActivityAccount.class);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });
        mChooseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChoose();
            }
        });

        mBtnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mUploadTask != null && mUploadTask.isInProgress()) {
                    Toast.makeText(UploadPictureActivity.this, "Đang đăng ảnh, vui lòng chờ !", Toast.LENGTH_SHORT).show();
                } else {
                    uploadFile();
                }
            }
        });


    }

    private void openFileChoose() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            mImageUri = data.getData();

            Picasso.with(this).load(mImageUri).into(mChooseImage);
            mEdtTieude.setText("");
            mEdtMota.setText("");
        }
    }

    private String getFileExtension(Uri uri) {
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }

    private void uploadFile() {
        if (mImageUri != null) {
            if (mEdtTieude.getText().toString() == "" || mEdtMota.getText().toString() == "") {
                Toast.makeText(UploadPictureActivity.this, "Vui lòng nhập tiêu đề và mô tả !", Toast.LENGTH_SHORT).show();
            } else {
                time = System.currentTimeMillis();

                StorageReference fileReference = mStorageRef.child(time
                        + "." + getFileExtension(mImageUri));
                mUploadTask = fileReference.putFile(mImageUri)
                        .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {

                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                fileExtension = getFileExtension(mImageUri);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        mProgressBar.setProgress(0);
                                    }
                                }, 500);
                                Toast.makeText(UploadPictureActivity.this, "Đăng ảnh thành công", Toast.LENGTH_SHORT).show();

                                fileReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {
                                        Upload upload = new Upload(String.valueOf(time),name, mEdtTieude.getText().toString(), mEdtMota.getText().toString(),
                                                String.valueOf(uri), fileExtension);
                                        String uploadID = mDatabaseRef.push().getKey();
                                        mDatabaseRef.child(uploadID).setValue(upload);
                                    }
                                });

                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(UploadPictureActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                                double progress = (100.0 * snapshot.getBytesTransferred() / snapshot.getTotalByteCount());
                                mProgressBar.setProgress((int) progress);
                            }
                        });
            }
        }else {
            Toast.makeText(this, "Không có ảnh nào được chọn", Toast.LENGTH_SHORT).show();
        }
    }
}