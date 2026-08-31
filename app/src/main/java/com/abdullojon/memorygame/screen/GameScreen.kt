package com.abdullojon.memorygame.screen

import androidx.appcompat.app.AlertDialog
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.abdullojon.memorygame.R
import com.abdullojon.memorygame.databinding.FinishDialogBinding
import com.abdullojon.memorygame.databinding.ScreenGameBinding
import com.abdullojon.memorygame.domain.AppRepository
import com.abdullojon.memorygame.model.CardData
import com.abdullojon.memorygame.model.LevelEnum
import dev.androidbroadcast.vbpd.viewBinding


class GameScreen: Fragment(R.layout.screen_game) {
    private val binding by viewBinding(ScreenGameBinding::bind)
    private val level by lazy { requireArguments().getSerializable("LEVEL") as LevelEnum }
    private var cardWidth = 0
    private var cardHeight = 0
    private var attemptCount = 0
    private var levelCount=1
    private val views = ArrayList<ImageView>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.root.post {
            cardWidth = binding.container.width / level.horizontalCount
            cardHeight = binding.container.height / level.verticalCount

            addAllViews()
            closeAllCards()
        }
        binding.reload.setOnClickListener {
            restart()
        }

        binding.menu.setOnClickListener {
            showMenuDialog()
        }
    }

    private fun addAllViews() {
        val cardList = AppRepository.getCardListByLevel(level)

        for (i in 0 until level.verticalCount) {
            for (j in 0 until level.horizontalCount) {
                val imageView = ImageView(requireContext())


                binding.container.addView(imageView, cardWidth, cardHeight)
                imageView.x = binding.container.x + binding.container.width/2 - cardWidth/2
                imageView.y = binding.container.y + binding.container.height/2 - cardHeight / 2

                imageView.animate()
                    .setDuration(2000)
                    .x(j * cardWidth.toFloat())
                    .y(i * cardHeight.toFloat())
                    .z(1f)
                    .start()

                imageView.tag = cardList[i * level.horizontalCount + j]
                imageView.setImageResource(cardList[i * level.horizontalCount + j].imgResID)
                views.add(imageView)
            }
        }
    }

    private fun closeAllCards() {
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            views.forEach {
                it.animate()
                    .setDuration(1000)
                    .rotationY(89f)
                    .withEndAction {
                        it.setImageResource(R.drawable.image_back)
                        it.rotationY = -89f
                        it.animate()
                            .setDuration(1000)
                            .rotationY(0f)
                            .start()
                    }
                    .start()
            }

        }, 4000)
        clickedCard()
    }
    private var counter = 0
    private var savedIndex = -1
    fun clickedCard(){
        views.forEachIndexed { index, imageView ->
            imageView.setOnClickListener {

                attemptCount++
                binding.attempt.text=attemptCount.toString()

                imageView.isClickable = false
                imageView.animate()
                    .setDuration(500)
                    .rotationY(90f)
                    .withEndAction {
                        val card = (imageView.tag as CardData)
                        imageView.setImageResource(card.imgResID)
                        imageView.animate()
                            .setDuration(500)
                            .rotationY(0f)
                            .withEndAction {
                                counter++
                                if (counter >=2){
                                    counter = 0
                                    isCorrect(index, savedIndex)
                                    savedIndex = -1
                                }else{
                                    savedIndex = index
                                }
                            }
                            .start()
                    }
                    .start()
            }
        }

    }
    fun isCorrect(index1: Int, index2: Int){
        val card1 = views[index1].tag as CardData
        val card2 = views[index2].tag as CardData

        if (card2 == card1){
            correct(index1,index2)
        }else{
            closeCard(index1,index2)

        }
    }

    fun correct(index1: Int, index2: Int){
        views[index1].animate()
            .alpha(0f)
            .setDuration(500)
            .start()
        views[index2].animate()
            .alpha(0f)
            .setDuration(500)
            .start()
        levelCount++
        binding.levelText.text=levelCount.toString()
        val matchedCount = views.count { it.alpha == 0f } + 2
        if (matchedCount >= views.size) {
            showWinDialog()
        }
    }
    fun showMenuDialog() {
        val dialog = AlertDialog.Builder(requireContext()).create()
        val dialogView = layoutInflater.inflate(R.layout.dialog_menu, null)
        dialog.setView(dialogView)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        dialogView.findViewById<View>(R.id.btn_resume).setOnClickListener {
            dialog.dismiss()
        }

        dialogView.findViewById<View>(R.id.btn_home).setOnClickListener {
            findNavController().popBackStack()
            dialog.dismiss()
        }

        dialogView.findViewById<View>(R.id.btn_restart).setOnClickListener {
            restart()
            dialog.dismiss()
        }

        dialog.show()
    }

    fun showWinDialog() {
        val dialog = AlertDialog.Builder(requireContext()).create()
        val dialogBinding = FinishDialogBinding.inflate(layoutInflater)
        dialog.setView(dialogBinding.root)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.setCancelable(false)

        dialogBinding.level.text = levelCount.toString()
        dialogBinding.attempts.text = attemptCount.toString()

        dialogBinding.btnRetry.setOnClickListener {
            restart()
            dialog.dismiss()
        }

        dialogBinding.btnHome.setOnClickListener {
            findNavController().popBackStack()
            dialog.dismiss()
        }

        dialog.show()
    }
    fun closeCard(index1: Int, index2: Int){
        val view1 = views[index1]
        val view2 = views[index2]
        view1.animate()
            .setDuration(500)
            .rotationY(90f)
            .withEndAction {
                view1.setImageResource(R.drawable.image_back)

                view1.animate()
                    .setDuration(500)
                    .rotationY(0f)
                    .withEndAction {
                        view1.isClickable = true
                    }
                    .start()
            }.start()
        view2.animate()
            .setDuration(500)
            .rotationY(90f)
            .withEndAction {
                view2.setImageResource(R.drawable.image_back)
                view2.animate()
                    .setDuration(500)
                    .rotationY(0f)
                    .withEndAction {
                        view2.isClickable = true
                    }
                    .start()
            }.start()
    }

    fun restart() {
        levelCount=1
        binding.levelText.text="1"
        attemptCount=0
        binding.attempt.text="0"
        counter = 0
        savedIndex = -1
        views.forEach { binding.container.removeView(it) }
        views.clear()
        addAllViews()
        closeAllCards()
    }
}