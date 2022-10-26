package com.example.finalpizzadeliveryapp.presentation.delivery.category.drink

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalpizzadeliveryapp.R
import com.example.finalpizzadeliveryapp.databinding.FragmentDrinkBinding
import com.example.finalpizzadeliveryapp.databinding.FragmentPizzaBinding
import com.example.finalpizzadeliveryapp.presentation.delivery.DeliveryViewModel
import com.example.finalpizzadeliveryapp.presentation.delivery.category.pizza.PizzaAdapter
import com.example.finalpizzadeliveryapp.presentation.delivery.category.pizza.PizzaFragment
import com.example.finalpizzadeliveryapp.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_drink.*
import kotlinx.android.synthetic.main.fragment_pizza.*

@AndroidEntryPoint
class DrinkFragment : Fragment() {
    private var _binding: FragmentDrinkBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<DeliveryViewModel>()
    lateinit var drinkAdapter: DrinkAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDrinkBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initViewModel()

    }

    private fun initViewModel(){
        viewModel.drink.observe(viewLifecycleOwner){
            drinkAdapter.submitList(it.data)
            progressBar_drink.isVisible = it is Resource.Loading<*> && it.data.isNullOrEmpty()
            tv_error_drink.isVisible = it is Resource.Error<*> && it.data.isNullOrEmpty()
            tv_error_drink.text = it.error?.localizedMessage
        }
    }

    private fun initAdapter(){
        drinkAdapter = DrinkAdapter()
        rv_drink.apply {
            adapter = drinkAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object{
        @JvmStatic
        fun newInstance() = DrinkFragment()
    }
}