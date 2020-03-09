package ewha.appsolute.linkeep

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class HashtagRecyclerViewItemDecoration(): RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)

        //아이템 사이의 마진값을 준 것
        outRect.set(0, 0, 16, 16)
    }
/*
    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
    }
*/
}