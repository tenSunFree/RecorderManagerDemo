package com.home.recordermanagerdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.mingyuechunqiu.recordermanager.feature.record.RecorderManagerFactory;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static com.mingyuechunqiu.recordermanager.data.constants.Constants.EXTRA_RECORD_VIDEO_RESULT_INFO;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 開啟錄影畫面
        RecorderManagerFactory.getRecordVideoRequest()
                .startRecordVideo(MainActivity.this, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && requestCode == 0) {
            assert data != null;
            data.getParcelableExtra(EXTRA_RECORD_VIDEO_RESULT_INFO); // 保存錄影
            finish();
        }
    }
}
