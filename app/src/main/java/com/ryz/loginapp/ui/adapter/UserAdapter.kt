package com.ryz.loginapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ryz.loginapp.R
import com.ryz.loginapp.common.loadRoundedImageUrl
import com.ryz.loginapp.data.entity.UserEntity
import com.ryz.loginapp.databinding.RowItemUserBinding

class UserAdapter : PagingDataAdapter<UserEntity, UserAdapter.UserViewHolder>(DIFF_CALLBACK) {
    inner class UserViewHolder(private val binding: RowItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(userEntity: UserEntity?) {
            with(binding) {
                imgUser.loadRoundedImageUrl(userEntity?.avatar)
                tvName.text = itemView.context.getString(
                    R.string.name,
                    userEntity?.first_name,
                    userEntity?.last_name
                )
                tvEmail.text = userEntity?.email
            }
        }
    }

    override fun onBindViewHolder(holder: UserAdapter.UserViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.UserViewHolder {
        val binding = RowItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<UserEntity>() {
            override fun areItemsTheSame(oldItem: UserEntity, newItem: UserEntity): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: UserEntity, newItem: UserEntity): Boolean =
                oldItem == newItem
        }
    }
}