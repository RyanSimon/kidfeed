package me.ryansimon.kidfeed;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author Ryan Simon
 */
public class FeedItemViewHolder extends RecyclerView.ViewHolder {

    /**
     * Layout vars
     */
    private TextView mChildAction;
    private TextView mRoomNumber;
    private TextView mActivityDate;
    private CircleImageView mChildImage;
    private ImageView mFeedImage;

    public FeedItemViewHolder(View itemView) {
        super(itemView);

        // get all the layout vars
        mChildAction = (TextView) itemView.findViewById(R.id.child_action_tv);
        mRoomNumber = (TextView) itemView.findViewById(R.id.room_number_tv);
        mActivityDate = (TextView) itemView.findViewById(R.id.activity_date_tv);
        mChildImage = (CircleImageView) itemView.findViewById(R.id.child_image);
        mFeedImage = (ImageView) itemView.findViewById(R.id.feed_image);
    }
}
