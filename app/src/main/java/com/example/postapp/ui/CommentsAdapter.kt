package com.example.postapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.postapp.models.Comment
import com.example.postapp.ui.CommentsAdapter.*
import kotlinx.android.synthetic.main.activity_comment.view.*
import com.example.postapp.ui.CommentsAdapter.CommentsViewHolder as CommentsAdapterCommentsViewHolder

class CommentsAdapter(var commentsList: List<Comment>):
    RecyclerView.Adapter<CommentsAdapter.CommentsViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CommentsAdapterCommentsViewHolder {
        val itemView=LayoutInflater.from()
    }

    override fun onBindViewHolder(holder: CommentsAdapterCommentsViewHolder, position: Int) {
        var comment=commentsList.get(position)
        holder.rowView.tvName=comment.name
        holder.rowView.tvBody.text=comment.body
        holder.rowView.tvEmail.text=comment.email
    }

    override fun getItemCount(): Int {
        return commentsList.size
    }
    class CommentsViewHolder(val rowViewGroup: View):RecyclerView:ViewHolder(rowView)
}