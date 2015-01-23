package me.ryansimon.kidfeed;

import android.os.Handler;
import android.support.v4.util.Pair;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.Arrays;
import java.util.List;

/**
 * @author Ryan Simon
 *
 * Main activity of the app. Displays a list of {@link me.ryansimon.kidfeed.FeedItem}'s.
 *
 * This Activity uses some of the new appcompat libraries in Lollipop:
 * {@link android.support.v7.widget.CardView}, {@link android.support.v7.widget.RecyclerView},
 * and {@link android.support.v7.widget.Toolbar}
 */
public class FeedActivity extends ActionBarActivity {

    /**
     * Layout vars
     */
    SwipeRefreshLayout mSwipeRefreshLayout;

    // mock content
    List<Pair<String,Integer>> mChildNameImagePairs;
    List<FeedItem> mFeedItems;

    /***** ACTIVITY LIFECYCLE METHODS *****/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        setupToolbar();
        setupSwipeToRefresh();
        setupContentList();
    }

    /***** HELPER METHODS *****/

    /**
     * Creates a few mock items in place of actual server content
     */
    private void createMockContent() {
        mChildNameImagePairs = Arrays.asList(
                new Pair<String, Integer>("Johnny",R.drawable.child1),
                new Pair<String, Integer>("Sofia",R.drawable.child2),
                new Pair<String, Integer>("Tiffany",R.drawable.child3),
                new Pair<String, Integer>("Beth",R.drawable.child4),
                new Pair<String, Integer>("Ben",R.drawable.child5)
        );

        FeedItem feedItem1 = new FeedItem(mChildNameImagePairs.get(0).first,"threw poop at teacher",
                "1/21/2015, 8:32 AM",1,mChildNameImagePairs.get(0).second,null);

        FeedItem feedItem2 = new FeedItem(mChildNameImagePairs.get(1).first,"did great on quiz",
                "1/21/2015, 11:32 AM",1,mChildNameImagePairs.get(1).second,mChildNameImagePairs.get(1).second);

        FeedItem feedItem3 = new FeedItem(mChildNameImagePairs.get(2).first,"started homework",
                "1/22/2015, 9:09 AM",2,mChildNameImagePairs.get(2).second,null);

        FeedItem feedItem4 = new FeedItem(mChildNameImagePairs.get(2).first,"finished homework",
                "1/22/2015, 12:11 PM",2,mChildNameImagePairs.get(2).second,null);

        FeedItem feedItem5 = new FeedItem(mChildNameImagePairs.get(3).first,"played on the swing",
                "1/23/2015, 1:23 PM",1,mChildNameImagePairs.get(3).second,null);

        FeedItem feedItem6 = new FeedItem(mChildNameImagePairs.get(4).first,"is in time out",
                "1/23/2015, 3:45 PM",3,mChildNameImagePairs.get(4).second,null);

        FeedItem feedItem7 = new FeedItem(mChildNameImagePairs.get(0).first,"was in a photo",
                "1/24/2015, 10:03 AM",1,mChildNameImagePairs.get(0).second,R.drawable.johnny_poop);

        mFeedItems = Arrays.asList(
                feedItem7,
                feedItem6,
                feedItem5,
                feedItem4,
                feedItem3,
                feedItem2,
                feedItem1
        );
    }

    /**
     * Sets up Toolbar and the title of the Activity
     */
    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getString(R.string.title_activity_feed));
    }

    /**
     * Sets up swipe to refresh with an artificial delay for demo purposes
     */
    private void setupSwipeToRefresh() {
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // faking a server refresh
                new Handler().postDelayed(new Runnable() {
                    @Override public void run() {
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                }, 4000);
            }
        });
    }

    /**
     * Sets up the content list
     */
    private void setupContentList() {
        // do this first, so we have items to give our RecyclerView
        createMockContent();

        // setup our RecyclerView
        RecyclerView recList = (RecyclerView) findViewById(R.id.feed_list);
        recList.setAdapter(new FeedItemAdapter(mFeedItems));
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);
    }
}
