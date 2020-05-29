package com.ruth.checkmeout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private ActionBarDrawerToggle t;

    @BindView(R.id.activity_main)DrawerLayout dl;
    @BindView(R.id.navigation) NavigationView nv;
    private Class fragmentClass;
    private Fragment fragment = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        ButterKnife.bind(this);

        t=new ActionBarDrawerToggle(this,dl,R.string.Open,R.string.Close);
        t.setDrawerIndicatorEnabled(true);
        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id=item.getItemId();
                if(id==R.id.home||id==R.id.about){

//                    Intent intent=new Intent(getBaseContext(),MainActivity.class);
//                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "Coming Soon",Toast.LENGTH_SHORT).show();
                    ImageView myImageView = (ImageView) findViewById(R.id.imgview);
                    Bitmap myBitmap = BitmapFactory.decodeResource(
                            getApplicationContext().getResources(),
                            R.drawable.puppy);
                    myImageView.setImageBitmap(myBitmap);
                    BarcodeDetector detector =
                            new BarcodeDetector.Builder(getApplicationContext())
                                    .setBarcodeFormats(Barcode.DATA_MATRIX | Barcode.QR_CODE)
                                    .build();
                    if(!detector.isOperational()){
                        Toast.makeText(MainActivity.this,"Could not set up the detector!",Toast.LENGTH_LONG).show();
                        //return;
                    }
                    Frame frame = new Frame.Builder().setBitmap(myBitmap).build();
                    SparseArray<Barcode> barcodes = detector.detect(frame);
                    Barcode thisCode = barcodes.valueAt(0);

                    Toast.makeText(MainActivity.this,thisCode.rawValue,Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(getBaseContext(),MainActivity.class);
                    startActivity(intent);

                }
                else {
                    switch (id){

                        case R.id.expenses:
                            Toast.makeText(MainActivity.this, "Expenses",Toast.LENGTH_SHORT).show();
                            fragmentClass=ExpensesFragment.class;break;

                        case R.id.account:
                            Toast.makeText(MainActivity.this, "My Account",Toast.LENGTH_SHORT).show();
                            fragmentClass=MyAccountFragment.class;break;
                        case R.id.signInLink:
                            Toast.makeText(MainActivity.this, "Log In",Toast.LENGTH_SHORT).show();
                            fragmentClass=LogInFragment.class;break;
                        case R.id.shop:
                            Toast.makeText(MainActivity.this, "Shop",Toast.LENGTH_SHORT).show();
                            fragmentClass=ShopFragment.class;break;


                        default:
                            return true;
                    }
                    try {
                        fragment = (Fragment) fragmentClass.newInstance();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();


                }
                dl.closeDrawers();


                return true;
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        switch (item.getItemId()) {
            case android.R.id.home:
                dl.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
