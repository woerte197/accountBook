package com.wangyang.account.ui.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class Circle @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var mPaint: Paint? = null
    private var path: Path? = null

    init {
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mPaint?.color = Color.RED
        mPaint?.style = Paint.Style.FILL
        path = Path()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawCircle(100f, 100f, 8f, mPaint!!)
        canvas?.drawCircle(150f, 100f, 10f, mPaint!!)
        path?.reset()
        path?.moveTo(150f, 100f)
        path?.lineTo(150f, 100f - 10f)
        path?.quadTo((150f+100f)/2, 100f, 100f, 100f - 8f)
        path?.lineTo(100f, 100f + 8f)
        path?.quadTo((150f+100f)/2, 100f, 150f, 100f + 10f)
        path?.close()
        canvas?.drawPath(path!!, mPaint!!)
    }


}