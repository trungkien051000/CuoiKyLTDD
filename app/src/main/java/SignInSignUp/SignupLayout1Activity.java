package SignInSignUp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pinterest.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SignupLayout1Activity extends AppCompatActivity {


    UsernameValidator usernameValidator;
    PasswordValidator passwordValidator;
    TextInputLayout lout1,lout2,lout3;
    TextInputEditText edt_sg_email,edt_sg_pass,edt_sg_rpass;
    Button btn_Next;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_layout1);


        usernameValidator = new UsernameValidator();
        passwordValidator = new PasswordValidator();
        edt_sg_email =  findViewById(R.id.user);
        edt_sg_pass =  findViewById(R.id.pass);
        edt_sg_rpass =  findViewById(R.id.repass);
        lout1 = findViewById(R.id.ipLayout1);
        lout2 = findViewById(R.id.ipLayout2);
        lout3 = findViewById(R.id.ipLayout3);
        btn_Next = (Button) findViewById(R.id.btn_next1);
        DB = new DBHelper(this);

        edt_sg_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length()==0)
                    lout1.setError("Bạn bắt buộc phải nhập tên đăng nhập");
                else
                    lout1.setError(null);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        edt_sg_pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length()==0)
                    lout2.setError("Bạn bắt buộc phải nhập mật khẩu");
                else
                    lout2.setError(null);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        edt_sg_rpass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length()==0)
                    lout3.setError("Bạn bắt buộc phải nhập lại mật khẩu");
                else
                    lout3.setError(null);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        btn_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = edt_sg_email.getText().toString();
                String pass = edt_sg_pass.getText().toString();
                String rpass = edt_sg_rpass.getText().toString();

                if(email.equals("")||pass.equals("")||rpass.equals(""))
                    Toast.makeText(SignupLayout1Activity.this,"Vui lòng nhập đầy đủ",Toast.LENGTH_SHORT).show();
                else{
                    if(usernameValidator.validate(edt_sg_email.getText().toString())==1){
                        if(passwordValidator.validate(edt_sg_pass.getText().toString())==1){
                            if(pass.equals(rpass)){
                                Boolean checkuser = DB.checkusername(email);
                                if(checkuser==false){
                                    Boolean insert = DB.insertData(email,pass);
                                    if(insert==true){
                                        //  Toast.makeText(SignupLayout1Activity.this,"Đăng ký thành công",Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(SignupLayout1Activity.this, SignupLayout4Activity.class);
                                        intent.putExtra("name",email);
                                        startActivity(intent);
                                    }
                                }else Toast.makeText(SignupLayout1Activity.this,"Tên đăng nhập đã đăng ký",Toast.LENGTH_SHORT).show();
                            }else Toast.makeText(SignupLayout1Activity.this,"Mập khẩu không đúng",Toast.LENGTH_SHORT).show();
                        }else {
                            lout2.setError("Mật khẩu phải đảm bảo: độ dài 8-20 ký tự, các kí tự cho phép gồm: chữ in hoa, chữ in thường, chữ số(a-z, A-Z hoặc 0-9), không sử dụng kí tự đặc biệt.");
                        }
                    }else
                        lout1.setError("Tên đăng nhập chỉ chứa các kí tự cho phép gồm: chữ in thường, chữ số (a-z, 0-9), dấu gạch dưới, dấu gạch ngang và dấu chấm. Tên đăng nhập phải bắt đầu hoặc kết thúc bằng chữ cái hoặc chữ số và phải chứa ít nhất ba chữ cái.");
                     }
            }
        });
        ImageView   backMain =  findViewById(R.id.back_main);
        backMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupLayout1Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}