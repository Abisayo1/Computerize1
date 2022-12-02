package com.abisayo.eNursing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import com.abisayo.eNursing.databinding.ActivityResultBinding

class Result : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    var handler: Handler? = null
    private lateinit var progressText : TextView
    var i = 0
    var j = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        supportActionBar?.hide(); // hide the title bar
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )


        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goHome.setOnClickListener {
            val intent = Intent(this, TopicsActivity::class.java)
            startActivity(intent)
            finish()
        }

        val  totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        val topic = intent.getStringExtra(Constants.TOPIC,)

        binding.tryAgain.setOnClickListener {
                if (
                    topic == "Algorithms"
                ){
                    val intent = Intent(this, AlgoQuizActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    val intent = Intent(this, Quiz::class.java)
                    startActivity(intent)
                    finish()
                }
        }

        if (correctAnswers <=4 ) {
            binding.motiv.text = "Ouch! It seems you need to study this topic one more time."
        } else if (correctAnswers == 5) {
            binding.motiv.text = "An average performance. You can do better!"
        } else if (correctAnswers == 10) {
            binding.motiv.text = "Great job computer expert!"
        } else {
            binding.motiv.text = "Nice! You can do better!"
        }

        i = correctAnswers
        j = totalQuestions
        binding.progressBar.max = totalQuestions

        handler = Handler(Handler.Callback {
            binding.progressBar.progress = i
            binding.progressText.text = "${i}/${binding.progressBar.max}"
            handler?.sendEmptyMessageDelayed(0, 100)

            true
        })

        handler?.sendEmptyMessage(0)
}
}