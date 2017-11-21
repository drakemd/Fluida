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

public class Dospem  extends NavigationDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolbarTitle("Dosen Pembimbing");
        ViewStub vs = (ViewStub)findViewById(R.id.viewStub);
        vs.setLayoutResource(R.layout.content_dospem);
        vs.inflate();
        Typeface textfont= Typeface.createFromAsset(getAssets(),"BENGUIAN.TTF");
        TextView nama1 = (TextView)findViewById(R.id.nama1);
        TextView nama2 = (TextView)findViewById(R.id.nama2);
        nama1.setTypeface(textfont);
        nama2.setTypeface(textfont);
        TabHost host = (TabHost)findViewById(R.id.tabhost);
        host.setup();
        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Pembimbing 1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Pembimbing 1");
        host.addTab(spec);
        //Tab 2
        spec = host.newTabSpec("Pembimbing 2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Pembimbing 2");
        host.addTab(spec);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, Tentang.class);
        this.startActivity(intent);
        this.finish();
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_righ);
    }

}
