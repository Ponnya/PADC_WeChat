package com.padc.ponnya.wechat.activities


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import com.padc.ponnya.wechat.R
import com.padc.ponnya.wechat.databinding.ActivityHomeBinding
import com.padc.ponnya.wechat.utils.TITLE_MOMENT


class HomeActivity : BaseAbstractActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var mMenu: Menu

    companion object {
        fun newIntent(context: Context) = Intent(context, HomeActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpActionBar()


    }

    private fun setUpActionBar() {
        setSupportActionBar(findViewById(R.id.toolbar))
        with(binding.toolbar) {
            title = TITLE_MOMENT
            setTitleTextColor(getColor(R.color.colorSecondary))
        }

    }

    private fun setUpMenuVisibility(
        searchVisibility: Boolean = false,
        addVisibility: Boolean = false
    ) {
        with(mMenu) {
            findItem(R.id.menuItemSearch).isVisible = searchVisibility
            findItem(R.id.menuItemAdd).isVisible = addVisibility
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        if (menu != null) {
            mMenu = menu
        }
        menuInflater.inflate(R.menu.home_action_bar_menu, menu)
        setUpMenuVisibility(searchVisibility = true)
        return true
    }

}