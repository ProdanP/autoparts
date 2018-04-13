package eu.prodan.autopartsmd.injection.modules

import android.arch.persistence.room.Room
import dagger.Module
import dagger.Provides
import eu.prodan.autopartsmd.AutopartsApplication
import eu.prodan.autopartsmd.local.ProductsDatabase
import javax.inject.Singleton

/**
 * Created by User on 12.04.2018.
 */
@Module
class AppModule {
    @Provides
    @Singleton
    fun providesDatabase(autopartsApplication: AutopartsApplication) : ProductsDatabase =
            Room.databaseBuilder(autopartsApplication, ProductsDatabase::class.java, "product").allowMainThreadQueries().build();
}