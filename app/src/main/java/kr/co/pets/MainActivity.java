package kr.co.pets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView text1, text2;
    //CheckBox chkAgree;
    Switch switchAgree;
    RadioGroup rGroup1;
    //RadioButton rdoDog, rdoCat, rdoRabbit;
    RadioButton[] radioArray = new RadioButton[3];
    //Button btnOK;
    ImageView imgPet;
    Button btnQuit, btnRerun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.s12);
        //setTitle("애완동물 사진 보기");
        setTitle("안드로이드 사진 보기");

        // 위젯을 변수에 대입
        text1 = findViewById(R.id.textView);
        switchAgree = findViewById(R.id.switchAgree);

        text2 = findViewById(R.id.textView2);
        rGroup1 = findViewById(R.id.Rgroup1);
//        rdoDog = findViewById(R.id.RdoDog);
//        rdoCat = findViewById(R.id.RdoCat);
//        rdoRabbit = findViewById(R.id.RdoRabbit);

        radioArray[0] = findViewById(R.id.Rdo100);
        radioArray[1] = findViewById(R.id.Rdo110);
        radioArray[2] = findViewById(R.id.Rdo120);

        //btnOK = findViewById(R.id.buttonOK);
        imgPet = findViewById(R.id.imageView);

        btnQuit = findViewById(R.id.BtnQuit);
        btnRerun = findViewById(R.id.BtnRerun);

        // 동의함 체크박스의 체크가 변경되면
/*
        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                //체크되면 모두 보이도록 설정
                if (chkAgree.isChecked() == true) {
                    text2.setVisibility(android.view.View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);
                    btnOK.setVisibility(View.VISIBLE);
                    imgPet.setVisibility(View.VISIBLE);
                }
                else {
                    text2.setVisibility(android.view.View.INVISIBLE);
                    rGroup1.setVisibility(View.INVISIBLE);
                    btnOK.setVisibility(View.INVISIBLE);
                    imgPet.setVisibility(View.INVISIBLE);
                }
            }
        });
*/

        switchAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                //체크되면 모두 보이도록 설정
                if (switchAgree.isChecked() == true) {
                    text2.setVisibility(View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);
                    imgPet.setVisibility(View.VISIBLE);
                    btnQuit.setVisibility(View.VISIBLE);
                    btnRerun.setVisibility(View.VISIBLE);
                }
                else {
                    text2.setVisibility(View.INVISIBLE);
                    rGroup1.setVisibility(View.INVISIBLE);
                    imgPet.setVisibility(View.INVISIBLE);
                    btnQuit.setVisibility(View.INVISIBLE);
                    btnRerun.setVisibility(View.INVISIBLE);
                }
            }
        });

/*
        // 선택 완료 버튼을 클릭하면
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (rGroup1.getCheckedRadioButtonId()) {
                    case R.id.RdoDog:
                        imgPet.setImageResource(R.drawable.dog3);
                        break;
                    case R.id.RdoCat:
                        imgPet.setImageResource(R.drawable.cat1);
                        break;
                    case R.id.RdoRabbit:
                        imgPet.setImageResource(R.drawable.rabbit2);
                    default:
                        Toast.makeText(getApplicationContext(), "동물 먼저 선택하세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });
*/

        // 라디오 버튼을 클릭할 때, 이미지 뷰를 변경시킴 ==> 배열로 처리함.
        final int[] draw = {R.drawable.q10, R.drawable.r11, R.drawable.s12};

        for (int i=0; i<radioArray.length; i++) {
            final int index;
            index = i;
            radioArray[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    imgPet.setImageResource(draw[index]);
                }
            });
        }

        // 종료 버튼을 클릭하면
        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // 처음으로 버튼을 클릭하면
        btnRerun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text2.setVisibility(View.VISIBLE);
                rGroup1.setVisibility(View.VISIBLE);
                imgPet.setVisibility(View.VISIBLE);
                btnQuit.setVisibility(View.VISIBLE);
                btnRerun.setVisibility(View.VISIBLE);

                rGroup1.clearCheck();
                switchAgree.setChecked(false);
            }
        });
    }
}































