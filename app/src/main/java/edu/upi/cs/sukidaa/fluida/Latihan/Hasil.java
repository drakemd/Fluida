package edu.upi.cs.sukidaa.fluida.Latihan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ViewFlipper;

import edu.upi.cs.sukidaa.fluida.MainMenu;
import edu.upi.cs.sukidaa.fluida.R;

public class Hasil extends AppCompatActivity implements View.OnClickListener{

    Button btnCoba;
    ImageButton home1, home2;
    TextView tvNilai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appbarlayout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Latihan");

        setSupportActionBar(toolbar);

        ViewStub vs = (ViewStub)findViewById(R.id.viewStub);
        vs.setLayoutResource(R.layout.hasil);
        vs.inflate();

        ViewFlipper viewFlipper = (ViewFlipper) findViewById(R.id.vp);

        int nilai = 0;
        Intent intent = getIntent();

        if(intent.getExtras()!=null){
            nilai = intent.getIntExtra("nilai",0);
        }

        if(nilai!=10){
            viewFlipper.showNext();
        }

        btnCoba = (Button) findViewById(R.id.btntry);
        home1 = (ImageButton) findViewById(R.id.home1);
        home2 = (ImageButton) findViewById(R.id.home2);

        tvNilai = (TextView) findViewById(R.id.nilai);

        tvNilai.setText("Nilai: " + nilai*10);

        btnCoba.setOnClickListener(this);
        home1.setOnClickListener(this);
        home2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btntry:
                Intent intent = new Intent(this, Soal.class);
                startActivity(intent);
                finish();
                break;
            case R.id.home1:
                Intent intent2 = new Intent(this, MainMenu.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.home2:
                Intent intent3 = new Intent(this, MainMenu.class);
                startActivity(intent3);
                finish();
                break;
        }
    }
}
