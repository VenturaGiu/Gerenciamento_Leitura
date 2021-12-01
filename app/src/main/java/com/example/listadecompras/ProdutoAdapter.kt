package com.example.listadecompras

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

import java.text.NumberFormat
import java.util.Locale

class ProdutoAdapter(contexto: Context) : ArrayAdapter<Livro>(contexto, 0) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val v: View
        if (convertView != null) {
            v = convertView
        } else {
            //inflar o layout
            //inflate(resource: View, root: ViewGroup, attachToRoot: Boolean)
            v = LayoutInflater.from(context).inflate(R.layout.list_view_item, parent, false)
        }
        val item = getItem(position)
        val txtLivro = v.findViewById<TextView>(R.id.txtItemLivro)
        val txtPaginas = v.findViewById<TextView>(R.id.txtItemPaginas)
        val txtData = v.findViewById<TextView>(R.id.txtItemData)
        val imgProduto = v.findViewById<ImageView>(R.id.imgItemFoto)

        txtPaginas.text = item?.pagina.toString()
        txtLivro.text = item?.nome
        val f = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
        txtData.text = item?.data.toString()
        if (item?.foto != null) {
            imgProduto.setImageBitmap(item?.foto)
        }
        return v
    }

}
//adaptador antigo
//val produtosAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)