package com.example.mobileapp_final

class MessageAdapter(private val messages: List<Message>) :
    RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {

    class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val messageTextView: TextView = itemView.findViewById(R.id.messageTextView)
        val avatarImageView: ImageView = itemView.findViewById(R.id.avatarImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_message, parent, false)
        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position:Int) {
        val message = messages[position]
        holder.messageTextView.text = messages.text

        val avatarRes = if(position % 2 == 0) {
            R.drawable.ic_avatar_placeholder //Sender
        } else {
            R.drawable.ic_avatar_placeholder //Receiver
        }
        holder.avatarImageView.setImageResource(avatarRes)
    }

    override fun getItemCount() = messages.size
}