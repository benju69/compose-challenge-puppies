/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.model

import android.os.Parcelable
import com.example.androiddevchallenge.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dog(
    val name: String,
    val breed: String,
    val gender: String,
    val height: String,
    val color: String,
    val image: Int,
    val url: String
) : Parcelable

// Make some dogs in code (next time from api :)), data from petfinder.com
val dogsList = listOf(
    Dog("Gunther", "Pointer & Terrier Mix", "Male",  "Medium", "Red / Chestnut / Orange, White / Cream", R.drawable.gunther, "https://www.petfinder.com/dog/gunther-49996076/ny/morris/suruluna-animal-rescue-ny1267/"),
    Dog("Montey", "Pit Bull Terrier", "Male", "Medium", "Black, White / Cream", R.drawable.montey, "https://www.petfinder.com/dog/montey-50689647/ny/clay/recycle-a-bull-bully-breed-rescue-ny1102/"),
    Dog("Amora", "Shepherd Mix", "Female", "Medium", "Brindle", R.drawable.amora, "https://www.petfinder.com/dog/amora-50698373/ny/amsterdam/montgomery-county-spca-ny203/"),
    Dog("Dame", "Shepherd Mix", "Female", "Medium", "Brindle", R.drawable.dame, "https://www.petfinder.com/dog/dame-50698366/ny/amsterdam/montgomery-county-spca-ny203/"),
    Dog("Posey", "Retriever Mix", "Female", "Medium", "Brown / Chocolate, White / Cream", R.drawable.posey, "https://www.petfinder.com/dog/posey-50698236/ny/amsterdam/montgomery-county-spca-ny203/"),
    Dog("Flint", "Australian Shepherd & Chow Chow Mix", "Male", "Medium", "", R.drawable.flint, "https://www.petfinder.com/dog/flint-50690266/pa/thompson/ruff-dog-rescue-north-east-pa932/"),
    Dog("Ellie", "Chihuahua & Terrier Mix", "Female", "Small", "Black, Yellow / Tan / Blond / Fawn", R.drawable.ellie, "https://www.petfinder.com/dog/ellie-50571534/ny/albany/homeward-bound-dog-rescue-of-ny-ny480/")
)
