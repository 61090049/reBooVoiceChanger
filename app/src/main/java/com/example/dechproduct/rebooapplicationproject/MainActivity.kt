package com.example.dechproduct.rebooapplicationproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.dechproduct.rebooapplicationproject.databinding.ActivityMainBinding

/* README.dech
//Flow of this app
            x1) create Navigation (res - Front)
->          x2) add-edit XML (res - Front)
->          v/3)implement Fragment that you choose for show ui (Front + Back)              -> Note that! we use view binding + Navigation Component! please read document - how to use it
 optional        3.5) network and model class (if want to use data from api - Back)        -> I know you can do it
            v/4) Model class which store data class (don't write getter-setter - Back)     -> I know you can do it (if must use parcelable don't forget to do with this file)
->          v/5) implement ViewModel which use for handle logic (Back)                     -> Important! BACK-END  Note that! we use all business logic in this file , you must spend a lot of time to handle with this thing
 optional        !! Database will use with room and repository so, in this time i will not do it ja -> if must used please create
*/


//Let's Start
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mNavController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpNavBottom()                                                    //เอาไว้ set ตัวล่างเฉยๆ เสร็จละ ไม่ต้องไปปรับครัช

    }

    private fun setUpNavBottom() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentHost) as NavHostFragment

        mNavController = navHostFragment.navController

        binding.bottomNav.setupWithNavController(
                mNavController
        )

        val appConfigBar = AppBarConfiguration(setOf(R.id.openAudioFragment))
        setupActionBarWithNavController(mNavController, appConfigBar)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(mNavController, null)
    }


}