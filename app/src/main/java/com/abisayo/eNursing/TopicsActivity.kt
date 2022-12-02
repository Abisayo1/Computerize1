package com.abisayo.eNursing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abisayo.eNursing.databinding.ActivityTopics1Binding


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

        topicList.add(Topic(0, "History of Nursing", "" ))
        topicList.add(Topic(0, "Trends in Nursing", "" ))
        topicList.add(Topic(0, "Professional Standards in Nursing Practice", "" ))
        topicList.add(Topic(0, "Roles and Functions of a Nurse", "" ))
        topicList.add(Topic(0, "Health Assessment", "" ))
        topicList.add(Topic(0, "Admission Process", "" ))
        topicList.add(Topic(0, "Discharge Process", "" ))
        topicList.add(Topic(0, "Referral Process", "" ))
        topicList.add(Topic(0, "Transfer Process", "" ))
        topicList.add(Topic(0, "Communication SKills", "" ))



        topicAdapter = TopicAdapter(topicList)
        recyclerView.adapter = topicAdapter


        topicAdapter.setOnItemClickListener(object : TopicAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                if (position == 0) {
                    val intent = Intent(this@TopicsActivity, HistoryNurseActivity::class.java)
                    startActivity(intent)

                }

//                if (position == 1) {
//                    val intent = Intent(this@TopicsActivity, AlgorithmSubtopicsActivity::class.java)
//                    startActivity(intent)
//
//                }
            }

        })


    }
}