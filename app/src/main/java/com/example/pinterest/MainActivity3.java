package com.example.pinterest;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.squareup.picasso.Picasso;

import java.io.InputStream;

public class MainActivity3 extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST = 1;
    private ImageButton backbtn;
    private Button donebtn, btnsua;
    private TextView ten, tenngdung;
    private ImageView profileImageview;
    private long time;
    private String fileExtension;
    public Uri mImageUri;
    private StorageTask mUploadTask;
    public Bitmap bitmap;
    private DatabaseReference mDatabaseRef;
    private StorageReference mStorageRef;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        backbtn = (ImageButton) findViewById(R.id.back);
        ten = findViewById(R.id.hoangkhong);
        tenngdung = findViewById(R.id.hoangkhong98);
        btnsua = findViewById(R.id.btn_sua);
        profileImageview = findViewById(R.id.img_edit_hoso);
        Intent intentGet = getIntent();
        name = intentGet.getStringExtra("name");

        ten.setText(name);
        tenngdung.setText(name);

        mStorageRef = FirebaseStorage.getInstance().getReference("avatar");
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("avatar");


        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });
        donebtn = (Button) findViewById(R.id.donebtn);

        donebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadFile();
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                    if (user.getPhotoUrl() != null) {
                        Glide.with(MainActivity3.this).load(user.getPhotoUrl()).into(profileImageview);
                    }
                }
            }
        });

        btnsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFileChoose();
//
            }
        });
        BottomNavigationView botNav = findViewById(R.id.bottom_navigation9);
        botNav.getMenu().findItem(R.id.bottom_account).setChecked(true);
        botNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bottom_home:
                        Toast.makeText(MainActivity3.this, "Trang chủ", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity3.this, LayoutTrangchuActivity.class);
                        intent.putExtra("name", name);
                        startActivity(intent);
                        break;
                    case R.id.bottom_search:
                        Toast.makeText(MainActivity3.this, "Tìm kiếm", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(MainActivity3.this, MainTimKiemActivity.class);
                        intent1.putExtra("name", name);
                        startActivity(intent1);
                        break;
                    case R.id.bottom_messenger:
                        Toast.makeText(MainActivity3.this, "Nhắn tin", Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent(MainActivity3.this, ThongbaoActivity.class);
                        intent2.putExtra("name", name);
                        startActivity(intent2);
                        break;
                    case R.id.bottom_account:
                        Toast.makeText(MainActivity3.this, "Tài khoản", Toast.LENGTH_SHORT).show();
                        Intent intent3 = new Intent(MainActivity3.this, MainActivityAccount.class);
                        intent3.putExtra("name", name);
                        startActivity(intent3);
                        break;
                }
                return true;
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
            Picasso.with(this).load(mImageUri).into(profileImageview);
        }
    }

    private String getFileExtension(Uri uri) {
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }

    private void uploadFile() {

        final ProgressDialog dialog=new ProgressDialog(this);
        dialog.setTitle("File Uploader");
        dialog.show();

        if (mImageUri != null) {
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
                                    dialog.setProgress(0);
                                }
                            }, 500);
                            Toast.makeText(MainActivity3.this, "Đăng ảnh thành công", Toast.LENGTH_SHORT).show();

                            fileReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    Avatar avatar = new Avatar(String.valueOf(time),String.valueOf(uri), fileExtension);
                                    String uploadID = mDatabaseRef.push().getKey();
                                    mDatabaseRef.child(uploadID).setValue(avatar);
                                }
                            });

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(MainActivity3.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                            double progress = (100.0 * snapshot.getBytesTransferred() / snapshot.getTotalByteCount());
                            dialog.setMessage("Uploaded :" + progress + " %");
                        }
                    });

        } else {
            Toast.makeText(this, "Không có ảnh nào được chọn", Toast.LENGTH_SHORT).show();
        }
    }
    }