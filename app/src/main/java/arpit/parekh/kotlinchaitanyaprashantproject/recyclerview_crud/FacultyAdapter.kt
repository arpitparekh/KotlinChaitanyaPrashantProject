package arpit.parekh.kotlinchaitanyaprashantproject.recyclerview_crud

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.SpinnerAdapter
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.FacultyRowItemBinding

class FacultyAdapter(val list : ArrayList<Faculty>,val onAdapterItemClickInterface: OnAdapterItemClickInterface) : RecyclerView.Adapter<FacultyAdapter.FacultyViewHolder>(){

    lateinit var context : Context


    class FacultyViewHolder(val binding : FacultyRowItemBinding) : RecyclerView.ViewHolder(binding.root)
        // holds the individual views inside item

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FacultyViewHolder {
        // individual item layout
        context = parent.context
        val inflater = LayoutInflater.from(parent.context)
        val binding = FacultyRowItemBinding.inflate(inflater, parent, false)
        return FacultyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FacultyViewHolder, position: Int) {
        // load data inside individual item
        val faculty = list[position]
        holder.binding.obj = faculty

        holder.itemView.setOnClickListener {

            onAdapterItemClickInterface.onClick(position)

        }

    }

    override fun getItemCount(): Int {
        return list.size
    }
}