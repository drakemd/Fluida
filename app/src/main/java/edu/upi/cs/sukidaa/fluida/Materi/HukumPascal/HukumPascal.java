package edu.upi.cs.sukidaa.fluida.Materi.HukumPascal;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageButton;

import com.ToxicBakery.viewpager.transforms.DepthPageTransformer;
import com.ToxicBakery.viewpager.transforms.FlipHorizontalTransformer;

import edu.upi.cs.sukidaa.fluida.MainMenu;
import edu.upi.cs.sukidaa.fluida.Materi.Materi;
import edu.upi.cs.sukidaa.fluida.Materi.TekananAtmosfer.Atm1;
import edu.upi.cs.sukidaa.fluida.Materi.TekananHidrostatis.Hidro1;
import edu.upi.cs.sukidaa.fluida.Materi.TekananHidrostatis.Hidro10;
import edu.upi.cs.sukidaa.fluida.Materi.TekananHidrostatis.Hidro11;
import edu.upi.cs.sukidaa.fluida.Materi.TekananHidrostatis.Hidro2;
import edu.upi.cs.sukidaa.fluida.Materi.TekananHidrostatis.Hidro3;
import edu.upi.cs.sukidaa.fluida.Materi.TekananHidrostatis.Hidro4;
import edu.upi.cs.sukidaa.fluida.Materi.TekananHidrostatis.Hidro5;
import edu.upi.cs.sukidaa.fluida.Materi.TekananHidrostatis.Hidro6;
import edu.upi.cs.sukidaa.fluida.Materi.TekananHidrostatis.Hidro7;
import edu.upi.cs.sukidaa.fluida.Materi.TekananHidrostatis.Hidro8;
import edu.upi.cs.sukidaa.fluida.Materi.TekananHidrostatis.Hidro9;
import edu.upi.cs.sukidaa.fluida.Materi.TekananHidrostatis.TekananHidrostatis;
import edu.upi.cs.sukidaa.fluida.Menu.NavigationDrawerActivity;
import edu.upi.cs.sukidaa.fluida.R;

public class HukumPascal extends NavigationDrawerActivity implements View.OnClickListener{

    private Button materi, aplikasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setToolbarTitle("Hukum Pascal");

        ViewStub vs = (ViewStub)findViewById(R.id.viewStub);
        vs.setLayoutResource(R.layout.hukumpascal);
        vs.inflate();

        materi = (Button) findViewById(R.id.btnMateriPascal);
        aplikasi = (Button) findViewById(R.id.btnAplikasi);

        materi.setOnClickListener(this);
        aplikasi.setOnClickListener(this);
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
            case R.id.btnMateriPascal:
                Intent intent2 = new Intent(this, MateriHukumPascal.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.btnAplikasi:
                Intent intent = new Intent(this, AplikasiHukumPascal.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
