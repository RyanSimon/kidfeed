package me.ryansimon.kidfeed;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author Ryan Simon
 */
public class FeedItemAdapter extends RecyclerView.Adapter<FeedItemAdapter.FeedItemViewHolder> {

    private List<String> mFeedItems;
    private static final int FIRST_AND_LAST_CARD_MARGIN = 4;

    public FeedItemAdapter(List<String> feedItems) {
        mFeedItems = feedItems;
    }

    @Override
    public FeedItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.feed_list_item, parent, false);
        return new FeedItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FeedItemViewHolder holder, int position) {

        holder.getChildAction().setText(mFeedItems.get(position));

        // add a top margin to the first item
        if(position == 0) {
            View rowContainer = holder.getRowContainer();
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) rowContainer.getLayoutParams();
            layoutParams.setMargins(layoutParams.leftMargin,
                    Helper.dpToPixels(FIRST_AND_LAST_CARD_MARGIN,rowContainer.getContext()),
                    layoutParams.rightMargin, layoutParams.bottomMargin);
        }
        // add a bottom margin to the last item
        else if(position == mFeedItems.size() - 1) {
            View rowContainer = holder.getRowContainer();
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) rowContainer.getLayoutParams();
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin,
                    layoutParams.rightMargin, Helper.dpToPixels(FIRST_AND_LAST_CARD_MARGIN,rowContainer.getContext()));
        }
    }

    @Override
    public int getItemCount() {
        return (mFeedItems != null) ? mFeedItems.size() : 0;
    }

    public static class FeedItemViewHolder extends RecyclerView.ViewHolder {

        /**
         * Layout vars
         */
        private TextView mChildAction;
        private TextView mRoomNumber;
        private TextView mActivityDate;
        private CircleImageView mChildImage;
        private ImageView mFeedImage;
        private View mRowContainer;

        public FeedItemViewHolder(View itemView) {
            super(itemView);

            // get all the layout vars
            mChildAction = (TextView) itemView.findViewById(R.id.child_action_tv);
            mRoomNumber = (TextView) itemView.findViewById(R.id.room_number_tv);
            mActivityDate = (TextView) itemView.findViewById(R.id.activity_date_tv);
            mChildImage = (CircleImageView) itemView.findViewById(R.id.child_image);
            mFeedImage = (ImageView) itemView.findViewById(R.id.feed_image);
            mRowContainer = itemView;
        }

        public TextView getChildAction() {
            return mChildAction;
        }

        public void setChildAction(TextView childAction) {
            mChildAction = childAction;
        }

        public TextView getRoomNumber() {
            return mRoomNumber;
        }

        public void setRoomNumber(TextView roomNumber) {
            mRoomNumber = roomNumber;
        }

        public TextView getActivityDate() {
            return mActivityDate;
        }

        public void setActivityDate(TextView activityDate) {
            mActivityDate = activityDate;
        }

        public CircleImageView getChildImage() {
            return mChildImage;
        }

        public void setChildImage(CircleImageView childImage) {
            mChildImage = childImage;
        }

        public ImageView getFeedImage() {
            return mFeedImage;
        }

        public void setFeedImage(ImageView feedImage) {
            mFeedImage = feedImage;
        }

        public View getRowContainer() {
            return mRowContainer;
        }

        public void setRowContainer(View rowContainer) {
            mRowContainer = rowContainer;
        }
    }
}
