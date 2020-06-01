package com.ruth.checkmeout.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.ruth.checkmeout.R;
import com.ruth.checkmeout.models.CheckMeOutSearchResponse;
import com.ruth.checkmeout.networks.CheckMeOutApi;
import com.ruth.checkmeout.networks.CheckMeOutClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ShopFragment extends Fragment implements View.OnClickListener {

    @BindView(R.id.btnScan)
    FloatingActionButton btnScan;
    private Class fragmentClass;
    private Fragment fragment = null;
    private String code;
    List<CheckMeOutSearchResponse> items;

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
        CheckMeOutApi client= CheckMeOutClient.getItem();
        Call<CheckMeOutSearchResponse> call=client.getItem(code);
        call.enqueue(new Callback<CheckMeOutSearchResponse>(){

            @Override
            public void onResponse(Call<CheckMeOutSearchResponse> call, Response<CheckMeOutSearchResponse> response) {

                if(response.isSuccessful()){
                    Bundle bundle=new Bundle();
                    bundle.putInt("id",response.body().getId());
                    bundle.putInt("price",response.body().getPrice());
                    bundle.putString("name",response.body().getName());
                    bundle.putString("code",response.body().getCode());

                }
            }

            @Override
            public void onFailure(Call<CheckMeOutSearchResponse> call, Throwable t) {

            }
        });
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
            fragmentClass=ScanningFragment.class;
            try {
                fragment = (Fragment) fragmentClass.newInstance();

            } catch (Exception e) {
                e.printStackTrace();
            }

            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();


        }

    }


}
