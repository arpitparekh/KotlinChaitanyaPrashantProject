package arpit.parekh.kotlinchaitanyaprashantproject.pass_string_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import arpit.parekh.kotlinchaitanyaprashantproject.R


class HelloFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hello, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = view.findViewById<Button>(R.id.btnSomething)

        val editText = view.findViewById<EditText>(R.id.edtSomething)

        button.setOnClickListener {

            val data = editText.text.toString()

            val bundle = Bundle()
            bundle.putString("something",data)

            parentFragmentManager.beginTransaction()
                .replace(R.id.fcv_another_holder,HiFragment::class.java,bundle)
                .addToBackStack("hello")
                .commit()

        }

    }
}