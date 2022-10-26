package com.example.finalpizzadeliveryapp.presentation.delivery.category.combo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalpizzadeliveryapp.R
import com.example.finalpizzadeliveryapp.databinding.FragmentComboBinding
import com.example.finalpizzadeliveryapp.databinding.FragmentDesertBinding
import com.example.finalpizzadeliveryapp.presentation.delivery.DeliveryViewModel
import com.example.finalpizzadeliveryapp.presentation.delivery.category.desert.DesertAdapter
import com.example.finalpizzadeliveryapp.presentation.delivery.category.pizza.PizzaFragment
import com.example.finalpizzadeliveryapp.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_combo.*
import kotlinx.android.synthetic.main.fragment_desert.*
import kotlinx.android.synthetic.main.fragment_drink.*

@AndroidEntryPoint
class ComboFragment : Fragment() {

    private var _binding: FragmentComboBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<DeliveryViewModel>()
    lateinit var comboAdapter: ComboAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentComboBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initViewModel()
    }

    private fun initViewModel(){
        viewModel.combo.observe(viewLifecycleOwner){
            comboAdapter.submitList(it.data)
            progressBar_combo.isVisible = it is Resource.Loading<*> && it.data.isNullOrEmpty()
            tv_error_combo.isVisible = it is Resource.Error<*> && it.data.isNullOrEmpty()
            tv_error_combo.text = it.error?.localizedMessage
        }
    }

    private fun initAdapter(){
        comboAdapter = ComboAdapter()
        rv_combo.apply {
            adapter = comboAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object{
        @JvmStatic
        fun newInstance() = ComboFragment()
    }


}