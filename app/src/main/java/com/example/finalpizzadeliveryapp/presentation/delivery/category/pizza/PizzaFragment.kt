package com.example.finalpizzadeliveryapp.presentation.delivery.category.pizza

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalpizzadeliveryapp.databinding.FragmentPizzaBinding
import com.example.finalpizzadeliveryapp.presentation.delivery.DeliveryViewModel
import com.example.finalpizzadeliveryapp.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_pizza.*

@AndroidEntryPoint
class PizzaFragment : Fragment() {

    private var _binding: FragmentPizzaBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<DeliveryViewModel>()
    private lateinit var pizzaAdapter: PizzaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPizzaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initViewModel()


    }

    private fun initViewModel(){
        viewModel.pizza.observe(viewLifecycleOwner){
            pizzaAdapter.submitList(it.data)
            progressBar_pizza.isVisible = it is Resource.Loading<*> && it.data.isNullOrEmpty()
            tv_error_pizza.isVisible = it is Resource.Error<*> && it.data.isNullOrEmpty()
            tv_error_pizza.text = it.error?.localizedMessage
        }
    }

    private fun initAdapter(){
        pizzaAdapter = PizzaAdapter()
        rv_pizza.apply {
        adapter = pizzaAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object{
        @JvmStatic
        fun newInstance() = PizzaFragment()
    }


}