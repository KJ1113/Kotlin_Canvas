package com.ssafy.hwandroidui08_gumi_6_yoonkijae

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import java.lang.Math.sqrt
import kotlin.math.pow

data class Point(var x:Float, var y:Float , var isContinue :Boolean ,var color : Int , var strokeWidth : Float , var mode : String)

private const val TAG = "DrawSample_싸피"
class DrawSample : View  {
    var mode : String = "line"
    var list = arrayListOf<Point>()
    var paint_color : Int = Color.RED
    var paint_strokeWidth : Float = 10F


    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) { }
    var paint : Paint
    init{
        paint = Paint()
        paint.strokeWidth = 10F
        paint.color = Color.RED

    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)


        list.forEachIndexed { index, point ->
            if(point.isContinue){
                paint.color = list[index-1].color
                paint.strokeWidth = list[index-1].strokeWidth

                if(list[index-1].mode == "line"){
                    canvas.drawLine(list[index-1].x , list[index-1].y , point.x, point.y, paint)
                }else if(list[index-1].mode == "circle"){
                    paint.style = Paint.Style.STROKE
                    var r : Double =  sqrt( (list[index-1].x - point.x).pow(2).toDouble()  + (list[index-1].y - point.y).pow(2).toDouble())/2
                    canvas.drawCircle(list[index-1].x , list[index-1].y , r.toFloat() ,paint)
                }else{
                    paint.style = Paint.Style.STROKE
                    canvas.drawRect(Rect( list[index-1].x.toInt() , list[index-1].y.toInt() , point.x.toInt(), point.y.toInt() ) , paint)
                }
            }
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if(paint_color == Color.WHITE) paint_strokeWidth = 50F
        else paint_strokeWidth = 10F

        when(event?.action){
            MotionEvent.ACTION_DOWN -> {
                list.add(Point(event?.x, event?.y ,false ,paint_color , paint_strokeWidth , mode))
            }
            MotionEvent.ACTION_MOVE -> {
                if(mode == "line"){
                    list.add(Point(event?.x, event?.y ,true , paint_color , paint_strokeWidth , mode))
                }
                //list.add(Point(event?.x, event?.y ,true , paint_color , paint_strokeWidth , mode))
            }
            MotionEvent.ACTION_UP -> {
                Log.d(TAG, "ACTION_UP : ${event.x} ${event.y}")
                list.add(Point(event?.x, event?.y ,true , paint_color , paint_strokeWidth , mode))
            }
        }
        invalidate()
        return true
    }

}