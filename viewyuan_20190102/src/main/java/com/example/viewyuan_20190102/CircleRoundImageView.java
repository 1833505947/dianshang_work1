package com.example.viewyuan_20190102;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

@SuppressLint("AppCompatCustomView")
public class CircleRoundImageView extends ImageView {
    public CircleRoundImageView(Context context) {
        super(context);
    }

    public CircleRoundImageView(Context context,AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleRoundImageView(Context context,AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getDrawable();
        Bitmap bitmap = bitmapDrawable.getBitmap();
        if (bitmap!=null){
            //对bitmap对象进行圆角转换
            Bitmap bm = getRoundBitmap(bitmap);
            //绘制新的bitmap
            canvas.drawBitmap(bm,0,0,null);
        }else {

            super.onDraw(canvas);
        }
    }
    /**
     * 获取圆角bitmap，xfermode，进阶里面一个交集
     * @param bitmap
     * @return
     */
    private Bitmap getRoundBitmap(Bitmap bitmap) {
        //宽高缩放比
        float widthScale = (float) getMeasuredWidth() / bitmap.getWidth();
        float heightScale = (float) getMeasuredHeight()/bitmap.getHeight();
        //矩阵变换类
        Matrix matrix = new Matrix();
        matrix.setScale(widthScale,heightScale);
        //对bitmap进行变换

        Bitmap bh_bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        //最终输出的对象
        Bitmap out_bitmap = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        //创建画布
        Canvas canvas = new Canvas(out_bitmap);
        //创建画笔
        Paint paint = new Paint();
        //创建一个圆角的图形
        RectF rectF = new RectF(0,0,getMeasuredWidth(),getMeasuredHeight());
        canvas.drawRoundRect(rectF,30,30,paint);
        //设置画笔的xfermode模式
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        //画原始bitmap
        canvas.drawBitmap(bh_bitmap,0,0,paint);
        return out_bitmap;
    }

}
