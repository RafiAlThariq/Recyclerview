package com.example.recyclerview

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.recyclerview.adapter.AdapterTeamBola
import com.example.recyclerview.databinding.ActivityMainBinding
import com.example.recyclerview.model.Pemain

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val listPemain = ArrayList<Pemain>()
        listPemain.add(Pemain("Nadeo Argawinata",R.drawable.nadeo,"Penjaga Gawang","1.87 m", "Kediri (Indonesia)","9 Maret 1997"))
        listPemain.add(Pemain("Yabes Roni Malaifani",R.drawable.yabes ,"Winger","1.68 m", "Alor (Indonesia)","6 Febuari 1995"))
        listPemain.add(Pemain("Willian Pacheco",R.drawable.paceco,"Belakang","1.96 m", "Sao Paulo (Brasil)","28 Maret 1992"))
        listPemain.add(Pemain("Leo Tupamahu",R.drawable.leo,"Belakang","1.79 m", "Jakarta (Indonesia)","31 Maret 1983"))
        listPemain.add(Pemain("Ilija Spasojevic",R.drawable.spaso,"Striker","1.87 m", "Jugoslawien (Montenegro)","11 September 1987"))

        binding.list.adapter = AdapterTeamBola(this, listPemain, object  : AdapterTeamBola.OnClickListener{
            override fun detailData(item: Pemain) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_pemain)

                    val image = this.findViewById<ImageView>(R.id.image_pemain)
                    val nama = this.findViewById<TextView>(R.id.txtNamaPemain)

                    val posisi = this.findViewById<TextView>(R.id.txtPosisi)
                    val tinggi = this.findViewById<TextView>(R.id.txtTinggi)
                    val tempatlahir = this.findViewById<TextView>(R.id.txtTempatLahir)
                    val tgllahir = this.findViewById<TextView>(R.id.txtTglLahir)
                    val btn = this.findViewById<Button>(R.id.btnClose)

                    image.setImageResource(item.foto)
                    nama.text = "${item?.nama}"
                    posisi.text = "${item?.posisi}"
                    tinggi.text = "${item?.tinggi}"
                    tempatlahir.text = "${item?.tempatlahir}"
                    tgllahir.text = "${item?.tgllahir}"

                    btn.setOnClickListener {
                        this.dismiss()
                    }

                }.show()
            }

        })
    }

}