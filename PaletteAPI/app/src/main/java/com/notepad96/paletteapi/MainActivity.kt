package com.notepad96.paletteapi

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.palette.graphics.Palette
import com.notepad96.paletteapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val images = listOf(R.drawable.sample, R.drawable.bread, R.drawable.cat)
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setImage(count)

        binding.changeImg.setOnClickListener {
            setImage(++count % 3)
        }
    }
    private fun setImage(count: Int) {
        binding.imageView01.setImageResource(images[count])

        val palette = createPaletteSync(BitmapFactory.decodeResource(resources, images[count]))

        setColor(binding.textColor01, palette.lightVibrantSwatch)
        setColor(binding.textColor02, palette.vibrantSwatch)
        setColor(binding.textColor03, palette.darkVibrantSwatch)
        setColor(binding.textColor04, palette.lightMutedSwatch)
        setColor(binding.textColor05, palette.mutedSwatch)
        setColor(binding.textColor06, palette.darkMutedSwatch)
    }

    private fun setColor(view: TextView, swatch: Palette.Swatch?) {
        with(view) {
            setBackgroundColor(swatch?.rgb ?: ContextCompat.getColor(context, R.color.default_background))
            setTextColor(swatch?.titleTextColor ?: ContextCompat.getColor(context, R.color.default_textColor))
        }
    }

    // 동기
    private fun createPaletteSync(bitmap: Bitmap): Palette = Palette.from(bitmap).generate()

    // 비동기
    fun createPaletteAsync(bitmap: Bitmap) {
        Palette.from(bitmap).generate { palette ->

        }
    }
}