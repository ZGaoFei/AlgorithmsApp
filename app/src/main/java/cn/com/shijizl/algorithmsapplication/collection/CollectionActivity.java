package cn.com.shijizl.algorithmsapplication.collection;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import cn.com.shijizl.algorithmsapplication.R;
import cn.com.shijizl.algorithmsapplication.algorithms.AlgorithmsUtils;

public class CollectionActivity extends AppCompatActivity {

    public static void start(Context context) {
        context.startActivity(new Intent(context, CollectionActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);

        initView();
        Log.e("==CollectionActivity===", "===onCreate===");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("==CollectionActivity===", "===onStart===");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("==CollectionActivity===", "===onResume===");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("==CollectionActivity===", "===onPause===");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("==CollectionActivity===", "===onRestart===");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("==CollectionActivity===", "===onStop===");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("==CollectionActivity===", "===onDestroy===");

    }

    private void initView() {
        Button button = (Button) findViewById(R.id.bt_collect_one);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                AlgorithmsUtils.fill();

//                AlgorithmsUtils.insert(3, 5, new int[]{1,2,3,4,6,7,8});

//                AlgorithmsUtils.creat();
                AlgorithmsUtils.create();
            }
        });
    }


}
