package ewha.appsolute.linkeep

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HashtagRecyclerViewAdapter(private val dataSet: Array<Hashtag>) : RecyclerView.Adapter<HashtagRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val textView: TextView

        init {
            v.setOnClickListener {
                Log.d(TAG, "Element $adapterPosition clicked.")
                //이벤트 처리
            }

            textView = v.findViewById(R.id.hashtag_name)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_hashtag, viewGroup, false)
        return ViewHolder(v)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.textView.text = dataSet[position].getName()
    }

    override fun getItemCount() = dataSet.size

    companion object {
        private const val TAG = "HashtagRecyclerViewAdapter"
    }
}