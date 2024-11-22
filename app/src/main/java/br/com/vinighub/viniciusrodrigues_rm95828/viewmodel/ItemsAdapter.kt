package br.com.vinighub.viniciusrodrigues_rm95828.viewmodel

import android.app.PendingIntent
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import br.com.vinighub.viniciusrodrigues_rm95828.MainActivity
import br.com.vinighub.viniciusrodrigues_rm95828.R
import br.com.vinighub.viniciusrodrigues_rm95828.model.DicasModel


class ItemsAdapter(private val onItemRemoved: (DicasModel) -> Unit) :
    RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

    // Lista de itens que serão exibidos no RecyclerView.
    private var items = listOf<DicasModel>()

    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        // Referências para as views de cada item.
        val textViewTitle = view.findViewById<TextView>(R.id.textViewTipsTitle)
        val textViewDescription = view.findViewById<TextView>(R.id.textViewTipsDescription)
        val button = view.findViewById<ImageButton>(R.id.imageButton)


        fun bind(item: DicasModel) {
            // Define o texto do TextView para o nome do item.
            textViewTitle.text = item.title
            textViewDescription.text = item.description

            // Define um listener para o botão, que chama o callback onItemRemoved quando clicado
            button.setOnClickListener {
                onItemRemoved(item)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // Infla o layout do item.
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.dicas_layout, parent, false)
        // Cria e retorna um novo ViewHolder.
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    fun updateItems(newItems: List<DicasModel>) {
        // Atualiza a lista de itens.
        items = newItems
        // Notifica o RecyclerView que os dados mudaram.
        notifyDataSetChanged()
    }
}