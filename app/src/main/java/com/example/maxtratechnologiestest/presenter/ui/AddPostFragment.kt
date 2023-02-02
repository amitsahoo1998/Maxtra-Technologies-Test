package com.example.maxtratechnologiestest.presenter.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.maxtratechnologiestest.data.model.CreatePostRequest
import com.example.maxtratechnologiestest.databinding.FragmentAddPostBinding
import com.example.maxtratechnologiestest.presenter.viewmodel.PostViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AddPostFragment : Fragment() {

    private var _binding: FragmentAddPostBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var viewModel: PostViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddPostBinding.inflate(inflater, container, false)
        viewModel = (activity as MainActivity).viewModel
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.submit.setOnClickListener {
            val name = binding.edName.text.toString()
            val user_id = binding.edUserId.text.toString()
            val post_type = binding.edPostType.text.toString()
            val discription = binding.edDiscription.text.toString()
            val image = binding.edImageLink.text.toString()
            val video = binding.edVideoLink.text.toString()
            val videoThumbnail = binding.edVideoDiscription.text.toString()
            viewModel.createPostApiCall(
                CreatePostRequest(
                    discription,
                    listOf(image),
                    name,
                    post_type.toInt(),
                    user_id.toInt(),
                    videoThumbnail,
                    video
                )
            )
        }
        viewModel._createPostData.observe(viewLifecycleOwner) {
            if (it != null) {
                it.data?.let { post ->
                    Toast.makeText(requireContext(), post.message, Toast.LENGTH_LONG).show()
                }
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}