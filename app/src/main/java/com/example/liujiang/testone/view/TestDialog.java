package com.example.liujiang.testone.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.liujiang.testone.R;

/**
 * Created by liujiang on 2017/3/27.
 */

public class TestDialog extends ProgressDialog {
    public TestDialog(Context context, int theme) {
        super(context, theme);
    }

    public TestDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setIndeterminate(false);
        setCanceledOnTouchOutside(false);
        setContentView(R.layout.load_dialog);

        WindowManager.LayoutParams arr = getWindow().getAttributes();
        arr.width = WindowManager.LayoutParams.WRAP_CONTENT;
        arr.alpha = 0.8f;
        arr.height = WindowManager.LayoutParams.WRAP_CONTENT;
        getWindow().setAttributes(arr);
    }
}

