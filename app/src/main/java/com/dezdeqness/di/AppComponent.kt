package com.dezdeqness.di

import android.content.Context
import com.dezdeqness.di.modules.AccountModule
import com.dezdeqness.di.modules.DataModule
import com.dezdeqness.di.modules.DatabaseModule
import com.dezdeqness.di.modules.RemoteModule
import com.dezdeqness.di.subcomponents.*
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ViewModelBuilderModule::class,
        AppSubcomponents::class,
        RemoteModule::class,
        AppModule::class,
        AccountModule::class,
        DataModule::class,
        DatabaseModule::class,
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun animeComponent(): AnimeComponent.Factory

    fun profileComponent(): ProfileComponent.Factory

    fun authorizationComponent(): AuthorizationComponent.Factory

    fun animeDetailsComponent(): AnimeDetailsComponent.Builder

    fun animeSearchFilterComponent(): AnimeSearchFilterComponent.Builder

    fun personalListComponent(): PersonalListComponent.Factory

    fun editRateComponent(): EditRateComponent.Builder

    fun calendarComponent(): CalendarComponent.Factory

}
