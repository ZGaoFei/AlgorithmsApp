package cn.com.shijizl.algorithmsapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import cn.com.shijizl.algorithmsapplication.collection.CollectionActivity;
import cn.com.shijizl.algorithmsapplication.eventbus.TwoActivity;
import cn.com.shijizl.algorithmsapplication.eventbus.TwoMessage;
import cn.com.shijizl.algorithmsapplication.test.TestActivity;

public class MainActivity extends Activity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);

        initView();
        Log.e("==MainActivity====", "===onCreate===");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("==MainActivity====", "===onStart===");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("==MainActivity====", "===onResume===");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("==MainActivity====", "===onPause===");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("==MainActivity====", "===onRestart===");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("==MainActivity====", "===onStop===");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("==MainActivity====", "===onDestroy===");
        EventBus.getDefault().unregister(this);
    }

    private void initView() {
        findViewById(R.id.bt_one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CollectionActivity.start(MainActivity.this);
            }
        });
        findViewById(R.id.bt_two).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestActivity.start(MainActivity.this);
            }
        });
        button = (Button) findViewById(R.id.bt_three);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TwoActivity.start(MainActivity.this);
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(TwoMessage message) {
        Toast.makeText(this, message.getTitle(), Toast.LENGTH_SHORT).show();
        button.setText(message.getTitle());
    }

    private Object object1 = new Object();
    private Object object2 = new Object();
    private void lock() {
        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object1) {
                    try {
                        Log.e("==thread1==", "==object1==");
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                synchronized (object2) {
                    Log.e("==thread1==", "==object2==");
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object2) {
                    try {
                        Log.e("==thread2==", "==object2==");
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                synchronized (object1) {
                    Log.e("==thread2==", "==object1==");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
