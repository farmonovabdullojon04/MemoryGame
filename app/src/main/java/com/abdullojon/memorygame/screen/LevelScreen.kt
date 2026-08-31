package com.abdullojon.memorygame.screen

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.abdullojon.memorygame.R
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abdullojon.memorygame.adapter.InfoAdapter
import com.abdullojon.memorygame.databinding.DialogExitBinding
import com.abdullojon.memorygame.databinding.ScreenLevelBinding
import com.abdullojon.memorygame.model.LevelEnum
import dev.androidbroadcast.vbpd.viewBinding

class LevelScreen:  Fragment(R.layout.screen_level) {
    private val binding by viewBinding(ScreenLevelBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.easy.setOnClickListener {
            openGameScreenByLevel(LevelEnum.EASY)
        }

        binding.medium.setOnClickListener {
            openGameScreenByLevel(LevelEnum.MEDIUM)
        }

        binding.hard.setOnClickListener {
            openGameScreenByLevel(LevelEnum.HARD)
        }

        binding.exit.setOnClickListener {
            val dialog = AlertDialog.Builder(requireContext()).create()
            val dialogBinding = DialogExitBinding.inflate(layoutInflater)
            dialog.setView(dialogBinding.root)
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

            dialogBinding.btnYes.setOnClickListener {
                requireActivity().finish()
            }

            dialogBinding.btnNo.setOnClickListener {
                dialog.dismiss()
            }

            dialog.show()
        }

        binding.btninfo.setOnClickListener {
            val dialog = AlertDialog.Builder(requireContext()).create()
            val dialogView = layoutInflater.inflate(R.layout.dialog_info, null)
            dialog.setView(dialogView)
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            
            val recyclerView = dialogView.findViewById<RecyclerView>(R.id.rv_info)
            val infoList = listOf(
                "About Memory Game",
                "Memory Game is a classic card matching game designed to test your memory, concentration, and cognitive skills. The game consists of pairs of cards with identical images hidden face down.",
                "How to Play",
                "Your goal is to find all identical pairs of cards. Tap on a card to flip it over, then tap on another. If the cards match, they stay open. If they don't, they flip back. Remember the positions of the images to find pairs efficiently.",
                "Challenge Yourself",
                "Every attempt counts! Try to match all pairs using the fewest attempts possible. Challenge yourself to improve your memory and complete the game faster each time.",
                "Game Features:",
                "• Classic card matching gameplay\n• Multiple difficulty levels (Easy, Medium, Hard)\n• Improves short-term memory and focus\n• Beautiful graphics and smooth animations\n• Track your attempts and progress",
                "Goal",
                "Find all matching pairs and become a Memory Game Master!"
            )
            
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.adapter = InfoAdapter(infoList)
            
            dialogView.setOnClickListener {
                dialog.dismiss()
            }
            
            dialog.show()
        }
    }

    private fun openGameScreenByLevel(level: LevelEnum) {
        val bundle = bundleOf().apply {
            putSerializable("LEVEL", level)
        }
        findNavController().navigate(R.id.action_levelScreen_to_gameScreen, bundle)
    }

}