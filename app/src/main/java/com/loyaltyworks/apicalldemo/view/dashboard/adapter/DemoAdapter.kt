package com.loyaltyworks.apicalldemo.view.dashboard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.loyaltyworks.apicalldemo.databinding.RowItemBinding
import com.loyaltyworks.apicalldemo.model.LstEventManagementDetailsAPI

class DemoAdapter(val lstEventManagementDetailsAPI: List<LstEventManagementDetailsAPI>):RecyclerView.Adapter<DemoAdapter.ViewHolder>() {

    class ViewHolder(val binding: RowItemBinding):RecyclerView.ViewHolder(binding.root) {
        val date = binding.date
        val custName = binding.custName
        val visitType = binding.visitType
        val remarks = binding.remarks
        val topic = binding.topic

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RowItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var data = lstEventManagementDetailsAPI[position]

        holder.date.text = data.eventDate
        holder.custName.text = data.beneficiaryDetails
        holder.visitType.text = data.eventTypeName
        holder.remarks.text = data.remarks
        holder.topic.text = data.topicDiscussed

    }

    override fun getItemCount(): Int {
        return lstEventManagementDetailsAPI.size
    }
}