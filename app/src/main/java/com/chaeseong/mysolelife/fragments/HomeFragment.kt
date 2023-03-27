package com.chaeseong.mysolelife.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.chaeseong.mysolelife.R
import com.chaeseong.mysolelife.databinding.ActivityLoginBinding
import com.chaeseong.mysolelife.databinding.FragmentHomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

	private lateinit var binding: FragmentHomeBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

	}

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {

		Log.d("HomeFragment","onClicked")

		binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false)

		binding.tipTap.setOnClickListener {

			Log.d("HomeFragment","tiptap")
			Toast.makeText(requireContext(),"Clicked",Toast.LENGTH_SHORT).show()
		}

		return binding.root
	}

}