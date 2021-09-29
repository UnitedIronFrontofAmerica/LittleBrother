package com.example.littlebrother_copwatch

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.ActivityNavigator
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.littlebrother_copwatch.ui.dossier.DossierFragment
import com.example.littlebrother_copwatch.ui.home.HomeFragment
import com.example.littlebrother_copwatch.ui.map.MapFragment
import com.example.littlebrother_copwatch.ui.report.ReportFragment
import com.example.littlebrother_copwatch.ui.scanner.ScannerFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val homeFragment = HomeFragment()
    private val mapFragment = MapFragment()
    private val reportFragment = ReportFragment()
    private val scannerFragment = ScannerFragment()
    private val dossierFragment = DossierFragment()

    // private val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)

    private var myImageButton: ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        myImageButton = findViewById(R.id.imageMenuButton)

        // TODO: MENU IMAGE BUTTON START
        
        // TODO: MENU IMAGE BUTTON END

        // TODO: BOTTOM NAVIGATION VIEW START
        supportActionBar?.hide()

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController: NavController = navHostFragment.navController
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_map, R.id.navigation_report, R.id.navigation_scanner, R.id.navigation_dossier))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        // TODO: BOTTOM NAVIGATION VIEW END

        // sets main activity to show home fragment automatically
        replaceFragment(homeFragment)

        // sets fragments to bottom navigation
        navView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home_btn -> replaceFragment(homeFragment)
                R.id.nav_map_btn -> replaceFragment(mapFragment)
                R.id.nav_report_btn -> replaceFragment(reportFragment)
                R.id.nav_scanner_btn -> replaceFragment(scannerFragment)
                R.id.nav_dossier_btn -> replaceFragment(dossierFragment)
            }
            true
        }

    }

    // sets function for changing fragments between action bar and bottom navigation
    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.nav_host_fragment, fragment)
        transaction.commit()
    }

    override fun finish() {
        super.finish()
        ActivityNavigator.applyPopAnimationsToPendingTransition(this)
    }

}


