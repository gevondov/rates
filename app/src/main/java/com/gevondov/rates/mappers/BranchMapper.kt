package com.gevondov.rates.mappers

import com.gevondov.rates.data.memory.entities.BankEntity
import com.gevondov.rates.data.memory.entities.BranchEntity
import com.gevondov.rates.data.remote.response.BranchResponse
import com.gevondov.rates.domain.model.Branch

class BranchMapper(
    private val workingDaysMapper: WorkingDaysMapper,
    private val bankMapper: BankMapper
) {

    fun fromResponse(response: BranchResponse) = BranchEntity(
        id = response.id,
        isHead = response.isHead,
        name = response.name,
        address = response.address,
        phone = response.phone,
        workingDays = workingDaysMapper.fromResponses(response.workingDays)
    )

    fun fromResponses(responses: List<BranchResponse>) = responses.map(this::fromResponse)

    fun fromEntity(entity: BranchEntity, bank: BankEntity) = Branch(
        id = entity.id,
        bank = bankMapper.fromEntity(bank),
        name = entity.name,
        address = entity.address,
        phone = entity.phone,
        workingDays = workingDaysMapper.fromEntities(entity.workingDays)
    )

}
