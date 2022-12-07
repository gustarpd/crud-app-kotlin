package com.example.crud_app_kotlin.Repository
import androidx.lifecycle.LiveData
import com.example.crud_app_kotlin.db.entity.SubscriberEntity

interface SubscriberRepository {
    suspend fun insertSubscriber(name: String, email: String): Long

    suspend fun updateSubscriber(id: Long, name: String, email: String)

    suspend fun deleteSubscriber(id: Long)

    suspend fun deleteAllSubscribers()

    suspend fun getAllSubscribers(): LiveData<List<SubscriberEntity>>
}