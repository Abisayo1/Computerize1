package com.abisayo.computerize1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abisayo.computerize1.Constants.EXTRA_CLOSE_APP
import com.abisayo.computerize1.admission.AdmissionSubTopicActivity
import com.abisayo.computerize1.databinding.ActivityTopics1Binding
import com.abisayo.computerize1.historyOfNursing.HistorySubTopicActivity
import com.abisayo.computerize1.roles.RolesSubTopicActivity
import com.abisayo.computerize1.trendsInNursing.TrendsSubTopicActivity
import kotlin.system.exitProcess


class TopicsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTopics1Binding
    private lateinit var recyclerView: RecyclerView
    private lateinit var topicList: ArrayList<Topic>
    private lateinit var topicAdapter: TopicAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        supportActionBar?.hide(); // hide the title bar
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        binding = ActivityTopics1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView3.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }

        recyclerView = findViewById(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(this)

        topicList = ArrayList()

//        topicList.add(Topic(0, "FlowChart", "" ))
        topicList.add(Topic(0, "History of Nursing", ""))
        topicList.add(Topic(0, "Trends in Nursing", ""))
        topicList.add(Topic(0, "Professional Standards in Nursing Practice", ""))
        topicList.add(Topic(0, "Roles and Functions of a Nurse", ""))
        topicList.add(Topic(0, "Health Assessment", ""))
        topicList.add(Topic(0, "Admission process", ""))



        topicAdapter = TopicAdapter(topicList)
        recyclerView.adapter = topicAdapter



        this
            .onBackPressedDispatcher
            .addCallback(this,
                object : OnBackPressedCallback(true) {
                    override fun handleOnBackPressed() {
                        Intent(this@TopicsActivity, MainActivity::class.java).also { intent ->
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                intent.putExtra(EXTRA_CLOSE_APP, true)
                            startActivity(intent)
                            finish()
                        }
                    }
                }
            )

        topicAdapter.setOnItemClickListener(object : TopicAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {

                when (position) {
//                    0 -> {
//                        val intent = Intent(this@TopicsActivity, FlowSubTopicsActivity::class.java)
//                        startActivity(intent)
//                    }
                    0 -> {
                        val intent =
                            Intent(this@TopicsActivity, HistorySubTopicActivity::class.java)
                        startActivity(intent)

                    }
                    1 -> {
                        val intent = Intent(this@TopicsActivity, TrendsSubTopicActivity::class.java)
                        startActivity(intent)

                    }
                    2 -> {
                        startActivity(Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.youtube.com/watch?v=xu0pGgQWPYc")));

                    }
                    3 -> {
                        val intent = Intent(this@TopicsActivity, RolesSubTopicActivity::class.java)
                        startActivity(intent)

                    }
                    4 -> {
//                        val intent = Intent(this@TopicsActivity, ::class.java)
//                        startActivity(intent)

                    }
                    5 -> {
                        val intent = Intent(this@TopicsActivity, AdmissionSubTopicActivity::class.java)
                        startActivity(intent)

                    }
                }
            }

        })


    }
}