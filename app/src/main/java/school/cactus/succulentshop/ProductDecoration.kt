package school.cactus.succulentshop

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class ProductDecoration : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val spacing = view.context.resources.getDimensionPixelSize(R.dimen.item_product_spacing)
        val position =parent.getChildAdapterPosition(view)
        val spanIndex =(view.layoutParams as StaggeredGridLayoutManager.LayoutParams).spanIndex

        val isAtRight = spanIndex == 1
        val isAtFirstLine = position < 2

        if(isAtRight){
            outRect.right = spacing
            outRect.left = spacing / 2
        }else{
            outRect.left = spacing
            outRect.right = spacing / 2
        }
        outRect.bottom = spacing
        if(isAtFirstLine){
            outRect.top = spacing
        }
    }
}