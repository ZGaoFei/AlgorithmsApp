package cn.com.shijizl.algorithmsapplication.collection;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
