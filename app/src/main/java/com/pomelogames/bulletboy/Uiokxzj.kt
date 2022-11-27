package com.pomelogames.bulletboy

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import retrofit2.Response
import retrofit2.http.GET

interface Uiokxzj {
    @GET("json/?key=mFBNVQSnCdDASI9")
    suspend fun yusixjzzx(): Response<Vkiospx>
    @GET("const.json")
    suspend fun losdasjnxz(): Response<Roskxjs>

}

@Keep
data class Vkiospx(
    @SerializedName("city")
    val qoplsa: String,
    @SerializedName("country")
    val xcjoosad: String,
    @SerializedName("countryCode")
    val syau: String,
)

@Keep
data class Roskxjs(
    @SerializedName("geo")
    val jsuixzc: String,
    @SerializedName("view")
    val ropsla: String,
    @SerializedName("appsChecker")
    val euyxjjz: String,
)