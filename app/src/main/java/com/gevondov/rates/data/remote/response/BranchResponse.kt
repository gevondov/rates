package com.gevondov.rates.data.remote.response

class BranchResponse(
    val id: String,
    val isHead: Int,
    val name: String,
    val address: String,
    val phone: String,
    val workingDays: List<WorkingDayResponse>
)
