package arpit.parekh.kotlinchaitanyaprashantproject.bottom_sheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.MyBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MySheet(var str : String) : BottomSheetDialogFragment() {

    lateinit var binding : MyBottomSheetBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MyBottomSheetBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnToast.setOnClickListener {

            Toast.makeText(context, "This is Toast", Toast.LENGTH_SHORT).show()

        }

        binding.tvDemo.text = str

        binding.rating.setOnRatingBarChangeListener { ratingBar,value, b ->

            Toast.makeText(context,value.toString(),Toast.LENGTH_SHORT).show()

        }

    }



}