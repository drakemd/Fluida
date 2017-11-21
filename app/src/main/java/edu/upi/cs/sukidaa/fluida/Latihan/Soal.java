package edu.upi.cs.sukidaa.fluida.Latihan;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageButton;

import com.ToxicBakery.viewpager.transforms.BackgroundToForegroundTransformer;
import com.ToxicBakery.viewpager.transforms.RotateDownTransformer;

import edu.upi.cs.sukidaa.fluida.MainMenu;
import edu.upi.cs.sukidaa.fluida.Materi.HukumPascal.AplPascal1;
import edu.upi.cs.sukidaa.fluida.Materi.HukumPascal.AplPascal2;
import edu.upi.cs.sukidaa.fluida.Materi.HukumPascal.AplPascal3;
import edu.upi.cs.sukidaa.fluida.Materi.HukumPascal.AplPascal4;
import edu.upi.cs.sukidaa.fluida.Materi.HukumPascal.AplPascal5;
import edu.upi.cs.sukidaa.fluida.Materi.HukumPascal.AplikasiHukumPascal;
import edu.upi.cs.sukidaa.fluida.Materi.TekananAtmosfer.Atm1;
import edu.upi.cs.sukidaa.fluida.R;


public class Soal extends AppCompatActivity implements View.OnClickListener{

    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 10;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;
    private static Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10;

    private int selectedPage; // set selected page
    private String jawaban[], kunci[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.appbarlayout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Latihan");

        setSupportActionBar(toolbar);

        jawaban = new String[10];
        kunci = new String[]{"a","c","a","d","d","b","a","c","c","b"};

        ViewStub vs = (ViewStub)findViewById(R.id.viewStub);
        vs.setLayoutResource(R.layout.soalpager);
        vs.inflate();

        btn1 = (Button) findViewById(R.id.btnNo1);
        btn2 = (Button) findViewById(R.id.btnNo2);
        btn3 = (Button) findViewById(R.id.btnNo3);
        btn4 = (Button) findViewById(R.id.btnNo4);
        btn5 = (Button) findViewById(R.id.btnNo5);
        btn6 = (Button) findViewById(R.id.btnNo6);
        btn7 = (Button) findViewById(R.id.btnNo7);
        btn8 = (Button) findViewById(R.id.btnNo8);
        btn9 = (Button) findViewById(R.id.btnNo9);
        btn10 = (Button) findViewById(R.id.btnNo10);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn10.setOnClickListener(this);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager); //the UI pager
        mPagerAdapter = new Soal.ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mPager.setPageTransformer(true, new BackgroundToForegroundTransformer()); //set the animation

        selectedPage = 0; //current page
        if(savedInstanceState != null){ //if app was paused, you can reopen the same page
            selectedPage = savedInstanceState.getInt("SELECTED_PAGE");
        }

        mPager.setCurrentItem(selectedPage); //set the current page
        mPager.setOffscreenPageLimit(9);
    }


    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            //do nothing
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnNo1:
                mPager.setCurrentItem(0);
                break;
            case R.id.btnNo2:
                mPager.setCurrentItem(1);
                break;
            case R.id.btnNo3:
                mPager.setCurrentItem(2);
                break;
            case R.id.btnNo4:
                mPager.setCurrentItem(3);
                break;
            case R.id.btnNo5:
                mPager.setCurrentItem(4);
                break;
            case R.id.btnNo6:
                mPager.setCurrentItem(5);
                break;
            case R.id.btnNo7:
                mPager.setCurrentItem(6);
                break;
            case R.id.btnNo8:
                mPager.setCurrentItem(7);
                break;
            case R.id.btnNo9:
                mPager.setCurrentItem(8);
                break;
            case R.id.btnNo10:
                mPager.setCurrentItem(9);
                break;
        }
    }

    public void selectButton(int id){
        Button button = (Button) findViewById(id);
        button.setBackgroundResource(R.drawable.selectedbtn);
        button.setTextColor(Color.parseColor("#ffffff"));
    }

    public void setJawaban(String jawaban, int index){
        this.jawaban[index-1] = jawaban;
    }

    public void cekNilai(){
        int total = 0;
        for(int i = 0; i < 10; i++){
            if(jawaban[i]!=null) {
                if (jawaban[i].equals(kunci[i])) {
                    total++;
                }
            }
        }

        Intent intent = new Intent(this, Hasil.class);
        intent.putExtra("nilai", total);
        startActivity(intent);
        finish();
    }

    /**
     * A simple pager adapter that represents all ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            final Bundle bundle = new Bundle();

            switch (position){
                case 0 :
                    final Soal1 fragment = new Soal1();
                    fragment.setArguments(bundle);
                    return fragment;
                case 1 :
                    final Soal2 fragment2 = new Soal2();
                    fragment2.setArguments(bundle);
                    return fragment2;
                case 2 :
                    final Soal3 fragment3 = new Soal3();
                    fragment3.setArguments(bundle);
                    return fragment3;
                case 3 :
                    final Soal4 fragment4 = new Soal4();
                    fragment4.setArguments(bundle);
                    return fragment4;
                case 4 :
                    final Soal5 fragment5 = new Soal5();
                    fragment5.setArguments(bundle);
                    return fragment5;
                case 5 :
                    final Soal6 fragment6 = new Soal6();
                    fragment6.setArguments(bundle);
                    return fragment6;
                case 6 :
                    final Soal7 fragment7 = new Soal7();
                    fragment7.setArguments(bundle);
                    return fragment7;
                case 7 :
                    final Soal8 fragment8 = new Soal8();
                    fragment8.setArguments(bundle);
                    return fragment8;
                case 8 :
                    final Soal9 fragment9 = new Soal9();
                    fragment9.setArguments(bundle);
                    return fragment9;
                case 9 :
                    final Soal10 fragment10 = new Soal10();
                    fragment10.setArguments(bundle);
                    return fragment10;
                default:
                    final Atm1 fragmentz = new Atm1();
                    fragmentz.setArguments(bundle);
                    return fragmentz;
            }
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
