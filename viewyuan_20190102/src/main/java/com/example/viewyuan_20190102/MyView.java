package com.example.viewyuan_20190102;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MyView extends View {

    private Paint paint;//画笔
    private int circleX;//圆的x轴起始坐标
    private int circleY;//圆的y轴起始坐标
    private int mRaduis = 100;//圆半径，px

    /**
     * new 一个空间调用的
     * @param context
     */
    public MyView(Context context) {
        this(context,null);
    }

    /**
     * 自定义view中包含的属性
     * @param context
     * @param attrs
     */
    public MyView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    /**
     * 自定义view中包含的属性和样式
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setAntiAlias(true);//抗锯齿
        //paint.setStyle(Paint.Style.FILL);//实心
       paint.setStyle(Paint.Style.FILL_AND_STROKE);//空心
        paint.setStrokeWidth(20);//空心圆环宽20
    }

   /* public MyView(Context context, @androidx.annotation.Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }*/

    /**
     * 测量
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /**
     * 在onmeasure之后
     * @param w
     * @param h
     * @param oldw
     * @param oldh
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    /**
     * 布局，摆放
     * @param changed
     * @param left
     * @param top
     * @param right
     * @param bottom
     */
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    /**
     * 绘制，展示
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        System.out.println("重绘："+"lhh");
        canvas.drawCircle(circleX,circleY,mRaduis,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){//获取动作行为
            case MotionEvent.ACTION_DOWN:
                circleX = (int) event.getX();//获取距离父控件的x轴坐标
                //circleX = (int) event.getRawX();//获取距离屏幕边缘的x轴坐标
                circleY = (int) event.getY();
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                circleX = (int) event.getX();
                circleY = (int) event.getY();

                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;//返回true，证明消费了这个事件（三个时间都运行了，包括按下，滑动，抬起），false的化，只走down事件
    }
}
