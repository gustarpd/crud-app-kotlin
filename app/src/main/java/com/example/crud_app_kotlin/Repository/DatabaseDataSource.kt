package com.example.crud_app_kotlin.Repository

import androidx.lifecycle.LiveData
import com.example.crud_app_kotlin.db.dao.SubscriberDao
import com.example.crud_app_kotlin.db.entity.SubscriberEntity

class DatabaseDataSource(private val subscriberDAO: SubscriberDao)  : SubscriberRepository {

    override suspend fun insertSubscriber(name: String, email: String): Long {
        val subscriber = SubscriberEntity(
            name = name,
            email = email
        )

        return subscriberDAO.insert(subscriber)
    }

    override suspend fun updateSubscriber(id: Long, name: String, email: String) {
        val subscriber = SubscriberEntity(
            id = id,
            name = name,
            email = email
        )

        subscriberDAO.update(subscriber)
    }

    override suspend fun deleteSubscriber(id: Long) {
        subscriberDAO.delete(id)
    }

    override suspend fun deleteAllSubscribers() {
        subscriberDAO.deleteAll()
    }

    override suspend fun getAllSubscribers(): LiveData<List<SubscriberEntity>> {
        return subscriberDAO.getAll()
    }
}