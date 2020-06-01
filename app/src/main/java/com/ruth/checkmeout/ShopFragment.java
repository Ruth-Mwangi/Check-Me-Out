package com.ruth.checkmeout;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;


public class ShopFragment extends Fragment implements View.OnClickListener {

    @BindView(R.id.btnScan)
    FloatingActionButton btnScan;
//    @BindView(R.id.surfaceView)
//    SurfaceView surfaceView;
//    private static final int REQUEST_CAMERA_PERMISSION = 201;
//    CameraSource cameraSource;
//    @BindView(R.id.txtBarcodeValue)
//    TextView txtBarcodeValue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_shop, container, false);
        ButterKnife.bind(this,view);
        Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
        btnScan.setOnClickListener(this);

        //initialiseDetectorsAndSources();
        return view;
    }

    @Override
    public void onClick(View v) {

        if(v==btnScan){
//            Snackbar.make(v, "FB clicked", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show();
//            //ImageView myImageView = (ImageView) findViewById(R.id.imgview);
//            Bitmap myBitmap = BitmapFactory.decodeResource(
//                    getContext().getResources(),
//                    R.drawable.download);
//            //myImageView.setImageBitmap(myBitmap);
//            BarcodeDetector detector =
//                    new BarcodeDetector.Builder(getContext())
//                            .setBarcodeFormats(Barcode.DATA_MATRIX | Barcode.EAN_13)
//                            .build();
//            if(!detector.isOperational()){
//                Toast.makeText(getContext(),"Could not set up the detector!",Toast.LENGTH_LONG).show();
//                //return;
//            }
//            Frame frame = new Frame.Builder().setBitmap(myBitmap).build();
//            SparseArray<Barcode> barcodes = detector.detect(frame);
//            Barcode thisCode = barcodes.valueAt(0);
//
//            Toast.makeText(getContext(),thisCode.rawValue,Toast.LENGTH_LONG).show();


        }

    }


}
