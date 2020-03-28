package com.gevondov.rates.domain.model

class Branch(
    val id: String,
    val bank: Bank,
    val name: String,
    val address: String,
    val phone: String,
    val workingDays: List<WorkingDay>
)
