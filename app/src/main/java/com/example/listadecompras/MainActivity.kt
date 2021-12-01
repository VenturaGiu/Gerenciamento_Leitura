package com.example.listadecompras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

import java.util.*

import	java.text.NumberFormat
import	java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val produtosAdapter = ProdutoAdapter(this)
        val listViewProduto = findViewById<ListView>(R.id.listViewProdutos)

        listViewProduto.adapter = produtosAdapter

        val btnAdicionar = findViewById<Button>(R.id.btnAdicionar)

        btnAdicionar.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }



        listViewProduto.setOnItemClickListener { adapterView: AdapterView<*>, view, position: Int, id ->
            val item = produtosAdapter.getItem(position)
            produtosAdapter.remove(item)

        }
    }
    override fun onResume()  {
        super.onResume()
        val listViewProduto = findViewById<ListView>(R.id.listViewProdutos)
        val adapter = listViewProduto.adapter as ProdutoAdapter
        val txtTotal = findViewById<TextView>(R.id.txtTotal)

        adapter.clear()
        adapter.addAll(livrosGlobal)

        var soma = 0

        for(item in livrosGlobal){
            soma += 1
        }

        val f = NumberFormat.getCurrencyInstance(Locale("pt", "b"))
        txtTotal.text = "Livros lidos:  ${soma}"
    }
}