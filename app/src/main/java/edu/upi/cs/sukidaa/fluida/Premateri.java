package edu.upi.cs.sukidaa.fluida;

import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ViewFlipper;

import edu.upi.cs.sukidaa.fluida.Materi.Materi;

public class Premateri extends AppCompatActivity {

    int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_premateri);
        final ImageButton buttonnext = (ImageButton)findViewById(R.id.buttonnext);
        final ImageButton buttonprev = (ImageButton)findViewById(R.id.buttonprev);
        final ViewFlipper viewFlipper = (ViewFlipper)findViewById(R.id.viewpremateri);
        viewFlipper.setInAnimation(this, R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this, R.anim.slide_out_left);

        buttonprev.setVisibility(View.GONE);


        buttonnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.showNext();
                if(viewFlipper.getDisplayedChild()==0){
                    buttonprev.setVisibility(View.GONE);
                }else{
                    buttonprev.setVisibility(View.VISIBLE);
                }

                if(viewFlipper.getDisplayedChild()==3){
                    Intent intent = new Intent(Premateri.this, Materi.class);
                    startActivity(intent);
                }
            }
        });

        buttonprev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.showPrevious();
                if(viewFlipper.getDisplayedChild()==0){
                    buttonprev.setVisibility(View.GONE);
                }else{
                    buttonprev.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        //nothing
    }
}
