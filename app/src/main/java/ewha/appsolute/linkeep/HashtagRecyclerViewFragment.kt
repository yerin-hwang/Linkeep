package ewha.appsolute.linkeep

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HashtagRecyclerViewFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
//    private lateinit var layoutManager: GridLayoutManager
    private lateinit var dataset: Array<Hashtag>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initDataset()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.fragment_hashtag, container, false).apply {
            tag = TAG
        }

        recyclerView = rootView.findViewById(R.id.recycler_hashtag)

        with(recyclerView) {
            layoutManager = GridLayoutManager(activity, SPAN_COUNT)
        }

        recyclerView.addItemDecoration(HashtagRecyclerViewItemDecoration())

        recyclerView.adapter = HashtagRecyclerViewAdapter(dataset)

        return rootView
    }

    private fun initDataset() {
        //테스트용으로 하드코딩한 것
        val listHashtag:Array<Hashtag> = Array(10) { i -> Hashtag("", "temp$i")}
        listHashtag[0] = Hashtag("DEV", "JavaScript")
        listHashtag[1] = Hashtag("DEV", "HTML")
        listHashtag[2] = Hashtag("DEV", "Android")
        listHashtag[3] = Hashtag("DEV", "JSON")
        listHashtag[4] = Hashtag("Travel", "Otawa")
        listHashtag[5] = Hashtag("Travel", "San Jose")
        listHashtag[6] = Hashtag("Travel", "전주")
        listHashtag[7] = Hashtag("Health", "Exercise")
        listHashtag[8] = Hashtag("Health", "Diseases")

        dataset = listHashtag
    }

    companion object {
        private const val TAG = "RecyclerViewFragment"
        private const val SPAN_COUNT = 2
    }
}