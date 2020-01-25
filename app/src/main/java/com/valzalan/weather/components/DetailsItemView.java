package com.valzalan.weather.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.valzalan.weather.R;

public class DetailsItemView extends FrameLayout {
    @SuppressWarnings("ConstantConditions")
    public DetailsItemView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                .inflate(R.layout.details_item, this, true);

        TypedArray arr = context.obtainStyledAttributes(attrs,
                R.styleable.DetailsItemView, 0, 0);

        ((TextView) findViewById(R.id.tvTitle))
                .setText(arr.getString(R.styleable.DetailsItemView_di_title));

        setValue(arr.getString(R.styleable.DetailsItemView_di_value));

        ((ImageView) findViewById(R.id.ivIcon))
                .setImageResource(arr.getResourceId(R.styleable.DetailsItemView_di_icon, R.drawable.ic_sun));

        arr.recycle();
    }

    public void setValue(String value){
        ((TextView) findViewById(R.id.tvValue)).setText(value);
    }
}
