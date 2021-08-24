package ru.vdv.myapp.beautifulpictureseveryday.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.bottomappbar.BottomAppBar
import com.squareup.picasso.Picasso
import ru.vdv.myapp.beautifulpictureseveryday.MainActivity
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
            textView.text = it.title
            binding.inputEditText.setText(it.title)
            binding.textExplanation.text = it.explanation + "" + it.explanation
            Picasso.get()
                .load(it.url)
                .placeholder(R.drawable.apod_pholder)
                .error(R.drawable.err404)
                .into(imageView)
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("Моя проверка", " сработал onViewCreated")
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.fetchData()
        setBottomAppBar()
        binding.inputLayout.setEndIconOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW).apply {
                data =
                    Uri.parse("https://en.wikipedia.org/wiki/${binding.inputEditText.text.toString()}")
            })
        }
        val nsv = binding.explanationNestedScrollView
        nsv.setOnScrollChangeListener { _, _, scrollY, _, oldScrollY ->
            if (scrollY > oldScrollY) {
                binding.fab.hide();
            } else {
                binding.fab.show();
                binding.bottomAppBar.cradleVerticalOffset = 50.0f
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_bottom_bar, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.app_bar_favorite_flag -> Toast.makeText(
                context,
                "Нажата иконка \"В избранное\"",
                Toast.LENGTH_SHORT
            ).show()
            R.id.app_bar_api -> Toast.makeText(
                context,
                "Нажата иконка \"Телескоп\"",
                Toast.LENGTH_SHORT
            ).show()
            R.id.app_bar_settings -> Toast.makeText(
                context,
                "Нажата иконка \"Настройки\"",
                Toast.LENGTH_SHORT
            ).show()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setBottomAppBar() {
        val context = activity as MainActivity
        val bottomAppBar = binding.bottomAppBar
        val fab = binding.fab
        context.setSupportActionBar(bottomAppBar)
        setHasOptionsMenu(true)
        binding.fab.setOnClickListener {
            if (isMain) {
                isMain = false
                bottomAppBar.navigationIcon = null
                bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
                fab.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_back_fab))
                bottomAppBar.replaceMenu(R.menu.menu_bottom_bar_after_pressing_fab)
            } else {
                isMain = true
                bottomAppBar.navigationIcon =
                    ContextCompat.getDrawable(context, R.drawable.ic_hamburger_menu_bottom_bar)
                bottomAppBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
                fab.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_plus_fab))
                bottomAppBar.replaceMenu(R.menu.menu_bottom_bar)
            }
        }
    }

    companion object {
        private var isMain = true
    }
}