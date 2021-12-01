package com.example.listadecompras

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import    android.graphics.Bitmap
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class CadastroActivity : AppCompatActivity() {
    val COD_IMAGE = 101
    var imageBitMap: Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val btnInserir = findViewById<Button>(R.id.btnInserir)
        val txtLivro = findViewById<EditText>(R.id.txtLivro)
        val txtPagina = findViewById<EditText>(R.id.txtPagina)
        val dataLeitura = findViewById<EditText>(R.id.dataLeitura)
        val imgFotoProduto = findViewById<ImageView>(R.id.imgFotoProduto)

        btnInserir.setOnClickListener {
            val livro = txtLivro.text.toString()
            val paginas = txtPagina.text.toString()
            val data = dataLeitura.text.toString()
            if (livro.isNotEmpty() && paginas.isNotEmpty()) {
                val prod = Livro(livro, paginas.toInt(), data)
                livrosGlobal.add(prod)
                txtLivro.text.clear()
                txtPagina.text.clear()
                dataLeitura.text.clear()
            } else {
                txtLivro.error = if (txtLivro.text.isEmpty()) "Preencha o nome do Livro"
                else null

                txtPagina.error = if (txtPagina.text.isEmpty()) "Preencha a Quantidade de Páginas"
                else null

                dataLeitura.error = if (dataLeitura.text.isEmpty()) "Preencha a Data de Conclusão da Leitura"
                else null
            }

        }

        imgFotoProduto.setOnClickListener {
            abrirGaleria()
        }
    }

    fun abrirGaleria() {
        //definindo a ação de conteudo
        val intent = Intent(Intent.ACTION_GET_CONTENT)

        //definindo filtro para imagens
        intent.type = "image/*"

        //inicializando a activity com resultado
        startActivityForResult(Intent.createChooser(intent, "Selecione uma imagem"), COD_IMAGE)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val imgFotoProduto = findViewById<ImageView>(R.id.imgFotoProduto)
        super.onActivityResult(requestCode, resultCode, data)


        if (requestCode == COD_IMAGE && resultCode == Activity.RESULT_OK) {

            if (data != null) {
                //vamos acessar a imagem escolhida através da variável "data"
                //lendo a URI com a imagem

                //val inputStream = contentResolver.openInputStream(data.getData());


                //transformando o resultado em bitmap
                //imageBitMap = BitmapFactory.decodeStream(inputStream)

                //exibir a imagem no aplicativo
                imgFotoProduto.setImageBitmap(imageBitMap)
            }
        }
    }
}