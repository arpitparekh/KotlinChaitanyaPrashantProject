package arpit.parekh.kotlinchaitanyaprashantproject.pass_object_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import arpit.parekh.kotlinchaitanyaprashantproject.R


class PehlaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pehla, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val edt1 = view.findViewById<EditText>(R.id.edtNameFrag)

        val edt2 = view.findViewById<EditText>(R.id.edtEmailFrag)

        val button = view.findViewById<Button>(R.id.btnSendFrag)

        button.setOnClickListener {


            val name = edt1.text.toString()

            val email = edt2.text.toString()

            val s = Student(name,email)

            val bundle = Bundle()
            bundle.putSerializable("object",s)

            parentFragmentManager.beginTransaction()
                .replace(R.id.fcv_extra_holder,DusraFragment::class.java,bundle)
                .addToBackStack("pehla") // handle back press event
                .commit()

        }


    }
}