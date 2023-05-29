package com.thoriq.geming

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import com.thoriq.geming.`class`.Lawan
import com.thoriq.geming.`class`.Orang
import com.thoriq.geming.`class`.Pemain
import com.thoriq.geming.databinding.FragmentGameplayBinding
import kotlin.random.Random

class GameplayFragment : Fragment() {
    lateinit var binding:FragmentGameplayBinding
    data class dataLawan(
        val text: String,
        val answers: Lawan)

    val player=Orang(10,1,3)
    var isAttack = true

    val lawans: MutableList<dataLawan> = mutableListOf(
        dataLawan("goblin", Lawan(10,1,2)),
        dataLawan("hobgolin", Lawan(5,1,9))
    )
    val index = lawans.random()
    val enemy = index.answers
    val enemyName = index.text

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentGameplayBinding.inflate(layoutInflater)
        binding.textView1.text = getString(R.string.text_menyerang)
        binding.textHpPlayer.text = player.GetHp().toString()
        binding.textHpLawan.text = enemy.GetHp().toString()
        binding.button.setOnClickListener{Serang()}
        binding.textHpLawan.text = enemyName
        binding.playerTextName.text = getString(R.string.you)
        return binding.root
    }
    fun Serang(){

        object : CountDownTimer(1000, 1000) {
            override fun onFinish() {
                enemy.GotAttack(player)
                isAttack = false
                val text: TextView = binding.textHpLawan
                text.text = enemy.GetHp().toString()
                statusCheck()
                Diserang()
            }

            override fun onTick(millisUntilFinished: Long) {
            }
        }.start()
        binding.button.isEnabled = false

    }
    fun Diserang(){

        val textTitle: TextView = binding.textView1
        textTitle.text = getString(R.string.text_diserang)
        object : CountDownTimer(1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
            }

            override fun onFinish() {
                player.GotAttack(enemy)
                isAttack = true
                val text: TextView = binding.textHpPlayer
                text.text = player.GetHp().toString()
                textTitle.text = getString(R.string.text_menyerang)
                binding.button.isEnabled = true
                statusCheck()
            }
        }.start()
    }
    fun statusCheck(){
        if (player.GetHp()<=0){
            view?.findNavController()?.navigate(R.id.action_gameplayFragment_to_loseFragment)
        }
        if(enemy.GetHp()<=0){ view?.findNavController()?.navigate(R.id.action_gameplayFragment_to_winFragment)}
    }
}


