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
    static View viewBeforeChange;

    public static void doMove(View view, int orientation) {

        change = 0;

        TextView t11 = (TextView) view.findViewById(R.id.t11);
        TextView t12 = (TextView) view.findViewById(R.id.t12);
        TextView t13 = (TextView) view.findViewById(R.id.t13);
        TextView t14 = (TextView) view.findViewById(R.id.t14);
        TextView t21 = (TextView) view.findViewById(R.id.t21);
        TextView t22 = (TextView) view.findViewById(R.id.t22);
        TextView t23 = (TextView) view.findViewById(R.id.t23);
        TextView t24 = (TextView) view.findViewById(R.id.t24);
        TextView t31 = (TextView) view.findViewById(R.id.t31);
        TextView t32 = (TextView) view.findViewById(R.id.t32);
        TextView t33 = (TextView) view.findViewById(R.id.t33);
        TextView t34 = (TextView) view.findViewById(R.id.t34);
        TextView t41 = (TextView) view.findViewById(R.id.t41);
        TextView t42 = (TextView) view.findViewById(R.id.t42);
        TextView t43 = (TextView) view.findViewById(R.id.t43);
        TextView t44 = (TextView) view.findViewById(R.id.t44);

        List<TextView> textViews = new ArrayList<>();

        textViews.add((TextView) view.findViewById(R.id.t11));
        textViews.add(t12);
        textViews.add(t13);
        textViews.add(t14);
        textViews.add(t21);
        textViews.add(t22);
        textViews.add(t23);
        textViews.add(t24);
        textViews.add(t31);
        textViews.add(t32);
        textViews.add(t33);
        textViews.add(t34);
        textViews.add(t41);
        textViews.add(t42);
        textViews.add(t43);
        textViews.add(t44);

        for (TextView textView : textViews) {
            if (textView.getText().equals("")) {
                textView.setText("0");
            }
        }
//

        Map<TextView, Integer> blocks = new HashMap<>();
        blocks.put(t11, Integer.valueOf(t11.getText().toString()));
        blocks.put(t12, Integer.valueOf(t12.getText().toString()));
        blocks.put(t13, Integer.valueOf(t13.getText().toString()));
        blocks.put(t14, Integer.valueOf(t14.getText().toString()));
        blocks.put(t21, Integer.valueOf(t21.getText().toString()));
        blocks.put(t22, Integer.valueOf(t22.getText().toString()));
        blocks.put(t23, Integer.valueOf(t23.getText().toString()));
        blocks.put(t24, Integer.valueOf(t24.getText().toString()));
        blocks.put(t31, Integer.valueOf(t31.getText().toString()));
        blocks.put(t32, Integer.valueOf(t32.getText().toString()));
        blocks.put(t33, Integer.valueOf(t33.getText().toString()));
        blocks.put(t34, Integer.valueOf(t34.getText().toString()));
        blocks.put(t41, Integer.valueOf(t41.getText().toString()));
        blocks.put(t42, Integer.valueOf(t42.getText().toString()));
        blocks.put(t43, Integer.valueOf(t43.getText().toString()));
        blocks.put(t44, Integer.valueOf(t44.getText().toString()));


        switch (orientation) {
            case 'l':
                beforeMove(t11, t12, t13, t14, blocks);
                doAdd(t11, t12, blocks);
                beforeMove(t11, t12, t13, t14, blocks);
                doAdd(t12, t13, blocks);
                beforeMove(t11, t12, t13, t14, blocks);
                doAdd(t13, t14, blocks);

                beforeMove(t21, t22, t23, t24, blocks);
                doAdd(t21, t22, blocks);
                beforeMove(t21, t22, t23, t24, blocks);
                doAdd(t22, t23, blocks);
                beforeMove(t21, t22, t23, t24, blocks);
                doAdd(t23, t24, blocks);

                beforeMove(t31, t32, t33, t34, blocks);
                doAdd(t31, t32, blocks);
                beforeMove(t31, t32, t33, t34, blocks);
                doAdd(t32, t33, blocks);
                beforeMove(t31, t32, t33, t34, blocks);
                doAdd(t33, t34, blocks);

                beforeMove(t41, t42, t43, t44, blocks);
                doAdd(t41, t42, blocks);
                beforeMove(t41, t42, t43, t44, blocks);
                doAdd(t42, t43, blocks);
                beforeMove(t41, t42, t43, t44, blocks);
                doAdd(t43, t44, blocks);
                break;

            case 'r':
                beforeMove(t14, t13, t12, t11, blocks);
                doAdd(t14, t13, blocks);
                beforeMove(t14, t13, t12, t11, blocks);
                doAdd(t13, t12, blocks);
                beforeMove(t14, t13, t12, t11, blocks);
                doAdd(t12, t11, blocks);

                beforeMove(t24, t23, t22, t21, blocks);
                doAdd(t24, t23, blocks);
                beforeMove(t24, t23, t22, t21, blocks);
                doAdd(t23, t22, blocks);
                beforeMove(t24, t23, t22, t21, blocks);
                doAdd(t22, t21, blocks);

                beforeMove(t34, t33, t32, t31, blocks);
                doAdd(t34, t33, blocks);
                beforeMove(t34, t33, t32, t31, blocks);
                doAdd(t33, t32, blocks);
                beforeMove(t34, t33, t32, t31, blocks);
                doAdd(t32, t31, blocks);

                beforeMove(t44, t43, t42, t41, blocks);
                doAdd(t44, t43, blocks);
                beforeMove(t44, t43, t42, t41, blocks);
                doAdd(t43, t42, blocks);
                beforeMove(t44, t43, t42, t41, blocks);
                doAdd(t42, t41, blocks);
                break;

            case 't':
                beforeMove(t11, t21, t31, t41, blocks);
                doAdd(t11, t21, blocks);
                beforeMove(t11, t21, t31, t41, blocks);
                doAdd(t21, t31, blocks);
                beforeMove(t11, t21, t31, t41, blocks);
                doAdd(t31, t41, blocks);

                beforeMove(t12, t22, t32, t42, blocks);
                doAdd(t12, t22, blocks);
                beforeMove(t12, t22, t32, t42, blocks);
                doAdd(t22, t32, blocks);
                beforeMove(t12, t22, t32, t42, blocks);
                doAdd(t32, t42, blocks);

                beforeMove(t13, t23, t33, t43, blocks);
                doAdd(t13, t23, blocks);
                beforeMove(t13, t23, t33, t43, blocks);
                doAdd(t23, t33, blocks);
                beforeMove(t13, t23, t33, t43, blocks);
                doAdd(t33, t43, blocks);

                beforeMove(t14, t24, t34, t44, blocks);
                doAdd(t14, t24, blocks);
                beforeMove(t14, t24, t34, t44, blocks);
                doAdd(t24, t34, blocks);
                beforeMove(t14, t24, t34, t44, blocks);
                doAdd(t34, t44, blocks);
                break;

            case 'b':
                beforeMove(t41, t31, t21, t11, blocks);
                doAdd(t41, t31, blocks);
                beforeMove(t41, t31, t21, t11, blocks);
                doAdd(t31, t21, blocks);
                beforeMove(t41, t31, t21, t11, blocks);
                doAdd(t21, t11, blocks);

                beforeMove(t42, t32, t22, t12, blocks);
                doAdd(t42, t32, blocks);
                beforeMove(t42, t32, t22, t12, blocks);
                doAdd(t32, t22, blocks);
                beforeMove(t42, t32, t22, t12, blocks);
                doAdd(t22, t12, blocks);

                beforeMove(t43, t33, t23, t13, blocks);
                doAdd(t43, t33, blocks);
                beforeMove(t43, t33, t23, t13, blocks);
                doAdd(t33, t23, blocks);
                beforeMove(t43, t33, t23, t13, blocks);
                doAdd(t23, t13, blocks);

                beforeMove(t44, t34, t24, t14, blocks);
                doAdd(t44, t34, blocks);
                beforeMove(t44, t34, t24, t14, blocks);
                doAdd(t34, t24, blocks);
                beforeMove(t44, t34, t24, t14, blocks);
                doAdd(t24, t14, blocks);
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

}
