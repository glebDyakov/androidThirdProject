package gleb.first_app.com;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private EditText text_from_user;
    private TextView result;
    private Button btn;
    private Float num;
    private FloatingActionButton floatBtn;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OnBtnClick();
    }
    public void OnBtnClick(){
        this.text_from_user = (EditText) findViewById(R.id.editText);
        this.result = (TextView) findViewById(R.id.result_field);
        this.btn=findViewById(R.id.btn_convert);
        this.floatBtn=findViewById(R.id.floatBtn);
        floatBtn.setOnClickListener(View.OnClickListener(){
            @Override
            public void OnClick(View view){
                Intent intent = new Intent("gleb.first_app.com.glebprogect.LoginPageActivity");
                startActivity(intent);
            }
        });

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void OnClick(View view){
                String text= text_from_user.getText().toString();
                if(text.matches("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("хотите умножить значение на 2");
                    builder.setCancelable(false);
                    builder.setPositiveButton("Да", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                                num *= 2f;
                                num *= 1.61f * 2f;
                                result.setText(Float.toString(num));
                                btn.setText("готово");
                                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                                    btn.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                                }else{
                                    btn.setBackgroundColor(Color.GREEN);
                                }
                        }
                    });

                    builder.setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog alert = builder.create();
                    alert.setTitle("Умножение чисел");
                    alert.show();
                    Float num = Float.parseFloat(text_from_user.getText().toString());
                    num *= 10;
                    result.setText(Float.toString(num));
                    btn.setText("готово");
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                        btn.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                    }else{
                        btn.setBackgroundColor(Color.GREEN);
                    }

                }else{
                    Toast.makeText(MainActivity.this, "Введите какой-то текст").show();
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                        btn.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                    }else{
                        btn.setBackgroundColor(Color.RED);
                    }
                }
            }
        });


    }
}