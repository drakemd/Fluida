package edu.upi.cs.sukidaa.fluida.Materi.TekananPermukaan;

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

import com.ToxicBakery.viewpager.transforms.RotateDownTransformer;

import edu.upi.cs.sukidaa.fluida.MainMenu;
import edu.upi.cs.sukidaa.fluida.Menu.NavigationDrawerActivity;
import edu.upi.cs.sukidaa.fluida.R;

/**
 * Created by Sutrisna Aji on 19/06/2017.
 */

public class TekananPermukaan extends NavigationDrawerActivity implements View.OnClickListener{

    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 12;

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
        setTitle("Tekanan Permukaan");
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
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mPager.setPageTransformer(true, new RotateDownTransformer()); //set the animation

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
                    bundle.putInt(Tp1.EXTRA_POSITION, position);
                    final Tp1 fragment = new Tp1();
                    fragment.setArguments(bundle);
                    return fragment;
                case 1 :
                    final Tp2 fragment2 = new Tp2();
                    fragment2.setArguments(bundle);
                    return fragment2;
                case 2 :
                    final Tp3 fragment3 = new Tp3();
                    fragment3.setArguments(bundle);
                    return fragment3;
                case 3 :
                    final Tp4 fragment4 = new Tp4();
                    fragment4.setArguments(bundle);
                    return fragment4;
                case 4 :
                    final Tp5 fragment5 = new Tp5();
                    fragment5.setArguments(bundle);
                    return fragment5;
                case 5 :
                    final Tp6 fragment6 = new Tp6();
                    fragment6.setArguments(bundle);
                    return fragment6;
                case 6 :
                    final Tp7 fragment7 = new Tp7();
                    fragment7.setArguments(bundle);
                    return fragment7;
                case 7 :
                    final Tp8 fragment8 = new Tp8();
                    fragment8.setArguments(bundle);
                    return fragment8;
                case 8 :
                    final Tp9 fragment9 = new Tp9();
                    fragment9.setArguments(bundle);
                    return fragment9;
                case 9 :
                    final Tp10 fragment10 = new Tp10();
                    fragment10.setArguments(bundle);
                    return fragment10;
                case 10 :
                    final Tp11 fragment11 = new Tp11();
                    fragment11.setArguments(bundle);
                    return fragment11;
                case 11 :
                    final Tp12 fragment12 = new Tp12();
                    fragment12.setArguments(bundle);
                    return fragment12;
                default:
                    bundle.putInt(Tp1.EXTRA_POSITION, position);
                    final Tp1 fragmentz = new Tp1();
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
