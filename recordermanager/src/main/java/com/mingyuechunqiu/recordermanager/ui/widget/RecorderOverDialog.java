package com.mingyuechunqiu.recordermanager.ui.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.mingyuechunqiu.recordermanager.R;

import androidx.annotation.NonNull;

public class RecorderOverDialog extends Dialog {

    private String title, content, first, second;
    private TextView titleTextView, contentTextView, firstTextView, secondTextView;
    private FrameLayout firstFrameLayout;
    private View.OnClickListener onDismissClickListener;
    private Window window = null;
    private Context context;
    private FrameLayout createFormFrameLayout, executingFrameLayout,
            executionCompletedFrameLayout, superiorAcceptanceCompletedFrameLayout,
            cancelFrameLayout, errorFrameLayout;
    private OnItemClickListener onItemClickListener;

    public RecorderOverDialog(
            Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.context = context;
    }

    public RecorderOverDialog(Context context, int theme) {
        super(context, theme);
        this.context = context;
    }

    public RecorderOverDialog(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        firstFrameLayout =  findViewById(R.id.firstFrameLayout);
        firstFrameLayout.setOnClickListener(onClickListener());
        titleTextView =  findViewById(R.id.titleTextView);
        titleTextView.setText(title);
        contentTextView =  findViewById(R.id.contentTextView);
        contentTextView.setText(content);
        firstTextView =  findViewById(R.id.firstTextView);
        firstTextView.setText(first);
        secondTextView =  findViewById(R.id.secondTextView);
        secondTextView.setText(second);
        secondTextView.setOnClickListener(onClickListener());
    }

    @NonNull
    private View.OnClickListener onClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.firstFrameLayout) {
                    onItemClickListener.onFirstClick();
                } else if (view.getId() == R.id.secondTextView) {
                    onItemClickListener.onSecondClick();
                }
            }
        };
    }

    public void setView(View view) {
        setContentView(view);
    }

    public void setView(int id) {
        setContentView(id);
    }

    public void setProperty(int x, int y, int w, int h) {
        window = getWindow();//得到对话框的窗口．
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.x = x;//设置对话框的位置．0为中间
        layoutParams.y = y;
        layoutParams.width = w;
        layoutParams.height = h;
        layoutParams.alpha = 1f;// 设置对话框的透明度,1f不透明
        layoutParams.gravity = Gravity.TOP;//设置显示在中间
        window.setAttributes(layoutParams);
    }

    public interface OnItemClickListener {
        void onFirstClick();

        void onSecondClick();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public void setSecond(String second) {
        this.second = second;
    }
}
