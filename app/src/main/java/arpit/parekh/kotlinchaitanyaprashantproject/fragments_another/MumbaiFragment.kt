package arpit.parekh.kotlinchaitanyaprashantproject.fragments_another

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import arpit.parekh.kotlinchaitanyaprashantproject.R

class MumbaiFragment : Fragment() {

    override fun onCreateView(    // join the layout with kotlin file
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mumbai,container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = view.findViewById<Button>(R.id.btnGoNext)

        button.setOnClickListener {

            val manager = parentFragmentManager
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.fcv_holder,GoaFragment())
            transaction.addToBackStack("mumbai")
            transaction.commit()

        }

    }


}