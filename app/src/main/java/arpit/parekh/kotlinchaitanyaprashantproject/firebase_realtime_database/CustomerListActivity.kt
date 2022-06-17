package arpit.parekh.kotlinchaitanyaprashantproject.firebase_realtime_database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityCustomerListBinding
import com.google.firebase.database.*

class CustomerListActivity : AppCompatActivity() {

    lateinit var binding : ActivityCustomerListBinding

    lateinit var ref : DatabaseReference

    lateinit var list : ArrayList<Customer>
    lateinit var keys : ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomerListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list = ArrayList()
        keys = ArrayList()

        ref = FirebaseDatabase.getInstance().getReference("Customer").child("CustomDetails")

        binding.listViewCustomer.setOnItemClickListener { adapterView, view, pos, l ->

            val customer =  list[pos]
            val key = keys[pos]

        }

        ref.addValueEventListener(object : ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {

                list.clear()
                keys.clear()
                for(childSnap in snapshot.children){

                    val customer : Customer? = childSnap.getValue(Customer::class.java)
                    val key : String? = childSnap.key

                    if(customer!=null){
                        list.add(customer)
                    }
                    if (key != null) {
                        keys.add(key)
                    }
                }

                val adapter = ArrayAdapter<Customer>(this@CustomerListActivity,android.R.layout.simple_list_item_1,list)
                binding.listViewCustomer.adapter = adapter
            }
            override fun onCancelled(error: DatabaseError) {

            }

        })

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