package com.gevondov.rates.widgets

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.widget.ImageView
import com.gevondov.rates.R

class ForegroundImageView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : ImageView(context, attrs, defStyleAttr) {

    private var customForeground: Drawable? = null

    init {
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.ForegroundImageView)
        val foreground = attributes.getDrawable(R.styleable.ForegroundImageView_foreground)
        foreground?.let { setForeground(it) }
        attributes.recycle()
    }

    override fun setForeground(drawable: Drawable?) {
        if (customForeground === drawable) {
            return
        }

        customForeground?.let {
            it.callback = null
            unscheduleDrawable(it)
        }

        customForeground = drawable

        drawable?.let {
            it.callback = this
            if (it.isStateful) {
                it.state = drawableState
            }
        }

        requestLayout()
        invalidate()
    }

    override fun getForeground() = customForeground

    override fun verifyDrawable(dr: Drawable): Boolean {
        return super.verifyDrawable(dr) || dr == customForeground
    }

    override fun jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState()
        customForeground?.run {
            jumpToCurrentState()
        }
    }

    override fun drawableStateChanged() {
        super.drawableStateChanged()
        customForeground?.let {
            if (it.isStateful) {
                it.state = drawableState
            }
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        customForeground?.let {
            it.setBounds(0, 0, measuredWidth, measuredHeight)
            invalidate()
        }
        setMeasuredDimension(measuredWidth, measuredWidth)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        customForeground?.let {
            it.setBounds(0, 0, w, h)
            invalidate()
        }
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        foreground?.draw(canvas)
    }
}
