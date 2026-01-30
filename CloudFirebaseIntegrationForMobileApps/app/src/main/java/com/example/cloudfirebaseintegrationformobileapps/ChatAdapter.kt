package com.example.cloudfirebaseintegrationformobileapps

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cloudfirebaseintegrationformobileapps.databinding.ItemMessageBinding
import com.google.firebase.auth.FirebaseAuth
import java.text.SimpleDateFormat
import java.util.*

class ChatAdapter(private val messages: List<Message>) :
    RecyclerView.Adapter<ChatAdapter.MessageViewHolder>() {

    private val currentUserEmail = FirebaseAuth.getInstance().currentUser?.email

    inner class MessageViewHolder(private val binding: ItemMessageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(message: Message) {
            val isSentByCurrentUser = message.sender == currentUserEmail || 
                                     (currentUserEmail == null && message.sender == "Anonymous")
            
            if (isSentByCurrentUser) {
                // Show sent message (right side, blue)
                binding.layoutSent.visibility = View.VISIBLE
                binding.layoutReceived.visibility = View.GONE
                binding.tvSenderSent.text = "You"
                binding.tvMessageSent.text = message.message
                binding.tvTimestampSent.text = formatTimestamp(message.timestamp)
            } else {
                // Show received message (left side, gray)
                binding.layoutReceived.visibility = View.VISIBLE
                binding.layoutSent.visibility = View.GONE
                binding.tvSenderReceived.text = message.sender.substringBefore("@")
                binding.tvMessageReceived.text = message.message
                binding.tvTimestampReceived.text = formatTimestamp(message.timestamp)
            }
        }

        private fun formatTimestamp(timestamp: Long): String {
            val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
            return sdf.format(Date(timestamp))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val binding = ItemMessageBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MessageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.bind(messages[position])
    }

    override fun getItemCount(): Int = messages.size
}
