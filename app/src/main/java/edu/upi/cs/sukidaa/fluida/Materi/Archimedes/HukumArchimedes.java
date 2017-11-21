package edu.upi.cs.sukidaa.fluida.Materi.Archimedes;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.AndroidCharacter;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.ToxicBakery.viewpager.transforms.RotateDownTransformer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.upi.cs.sukidaa.fluida.MainMenu;
import edu.upi.cs.sukidaa.fluida.Materi.HukumPascal.AplikasiHukumPascal;
import edu.upi.cs.sukidaa.fluida.Materi.HukumPascal.MateriHukumPascal;
import edu.upi.cs.sukidaa.fluida.Menu.ExpandableListAdapter;
import edu.upi.cs.sukidaa.fluida.Menu.NavigationDrawerActivity;
import edu.upi.cs.sukidaa.fluida.R;
import edu.upi.cs.sukidaa.fluida.ViewDialog;

public class HukumArchimedes extends NavigationDrawerActivity implements View.OnClickListener{

    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 9;

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
        setToolbarTitle("Hukum Archimedes");
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
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
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
                    Intent intent = new Intent(HukumArchimedes.this, AplikasiArchimedes.class);
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
    public static class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            final Bundle bundle = new Bundle();
            switch (position){
                case 0 :
                    bundle.putInt(Ha1.EXTRA_POSITION, position);
                    final Ha1 fragment = new Ha1();
                    fragment.setArguments(bundle);
                    return fragment;
                case 1 :
                    final Ha2 fragment2 = new Ha2();
                    fragment2.setArguments(bundle);
                    return fragment2;
                case 2 :
                    final Ha3 fragment3 = new Ha3();
                    fragment3.setArguments(bundle);
                    return fragment3;
                case 3 :
                    final Ha4 fragment4 = new Ha4();
                    fragment4.setArguments(bundle);
                    return fragment4;
                case 4 :
                    final Ha5 fragment5 = new Ha5();
                    fragment5.setArguments(bundle);
                    return fragment5;
                case 5 :
                    final Ha6 fragment6 = new Ha6();
                    fragment6.setArguments(bundle);
                    return fragment6;
                case 6 :
                    final Ha7 fragment7 = new Ha7();
                    fragment7.setArguments(bundle);
                    return fragment7;
                case 7 :
                    final Ha8 fragment8 = new Ha8();
                    fragment8.setArguments(bundle);
                    return fragment8;
                case 8 :
                    final Ha9 fragment9 = new Ha9();
                    fragment9.setArguments(bundle);
                    return fragment9;
                default:
                    bundle.putInt(Ha1.EXTRA_POSITION, position);
                    final Ha1 fragmentz = new Ha1();
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
