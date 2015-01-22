package me.ryansimon.kidfeed;

/**
 * @author Ryan Simon
 */
public class FeedItem {

    private String mChildName;
    private String mActivity;
    private String mTimeStamp;
    private int mImageId; // this is in lieu of an image url from a server

    public FeedItem(String childName, String activity, String timeStamp, int imageId) {
        mChildName = childName;
        mActivity = activity;
        mTimeStamp = timeStamp;
        mImageId = imageId;
    }

    public String getChildName() {
        return mChildName;
    }

    public void setChildName(String childName) {
        mChildName = childName;
    }

    public String getActivity() {
        return mActivity;
    }

    public void setActivity(String activity) {
        mActivity = activity;
    }

    public String getTimeStamp() {
        return mTimeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        mTimeStamp = timeStamp;
    }

    public int getImageId() {
        return mImageId;
    }

    public void setImageId(int imageId) {
        mImageId = imageId;
    }
}
