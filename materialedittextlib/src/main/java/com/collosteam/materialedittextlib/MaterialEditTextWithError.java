package com.collosteam.materialedittextlib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Collos on 10/11/2014.
 */
public class MaterialEditTextWithError extends LinearLayout implements TextWatcher {

    MaterialEditText materialEditText;
    TextView errorText;
    ImageView errorImage;
    View errorView;


    public MaterialEditTextWithError(Context context) {
        super(context);
        init(context, null);
    }

    public MaterialEditTextWithError(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public MaterialEditTextWithError(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        inflate(context, R.layout.edit_text_item, this);


        errorView = findViewById(R.id.errorView);

        materialEditText = (MaterialEditText) findViewById(R.id.etext);
        materialEditText.addTextChangedListener(this);

        errorText = (TextView) findViewById(R.id.tvError);
        errorText.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"Roboto-Medium.ttf"));

        TypedArray values = context.obtainStyledAttributes(attrs, R.styleable.MaterialEditText);
        int typeface = values.getInt(R.styleable.MaterialEditText_typeface, 0);
        materialEditText.setCustomTypeFace(context, typeface);
        values.recycle();
    }

    public void setText(int stringID) {
        materialEditText.setText(stringID);
    }

    public void setText(CharSequence text) {
        materialEditText.setText(text);
    }

    public Editable getText() {
        return materialEditText.getText();
    }

    public void setHint(int string_id){
        materialEditText.setHint(string_id);
    }
    public void setHint(CharSequence text) {
        materialEditText.setHint(text);
    }

    public CharSequence getHint() {
        return materialEditText.getHint();
    }


    private CharSequence error;

    public void setError(CharSequence charSequence) {
        if (charSequence != null) {
            error = charSequence;
            errorText.setText(error);
            errorView.setVisibility(VISIBLE);
            materialEditText.setBackgroundResource(R.drawable.error_line);
        }
    }

    public CharSequence getError() {
        return error;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

        error = null;
        errorText.setError(null);
        errorView.setVisibility(INVISIBLE);
        materialEditText.setBackgroundResource(R.drawable.material_edittext_bg);
    }
}