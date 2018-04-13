package eu.prodan.autopartsmd.injection

import dagger.BindsInstance
import dagger.Component
import eu.prodan.autopartsmd.AutopartsApplication
import eu.prodan.autopartsmd.injection.modules.ActivityModule
import eu.prodan.autopartsmd.injection.modules.AppModule
import eu.prodan.autopartsmd.injection.modules.RemoteModule
import javax.inject.Singleton

/**
 * Created by User on 13.04.2018.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, ActivityModule::class, RemoteModule::class))
interface AppComponent {
    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(autopartsApplication: AutopartsApplication) : Builder
        fun build() : AppComponent
    }

    fun inject(autopartsApplication: AutopartsApplication)
}