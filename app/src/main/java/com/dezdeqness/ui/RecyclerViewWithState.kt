package com.dezdeqness.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView
import com.dezdeqness.R


class RecyclerViewWithState @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var recyclerLayout: ViewGroup? = null

    val recyclerView: RecyclerView
        get() = recyclerLayout as RecyclerView

    val errorLayout: View
        get() = errorView as View

    private var emptyStateView: View? = null
    private var loadingView: View? = null
    private var errorView: View? = null

    private var recyclerViewId: Int
    private var loadingStateId: Int
    private var emptyStateId: Int
    private var errorStateId: Int

    private var isLoadingStateShowing: Boolean = false
    private var isEmptyStateShowing: Boolean = false
    private var isErrorStateShowing: Boolean = false

    var layoutManager: RecyclerView.LayoutManager?
        get() = recyclerView.layoutManager
        set(value) {
            recyclerView.layoutManager = value
        }

    var adapter: RecyclerView.Adapter<*>?
        get() = recyclerView.adapter
        set(value) {
            recyclerView.adapter = value
        }

    init {

        val typedArray = context.obtainStyledAttributes(
            attrs,
            R.styleable.RecyclerViewWithState,
            defStyleAttr,
            0
        )

        recyclerViewId = typedArray.getResourceId(R.styleable.RecyclerViewWithState_recycleViewLayout, 0)
        loadingStateId = typedArray.getResourceId(
            R.styleable.RecyclerViewWithState_loadingStateLayout,
            R.layout.state_loading,
            )
        emptyStateId = typedArray.getResourceId(
            R.styleable.RecyclerViewWithState_emptyStateLayout,
            R.layout.state_empty
        )
        errorStateId = typedArray.getResourceId(
            R.styleable.RecyclerViewWithState_errorStateLayout,
            R.layout.state_error
        )

        recyclerLayout = LayoutInflater.from(context).inflate(recyclerViewId, this, false) as ViewGroup
        loadingView = LayoutInflater.from(context).inflate(loadingStateId, this, false)
        emptyStateView = LayoutInflater.from(context).inflate(emptyStateId, this, false)
        errorView = LayoutInflater.from(context).inflate(errorStateId, this, false)

        addView(recyclerLayout)

        typedArray.recycle()
    }

    fun addItemDecoration(decor: RecyclerView.ItemDecoration) {
        recyclerView.addItemDecoration(decor)
    }

    fun setLoadingState(isLoadingStateShowing: Boolean) {
        if (this.isLoadingStateShowing == isLoadingStateShowing) {
            return
        }
        this.isLoadingStateShowing = isLoadingStateShowing

        removeView(loadingView)

        if (isLoadingStateShowing) {
            addView(loadingView)
        }
    }

    fun scrollToPosition(position: Int) {
        recyclerView.scrollToPosition(position)
    }

    fun setEmptyState(isEmptyStateShowing: Boolean) {
        if (this.isEmptyStateShowing == isEmptyStateShowing) {
            return
        }
        this.isEmptyStateShowing = isEmptyStateShowing
        removeView(emptyStateView)

        if (isEmptyStateShowing) {
            addView(emptyStateView)
        }
    }

    fun setErrorState(isErrorStateShowing: Boolean) {
        if (this.isErrorStateShowing == isErrorStateShowing) {
            return
        }
        this.isErrorStateShowing = isErrorStateShowing
        removeView(errorView)

        if (isErrorStateShowing) {
            addView(errorView)
        }
    }

}
