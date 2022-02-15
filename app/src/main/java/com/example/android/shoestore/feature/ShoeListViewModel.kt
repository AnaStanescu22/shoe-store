package com.example.android.shoestore.feature

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.navigation.findNavController
import com.example.android.shoestore.model.Shoe
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ShoeListViewModel(app: Application) : AndroidViewModel(app) {

    private val _shoe: MutableStateFlow<ArrayList<Shoe>> =
        MutableStateFlow(ArrayList())

    val shoe = _shoe.asStateFlow()

    fun addShoe(v: View, shoe: Shoe){
        _shoe.value?.add(shoe)
        navigate(v)
    }

    fun navigate(v: View){
        v.findNavController()
            .navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
    }
}