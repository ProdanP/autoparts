package eu.prodan.autopartsmd.injection.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import eu.prodan.autopartsmd.MainActivity

/**
 * Created by User on 12.04.2018.
 */
@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun contribMainActivity() : MainActivity
}