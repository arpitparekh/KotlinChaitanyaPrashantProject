package arpit.parekh.kotlinchaitanyaprashantproject.firebase_realtime_database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityCustomerListBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CustomerListActivity : AppCompatActivity() {

    lateinit var binding : ActivityCustomerListBinding

    lateinit var ref : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomerListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ref = FirebaseDatabase.getInstance().getReference("Customer").child("CustomDetails")

        binding.btnSend.setOnClickListener {

            val name = binding.edtName.text.toString()
            val address = binding.edtAddress.text.toString()
            val productName = binding.edtProduct.text.toString()

            val customer = Customer(name,address,productName)

            ref.push().setValue(customer).addOnSuccessListener {

                Toast.makeText(this,"Data Uploaded Successfully",Toast.LENGTH_SHORT).show()

            }.addOnFailureListener {
                Toast.makeText(this,it.message,Toast.LENGTH_SHORT).show()
            }

        }

    }
}