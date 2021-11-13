package com.example.basquetball

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ScoreActivity : AppCompatActivity(){

    companion object{
        const val LOCAL_SCORE_KEY = "local"
        const val VISITANTE_SCORE_KEY = "visitante"
    }
    private lateinit var score_text : TextView
    private lateinit var who_won_text : TextView
    var texto2 =""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

    score_text = findViewById(R.id.score_text)

    val localScore = intent.extras!!.getInt(LOCAL_SCORE_KEY)
        val visitanteScore = intent.extras!!.getInt(VISITANTE_SCORE_KEY)
        val texto = "$localScore - $visitanteScore"

        score_text.text = texto

        if (localScore>visitanteScore){
            texto2 = "Locales Ganaron"
        }else if (localScore<visitanteScore){
            texto2 = "Visitantes Ganaron"
        }else{
            texto2 = "Empate :("
        }
        who_won_text.text = texto2
    }
}