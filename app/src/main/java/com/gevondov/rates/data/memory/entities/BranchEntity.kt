package com.gevondov.rates.data.memory.entities

class BranchEntity(
    val id: String,
    val isHead: Boolean,
    val name: String,
    val address: String,
    val phone: String,
    val workingDays: List<WorkingDayEntity>
)
