package com.gevondov.rates.data.remote.network.deserializers

import com.gevondov.rates.data.remote.response.BankResponse
import com.gevondov.rates.data.remote.response.BanksResponse
import com.gevondov.rates.data.remote.response.RateResponse
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import java.lang.reflect.Type

class BanksResponseDeserializer : JsonDeserializer<BanksResponse> {

    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext?): BanksResponse {
        val banksObject = json.asJsonObject
        val banks = banksObject.keySet().map { id ->
            val bank = banksObject.getAsJsonObject(id)
            val name = bank.getAsJsonPrimitive("title").asString
            val rates = bank.getAsJsonObject("list")
            BankResponse(id, name, deserializeRates(rates))
        }
        return BanksResponse(banks)
    }

    private fun deserializeRates(json: JsonObject): List<RateResponse> {
        return json.keySet().mapNotNull { name ->
            val rateObjects = json.getAsJsonObject(name)
            rateObjects.keySet().firstOrNull()?.let { key ->
                val rate = rateObjects.getAsJsonObject(key)
                val buy = rate.getAsJsonPrimitive("buy").asFloat
                val sell = rate.getAsJsonPrimitive("sell").asFloat
                RateResponse(name, buy, sell)
            }
        }
    }
}
