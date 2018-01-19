package com.xy.carbarn.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

public class RatioImageView extends android.support.v7.widget.AppCompatImageView {

    public RatioImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            // 因为高有问题，所以我们修改这高，让它按比例算出这个高
            int picRealHeight = drawable.getMinimumHeight();    // 获取图片真实的高
            int picRealWidth = drawable.getMinimumWidth();      // 获取图片真实的宽

            float scale = (float) picRealHeight / picRealWidth; // 计算图片高和宽的比例
            int width = MeasureSpec.getSize(widthMeasureSpec);  // 获取测量规格
            int height = (int) (width * scale);                 // 按比例计算高度
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);   // 创建测量规格
        }

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

}