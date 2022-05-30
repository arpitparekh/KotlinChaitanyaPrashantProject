package arpit.parekh.kotlinchaitanyaprashantproject.room

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.NoteRowItemBinding

class NoteAdapter(val list: List<Note>,val onNoteClickInterface: OnNoteClickInterface) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    class NoteViewHolder(val binding: NoteRowItemBinding)  : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = NoteRowItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = list[position]
        holder.binding.obj = note

        holder.itemView.setOnClickListener {

            onNoteClickInterface.onNoteClick(position)
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }
}