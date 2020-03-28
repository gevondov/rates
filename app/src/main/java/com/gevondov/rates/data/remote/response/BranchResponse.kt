package com.gevondov.rates.data.remote.response

class BranchResponse(
    val id: String,
    val isHead: Boolean,
    val name: String,
    val address: String,
    val phone: String,
    val workingDays: List<WorkingDayResponse>
)
