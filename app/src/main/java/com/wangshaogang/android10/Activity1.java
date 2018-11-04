package com.wangshaogang.android10;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Activity1 extends AppCompatActivity implements View.OnClickListener {

    private float downX;    //按下时 的X坐标
    private float downY;    //按下时 的Y坐标

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null) {
//            actionBar.hide();
//        }
        Button feedback = (Button) findViewById(R.id.feedback);
        feedback.setOnClickListener(Activity1.this);
        Button restart = (Button) findViewById(R.id.restart);
        restart.setOnClickListener(Activity1.this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.restart:
                Intent intent = new Intent(Activity1.this, Activity1.class);
                startActivity(intent);
                finish();
                break;
            case R.id.feedback:
                String url = "mqqwpa://im/chat?chat_type=wpa&uin=1095151731";//uin是发送过去的qq号码
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                break;
        }
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(Activity1.this, "由于我没有对数据进行持久化，按Back键退出程序会丢失所有数据，所以我重写了Back键的功能，要退出请从多任务出后关闭，见谅🤪。", Toast.LENGTH_LONG).show();
    }


//    private View.OnClickListener mQQclickListener=new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            String url="mqqwpa://im/chat?chat_type=wpa&uin=2853700237";
//            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
//        }
//    };


    /**
     * 触屏事件
     *
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        String action = "";
        //在触发时回去到起始坐标
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //将按下时的坐标存储
                downX = x;
                downY = y;
                Log.v("Tag", "=======按下时X：" + x + "Y：" + y);
                break;
            case MotionEvent.ACTION_UP:
                Log.v("Tag", "=======抬起时X：" + x + "Y：" + y);

                //获取到距离差
                float dx = x - downX;
                float dy = y - downY;
                //防止是按下也判断
                //~第三个条件是我添加的用来限制滑动起点范围
                if (Math.abs(dx) > 3 && Math.abs(dy) > 3 && downY < 1500) {
                    //通过距离差判断方向
                    int orientation = getOrientation(dx, dy);
                    switch (orientation) {
                        case 't':
                            action = "上";
                            break;
                        case 'b':
                            action = "下";
                            break;
                        case 'l':
                            action = "左";
                            break;
                        case 'r':
                            action = "右";
                            break;
                    }
                    Log.d("Tag", "向" + action + "滑动");
//                    Toast.makeText(Activity1.this, "向" + action + "滑动", Toast.LENGTH_SHORT).show();
                    // 用另一个方法处理滑动后的操作
                    View view = findViewById(R.id.a1);
                    Move.doMove(view, orientation);
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    /**
     * 根据距离差判断 滑动方向
     *
     * @param dx X轴的距离差
     * @param dy Y轴的距离差
     * @return 滑动的方向
     */
    private int getOrientation(float dx, float dy) {
        Log.v("Tag", "========X轴距离差：" + dx);
        Log.v("Tag", "========Y轴距离差：" + dy);
        if (Math.abs(dx) > Math.abs(dy)) {
            //X轴移动
            return dx > 0 ? 'r' : 'l';
        } else {
            //Y轴移动
            return dy > 0 ? 'b' : 't';
        }
    }
}
