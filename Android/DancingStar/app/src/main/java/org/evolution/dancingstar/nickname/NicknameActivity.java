package org.evolution.dancingstar.nickname;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.evolution.dancingstar.R;
import org.evolution.dancingstar.main.MainActivity;

public class NicknameActivity extends AppCompatActivity {

    private EditText mEtNickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nickname);

        mEtNickname = findViewById(R.id.nickname_et_nickname);
        Button btnStart = findViewById(R.id.nickname_btn_start);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nickname = mEtNickname.getText().toString().trim();
                if(nickname.equals(""))
                    Toast.makeText(NicknameActivity.this, "닉네임을 입력해주세요.", Toast.LENGTH_SHORT).show();
                else {
                    SharedPreferences sharedPreferences = getSharedPreferences("preference",0);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("nickname",nickname);
                    editor.apply();
                    Intent intent = new Intent(NicknameActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
