package cn.com.shijizl.algorithmsapplication.eventbus;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import cn.com.shijizl.algorithmsapplication.R;

public class TwoActivity extends AppCompatActivity {

    private TextView textView;

    public static void start(Context context) {
        Intent intent = new Intent(context, TwoActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        EventBus.getDefault().register(this);

        initView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    private void initView() {
        textView = (TextView) findViewById(R.id.tv_get_message);
        Button button = (Button) findViewById(R.id.bt_skip_event);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OneActivity.start(TwoActivity.this);
            }
        });

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(OneMessage message) {
        Toast.makeText(this, message.getName() + "/" + message.getSex() + "/" + message.getAge(), Toast.LENGTH_SHORT).show();
        textView.setText(message.getName() + "/" + message.getSex() + "/" + message.getAge());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(TwoMessage message) {
        Toast.makeText(this, message.getTitle(), Toast.LENGTH_SHORT).show();
        textView.setText(message.getTitle());
    }

}
