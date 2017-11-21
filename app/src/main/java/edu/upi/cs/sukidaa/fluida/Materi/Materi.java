package edu.upi.cs.sukidaa.fluida.Materi;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.TextView;

import edu.upi.cs.sukidaa.fluida.Materi.Archimedes.MenuArchimedes;
import edu.upi.cs.sukidaa.fluida.Materi.HukumPascal.HukumPascal;
import edu.upi.cs.sukidaa.fluida.Materi.TekananAtmosfer.TekananAtmosfer;
import edu.upi.cs.sukidaa.fluida.Materi.TekananHidrostatis.TekananHidrostatis;
import edu.upi.cs.sukidaa.fluida.Materi.TekananPermukaan.TekananPermukaan;
import edu.upi.cs.sukidaa.fluida.Menu.NavigationDrawerActivity;
import edu.upi.cs.sukidaa.fluida.R;

public class Materi extends NavigationDrawerActivity implements View.OnClickListener{

    private TextView tvMateri;
    private Button btnAtmosfer, btnHidrostatis, btnPermukaan, btnPascal, btnArchi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setToolbarTitle("Materi");

        ViewStub vs = (ViewStub)findViewById(R.id.viewStub);
        vs.setLayoutResource(R.layout.content_materi);
        vs.inflate();

        tvMateri = (TextView) findViewById(R.id.tvMateri);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            tvMateri.setText(Html.fromHtml(getString(R.string.materi), Html.FROM_HTML_MODE_COMPACT));
        }else{
            tvMateri.setText(Html.fromHtml(getString(R.string.materi)));
        }

        btnAtmosfer = (Button) findViewById(R.id.btnAtmosfer);
        btnHidrostatis = (Button) findViewById(R.id.btnHidrostatis);
        btnPermukaan = (Button) findViewById(R.id.btnTegang);
        btnPascal = (Button) findViewById(R.id.btnPascal);
        btnArchi = (Button) findViewById(R.id.btnArchimedes);

        btnAtmosfer.setOnClickListener(this);
        btnHidrostatis.setOnClickListener(this);
        btnPermukaan.setOnClickListener(this);
        btnPascal.setOnClickListener(this);
        btnArchi.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            drawer.openDrawer(GravityCompat.START);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAtmosfer:
                Intent intent = new Intent(this, TekananAtmosfer.class);
                this.startActivity(intent);
                finish();
                break;
            case R.id.btnHidrostatis:
                Intent intent2 = new Intent(this, TekananHidrostatis.class);
                this.startActivity(intent2);
                finish();
                break;
            case R.id.btnTegang:
                Intent intent3 = new Intent(this, TekananPermukaan.class);
                this.startActivity(intent3);
                finish();
                break;
            case R.id.btnPascal:
                Intent intent4 = new Intent(this, HukumPascal.class);
                this.startActivity(intent4);
                finish();
                break;
            case R.id.btnArchimedes:
                Intent intent5 = new Intent(this, MenuArchimedes.class);
                this.startActivity(intent5);
                finish();
                break;
        }
    }
}
