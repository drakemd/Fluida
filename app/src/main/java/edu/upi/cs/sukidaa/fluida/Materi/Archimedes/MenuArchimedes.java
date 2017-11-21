package edu.upi.cs.sukidaa.fluida.Materi.Archimedes;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;

import edu.upi.cs.sukidaa.fluida.Materi.Materi;
import edu.upi.cs.sukidaa.fluida.Materi.TekananAtmosfer.TekananAtmosfer;
import edu.upi.cs.sukidaa.fluida.Materi.TekananPermukaan.TekananPermukaan;
import edu.upi.cs.sukidaa.fluida.Menu.NavigationDrawerActivity;
import edu.upi.cs.sukidaa.fluida.R;

public class MenuArchimedes extends NavigationDrawerActivity implements View.OnClickListener {
    Button btnArchimedes1, btnArchimedes2, btnArchimedes3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolbarTitle("Hukum Archimedes");

        ViewStub vs = (ViewStub)findViewById(R.id.viewStub);
        vs.setLayoutResource(R.layout.content_menu_archimedes);
        vs.inflate();
        btnArchimedes1 = (Button)findViewById(R.id.btnArchimedes1);
        btnArchimedes2 = (Button)findViewById(R.id.btnArchimedes2);
        btnArchimedes3 = (Button)findViewById(R.id.btnArchimedes3);
        btnArchimedes1.setOnClickListener(this);
        btnArchimedes2.setOnClickListener(this);
        btnArchimedes3.setOnClickListener(this);

    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, Materi.class);
        this.startActivity(intent);
        finish();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnArchimedes1:
                Intent intent = new Intent(this, HukumArchimedes.class);
                this.startActivity(intent);
                finish();
                break;
            case R.id.btnArchimedes2:
                intent = new Intent(this, Tenggelam.class);
                this.startActivity(intent);
                finish();
                break;
            case R.id.btnArchimedes3:
                intent = new Intent(this, AplikasiArchimedes.class);
                this.startActivity(intent);
                finish();
                break;
        }
    }
}
