package com.lynn.tvapp.data.source.network.model.item

import com.google.gson.annotations.SerializedName

data class Cast(
    @SerializedName("person") var person: Person
)
