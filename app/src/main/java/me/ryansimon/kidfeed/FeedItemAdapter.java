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

    private List<FeedItem> mFeedItems;
    private static final int FIRST_AND_LAST_CARD_MARGIN = 4;

    public FeedItemAdapter(List<FeedItem> feedItems) {
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

        // set our Views
        FeedItem feedItem = mFeedItems.get(position);
        holder.getChildAction().setText(feedItem.getChildName() + " " + feedItem.getActivity());
        holder.getChildImage().setImageResource(feedItem.getChildImage());
        holder.getActivityDate().setText(feedItem.getTimeStamp());
        holder.getRoomNumber().setText("Room " + feedItem.getRoomNumber());

        // show content image if there's one available...
        if(feedItem.getContentImage() != null) {
            holder.getContentImage().setVisibility(View.VISIBLE);
            holder.getContentImage().setImageResource(feedItem.getContentImage());
        }
        // otherwise, hide the ImageView
        else {
            holder.getContentImage().setVisibility(View.GONE);
        }

        View rowContainer = holder.getRowContainer();
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) rowContainer.getLayoutParams();

        // add a top margin to the first item
        if(position == 0) {
            layoutParams.setMargins(layoutParams.leftMargin,
                    Helper.dpToPixels(FIRST_AND_LAST_CARD_MARGIN,rowContainer.getContext()),
                    layoutParams.rightMargin, 0);
        }
        // add a bottom margin to the last item
        else if(position == mFeedItems.size() - 1) {
            layoutParams.setMargins(layoutParams.leftMargin, 0,
                    layoutParams.rightMargin, Helper.dpToPixels(FIRST_AND_LAST_CARD_MARGIN,rowContainer.getContext()));
        }
        // normal margins should be applied
        else {
            layoutParams.setMargins(layoutParams.leftMargin, 0,
                    layoutParams.rightMargin, 0);
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
        private ImageView mContentImage;
        private View mRowContainer;

        public FeedItemViewHolder(View itemView) {
            super(itemView);

            // get all the layout vars
            mChildAction = (TextView) itemView.findViewById(R.id.child_action_tv);
            mRoomNumber = (TextView) itemView.findViewById(R.id.room_number_tv);
            mActivityDate = (TextView) itemView.findViewById(R.id.activity_date_tv);
            mChildImage = (CircleImageView) itemView.findViewById(R.id.child_image);
            mContentImage = (ImageView) itemView.findViewById(R.id.feed_image);
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

        public ImageView getContentImage() {
            return mContentImage;
        }

        public void setContentImage(ImageView contentImage) {
            mContentImage = contentImage;
        }

        public View getRowContainer() {
            return mRowContainer;
        }

        public void setRowContainer(View rowContainer) {
            mRowContainer = rowContainer;
        }
    }
}
