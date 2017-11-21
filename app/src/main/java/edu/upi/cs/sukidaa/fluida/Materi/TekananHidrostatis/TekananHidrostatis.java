package edu.upi.cs.sukidaa.fluida.Materi.TekananHidrostatis;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageButton;

import com.ToxicBakery.viewpager.transforms.DepthPageTransformer;

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
import edu.upi.cs.sukidaa.fluida.Menu.NavigationDrawerActivity;
import edu.upi.cs.sukidaa.fluida.R;

/**
 * Created by drake on 6/19/2017.
 */

public class TekananHidrostatis extends NavigationDrawerActivity implements View.OnClickListener {

    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 11;

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

        setToolbarTitle("Tekanan Hidrostatis");

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
        mPagerAdapter = new  ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mPager.setPageTransformer(true, new DepthPageTransformer()); //set the animation

        selectedPage = 0; //current page
        if(savedInstanceState != null){ //if app was paused, you can reopen the same page
            selectedPage = savedInstanceState.getInt("SELECTED_PAGE");
        }

        mPager.setCurrentItem(selectedPage); //set the current page

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

                if(position==NUM_PAGES-1){
                    right.setBackgroundResource(R.color.transparent);
                }else{
                    right.setBackgroundResource(R.drawable.right_select);
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
                mPager.setCurrentItem(mPager.getCurrentItem() + 1);
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
                    final Hidro1 fragment = new Hidro1();
                    fragment.setArguments(bundle);
                    return fragment;
                case 1 :
                    final Hidro2 fragment2 = new Hidro2();
                    fragment2.setArguments(bundle);
                    return fragment2;
                case 2 :
                    final Hidro3 fragment3 = new Hidro3();
                    fragment3.setArguments(bundle);
                    return fragment3;
                case 3 :
                    final Hidro4 fragment4 = new Hidro4();
                    fragment4.setArguments(bundle);
                    return fragment4;
                case 4 :
                    final Hidro5 fragment5 = new Hidro5();
                    fragment5.setArguments(bundle);
                    return fragment5;
                case 5 :
                    final Hidro6 fragment6 = new Hidro6();
                    fragment6.setArguments(bundle);
                    return fragment6;
                case 6 :
                    final Hidro7 fragment7 = new Hidro7();
                    fragment7.setArguments(bundle);
                    return fragment7;
                case 7 :
                    final Hidro8 fragment8 = new Hidro8();
                    fragment8.setArguments(bundle);
                    return fragment8;
                case 8 :
                    final Hidro9 fragment9 = new Hidro9();
                    fragment9.setArguments(bundle);
                    return fragment9;
                case 9 :
                    final Hidro10 fragment10 = new Hidro10();
                    fragment10.setArguments(bundle);
                    return fragment10;
                case 10 :
                    final Hidro11 fragment11 = new Hidro11();
                    fragment11.setArguments(bundle);
                    return fragment11;
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
