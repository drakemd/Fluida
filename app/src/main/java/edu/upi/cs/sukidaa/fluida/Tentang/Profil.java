package edu.upi.cs.sukidaa.fluida.Tentang;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewStub;
import android.widget.TabHost;
import android.widget.TextView;

import edu.upi.cs.sukidaa.fluida.Menu.NavigationDrawerActivity;
import edu.upi.cs.sukidaa.fluida.R;

public class Profil extends NavigationDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolbarTitle("Profil Penyusun");
        ViewStub vs = (ViewStub)findViewById(R.id.viewStub);
        vs.setLayoutResource(R.layout.content_profil);
        vs.inflate();
        Typeface textfont= Typeface.createFromAsset(getAssets(),"BENGUIAN.TTF");
        TextView judul = (TextView)findViewById(R.id.judul);
        TextView nama = (TextView)findViewById(R.id.nama);
        TextView deskripsi = (TextView)findViewById(R.id.deskripsi);
        judul.setTypeface(textfont);
        nama.setTypeface(textfont);
        deskripsi.setTypeface(textfont);

    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, Tentang.class);
        this.startActivity(intent);
        this.finish();
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_righ);
    }
}
