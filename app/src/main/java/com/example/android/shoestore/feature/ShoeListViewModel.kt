package com.example.android.shoestore.feature

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.android.shoestore.model.Shoe
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ShoeListViewModel(app: Application) : AndroidViewModel(app) {

    private val _state: MutableStateFlow<ShoeState> =
        MutableStateFlow(ShoeState(ArrayList()))

    val state = _state.asStateFlow()

    fun addShoe(name: String, size: Double, company: String, description: String) {
        val shoe: Shoe = Shoe(name, size, company, description)
        val shoes = _state.value.shoes
        shoes.add(shoe)
        _state.value = ShoeState(shoes)
    }
}

data class ShoeState(val shoes: ArrayList<Shoe>)