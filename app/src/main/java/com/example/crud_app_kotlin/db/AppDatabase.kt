import com.example.crud_app_kotlin.db.dao.SubscriberDao
import com.example.crud_app_kotlin.db.entity.SubscriberEntity


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [SubscriberEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract val subscriberDAO: SubscriberDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                var instance: AppDatabase? = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        "app_database"
                    ).build()
                }

                return instance
            }
        }
    }
}