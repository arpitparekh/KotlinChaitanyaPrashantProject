package arpit.parekh.kotlinchaitanyaprashantproject.binding_in_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import arpit.parekh.kotlinchaitanyaprashantproject.R
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.FragmentDemoBinding

class DemoFragment : Fragment() {

    lateinit var binding : FragmentDemoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDemoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnDemo.setOnClickListener {

        }

        binding.ivDemo.setOnClickListener {

        }

    }

}