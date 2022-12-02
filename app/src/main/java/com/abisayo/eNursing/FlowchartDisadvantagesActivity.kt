package com.abisayo.eNursing

import android.content.Intent
import android.graphics.Point
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.ScrollView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.abisayo.eNursing.databinding.ActivityFlowchartDisadvantagesBinding
import com.google.android.material.navigation.NavigationView


class FlowchartDisadvantagesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFlowchartDisadvantagesBinding
    lateinit private var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        binding = ActivityFlowchartDisadvantagesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val intent = Intent(this, FlowchartExamplesActivity::class.java)
            startActivity(intent)
        }

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.nav_home ->  {intent = Intent(this, TopicsActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                R.id.profile ->  {intent = Intent(this, Profile::class.java)
                    startActivity(intent)
                }

                R.id.flow -> {intent = Intent(this, Learn::class.java)
                    startActivity(intent)
                }
                R.id.element -> {intent = Intent(this, ReligionActivity::class.java)
                    startActivity(intent)
                }
                R.id.rules -> {intent = Intent(this, WarActivity::class.java)
                    startActivity(intent)
                }
                R.id.adv -> {intent = Intent(this, FlowchartAdvantagtesActivity::class.java)
                    startActivity(intent)
                }
                R.id.dis -> scrollToView(binding.scroll, binding.dis)

                R.id.quiz ->  {intent = Intent(this, Quiz::class.java)
                    startActivity(intent)

                }

                R.id.flow_example ->  {intent = Intent(this, FlowchartExamplesActivity::class.java)
                    startActivity(intent)

                }


            }
            true
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        if (item.itemId == R.id.action_item_one) {
            val intent = Intent(this, TopicsActivity::class.java)
            startActivity(intent)
            finish()
        }
        return super.onOptionsItemSelected(item)


    }

    private fun scrollToView(scrollViewParent: ScrollView, view: View) {
        // Get deepChild Offset
        val childOffset = Point()
        getDeepChildOffset(scrollViewParent, view.parent, view, childOffset)
        // Scroll to child.
        scrollViewParent.smoothScrollTo(0, childOffset.y)

        binding.drawerLayout.closeDrawers()
    }
    private fun getDeepChildOffset(
        mainParent: ViewGroup,
        parent: ViewParent,
        child: View,
        accumulatedOffset: Point
    ) {
        val parentGroup = parent as ViewGroup
        accumulatedOffset.x += child.left
        accumulatedOffset.y += child.top
        if (parentGroup == mainParent) {
            return
        }
        getDeepChildOffset(mainParent, parentGroup.parent, parentGroup, accumulatedOffset)
    }
}
