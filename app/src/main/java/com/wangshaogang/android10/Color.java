package com.wangshaogang.android10;

import android.widget.TextView;

import java.util.List;

/**
 * Created by 王少刚 on 2018/11/4.
 */

public class Color {
    public static void setColor(List<TextView> textViews) {
        for (TextView textView: textViews) {
            switch (textView.getText().toString()) {
                case "":
                    textView.setBackgroundResource(R.color.c0bg);
                    break;
                case "2":
                    textView.setBackgroundResource(R.color.c2bg);
                    break;
                case "4":
                    textView.setBackgroundResource(R.color.c4bg);
                    break;
                case "8":
                    textView.setBackgroundResource(R.color.c8bg);
                    break;
                case "16":
                    textView.setBackgroundResource(R.color.c16bg);
                    break;
                case "32":
                    textView.setBackgroundResource(R.color.c32bg);
                    break;
                case "64":
                    textView.setBackgroundResource(R.color.c64bg);
                    break;
                case "128":
                    textView.setBackgroundResource(R.color.c128bg);
                    break;
                case "256":
                    textView.setBackgroundResource(R.color.c256bg);
                    break;
                case "512":
                    textView.setBackgroundResource(R.color.c512bg);
                    break;
                case "1024":
                    textView.setBackgroundResource(R.color.c1024bg);
                    break;
                case "2048":
                    textView.setBackgroundResource(R.color.c2048bg);
                    break;
                case "4096":
                    textView.setBackgroundResource(R.color.c4096bg);
                    break;
                case "8192":
                    textView.setBackgroundResource(R.color.c8192bg);
                    break;
                case "16384":
                    textView.setBackgroundResource(R.color.c16384bg);
                    break;
                case "32768":
                    textView.setBackgroundResource(R.color.c32768bg);
                    break;
                case "65536":
                    textView.setBackgroundResource(R.color.c65536bg);
                    break;
            }
        }
    }
}
