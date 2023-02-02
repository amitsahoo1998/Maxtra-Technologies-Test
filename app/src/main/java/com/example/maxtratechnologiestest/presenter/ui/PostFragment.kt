package com.example.maxtratechnologiestest.presenter.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.maxtratechnologiestest.data.model.PostListingRequest
import com.example.maxtratechnologiestest.databinding.FragmentPostBinding
import com.example.maxtratechnologiestest.presenter.viewmodel.PostViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class PostFragment : Fragment() {

    private var _binding: FragmentPostBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var viewModel: PostViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPostBinding.inflate(inflater, container, false)
        viewModel = (activity as MainActivity).viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val postAdapter = (activity as MainActivity).postAdapter
        binding.recycleView.layoutManager = LinearLayoutManager(requireContext())
        binding.recycleView.adapter = postAdapter


        binding.btnSubmit.setOnClickListener {
            if (!binding.edUserId.text.equals("")){
                viewModel.getPostList(PostListingRequest(binding.edUserId.text.toString().toInt()))
            }else{
                binding.edUserId.error = "Please enter valid id"
            }
        }

        viewModel._postListData.observe(viewLifecycleOwner){
            if (it != null){
                it.data?.let { post ->
                    postAdapter.differ.submitList(it.data.data)
                }
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}