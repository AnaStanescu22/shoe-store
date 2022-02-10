package com.example.android.shoestore.feature

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.shoestore.R
import com.example.android.shoestore.databinding.FragmentShoeListBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class ShoeListFragment : Fragment() {
    private val sharedViewModel: ShoeListViewModel by activityViewModels()
    private lateinit var shoeAdapter : ShoeRecyclerAdapter
    private lateinit var binding: FragmentShoeListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_list, container, false
        )

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        shoeAdapter = ShoeRecyclerAdapter()
        binding.shoeRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.shoeRecyclerView.adapter = shoeAdapter

        sharedViewModel.state.onEach { shoeState ->
            shoeAdapter.setShoe(shoeState.shoes)
        }. launchIn(lifecycleScope)

        binding.addButton.setOnClickListener {
            findNavController()
                .navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        findNavController().navigate(R.id.loginFragment)
        return super.onOptionsItemSelected(item)
    }
}