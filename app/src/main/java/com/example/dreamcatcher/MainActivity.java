package com.example.dreamcatcher;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        //Get dimensions based on screen size
        int deviceWidth = metrics.widthPixels;
        double bg_height_double = deviceWidth / 1.714;
        int bg_height = (int) bg_height_double;
        int deviceHeight = metrics.heightPixels;

        //Get Root Layout
        ConstraintLayout dash_layout = getWindow().getDecorView().findViewById(R.id.root_layout);
        ConstraintSet dash_set = new ConstraintSet();

        //Get Custom Background Drawable
        Drawable dash_bg = getResources().getDrawable(R.drawable.dashboard_bg_custom);
        ImageView dash_bg_holder = new ImageView(this);

        //Add Custom BG drawable to root layout
        dash_bg_holder.setId(View.generateViewId());
        dash_bg_holder.setImageBitmap(bitmapToDrawable(dash_bg,deviceWidth,bg_height));
        dash_layout.addView(dash_bg_holder);


        //Create TextView1
       TextView tView_Date  = new TextView(this);
        tView_Date.setId(View.generateViewId());

        tView_Date.setText(R.string.date);
        tView_Date.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        tView_Date.setTextSize(R.dimen.sub1);
        tView_Date.setTextColor(Color.BLACK);
        Typeface openSansBold = ResourcesCompat.getFont(this, R.font.open_sans_bold);
        tView_Date.setTypeface(openSansBold);
        dash_layout.addView(tView_Date);

        dash_set.clone(dash_layout);
        dash_set.connect(dash_bg_holder.getId(),ConstraintSet.TOP,dash_layout.getId(),ConstraintSet.TOP,0);
        dash_set.connect(tView_Date.getId(),ConstraintSet.TOP,dash_layout.getId(),ConstraintSet.TOP,60);
        dash_set.applyTo(dash_layout);





    }
    public Bitmap bitmapToDrawable(Drawable drawable, int width, int height){
        Bitmap mutableBitmap = Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888);
        Canvas canvas  = new Canvas(mutableBitmap);
        drawable.setBounds(0,0,width,height);
        drawable.draw(canvas);

        return mutableBitmap;
    }
}
