package edu.upi.cs.sukidaa.fluida;

/**
 * Created by drake on 6/17/2017.
 */

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;;import edu.upi.cs.sukidaa.fluida.Latihan.Latihan;
import edu.upi.cs.sukidaa.fluida.Materi.Materi;
import edu.upi.cs.sukidaa.fluida.Tentang.Tentang;

public class MainMenu extends AppCompatActivity implements View.OnClickListener{

    ImageButton materi, tentang, exit, latihan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        materi = (ImageButton) findViewById(R.id.buttonmateri);
        exit = (ImageButton) findViewById(R.id.imageButton5);
        tentang = (ImageButton) findViewById(R.id.buttontentang);
        latihan = (ImageButton) findViewById(R.id.buttonlatihan);

        materi.setOnClickListener(this);
        exit.setOnClickListener(this);
        tentang.setOnClickListener(this);
        latihan.setOnClickListener(this);
    }

    public void exit_game(){
        ViewDialog alert = new ViewDialog();
        alert.showDialogExit(MainMenu.this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonmateri:
                Intent intent = new Intent(this, Materi.class);
                this.startActivity(intent);
                this.finish();
                break;
            case R.id.imageButton5:
                exit_game();
                break;
            case R.id.buttontentang:
                Intent intent1 = new Intent(this, Tentang.class);
                this.startActivity(intent1);
                this.finish();
                break;
            case R.id.buttonlatihan:
                Intent intent2 = new Intent(this, Latihan.class);
                this.startActivity(intent2);
                this.finish();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        exit_game();
    }
}
