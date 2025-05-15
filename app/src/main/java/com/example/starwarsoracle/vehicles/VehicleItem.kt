package com.example.starwarsoracle.vehicles


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VehicleItem(
    @SerialName("cargo_capacity")
    val cargoCapacity: String? = null,
    @SerialName("consumables")
    val consumables: String? = null,
    @SerialName("cost_in_credits")
    val costInCredits: String? = null,
    @SerialName("created")
    val created: String? = null,
    @SerialName("crew")
    val crew: String? = null,
    @SerialName("edited")
    val edited: String? = null,
    @SerialName("films")
    val films: List<String?>? = null,
    @SerialName("length")
    val length: String? = null,
    @SerialName("manufacturer")
    val manufacturer: String? = null,
    @SerialName("max_atmosphering_speed")
    val maxAtmospheringSpeed: String? = null,
    @SerialName("model")
    val model: String? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("passengers")
    val passengers: String? = null,
    @SerialName("pilots")
    val pilots: List<String?>? = null,
    @SerialName("url")
    val url: String? = null,
    @SerialName("vehicle_class")
    val vehicleClass: String? = null
)