package arpit.parekh.kotlinchaitanyaprashantproject.firebase_realtime_database

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityCustomerListBinding
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.CustomerUpdateLayoutBinding
import com.google.firebase.database.*

class CustomerListActivity : AppCompatActivity() {

    lateinit var binding : ActivityCustomerListBinding
    lateinit var binding1 : CustomerUpdateLayoutBinding
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

            binding1 = CustomerUpdateLayoutBinding.inflate(layoutInflater)

            val customer =  list[pos]
            val key = keys[pos]

            binding1.edtNameUpdate.setText(customer.name)
            binding1.edtAddressUpdate.setText(customer.address)
            binding1.edtProductUpdate.setText(customer.product)

            AlertDialog.Builder(this)
                .setTitle("Choose One")
                .setPositiveButton("Update", DialogInterface.OnClickListener { dialogInterface, i ->

                    AlertDialog.Builder(this)
                        .setTitle("Update")
                        .setView(binding1.root)
                        .setPositiveButton("Update", DialogInterface.OnClickListener { dialogInterface, i ->

                            val name = binding1.edtNameUpdate.text.toString()
                            val address = binding1.edtAddressUpdate.text.toString()
                            val product = binding1.edtProductUpdate.text.toString()

                            val customerUpdate = Customer(name,address,product)

                            ref.child(key).setValue(customerUpdate)  // update


                        }).create().show()

                }).setNegativeButton("Delete", DialogInterface.OnClickListener { dialogInterface, i ->

                    ref.child(key).removeValue()  // delete

                }).create().show()

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

        // Content Resolver
        // Cursor

    }
}