package com.example.lovecalculator_mvvm.onboarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.lovecalculator_mvvm.R
import com.example.lovecalculator_mvvm.databinding.ItemOnBoardingBinding
import com.example.lovecalculator_mvvm.onboarding.OnBoardingModel


class OnBoardingAdapter(private val onClick: () -> Unit) :
    RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {
    private val list = arrayListOf<OnBoardingModel>(
        OnBoardingModel(
            "Have a good time",
            "You should take the time to help those who need you",
            R.raw.anim_1
        ),
        OnBoardingModel(
            "Cherishing love",
            "It is no longer possible for you to cherish love",
            R.raw.anim_2
        ),
        OnBoardingModel(
            "Have a breakup?",
            "We have the correction for you don't worry \n mayby someone is waiting for you!",
            R.raw.anim_3
        ),
        OnBoardingModel(
            "It's funs and many more!",
            "",
            R.raw.anim_4
        )
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnBoardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnBoardingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(onBoarding: OnBoardingModel) = with(binding) {
            tvTitle.text = onBoarding.title
            tvDesc.text = onBoarding.desc
            btnGetStarted.isVisible = adapterPosition == list.lastIndex

            onBoarding.anim?.let {
                with(binding) {
                    animBoard.setAnimation(onBoarding.anim)
                    animBoard.playAnimation()
                }
            }
            btnGetStarted.setOnClickListener {
                onClick()
            }
        }
    }
}