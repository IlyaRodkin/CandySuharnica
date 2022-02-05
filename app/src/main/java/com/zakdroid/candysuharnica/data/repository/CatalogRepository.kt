package com.zakdroid.candysuharnica.data.repository

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.zakdroid.candysuharnica.data.model.CatalogItem
import com.zakdroid.candysuharnica.data.model.CatalogResponse
import kotlinx.coroutines.tasks.await

class CatalogRepository constructor(
    private val rootRef: DatabaseReference = FirebaseDatabase.getInstance("https://candysuharnica-default-rtdb.europe-west1.firebasedatabase.app/").reference,
    private val productRef: DatabaseReference = rootRef.child("catalog")
) {
    suspend fun getResponseFromRealtimeDatabase(): CatalogResponse {
        val response = CatalogResponse()
        try {
            response.catalogItems = productRef.get().await().children.map { snapShot ->
                snapShot.getValue(CatalogItem::class.java)!!
            }
        } catch (exception: Exception) {
            response.exception = exception
        }
        return response
    }
}