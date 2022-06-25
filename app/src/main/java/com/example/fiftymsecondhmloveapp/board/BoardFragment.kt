package com.example.fiftymsecondhmloveapp.board

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import com.example.fiftymsecondhmloveapp.Prefs
import com.example.fiftymsecondhmloveapp.R
import com.example.fiftymsecondhmloveapp.board.BoardAdapter
import com.example.fiftymsecondhmloveapp.databinding.FragmentBoardBinding
import com.example.fiftymsecondhmloveapp.model.Board

class BoardFragment : Fragment() {

    private lateinit var binding: FragmentBoardBinding
    private lateinit var adapter: BoardAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding =
            FragmentBoardBinding.inflate(LayoutInflater.from(requireContext()), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = BoardAdapter(requireContext(),findNavController())
        binding.viewPager.adapter = adapter
        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner) {
            activity?.finish()
        }
        adapter.addItem(Board(R.raw.board_love1, "Have a good time", "You should take the time to help those who need you"))
        adapter.addItem(Board(R.raw.board_love2, "Cherishing love", "It is now no longer possible for you to cherish love"))
        adapter.addItem(Board(R.raw.board_love3, "Have a breakup?", "We have made the correction for you don't worry\nMaybe someone is waiting for you!"))
        adapter.addItem(Board(R.raw.board_love4, "", "It's Fans and Many more"))

        binding.textSkip.setOnClickListener {
            Prefs(requireContext()).saveState()
            findNavController().navigateUp()
        }
    }
}