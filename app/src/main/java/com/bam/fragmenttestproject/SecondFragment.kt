package com.bam.fragmenttestproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bam.fragmenttestproject.databinding.FragmentFirstBinding
import com.bam.fragmenttestproject.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    lateinit var binding: FragmentSecondBinding;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.switch1.setOnCheckedChangeListener { buttonView, isChecked ->
            run {
                if (isChecked) {
                   changeFragmentContainer(ItemFragment2())
                }
                else {
                    changeFragmentContainer(ItemFragment1())
                }
            }
        }
    }

    private fun changeFragmentContainer(fragment: Fragment){
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView2, fragment)
            .commit()
    }

}