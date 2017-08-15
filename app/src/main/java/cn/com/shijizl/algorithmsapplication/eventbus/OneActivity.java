package cn.com.shijizl.algorithmsapplication.eventbus;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;

import cn.com.shijizl.algorithmsapplication.R;

public class OneActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent intent = new Intent(context, OneActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        initView();
    }

    /*@Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }*/

    private void initView() {
        Button button = (Button) findViewById(R.id.bt_post);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("====", "====");
                EventBus.getDefault().post(new OneMessage("feifei", 20, "nan"));
            }
        });

        Button button2 = (Button) findViewById(R.id.bt_post_two);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("====", "====");
                EventBus.getDefault().post(new TwoMessage("title"));
            }
        });
    }
}
