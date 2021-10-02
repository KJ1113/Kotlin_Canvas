package com.ssafy.hwandroidui08_gumi_6_yoonkijae

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ssafy.hwandroidui08_gumi_6_yoonkijae.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var mymode : String = "line"
    var Shapes : String = "line"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivity()


        binding.imageButton.setOnClickListener {
            binding.draw.list.clear()
            binding.draw.invalidate()
        }

        binding.imageButton3.setOnClickListener {
            mymode = "line"
            binding.draw.mode = "line"
            binding.draw.paint_color = Color.WHITE

            binding.imageButton5.visibility = View.INVISIBLE
            binding.imageButton6.visibility = View.INVISIBLE
            binding.imageButton7.visibility = View.INVISIBLE
        }

        binding.imageButton2.setOnClickListener {
            mymode = "line"
            binding.imageButton5.visibility = View.VISIBLE
            binding.imageButton6.visibility = View.VISIBLE
            binding.imageButton7.visibility = View.VISIBLE

            binding.imageButton5.setBackgroundColor(Color.RED)
            binding.imageButton6.setBackgroundColor(Color.BLUE)
            binding.imageButton7.setBackgroundColor(Color.BLACK)

            binding.imageButton5.setImageBitmap(null)
            binding.imageButton6.setImageBitmap(null)
            binding.imageButton7.setImageBitmap(null)
        }


        binding.imageButton4.setOnClickListener {
            mymode = "Shape"
            binding.imageButton5.visibility = View.VISIBLE
            binding.imageButton6.visibility = View.VISIBLE
            binding.imageButton7.visibility = View.VISIBLE

            binding.imageButton5.setBackgroundColor(Color.WHITE)
            binding.imageButton6.setBackgroundColor(Color.WHITE)
            binding.imageButton7.setBackgroundColor(Color.WHITE)

            binding.imageButton5.setImageResource(R.drawable.line)
            binding.imageButton7.setImageResource(R.drawable.circle)
            binding.imageButton6.setImageResource(R.drawable.rect)
        }

        binding.imageButton5.setOnClickListener { // 선 , 빨강
            if(mymode == "line"){
                binding.draw.paint_color = Color.RED
            }else{
                binding.draw.mode = "line"
            }
        }

        binding.imageButton7.setOnClickListener { // 원 , 블랙
            if(mymode == "line"){
                binding.draw.paint_color = Color.BLACK
            }else{
                binding.draw.mode = "circle"
            }
        }

        binding.imageButton6.setOnClickListener { // 사각 , 블루
            if(mymode == "line"){
                binding.draw.paint_color = Color.BLUE
            }
            else{
                binding.draw.mode = "rectangle"
            }
        }
    }

    fun initActivity(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imageButton5.visibility = View.INVISIBLE
        binding.imageButton6.visibility = View.INVISIBLE
        binding.imageButton7.visibility = View.INVISIBLE
    }
}