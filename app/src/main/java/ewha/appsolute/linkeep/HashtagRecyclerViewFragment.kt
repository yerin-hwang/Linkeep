package ewha.appsolute.linkeep

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HashtagRecyclerViewFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var dataset: Array<Hashtag>

    enum class LayoutManagerType { GRID_LAYOUT_MANAGER, LINEAR_LAYOUT_MANAGER }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initDataset()
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_hashtag,
            container, false).apply { tag = TAG}

        recyclerView = rootView.findViewById(R.id.recycler_hashtag)

        layoutManager = LinearLayoutManager(activity)

        setRecyclerViewLayoutManager()

        recyclerView.adapter = HashtagRecyclerViewAdapter(dataset)


        return rootView
    }

    private fun setRecyclerViewLayoutManager() {
        var scrollPosition = 0

        // If a layout manager has already been set, get current scroll position.
        if (recyclerView.layoutManager != null) {
            scrollPosition = (recyclerView.layoutManager as LinearLayoutManager)
                .findFirstCompletelyVisibleItemPosition()
        }

        layoutManager = GridLayoutManager(activity, SPAN_COUNT)

        with(recyclerView) {
            layoutManager = this@HashtagRecyclerViewFragment.layoutManager
            scrollToPosition(scrollPosition)
        }

    }

//    override fun onSaveInstanceState(savedInstanceState: Bundle) {
//
//        // Save currently selected layout manager.
//        savedInstanceState.putSerializable(KEY_LAYOUT_MANAGER)
//        super.onSaveInstanceState(savedInstanceState)
//    }

    private fun initDataset() {
        var test0:Hashtag = Hashtag("DEV", "JavaScript")
        var test1:Hashtag = Hashtag("DEV", "HTML")
        var test2:Hashtag = Hashtag("DEV", "Android")
        var test3:Hashtag = Hashtag("DEV", "JSON")
        var test4:Hashtag = Hashtag("Travel", "Otawa")
        var test5:Hashtag = Hashtag("Travel", "San Jose")
        var test6:Hashtag = Hashtag("Travel", "HTML")
        var test7:Hashtag = Hashtag("Health", "Exercise")
        var test8:Hashtag = Hashtag("Health", "Diseases")

        var listHashtag:Array<Hashtag> = arrayOf()
        listHashtag[0] = test0
        listHashtag[1] = test1
        listHashtag[2] = test2
        listHashtag[3] = test3
        listHashtag[4] = test4
        listHashtag[5] = test5
        listHashtag[6] = test6
        listHashtag[7] = test7
        listHashtag[8] = test8

        dataset = listHashtag
    }

    companion object {
        private val TAG = "RecyclerViewFragment"
        private val KEY_LAYOUT_MANAGER = "layoutManager"
        private val SPAN_COUNT = 2
        private val DATASET_COUNT = 60
    }}