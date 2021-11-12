package com.example.doadzikir

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HarianDzikirDoaActivity : AppCompatActivity() {

    private val listDzikir :ArrayList<DzikirDoa> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_harian_dzikir_doa)

        val rvDzikirDoaHarian = findViewById<RecyclerView>(R.id.rv_dzikir_doa_harian)
        rvDzikirDoaHarian.layoutManager = LinearLayoutManager (this)
        rvDzikirDoaHarian.adapter =DzikirDoaAdapter(listDzikir)

        iniData()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun iniData(){
        val desc = resources.getStringArray(R.array.arr_dzikir_doa_harian)
        val lafaz = resources.getStringArray(R.array.arr_lafaz_dzikir_doa_harian)
        val terjemahan = resources.getStringArray(R.array.arr_terjemah_dzikir_doa_harian)

        for (data in desc.indices){
            val dzikir = DzikirDoa(
                desc[data],
                lafaz[data],
                terjemahan[data]
            )
            listDzikir.add(dzikir)
        }
    }

}