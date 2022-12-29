package com.padc.ponnya.wechat.activities


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.padc.ponnya.wechat.R
import com.padc.ponnya.wechat.databinding.ActivityHomeBinding
import com.padc.ponnya.wechat.fragments.ChatFragment
import com.padc.ponnya.wechat.fragments.ContactsFragment
import com.padc.ponnya.wechat.fragments.MeFragment
import com.padc.ponnya.wechat.fragments.MomentFragment
import com.padc.ponnya.wechat.utils.TITLE_CHAT
import com.padc.ponnya.wechat.utils.TITLE_CONTACTS
import com.padc.ponnya.wechat.utils.TITLE_ME
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
        setUpFragment()
        setUpBottomAppBarListener()
        println("onCreate")

    }

    private fun setUpActionBar() {
        with(binding.toolbar) {
            title = TITLE_MOMENT
            setTitleTextColor(getColor(R.color.colorSecondary))
            mMenu = menu
            menuInflater.inflate(R.menu.home_action_bar_menu, menu)
        }

    }

    private fun setUpFragment() {
        supportFragmentManager.commit {
            add<MomentFragment>(R.id.fragmentContainer)
        }
    }

    private fun setUpBottomAppBarListener() {
        binding.bottomAppBar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menuItemMoment -> {
                    binding.toolbar.title = TITLE_MOMENT
                    setUpMenuVisibility(addVisible = true)
                    supportFragmentManager.commit {
                        replace<MomentFragment>(R.id.fragmentContainer)
                    }
                    true
                }
                R.id.menuItemChat -> {
                    binding.toolbar.title = TITLE_CHAT
                    setUpMenuVisibility(searchVisible = true)
                    supportFragmentManager.commit {
                        replace<ChatFragment>(R.id.fragmentContainer)
                    }
                    true
                }
                R.id.menuItemContact -> {
                    binding.toolbar.title = TITLE_CONTACTS
                    supportFragmentManager.commit {
                        replace<ContactsFragment>(R.id.fragmentContainer)
                    }
                    setUpMenuVisibility(contactsAddVisible = true)
                    true
                }
                R.id.menuItemMe -> {
                    binding.toolbar.title = TITLE_ME
                    setUpMenuVisibility(editVisible = true)
                    supportFragmentManager.commit {
                        replace<MeFragment>(R.id.fragmentContainer)
                    }
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    private fun setUpMenuVisibility(
        addVisible: Boolean = false,
        searchVisible: Boolean = false,
        contactsAddVisible: Boolean = false,
        editVisible: Boolean = false,
    ) {
        with(mMenu) {
            findItem(R.id.menuItemAdd).isVisible = addVisible
            findItem(R.id.menuItemSearch).isVisible = searchVisible
            findItem(R.id.menuItemContactAdd).isVisible = contactsAddVisible
            findItem(R.id.menuItemEdit).isVisible = editVisible
        }
    }


}