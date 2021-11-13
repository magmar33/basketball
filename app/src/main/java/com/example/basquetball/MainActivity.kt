package com.example.basquetball

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tvLocal : TextView
    private lateinit var tvVisitante : TextView

    private lateinit var btnRestar : Button
    private lateinit var btnSumar : Button
    private lateinit var btnSumarDoble : Button

    private lateinit var btnRestart : ImageButton

    private lateinit var btnRestarVisitante : Button
    private lateinit var btnSumarVisitante : Button
    private lateinit var btnSumarDobleVisitante : Button

    private lateinit var btnMarcador : ImageButton

    var local = 0
    var visitante = 0

    fun Restar(variable : Int){
        if(variable == local) {
            if(local == 0){
                local = 0
            }else {
                local -= 1
            }
        }else{
            if(visitante == 0){
            visitante = 0
        }else {
            visitante -= 1
        }
        }
    }
    fun Sumar(variable : Int) {
        if (variable == local) {
            local = local + 1
        } else if(variable == visitante){
            visitante = visitante + 1
        }
    }

    fun SumarDoble(variable : Int){
        if (variable == local) {
            local = local + 2
        } else {
            visitante = visitante + 2
        }
    }

    fun Restart(){
        local = 0
        visitante = 0
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvLocal = findViewById(R.id.tvLocal)
        tvVisitante = findViewById(R.id.tvVisitante)

        btnRestar = findViewById(R.id.btnRestar)
        btnRestar.setOnClickListener(this)

        btnSumar = findViewById(R.id.btnSumar)
        btnSumar.setOnClickListener(this)

        btnSumarDoble = findViewById(R.id.btnSumarDoble)
        btnSumarDoble.setOnClickListener(this)

        btnRestarVisitante = findViewById(R.id.btnRestarVisitante)
        btnRestarVisitante.setOnClickListener(this)

        btnSumarVisitante = findViewById(R.id.btnSumarVisitante)
        btnSumarVisitante.setOnClickListener(this)

        btnSumarDobleVisitante = findViewById(R.id.btnSumarDobleVisitante)
        btnSumarDobleVisitante.setOnClickListener(this)

        btnRestart = findViewById(R.id.btnRestart)
        btnRestart.setOnClickListener(this)

        btnMarcador = findViewById(R.id.btnMarcador)
        btnMarcador.setOnClickListener(this)

        tvLocal.text = local.toString()
        tvVisitante.text = visitante.toString()



    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.btnRestar -> {
                Restar(local)
                tvLocal.text = local.toString()
            }
            R.id.btnSumar -> {
                Sumar(local)
                tvLocal.text = local.toString()
            }
            R.id.btnSumarDoble -> {
                SumarDoble(local)
                tvLocal.text = local.toString()
            }
            R.id.btnRestart -> {
                Restart()
                tvLocal.text = local.toString()
                tvVisitante.text = visitante.toString()
            }

            R.id.btnRestarVisitante -> {
                Restar(visitante)
                tvVisitante.text = visitante.toString()
            }
            R.id.btnSumarVisitante -> {
                Sumar(visitante)
                tvVisitante.text = visitante.toString()
            }
            R.id.btnSumarDobleVisitante -> {
                SumarDoble(visitante)
                tvVisitante.text = visitante.toString()
            }
            R.id.btnMarcador -> {
                intent = Intent(this,ScoreActivity::class.java)
                intent.putExtra(ScoreActivity.LOCAL_SCORE_KEY,local)
                intent.putExtra(ScoreActivity.VISITANTE_SCORE_KEY,visitante)
                startActivity(intent)

            }

        }
    }
}