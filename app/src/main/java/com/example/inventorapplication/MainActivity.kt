package com.example.inventorapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvInventor: RecyclerView
    private val list = ArrayList<Inventor>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvInventor = findViewById(R.id.rv_inventor)
        rvInventor.setHasFixedSize(true)

        list.addAll(getListInventors())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.about_page -> {
                val moveIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListInventors(): ArrayList<Inventor>{
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listInventor = ArrayList<Inventor>()
        for(i in dataName.indices){
            val inventor = Inventor(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listInventor.add(inventor)
        }
        return listInventor
    }

    private fun showRecyclerList() {
        rvInventor.layoutManager = LinearLayoutManager(this)
        val listInventorAdapter = ListInventorAdapter(list)
        rvInventor.adapter = listInventorAdapter

        listInventorAdapter.setOnItemClickCallback(object : ListInventorAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Inventor) {
                val intentDetailed = Intent(this@MainActivity, DetailedActivity::class.java)
                intentDetailed.putExtra(DetailedActivity.DATA, data)
                startActivity(intentDetailed)
            }
        })
    }

}