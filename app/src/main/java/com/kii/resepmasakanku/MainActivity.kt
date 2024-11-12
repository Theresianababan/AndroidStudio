package com.kii.resepmasakanku

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvResep: RecyclerView
    private val list = ArrayList<Resep>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvResep = findViewById(R.id.rv_resep)
        rvResep.setHasFixedSize(true)

        list.addAll(getListResep())
        showRecyclerList()
    }

    private fun getListResep(): ArrayList<Resep> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataIngredients = resources.getStringArray(R.array.data_ingredients)
        val dataInstructions = resources.getStringArray(R.array.data_instructions)
        val listResep = ArrayList<Resep>()

        for (i in dataName.indices) {
            val resep = Resep(
                dataName[i],
                dataDescription[i],
                dataPhoto.getResourceId(i, -1),
                dataIngredients[i],
                dataInstructions[i]
            )
            listResep.add(resep)
        }
        dataPhoto.recycle()
        return listResep
    }

    private fun showRecyclerList() {
        rvResep.layoutManager = LinearLayoutManager(this)
        val listResepAdapter = ListResepAdapter(list)
        rvResep.adapter = listResepAdapter
    }
}
