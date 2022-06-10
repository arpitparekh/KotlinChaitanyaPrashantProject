package arpit.parekh.kotlinchaitanyaprashantproject.photo_json_parsing
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.PhotoRowItemBinding
import com.bumptech.glide.Glide

class PhotoAdapter(val list : ArrayList<Photo>,val context : Context) : RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    class PhotoViewHolder(val binding: PhotoRowItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding = PhotoRowItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PhotoViewHolder(binding)
    }
    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photo = list[position]
        holder.binding.obj = photo
        Glide.with(context).load(photo.url).into(holder.binding.ivPhoto);
    }
    override fun getItemCount() = list.size
}