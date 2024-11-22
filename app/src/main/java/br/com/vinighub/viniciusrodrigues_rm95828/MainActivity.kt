package br.com.vinighub.viniciusrodrigues_rm95828

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import br.com.vinighub.viniciusrodrigues_rm95828.viewmodel.ItemsAdapter
import br.com.vinighub.viniciusrodrigues_rm95828.viewmodel.ItemsViewModel
import br.com.vinighub.viniciusrodrigues_rm95828.viewmodel.ItemsViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ItemsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.title = "Lista de Dicas"

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val itemsAdapter = ItemsAdapter { item ->
            viewModel.removeItem(item)
        }

        recyclerView.adapter = itemsAdapter

        val button = findViewById<Button>(R.id.button)
        val buttonGroup = findViewById<Button>(R.id.group)
        val editTextTitle = findViewById<EditText>(R.id.editTextTitle)
        val editTextDescription = findViewById<EditText>(R.id.editTextDescription)

        button.setOnClickListener {
            if (editTextTitle.text.isEmpty() || editTextDescription.text.isEmpty()) {
                editTextTitle.error = "Preencha o campo titulo"
                editTextDescription.error = "Preencha o campo descrição"
                return@setOnClickListener
            }

            viewModel.addItem(editTextTitle.text.toString(), editTextDescription.text.toString())
            editTextTitle.text.clear()
            editTextDescription.text.clear()
        }

        buttonGroup.setOnClickListener {
            val intent = Intent(this, GroupActivity::class.java)
            startActivity(intent)
        }


        val viewModelFactory = ItemsViewModelFactory(application)

        viewModel = ViewModelProvider(this, viewModelFactory).get(ItemsViewModel::class.java)

        viewModel.itemsLiveData.observe(this) { items ->
            itemsAdapter.updateItems(items)
        }
    }
}