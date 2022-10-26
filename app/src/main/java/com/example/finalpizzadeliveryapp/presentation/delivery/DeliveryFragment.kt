package com.example.finalpizzadeliveryapp.presentation.delivery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.finalpizzadeliveryapp.R
import com.example.finalpizzadeliveryapp.databinding.FragmentDeliveryBinding
import com.example.finalpizzadeliveryapp.databinding.FragmentPizzaBinding
import com.example.finalpizzadeliveryapp.presentation.delivery.category.combo.ComboFragment
import com.example.finalpizzadeliveryapp.presentation.delivery.category.desert.DesertFragment
import com.example.finalpizzadeliveryapp.presentation.delivery.category.drink.DrinkFragment
import com.example.finalpizzadeliveryapp.presentation.delivery.category.pizza.PizzaFragment
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.bottomsheet.*

@AndroidEntryPoint
class DeliveryFragment : Fragment() {
    private val fragmentList = listOf(
        PizzaFragment.newInstance(),
        ComboFragment.newInstance(),
        DesertFragment.newInstance(),
        DrinkFragment.newInstance()
    )
    private var _binding: FragmentDeliveryBinding? = null
    private val binding get() = _binding!!
    private lateinit var dialog: BottomSheetDialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDeliveryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        replaceFragments(PizzaFragment.newInstance())

        binding.categoryTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                (requireActivity()).supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.placeholder, fragmentList[tab?.position!!])
                    .commit()
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

        binding.btChooseCity.setOnClickListener {
            showBottomSheet()
        }
    }

    private fun replaceFragments(fragment: Fragment){
        (requireActivity()).supportFragmentManager.beginTransaction()
            .replace(R.id.placeholder, fragment)
            .commit()
    }
    private fun showBottomSheet(){
        val dialogView = layoutInflater.inflate(R.layout.bottomsheet, null)
        dialog = BottomSheetDialog(requireActivity(), R.style.BottomSheetDialogTheme)
        dialog.setContentView(dialogView)
        dialog.show()

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object{
        @JvmStatic
        fun newInstance() = DeliveryFragment()
    }


}