package chapter.android.aweme.ss.com.homework;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

import chapter.android.aweme.ss.com.homework.model.Message;
import chapter.android.aweme.ss.com.homework.widget.CircleImageView;

import static android.content.ContentValues.TAG;

public class RvE3Adapter extends RecyclerView.Adapter<RvE3Adapter.E3ViewHolder> {
    private Context mContext;
    private List<Message> messages;
    public RvE3Adapter(Context context, List<Message> list) {
        messages = list;
        mContext = context;
    }

    @NonNull
    @Override
    public RvE3Adapter.E3ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        int layoutIdListItem = R.layout.im_list_item;
        //mContext = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(layoutIdListItem, viewGroup, false);
        E3ViewHolder viewHolder = new E3ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RvE3Adapter.E3ViewHolder viewHolder, int i) {
        Message mes = messages.get(i);
        viewHolder.title.setText(mes.getTitle());
        viewHolder.time.setText(mes.getTime());
        viewHolder.description.setText(mes.getDescription());
        switch (mes.getIcon()) {
            case "TYPE_ROBOT":
                viewHolder.avatar.setImageResource(R.drawable.session_robot);
                break;
            case "TYPE_USER":
                viewHolder.avatar.setImageResource(R.drawable.icon_girl);
                break;
            case "TYPE_SYSTEM":
                viewHolder.avatar.setImageResource(R.drawable.session_system_notice);
            case "TYPE_STRANGER":
                viewHolder.avatar.setImageResource(R.drawable.session_stranger);
                break;
            case "TYPE_GAME":
                viewHolder.avatar.setImageResource(R.drawable.icon_micro_game_comment);
                break;
        }
        if (mes.isOfficial()){
            viewHolder.portrait.setVisibility(View.VISIBLE);
        }
        else {
            viewHolder.portrait.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    class E3ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView title, time, description;
        private ImageView portrait;
        private CircleImageView avatar;
        public E3ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_title);
            time = itemView.findViewById(R.id.tv_time);
            description = itemView.findViewById(R.id.tv_description);
            avatar = itemView.findViewById(R.id.iv_avatar);
            portrait = itemView.findViewById(R.id.robot_notice);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int pos = getAdapterPosition();
            onListItemClick(pos);
        }
    }

    public void onListItemClick(int pos) {
        Log.d(TAG, "onListItemClick: ");
        Intent intent = new Intent(mContext, chatRoomActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("pos", pos);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }
}

