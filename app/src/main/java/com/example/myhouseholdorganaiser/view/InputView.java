package com.example.myhouseholdorganaiser.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.example.myhouseholdorganaiser.R;
import com.example.myhouseholdorganaiser.databinding.ViewInputBinding;

public class InputView extends LinearLayout {

    ViewInputBinding binding;

    public InputView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(attrs);
    }

    public InputView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(attrs);
    }

    public InputView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(attrs);
    }

    private void initView(AttributeSet attrs) {
        binding = ViewInputBinding.inflate(LayoutInflater.from(getContext()), this, true);
        TypedArray attributes = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.InputView, 0, 0);
        try {
            String hint = attributes.getString(R.styleable.InputView_hint);
            binding.edittextField.setHint(hint);

            int inputType = attributes.getInt(R.styleable.InputView_android_inputType, InputType.TYPE_NULL);
            binding.edittextField.setInputType(inputType);

        } finally {
            attributes.recycle();
        }
    }
}
