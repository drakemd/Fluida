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
import android.widget.ImageButton;

import com.ToxicBakery.viewpager.transforms.FlipHorizontalTransformer;
import com.ToxicBakery.viewpager.transforms.RotateDownTransformer;

import edu.upi.cs.sukidaa.fluida.MainMenu;
import edu.upi.cs.sukidaa.fluida.Materi.TekananAtmosfer.Atm1;
import edu.upi.cs.sukidaa.fluida.Materi.TekananAtmosfer.Atm10;
import edu.upi.cs.sukidaa.fluida.Materi.TekananAtmosfer.Atm11;
import edu.upi.cs.sukidaa.fluida.Materi.TekananAtmosfer.Atm12;
import edu.upi.cs.sukidaa.fluida.Materi.TekananAtmosfer.Atm13;
import edu.upi.cs.sukidaa.fluida.Materi.TekananAtmosfer.Atm2;
import edu.upi.cs.sukidaa.fluida.Materi.TekananAtmosfer.Atm3;
import edu.upi.cs.sukidaa.fluida.Materi.TekananAtmosfer.Atm4;
import edu.upi.cs.sukidaa.fluida.Materi.TekananAtmosfer.Atm5;
import edu.upi.cs.sukidaa.fluida.Materi.TekananAtmosfer.Atm6;
import edu.upi.cs.sukidaa.fluida.Materi.TekananAtmosfer.Atm7;
import edu.upi.cs.sukidaa.fluida.Materi.TekananAtmosfer.Atm8;
import edu.upi.cs.sukidaa.fluida.Materi.TekananAtmosfer.Atm9;
import edu.upi.cs.sukidaa.fluida.Materi.TekananAtmosfer.TekananAtmosfer;
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
import edu.upi.cs.sukidaa.fluida.Menu.NavigationDrawerActivity;
import edu.upi.cs.sukidaa.fluida.R;

public class MateriHukumPascal extends NavigationDrawerActivity implements View.OnClickListener {

    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 5;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;
    private ImageButton left, right, home;

    private int selectedPage; // set selected page


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setToolbarTitle("Materi Hukum Pascal");

        ViewStub vs = (ViewStub)findViewById(R.id.viewStub);
        vs.setLayoutResource(R.layout.tekananatm);
        vs.inflate();

        left = (ImageButton) findViewById(R.id.btnLeft);
        right = (ImageButton) findViewById(R.id.btnRight);
        home = (ImageButton) findViewById(R.id.btnHome);

        left.setOnClickListener(this);
        right.setOnClickListener(this);
        home.setOnClickListener(this);

        left.setBackgroundResource(R.color.transparent);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager); //the UI pager
        mPagerAdapter = new MateriHukumPascal.ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mPager.setPageTransformer(true, new RotateDownTransformer()); //set the animation

        selectedPage = 0; //current page
        if(savedInstanceState != null){ //if app was paused, you can reopen the same page
            selectedPage = savedInstanceState.getInt("SELECTED_PAGE");
        }

        mPager.setCurrentItem(selectedPage); //set the current page
        mPager.setOffscreenPageLimit(4);

        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==0){
                    left.setBackgroundResource(R.color.transparent);
                }else{
                    left.setBackgroundResource(R.drawable.left_select);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                drawer.openDrawer(GravityCompat.START);
            }
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btnLeft :
                mPager.setCurrentItem(mPager.getCurrentItem() - 1);
                break;
            case R.id.btnRight :
                if(mPager.getCurrentItem() == NUM_PAGES-1){
                    Intent intent = new Intent(MateriHukumPascal.this, AplikasiHukumPascal.class);
                    startActivity(intent);
                    finish();
                }else{
                    mPager.setCurrentItem(mPager.getCurrentItem() + 1);
                }
                break;
            case R.id.btnHome :
                Intent intent = new Intent(this, MainMenu.class);
                this.startActivity(intent);
                this.finish();
        }
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
                    final Pascal1 fragment = new Pascal1();
                    fragment.setArguments(bundle);
                    return fragment;
                case 1 :
                    final Pascal2 fragment2 = new Pascal2();
                    fragment2.setArguments(bundle);
                    return fragment2;
                case 2 :
                    final Pascal3 fragment3 = new Pascal3();
                    fragment3.setArguments(bundle);
                    return fragment3;
                case 3 :
                    final Pascal4 fragment4 = new Pascal4();
                    fragment4.setArguments(bundle);
                    return fragment4;
                case 4 :
                    final Pascal5 fragment5 = new Pascal5();
                    fragment5.setArguments(bundle);
                    return fragment5;
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
