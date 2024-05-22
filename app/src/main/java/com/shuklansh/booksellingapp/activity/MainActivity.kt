//package com.shuklansh.booksellingapp.activity
//
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.view.MenuItem
//import android.widget.FrameLayout
//import androidx.appcompat.app.ActionBarDrawerToggle
//import androidx.coordinatorlayout.widget.CoordinatorLayout
//import androidx.core.view.GravityCompat
//import androidx.drawerlayout.widget.DrawerLayout
//import com.google.android.material.appbar.MaterialToolbar
//import com.google.android.material.navigation.NavigationView
//import com.shuklansh.booksellingapp.R
//import com.shuklansh.booksellingapp.fragments.AboutFragment
//import com.shuklansh.booksellingapp.fragments.DashboardFragment
//import com.shuklansh.booksellingapp.fragments.ProfileFragment
//import com.shuklansh.booksellingapp.fragments.FavouritesFragment
//
//class MainActivity : AppCompatActivity(), PaymentResultListener {
//
//    lateinit var drawerLayout: //the whole activity is inside drawer layout to allow the navigation drawer slide in/out functionality in the main activity layout
//    lateinit var frameLayout: FrameLayout //to navigate to different screens from the navigation drawer
//    lateinit var toolbar: MaterialToolbar //will be used as actionbar as it is more customisable. it is inside the material appbar layout (appbar layout is a vertical linear layout)
//    lateinit var coordinatorLayout: CoordinatorLayout //to keep the navigation drawer and menu working together
//    lateinit var navigationView: NavigationView //the nav drawer itself, contains the header and the menu items in it.
//    var nightmodestatus: Int = 0 //to allow changing dark theme or light theme from navigation drawer
//    var prevMenuItem: MenuItem?=null //variable to store the previousMenuItem which will be unchecked when new item selected
//
//
//
//
//
//
//       lateinit var txtPaymentStatus: TextView
//
//       lateinit var editAmount: EditText
//
//       lateinit var btnPayNow: Button
//
//
//
//        override fun onCreate(savedInstanceState: Bundle?) {
//
//            super.onCreate(savedInstanceState)
//
//            setContentView(R.layout.activity_main)
//
//            txtPaymentStatus = findViewById(R.id.paymentStatus)
//
//            editAmount = findViewById(R.id.edit_amount)
//
//            btnPayNow = findViewById(R.id.btn_pay)
//
//
//
//            btnPayNow.setOnClickListener {
//
//                savePayments(editAmount.text.toString().trim().toInt())
//
//            }
//
//
//
//            Checkout.preload(this@MainActivity)
//
//        }
//
//
//
//        private fun savePayments(amount: Int) {
//
//            val checkout = Checkout()
//
//            checkout.setKeyID("rzp_test_lyVg4EbhAATCjE")
//
//            try {
//
//                val options = JSONObject()
//
//                options.put("name", "Razorpay Demo")
//
//                options.put("description", "If You Like these Tutorials. Buy me a Coffee")
//
//                //options.put("image","")
//
//                options.put("theme.color", "#3399cc")
//
//                options.put("currency", "INR")
//
//                options.put("amount", amount * 100)
//
//
//
//                val retryObj = JSONObject()
//
//                retryObj.put("enabled", true)
//
//                retryObj.put("max_count", 4)
//
//                options.put("retry", retryObj)
//
//
//
//                checkout.open(this@MainActivity, options)
//
//            } catch (e: Exception) {
//
//                Toast.makeText(this@MainActivity, "Error in Payment : " + e.message, Toast.LENGTH_LONG)
//
//                    .show()
//
//                e.printStackTrace()
//
//            }
//
//        }
//
//
//
//        override fun onPaymentSuccess(p0: String?) {
//
//            txtPaymentStatus.text = p0
//
//            txtPaymentStatus.setTextColor(Color.GREEN)
//
//        }
//
//
//
//        override fun onPaymentError(p0: Int, p1: String?) {
//
//            txtPaymentStatus.text = p1
//
//            txtPaymentStatus.setTextColor(Color.RED)
//
//        }
//
//    /}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        drawerLayout = findViewById(R.id.drawerlayout)
//        frameLayout = findViewById(R.id.framLayout) //used to open diff screens from navigation drawer
//        toolbar = findViewById(R.id.toolBarId)
//        coordinatorLayout = findViewById(R.id.coordinatorLayoutId)
//        navigationView = findViewById(R.id.navView)
//        setUpToolbar()
//        //hamburger icon functionality is stored in actionBarDrawerToggle constant. it is used to open/close navigation drawer
//
//        openDashboardFragment()
//
//        val actionDrawerToggle =
//            ActionBarDrawerToggle(//function to implement drawer slide in/out functionality
//                this@MainActivity,//to display the hamburger icon in the main activity
//                drawerLayout, //this layout allows the navigation drawer to slide in/out. actionBarDrawerToggle takes only drawerLayout as arg here.
//                R.string.opendrawer,
//                R.string.closedrawer
//            )
//        drawerLayout.addDrawerListener(actionDrawerToggle)//drawerListener is used to monitor the state and motion of drawer views.
//        actionDrawerToggle.syncState() //this will make home button icon (also called hamburger) point left or show hamburger based on if navdrawer is open/close
//        //to enable the working of clicking and action on elements of NAVIGATION DRAWER
//        navigationView.setNavigationItemSelectedListener {//this is for interacting and performing functions from items in the menu, which are stored in navigationview as menu
//            //it = currently selected menu item
//            if (prevMenuItem != null){
//                prevMenuItem?.isChecked=false } //if there is any menu item which was previously selected unhighlight it
//            it.isCheckable=true
//            it.isChecked=true //highlight currently selected menu item
//            prevMenuItem=it //after the currently selected menu item is highlighted, the value is stored in prev menu item so that when new item is selected, the if block runs again and unhighlights the previously selecte menu item
//
//            //In Kotlin, when replaces the switch operator of other languages like Java.
//            when (it.itemId) { //it will give us currently selected item.
//
//                // following are the ids of all the menu options in the menu layout.
//                // These will be made functional by creating a fragment for these options.
//                // the diff fragments will be shown when menu items will be clicked
//
//
//                R.id.dashboard -> {
//                    //Toast.makeText(this@MainActivity,"Opening dashboard..",Toast.LENGTH_SHORT).show() //to display dashboard press
////                    supportFragmentManager.beginTransaction().replace(
////                        R.id.framLayout,DashboardFragment())
////                        .addToBackStack("Dashboard")
////                        //adds dashboard to backstack when dashboard selected,
////                        // so when back is pressed, we can use backstack to go to last fragment
////                        .commit()//dashboardfragment replacing the framelayout
//                    //now once fragment is open, we should close the navBar (slide in the screen). so we do drawerLayout.closeDrawers()
//                    openDashboardFragment()
//                    supportActionBar?.title = ("Dashboard")
//                    navigationView.setCheckedItem(R.id.dashboard)
//                    drawerLayout.closeDrawers()
//
//                }
//                R.id.favourites -> {
//                    //Toast.makeText(this@MainActivity,"Opening favourites..",Toast.LENGTH_SHORT).show() //to display fav press
//                    supportFragmentManager.beginTransaction().replace(R.id.framLayout, FavouritesFragment())
//                        .addToBackStack("Favourites")
//                        .commit()
//                    supportActionBar?.title = ("Favourites")
//                    drawerLayout.closeDrawers()
//
//
//                }
//                R.id.profile -> {
//                    //Toast.makeText(this@MainActivity,"Opening profile..",Toast.LENGTH_SHORT).show() //to display profile press
//                    supportFragmentManager.beginTransaction().replace(
//                        R.id.framLayout, ProfileFragment()
//                    )
//                        .addToBackStack("Profile")
//                        .commit()
//                    supportActionBar?.title = ("Profile")
//                    drawerLayout.closeDrawers()
//
//
//                }
//                R.id.about -> {
//                    //Toast.makeText(this@MainActivity,"Opening about..",Toast.LENGTH_SHORT).show() //to display about press
//                    supportFragmentManager.beginTransaction().replace(
//                        R.id.framLayout, AboutFragment()
//                    )
//                        .addToBackStack("About")
//                        .commit()
//                    drawerLayout.closeDrawers()
//
//                    supportActionBar?.title = ("About")
//                }
////                R.id.themeSet -> { //dark mode enable/disable when themeset is pressed.
////
////                    nightmodestatus =
////                        AppCompatDelegate.getDefaultNightMode() //store default night mode status and store its value in nightmodestatus variable
////                    if (nightmodestatus == AppCompatDelegate.MODE_NIGHT_NO) { //if the default status is no then make it yes on press.
////                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
////                    } else { // if default status is yes then  make it no on press.
////                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
////                    }
////                }
////                R.id.checkConnMenu -> { //dark mode enable/disable when themeset is pressed.
////                    checkConn()
////                }
//            }
//
//
//
//
//            return@setNavigationItemSelectedListener true //since we are using lambda syntax
//        }
//    }
//
//    fun setUpToolbar() {
//        setSupportActionBar(toolbar)
//        supportActionBar?.title = "Toolbar Title"
//
//        //following 2 lines are for displaying and enabling back button which is called home button
//        supportActionBar?.setHomeButtonEnabled(true)//enables hamburger
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)//displays hamburger in the home button position. (in beginning on title bar to left of title)
//    }
//
//    fun openDashboardFragment(){
//        val dashbordFrag= DashboardFragment() //DashboardFragment() is the fragment file for the dashboard, being stored in the variable dashbordFrag.
//        val transaction= supportFragmentManager.beginTransaction()
//        transaction.replace(R.id.framLayout,dashbordFrag)
//        transaction.commit()
//        supportActionBar?.title="Dashboard"
//        navigationView.setCheckedItem(R.id.dashboard)
//    }
//
//    //to enable the working of clicking and action on elements of TOOLBAR
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {//this function is used to enable onClick functionality for elements on the toolbar
//        val id = item.itemId
//        if (id == android.R.id.home) {
//            drawerLayout.openDrawer(GravityCompat.START) //when home button pressed open navigation drawer.
//        }
//        return super.onOptionsItemSelected(item)
//    }
//
////        fun checkConn(){
////            if(ConnectionManager().checkConnectivity(this)){
////                //internet available
////                val dialog = AlertDialog.Builder(this)
////                dialog.setTitle("Success")
////                dialog.setMessage("Successfully connected to Internet")
////                dialog.setPositiveButton("Okay"){text,listener-> //do nothing
////                }
//////                dialog.setNegativeButton("Cancel"){text,listener-> //do nothing
//////                }
////                dialog.create()
////                dialog.show()
////            }
////            else{
////                //no internet
////                val dialog = AlertDialog.Builder(this)
////                dialog.setTitle("Conection Failed")
////                dialog.setMessage("Could not connect to Internet, Please check your connection and try again")
////                dialog.setPositiveButton("Retry"){text,listener-> //do nothing
////                    checkConn()
////                }
////                dialog.setNegativeButton("Cancel"){text,listener-> //do nothing
////                }
////                dialog.create()
////                dialog.show()
////            }
////        }
//
//    override fun onBackPressed() {
//        /*
//        This function is for directing user to dashboard fragment from any other fragment, when back btn is pressed.
//        If dashboard frag is open already, then back btn will behave in its default manner i.e. exit app.
//         */
//        val fragmentCurrent = supportFragmentManager.findFragmentById(R.id.framLayout) //fragmentCurrent variable will hold the fragment currently in the frameLayout
//        when(fragmentCurrent){ //fragmentcurrent is being used as arguement for when function (switch case)
//            !is DashboardFragment -> openDashboardFragment() //when current fragment is not dashboard fragment -> open dashboard fragment (function to open dashboard frag is called)
//            else->super.onBackPressed() //if the fragment currently in the framelayout is dashboard frag, then make the back btn behave in default manner i.e. exit app
//        }
//    }
package com.shuklansh.booksellingapp.activity

import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView
import com.razorpay.Checkout
import com.shuklansh.booksellingapp.R
import com.shuklansh.booksellingapp.fragments.AboutFragment
import com.shuklansh.booksellingapp.fragments.DashboardFragment
import com.shuklansh.booksellingapp.fragments.FavouritesFragment
import com.shuklansh.booksellingapp.fragments.ProfileFragment
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    lateinit var drawerLayout: DrawerLayout
    lateinit var frameLayout: FrameLayout
    lateinit var toolbar: MaterialToolbar
    lateinit var coordinatorLayout: CoordinatorLayout
    lateinit var navigationView: NavigationView
    var nightmodestatus: Int = 0
    var prevMenuItem: MenuItem? = null

    lateinit var txtPaymentStatus: TextView
    lateinit var editAmount: EditText
    lateinit var btnPayNow: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerlayout)
        frameLayout = findViewById(R.id.framLayout)
        toolbar = findViewById(R.id.toolBarId)
        coordinatorLayout = findViewById(R.id.coordinatorLayoutId)
        navigationView = findViewById(R.id.navView)

        setUpToolbar()
        openDashboardFragment()

        val actionDrawerToggle = ActionBarDrawerToggle(
            this@MainActivity,
            drawerLayout,
            R.string.opendrawer,
            R.string.closedrawer
        )
        drawerLayout.addDrawerListener(actionDrawerToggle)
        actionDrawerToggle.syncState()

        navigationView.setNavigationItemSelectedListener { menuItem ->
            if (prevMenuItem != null) {
                prevMenuItem?.isChecked = false
            }
            menuItem.isCheckable = true
            menuItem.isChecked = true
            prevMenuItem = menuItem

            when (menuItem.itemId) {
                R.id.dashboard -> {
                    openDashboardFragment()
                    supportActionBar?.title = "Dashboard"
                    drawerLayout.closeDrawers()
                }
                R.id.favourites -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.framLayout, FavouritesFragment())
                        .addToBackStack("Favourites")
                        .commit()
                    supportActionBar?.title = "Favourites"
                    drawerLayout.closeDrawers()
                }
                R.id.profile -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.framLayout, ProfileFragment())
                        .addToBackStack("Profile")
                        .commit()
                    supportActionBar?.title = "Profile"
                    drawerLayout.closeDrawers()
                }
                R.id.about -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.framLayout, AboutFragment())
                        .addToBackStack("About")
                        .commit()
                    drawerLayout.closeDrawers()
                    supportActionBar?.title = "About"
                }
            }
            true
        }


    }

    private fun setUpToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Toolbar Title"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun openDashboardFragment() {
        val dashboardFragment = DashboardFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.framLayout, dashboardFragment)
        transaction.commit()
        supportActionBar?.title = "Dashboard"
        navigationView.setCheckedItem(R.id.dashboard)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        val fragmentCurrent = supportFragmentManager.findFragmentById(R.id.framLayout)
        when (fragmentCurrent) {
            !is DashboardFragment -> openDashboardFragment()
            else -> super.onBackPressed()
        }
    }

    // Function to handle payment
    private fun handlePayment(amount: Int) {
        // Implement your payment logic here
        // For example, you can start a new activity for payment processing
        // Or integrate a payment gateway SDK/API to process payments
        // Function to handle payment
        // Initialize Razorpay checkout
        val checkout = Checkout()
        checkout.setKeyID("rzp_test_4sXZYJ5c5Jkcgd")

        try {
            // Set up payment options
            val options = JSONObject()
            options.put("amount", amount * 100) // Amount in paisa
            options.put("currency", "INR")
            options.put("receipt", "order_receipt")

            // Open Razorpay checkout activity with payment options
            checkout.open(this, options)

        } catch (e: Exception) {
            // Handle error if initialization or payment request fails
            Toast.makeText(this@MainActivity, "Error in Payment : " + e.message, Toast.LENGTH_LONG)
                .show()
            e.printStackTrace()
        }
    }

    // Payment success callback
    fun onPaymentSuccess(p0: String?) {
        // Handle payment success
        txtPaymentStatus.text = "Payment Successful"
        txtPaymentStatus.setTextColor(Color.GREEN)
    }

    // Payment error callback
    fun onPaymentError(p0: Int, p1: String?) {
        // Handle payment error
        txtPaymentStatus.text = "Payment Failed: $p1"
        txtPaymentStatus.setTextColor(Color.RED)
    }

}





