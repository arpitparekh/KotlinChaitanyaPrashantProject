package arpit.parekh.kotlinchaitanyaprashantproject.pass_object_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import arpit.parekh.kotlinchaitanyaprashantproject.R


class DusraFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dusra, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textView = view.findViewById<TextView>(R.id.tvObjectFrag)
        val button = view.findViewById<Button>(R.id.btnGoBack)

        val bundle = arguments

        val student : Student = bundle?.getSerializable("object") as Student

        textView.text = "name is ${student.name}\nemail is ${student.email}"


        button.setOnClickListener {

            parentFragmentManager.popBackStack()

        }


    }
}