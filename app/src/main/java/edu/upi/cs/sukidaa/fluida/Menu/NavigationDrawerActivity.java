package edu.upi.cs.sukidaa.fluida.Menu;

import android.content.Intent;
import android.os.Build;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.upi.cs.sukidaa.fluida.Latihan.Latihan;
import edu.upi.cs.sukidaa.fluida.Materi.Archimedes.MenuArchimedes;
import edu.upi.cs.sukidaa.fluida.Materi.HukumPascal.HukumPascal;
import edu.upi.cs.sukidaa.fluida.Materi.TekananAtmosfer.TekananAtmosfer;
import edu.upi.cs.sukidaa.fluida.Materi.TekananHidrostatis.TekananHidrostatis;
import edu.upi.cs.sukidaa.fluida.Materi.TekananPermukaan.TekananPermukaan;
import edu.upi.cs.sukidaa.fluida.Menu.ExpandableListAdapter;
import edu.upi.cs.sukidaa.fluida.R;
import edu.upi.cs.sukidaa.fluida.Tentang.Dospem;
import edu.upi.cs.sukidaa.fluida.Tentang.Profil;
import edu.upi.cs.sukidaa.fluida.Tentang.Referensi;
import edu.upi.cs.sukidaa.fluida.ViewDialog;

public class NavigationDrawerActivity extends AppCompatActivity {

    private ArrayList<String> listDataHeader;
    private HashMap<String, List<String>> listDataChild;
    private ExpandableListView expListView;
    private ExpandableListAdapter listAdapter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawerlayout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Materi");
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        enableExpandableList();
    }

    private void enableExpandableList() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
        expListView = (ExpandableListView) findViewById(R.id.left_drawer);

        prepareListData(listDataHeader, listDataChild);
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        // setting list adapter
        expListView.setAdapter(listAdapter);

        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                if(groupPosition == 3){
                    exit_game();
                }else if(groupPosition == 1){
                    Intent intent = new Intent(getApplicationContext(), Latihan.class);
                    startActivity(intent);
                    finish();
                }
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                //cool
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                //cool
            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                // Temporary code:

                if(groupPosition == 0){
                    if(childPosition == 0){
                        Intent intent = new Intent(getApplicationContext(), TekananAtmosfer.class);
                        startActivity(intent);
                        finish();
                    }else if(childPosition == 1){
                        Intent intent = new Intent(getApplicationContext(), TekananHidrostatis.class);
                        startActivity(intent);
                        finish();
                    }else if(childPosition == 2){
                        Intent intent = new Intent(getApplicationContext(), HukumPascal.class);
                        startActivity(intent);
                        finish();
                    }else if(childPosition == 3){
                        Intent intent = new Intent(getApplicationContext(), MenuArchimedes.class);
                        startActivity(intent);
                        finish();
                    }else if(childPosition == 4){
                        Intent intent = new Intent(getApplicationContext(), TekananPermukaan.class);
                        startActivity(intent);
                        finish();
                    }
                }else if(groupPosition == 2){
                    if(childPosition == 0){
                        Intent intent = new Intent(getApplicationContext(), Dospem.class);
                        startActivity(intent);
                        finish();
                    }else if(childPosition == 1){
                        Intent intent = new Intent(getApplicationContext(), Profil.class);
                        startActivity(intent);
                        finish();
                    }else if(childPosition == 2){
                        Intent intent = new Intent(getApplicationContext(), Referensi.class);
                        startActivity(intent);
                        finish();
                    }
                }

                // till here
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });
    }

    public void exit_game(){
        ViewDialog alert = new ViewDialog();
        alert.showDialogExit(this);
    }

    public void setToolbarTitle(String title){
        toolbar.setTitle(title);
    }

    private void prepareListData(List<String> listDataHeader, Map<String,
            List<String>> listDataChild) {


        // Adding child data
        listDataHeader.add("MATERI");
        listDataHeader.add("LATIHAN");
        listDataHeader.add("TENTANG");
        listDataHeader.add("KELUAR");

        // Adding child data
        List<String> materi = new ArrayList<String>();
        materi.add("Tekanan Atmosfer");
        materi.add("Tekanan Hidrostatis");
        materi.add("Hukum Pascal");
        materi.add("Hukum Archimedes");
        materi.add("Tegangan Permukaan");


        List<String> latihan = new ArrayList<String>();

        List<String> tentang = new ArrayList<String>();
        tentang.add("Dosen Pembimbing");
        tentang.add("Profil Penyusun");
        tentang.add("Referensi");

        List<String> keluar = new ArrayList<String>();


        listDataChild.put(listDataHeader.get(0), materi); // Header, Child data
        listDataChild.put(listDataHeader.get(1), new ArrayList<String>());
        listDataChild.put(listDataHeader.get(2), tentang);
        listDataChild.put(listDataHeader.get(3), new ArrayList<String>());
    }
}
