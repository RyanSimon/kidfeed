# KidFeed
Sample Android app that shows up to date activity about your child at a daycare or school.

Lollipop version             |  KitKat version
:-------------------------:|:-------------------------:
![](https://raw.githubusercontent.com/ryan-simon/kidfeed/master/screenshots/KidFeed_Lollipop.png)  |  ![](https://raw.githubusercontent.com/ryan-simon/kidfeed/master/screenshots/KidFeed_KitKat.png)

# Design
The goal with the design is to take advantage of some of the great new AppCompat libraries, while keeping the overall aesthetic clean, simple, and attractive (besides the poop...).

# Libraries and Techniques Used
In my attempt to keep things as simple as possible, I mostly used Android support libraries to design the UI.

#### CardView [[link]](https://developer.android.com/reference/android/support/v7/widget/CardView.html)
The type of data being presented in KidFeed lends itself well to the CardView. The margins give a good degree of separation to each item, and fits in with the modern Material Design guidelines set forth by Google.

#### RecyclerView [[link]](https://developer.android.com/reference/android/support/v7/widget/RecyclerView.html)
Those familiar with the ViewHolder pattern and its use with ListViews can rejoice in the beautiful flexibility that is RecyclerView. KidFeed's Activity screen uses this to keep scrolling between items smooth, and lag free.

RecyclerView incorporates its own version of the ViewHolder pattern to maintain the performance gains, yet allows for much more flexibility. 

For example, this flexibility is especially useful in handeling click events on different Views within an individual row.

#### Toolbar [[link]](http://developer.android.com/reference/android/widget/Toolbar.html)
As Android's replacement for the ActionBar, the Toolbar's greatest strength is its ability to be injected straight into a layout. This allows for an incredible amount of design flexibility.

KidFeed's Toolbar is a very basic example of the Toolbar. I used it to solve a very bothersome issue where the default Toolbar title text would shrink in size when the phone is in landscape mode.

#### CircleImageView [[link]](https://github.com/hdodenhof/CircleImageView)
Great little library that handles the rather common task of taking a Bitmap, and creating a circle out of it. KidFeed's status images take advantage of this very useful tool.