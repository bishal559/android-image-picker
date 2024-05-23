package com.bishal.imagepicker.multiselect

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.NavHostFragment
import androidx.viewpager2.widget.ViewPager2
import com.bishal.imagepicker.R
import com.bishal.imagepicker.databinding.FragmentMultiSelectBinding
import kotlin.math.abs


class MultiSelectFragment : Fragment() {

    private lateinit var b: FragmentMultiSelectBinding
    private lateinit var addresses: List<String>
    private lateinit var multiSelectPagerAdapter: MultiSelectPagerAdapter
    private var position = -1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        b = FragmentMultiSelectBinding.inflate(inflater, container, false)
        return b.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val actionBar = (activity as AppCompatActivity).supportActionBar
        actionBar?.let {
            it.title = getString(R.string.instagrampicker_multi_select_title)
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowHomeEnabled(true)
            it.setHomeAsUpIndicator(R.drawable.vector_prev)
        }
        initialization()
        init()
    }

    private fun init() {
        addresses = requireArguments().getStringArray("pics")?.toList() ?: emptyList()
        if (addresses.isEmpty()) NavHostFragment.findNavController(this).popBackStack()

        initViewPager()
    }

    private fun initViewPager() {
        multiSelectPagerAdapter = MultiSelectPagerAdapter(this, addresses){_,pos->
            position=pos
        }
        b.multiSelectViewpager.apply {
            adapter = multiSelectPagerAdapter
            offscreenPageLimit = 1
            val nextItemVisiblePx = resources.getDimension(R.dimen.viewpager_next_item_visible)
            val currentItemHorizontalMarginPx = resources.getDimension(R.dimen.viewpager_current_item_horizontal_margin)
            val pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx
            val pageTransformer = ViewPager2.PageTransformer { page: View, position: Float ->
                page.translationX = -pageTranslationX * position
                page.scaleY = 1 - (0.25f * abs(position))
            }
            setPageTransformer(pageTransformer)
            val itemDecoration = HorizontalMarginItemDecoration(
                context,
                R.dimen.viewpager_current_item_horizontal_margin
            )
            addItemDecoration(itemDecoration)
        }
    }




    private fun initialization(){
        requireActivity().addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                // Add menu items here
                menuInflater.inflate(R.menu.menu_main, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                // Handle the menu selection
                return when (menuItem.itemId) {
                    R.id.action_next -> {
                        // clearCompletedTasks()
                        true
                    }

                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }



}