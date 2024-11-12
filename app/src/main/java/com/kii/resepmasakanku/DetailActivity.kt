package com.kii.resepmasakanku

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DESCRIPTION = "extra_description"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_INGREDIENTS = "extra_ingredients"
        const val EXTRA_INSTRUCTIONS = "extra_instructions"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvDetailName: TextView = findViewById(R.id.tv_detail_name)
        val tvDetailDescription: TextView = findViewById(R.id.tv_detail_description)
        val imgDetailPhoto: ImageView = findViewById(R.id.img_detail_photo)
        val tvDetailIngredients: TextView = findViewById(R.id.tv_detail_ingredients)
        val tvDetailInstructions: TextView = findViewById(R.id.tv_detail_instructions)

        val name = intent.getStringExtra(EXTRA_NAME)
        val description = intent.getStringExtra(EXTRA_DESCRIPTION)
        val photo = intent.getIntExtra(EXTRA_PHOTO, 0)
        val ingredients = intent.getStringExtra(EXTRA_INGREDIENTS)
        val instructions = intent.getStringExtra(EXTRA_INSTRUCTIONS)

        tvDetailName.text = name
        tvDetailDescription.text = description
        imgDetailPhoto.setImageResource(photo)
        tvDetailIngredients.text = ingredients
        tvDetailInstructions.text = instructions
    }
}