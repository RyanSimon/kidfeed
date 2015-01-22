package me.ryansimon.kidfeed;

import android.support.v4.util.Pair;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FeedActivity extends ActionBarActivity {

    // mock content
    List<Pair<String,Integer>> mChildNameImagePairs;
    List<FeedItem> mFeedItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        setupContentList();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_feed, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

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

        FeedItem feedItem3 = new FeedItem(mChildNameImagePairs.get(2).first,"finished homework",
                "1/22/2015, 9:09 AM",1,mChildNameImagePairs.get(2).second,null);

        FeedItem feedItem4 = new FeedItem(mChildNameImagePairs.get(2).first,"ate lunch",
                "1/22/2015, 12:11 PM",1,mChildNameImagePairs.get(2).second,null);

        mFeedItems = Arrays.asList(
                feedItem4,
                feedItem3,
                feedItem2,
                feedItem1
        );
    }

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
