package edu.upi.cs.sukidaa.fluida.Tentang;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;

import edu.upi.cs.sukidaa.fluida.MainMenu;
import edu.upi.cs.sukidaa.fluida.Menu.NavigationDrawerActivity;
import edu.upi.cs.sukidaa.fluida.R;

public class Tentang extends NavigationDrawerActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolbarTitle("Tentang");
        ViewStub vs = (ViewStub)findViewById(R.id.viewStub);
        vs.setLayoutResource(R.layout.content_tentang);
        vs.inflate();
        Button btnDosen = (Button)findViewById(R.id.btnDosen);
        Button btnProfil = (Button)findViewById(R.id.btnProfil);
        Button btnReferensi = (Button)findViewById(R.id.btnReferensi);
        btnDosen.setOnClickListener(this);
        btnProfil.setOnClickListener(this);
        btnReferensi.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnDosen:
                Intent intent = new Intent(this, Dospem.class);
                this.startActivity(intent);
                this.finish();
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                break;
            case R.id.btnProfil:
                intent = new Intent(this, Profil.class);
                this.startActivity(intent);
                this.finish();
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                break;
            case R.id.btnReferensi:
                intent = new Intent(this, Referensi.class);
                this.startActivity(intent);
                this.finish();
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
        finish();
    }
}
