package com.wangshaogang.android10;

import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by 王少刚 on 2018/11/4.
 */

public class Move {
    static int change;
    static int score;

    public static void doMove(View view, int orientation) {

        change = 0;

        List<TextView> textViews = new ArrayList<>();

        textViews.add((TextView) view.findViewById(R.id.t11));
        textViews.add((TextView) view.findViewById(R.id.t12));
        textViews.add((TextView) view.findViewById(R.id.t13));
        textViews.add((TextView) view.findViewById(R.id.t14));
        textViews.add((TextView) view.findViewById(R.id.t21));
        textViews.add((TextView) view.findViewById(R.id.t22));
        textViews.add((TextView) view.findViewById(R.id.t23));
        textViews.add((TextView) view.findViewById(R.id.t24));
        textViews.add((TextView) view.findViewById(R.id.t31));
        textViews.add((TextView) view.findViewById(R.id.t32));
        textViews.add((TextView) view.findViewById(R.id.t33));
        textViews.add((TextView) view.findViewById(R.id.t34));
        textViews.add((TextView) view.findViewById(R.id.t41));
        textViews.add((TextView) view.findViewById(R.id.t42));
        textViews.add((TextView) view.findViewById(R.id.t43));
        textViews.add((TextView) view.findViewById(R.id.t44));

        Map<TextView, Integer> blocks = new HashMap<>();

        for (TextView textView : textViews) {
            if (textView.getText().equals("")) {
                textView.setText("0");
            }
            blocks.put(textView, Integer.valueOf(textView.getText().toString()));
        }

        switch (orientation) {
            case 'l':
                doAll(textViews.get(0), textViews.get(1), textViews.get(2), textViews.get(3),
                        textViews.get(4), textViews.get(5), textViews.get(6), textViews.get(7),
                        textViews.get(8), textViews.get(9), textViews.get(10), textViews.get(11),
                        textViews.get(12), textViews.get(13), textViews.get(14), textViews.get(15), blocks);
                break;
            case 'r':
                doAll(textViews.get(3), textViews.get(2), textViews.get(1), textViews.get(0),
                        textViews.get(7), textViews.get(6), textViews.get(5), textViews.get(4),
                        textViews.get(11), textViews.get(10), textViews.get(9), textViews.get(8),
                        textViews.get(15), textViews.get(14), textViews.get(13), textViews.get(12), blocks);
                break;
            case 't':
                doAll(textViews.get(0), textViews.get(4), textViews.get(8), textViews.get(12),
                        textViews.get(1), textViews.get(5), textViews.get(9), textViews.get(13),
                        textViews.get(2), textViews.get(6), textViews.get(10), textViews.get(14),
                        textViews.get(3), textViews.get(7), textViews.get(11), textViews.get(15), blocks);
                break;
            case 'b':
                doAll(textViews.get(12), textViews.get(8), textViews.get(4), textViews.get(0),
                        textViews.get(13), textViews.get(9), textViews.get(5), textViews.get(1),
                        textViews.get(14), textViews.get(10), textViews.get(6), textViews.get(2),
                        textViews.get(15), textViews.get(11), textViews.get(7), textViews.get(3), blocks);
            default:
                break;
        }


        for (TextView textView : textViews) {
            if (blocks.get(textView) == 0) {
                textView.setText("");
            } else {
                textView.setText(blocks.get(textView) + "");
            }
        }

        ((TextView)view.findViewById(R.id.score)).setText("Score: " + score);
        Color.setColor(textViews);

        if (change==0) {
            return;
        }

        List<TextView> textViews0 = new ArrayList<TextView>();
        for (TextView textView: textViews) {
            if (textView.getText().equals("")) {
                textViews0.add(textView);
            }
        }
        Random random = new Random();
        int r = random.nextInt(textViews0.size());
        int n = (random.nextDouble()%1>0.1?2:4);
        textViews0.get(r).setText(n+ "");

        Color.setColor(textViews);

    }

    // 向第一个参数对齐
    static void beforeMove(TextView t1, TextView t2, TextView t3, TextView t4, Map<TextView, Integer> blocks) {
        if (blocks.get(t1)==0&&(blocks.get(t2)!=0||blocks.get(t3)!=0||blocks.get(t4)!=0)||
                blocks.get(t2)==0&&(blocks.get(t3)!=0||blocks.get(t4)!=0)||
                blocks.get(t3)==0&&blocks.get(t4)!=0) {
            change ++;
        }
        if (blocks.get(t3) == 0) {
            blocks.put(t3, blocks.get(t4));
            blocks.put(t4, 0);
        }
        if (blocks.get(t2) == 0) {
            blocks.put(t2, blocks.get(t3));
            blocks.put(t3, blocks.get(t4));
            blocks.put(t4, 0);
        }
        if (blocks.get(t1) == 0) {
            blocks.put(t1, blocks.get(t2));
            blocks.put(t2, blocks.get(t3));
            blocks.put(t3, blocks.get(t4));
            blocks.put(t4, 0);
        }
    }

    // 把第二个参数加到第一个参数，然后第二个参数置零
    static void doAdd(TextView t1, TextView t2, Map<TextView, Integer> blocks) {
        if (blocks.get(t1).equals(blocks.get(t2)) && blocks.get(t1)!=0 && blocks.get(t2) != 0) {
            blocks.put(t1, blocks.get(t1) + blocks.get(t2));
            blocks.put(t2, 0);
            change ++;
            score += blocks.get(t1);
        }
    }

    static void doAGroup(TextView t1, TextView t2, TextView t3, TextView t4, Map<TextView, Integer> blocks) {
        beforeMove(t1, t2, t3, t4, blocks);
        doAdd(t1, t2, blocks);
        beforeMove(t1, t2, t3, t4, blocks);
        doAdd(t2, t3, blocks);
        beforeMove(t1, t2, t3, t4, blocks);
        doAdd(t3, t4, blocks);
    }

    static void doAll(TextView t11, TextView t12, TextView t13, TextView t14,
                      TextView t21, TextView t22, TextView t23, TextView t24,
                      TextView t31, TextView t32, TextView t33, TextView t34,
                      TextView t41, TextView t42, TextView t43, TextView t44, Map<TextView, Integer> blocks) {
        doAGroup(t11, t12, t13, t14, blocks);
        doAGroup(t21, t22, t23, t24, blocks);
        doAGroup(t31, t32, t33, t34, blocks);
        doAGroup(t41, t42, t43, t44, blocks);
    }

}
