package me.ryansimon.kidfeed;

/**
 * @author Ryan Simon
 */
public class FeedItem {

    private String mChildName;
    private String mActivity;
    private String mTimeStamp;
    private Integer mRoomNumber;
    private Integer mChildImage; // this is in lieu of an image url from a server
    private Integer mContentImage; // this is in lieu of an image url from a server

    public FeedItem(String childName, String activity, String timeStamp, Integer roomNumber,
                    Integer childImage, Integer contentImage) {
        mChildName = childName;
        mActivity = activity;
        mTimeStamp = timeStamp;
        mRoomNumber = roomNumber;
        mChildImage = childImage;
        mContentImage = contentImage;
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

    public Integer getContentImage() {
        return mContentImage;
    }

    public void setContentImage(int contentImage) {
        mContentImage = contentImage;
    }

    public Integer getRoomNumber() {
        return mRoomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        mRoomNumber = roomNumber;
    }

    public Integer getChildImage() {
        return mChildImage;
    }

    public void setChildImage(Integer childImage) {
        mChildImage = childImage;
    }
}
