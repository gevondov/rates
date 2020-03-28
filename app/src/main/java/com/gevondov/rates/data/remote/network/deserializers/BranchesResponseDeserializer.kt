package com.gevondov.rates.data.remote.network.deserializers

import com.gevondov.rates.data.remote.response.BranchResponse
import com.gevondov.rates.data.remote.response.BranchesResponse
import com.gevondov.rates.data.remote.response.WorkingDayResponse
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class BranchesResponseDeserializer : JsonDeserializer<BranchesResponse> {

    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext?): BranchesResponse {
        val branchesObject = json.asJsonObject.getAsJsonObject("list")
        val branches = branchesObject.keySet().map { id ->
            val branch = branchesObject.getAsJsonObject(id)
            val head = branch.getAsJsonPrimitive("head").asInt
            val nameObject = branch.getAsJsonObject("title")
            val name = nameObject.getAsJsonPrimitive("en").asString
            val addressObject = branch.getAsJsonObject("address")
            val address = addressObject.getAsJsonPrimitive("en").asString
            val phone = branch.getAsJsonPrimitive("contacts").asString
            val workDays = branch.getAsJsonArray("workhours")
                .map { it.asJsonObject }
                .map {
                    val days = it.getAsJsonPrimitive("days").asString
                    val hours = it.getAsJsonPrimitive("hours").asString
                    WorkingDayResponse(days, hours)
                }

            BranchResponse(id, head, name, address, phone, workDays)
        }
        return BranchesResponse(branches)
    }

}
