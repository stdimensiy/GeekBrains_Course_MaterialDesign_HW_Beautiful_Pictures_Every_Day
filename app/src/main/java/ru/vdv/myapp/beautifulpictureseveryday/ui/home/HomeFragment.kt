package ru.vdv.myapp.beautifulpictureseveryday.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.squareup.picasso.Picasso
import ru.vdv.myapp.beautifulpictureseveryday.R
import ru.vdv.myapp.beautifulpictureseveryday.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels {
        HomeViewModelFactory(requireActivity().application)
    }
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val textView: TextView = binding.textHome
        val imageView: ImageView = binding.imageViewApod
        homeViewModel.apodLiveData.observe(viewLifecycleOwner, {
            Log.d("Моя проверка", " пытаюсь вывести результат")
            //textView.text = it.explanation
            Picasso.get()
                .load(it.url)
                .placeholder(R.drawable.apod_pholder)
                .error(R.drawable.err404)
                .resize(1080, 2340)
                .centerCrop()
                .into(imageView)
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("Моя проверка", " сработал onViewCreated")
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.fetchData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}