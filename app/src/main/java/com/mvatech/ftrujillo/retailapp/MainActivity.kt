package com.mvatech.ftrujillo.retailapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import com.mvatech.ftrujillo.retailapp.databinding.ActivityMainBinding
import androidx.drawerlayout.widget.DrawerLayout
import com.mvatech.ftrujillo.retailapp.core.toast
import com.mvatech.ftrujillo.retailapp.features.shop.ui.ShoppingFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var binds: ActivityMainBinding
    private lateinit var drawer:DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binds = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setUpToolbar()
        setUpDrawer()
        setUpStartFragment(savedInstanceState)
        setUpListeners()
    }

    private fun setUpToolbar() {
        setSupportActionBar(binds.mainToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        val shopByList = listOf("Shop Mens", "Shop Womens", "Shop Boy", "Shop Girls")
        val spinnerAdapter = ArrayAdapter(this, R.layout.spinner_item, shopByList)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        shoppingForSpinner.adapter = spinnerAdapter

    }

    private fun setUpStartFragment(savedInstanceState: Bundle?) {
        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction().
                replace(R.id.fragmentContainer, ShoppingFragment()).commit()
            mainNavView.setCheckedItem(R.id.shoppingDrawer)
        }
    }

    private fun setUpListeners() {
        binds.mainNavView.setNavigationItemSelectedListener(this::onNavItemSelected)
    }

    private fun setUpDrawer(){
        drawer = binds.mainNavigationDrawer
        val toggle = ActionBarDrawerToggle(
            this, drawer, binds.mainToolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()
    }

    private fun onNavItemSelected(menuItem: MenuItem):Boolean{
        when(menuItem.itemId){
            R.id.shoppingDrawer -> supportFragmentManager.beginTransaction().
                replace(R.id.fragmentContainer, ShoppingFragment()).commit()
            R.id.myAccountDrawer -> "My account".toast(this)
            R.id.mySavesDrawer -> "My Saves".toast(this)
            R.id.scanToShop -> "Scan to shop".toast(this)
            R.id.inboxDrawer -> "Inbox".toast(this)
        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if(binds.mainNavigationDrawer.isDrawerOpen(GravityCompat.START)){
            binds.mainNavigationDrawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_activity_top_menu, menu)
        return true
    }

}