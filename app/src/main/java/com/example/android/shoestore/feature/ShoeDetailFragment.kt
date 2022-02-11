package com.example.android.shoestore.feature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.android.shoestore.R
import com.example.android.shoestore.databinding.FragmentShoeDetailBinding

class ShoeDetailFragment : Fragment() {

    private val sharedViewModel: ShoeListViewModel by activityViewModels()
    private lateinit var binding: FragmentShoeDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_detail,
            container, false
        )
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.saveButton.setOnClickListener {
            val name = binding.nameEditText.text.toString()
            val size = binding.sizeEditText.text.toString().toDoubleOrNull()
            val company = binding.companyEditText.text.toString()
            val description = binding.descriptionEditText.text.toString()
            val inputFields = listOf(name, size.toString(), company, description)
            if (inputFields.any {
                    it.isEmpty()
                }) Toast.makeText(context, "Fill in the fields", Toast.LENGTH_SHORT).show()
            else {
                sharedViewModel.addShoe(name, size ?: 0.0, company, description)
                findNavController()
                    .navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
            }
        }
        binding.cancelButton.setOnClickListener {
            findNavController()
                .navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }
    }
}