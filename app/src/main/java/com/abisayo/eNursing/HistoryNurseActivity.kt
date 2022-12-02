package com.abisayo.eNursing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abisayo.eNursing.databinding.ActivityHistoryOfNursingSubTopicsBinding

class HistoryNurseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHistoryOfNursingSubTopicsBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var topicList: ArrayList<Topic>
    private lateinit var topicAdapter: SubTopicsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        supportActionBar?.hide(); // hide the title bar
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        binding = ActivityHistoryOfNursingSubTopicsBinding.inflate(layoutInflater)
        setContentView(binding.root)


    recyclerView = binding.recycler
    recyclerView.layoutManager = LinearLayoutManager(this)

    topicList = ArrayList()

    topicList.add(Topic(0, "History of Nursing", "Introduction" ))
    topicList.add(Topic(0, "History of Nursing", "Religion" ))
    topicList.add(Topic(0, "History of Nursing", "War" ))
    topicList.add(Topic(0, "History of Nursing", "Societal Attitudes" ))
    topicList.add(Topic(0, "History of Nursing", "Nursing Leaders" ))
    topicList.add(Topic(0, "History of Nursing", "Men in Nursing" ))
    topicList.add(Topic(0, "History of Nursing", "Videos to Watch" ))



        topicAdapter = SubTopicsAdapter(topicList)
    recyclerView.adapter = topicAdapter


    topicAdapter.setOnItemClickListener(object : SubTopicsAdapter.onItemClickListener{
        override fun onItemClick(position: Int) {
            if (position == 0) {
                val intent = Intent(this@HistoryNurseActivity, Learn::class.java)
                startActivity(intent)

            }

            if (position == 1) {
                val intent = Intent(this@HistoryNurseActivity, ReligionActivity::class.java)
                startActivity(intent)

            }
            if (position == 2) {
                val intent = Intent(this@HistoryNurseActivity, WarActivity::class.java)
                startActivity(intent)

            }
//            if (position == 3) {
//                val intent = Intent(this@HistoryNurseActivity, FlowchartAdvantagtesActivity::class.java)
//                startActivity(intent)
//
//            }
//            if (position == 4) {
//                val intent = Intent(this@HistoryNurseActivity, FlowchartDisadvantagesActivity::class.java)
//                startActivity(intent)
//
//            }
//            if (position == 5) {
//                val intent = Intent(this@HistoryNurseActivity, FlowchartExamplesActivity::class.java)
//                startActivity(intent)
//
//            }
        }

    })


}
}