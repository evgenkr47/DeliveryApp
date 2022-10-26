package com.example.finalpizzadeliveryapp.presentation.delivery.category.desert

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalpizzadeliveryapp.R
import com.example.finalpizzadeliveryapp.databinding.FragmentDesertBinding
import com.example.finalpizzadeliveryapp.databinding.FragmentDrinkBinding
import com.example.finalpizzadeliveryapp.presentation.delivery.DeliveryViewModel
import com.example.finalpizzadeliveryapp.presentation.delivery.category.drink.DrinkAdapter
import com.example.finalpizzadeliveryapp.presentation.delivery.category.pizza.PizzaFragment
import com.example.finalpizzadeliveryapp.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_desert.*
import kotlinx.android.synthetic.main.fragment_drink.*
@AndroidEntryPoint
class DesertFragment : Fragment() {
    private var _binding: FragmentDesertBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<DeliveryViewModel>()
    lateinit var desertAdapter: DesertAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDesertBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initViewModel()

    }


    private fun initViewModel(){
        viewModel.desert.observe(viewLifecycleOwner){
            desertAdapter.submitList(it.data)
            progressBar_desert.isVisible = it is Resource.Loading<*> && it.data.isNullOrEmpty()
            tv_error_desert.isVisible = it is Resource.Error<*> && it.data.isNullOrEmpty()
            tv_error_desert.text = it.error?.localizedMessage
        }
    }

    private fun initAdapter(){
        desertAdapter = DesertAdapter()
        rv_desert.apply {
            adapter = desertAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object{
        @JvmStatic
        fun newInstance() = DesertFragment()
    }


}