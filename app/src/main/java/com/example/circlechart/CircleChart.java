package com.example.circlechart;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by 懷民 on 2017/10/3.
 */

public class CircleChart extends RelativeLayout {

    private Circle circle;
    private TextView txtTitle, txtContent;

    public CircleChart(Context context) {
        super(context);
        init();
    }

    public CircleChart(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.circle_chart, this);
        circle = findViewById(R.id.circle);
        txtTitle = findViewById(R.id.textView);
        txtContent = findViewById(R.id.textView2);
    }

    public void setTitle(String title) {
        txtTitle.setText(title);
    }

    public void setContent(String content) {
        txtContent.setText(content);
    }

    public void setData(int[] per, int[] color) {
        circle.setData(per, color);
    }

}
