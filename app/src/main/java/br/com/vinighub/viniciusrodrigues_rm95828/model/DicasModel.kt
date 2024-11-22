package br.com.vinighub.viniciusrodrigues_rm95828.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DicasModel(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val title: String,

    val description: String
)