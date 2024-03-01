package datastore

import android.content.Context
import android.provider.Settings
import androidx.compose.ui.text.font.FontVariation
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


const val SETTINGS = "settings"
@Module
@InstallIn(SingletonComponent::class)
class DataStoreModule {
    @Provides
    @Singleton


    fun providePreferencesDataStore(
        @ApplicationContext context:Context //ler e escrever acessar recursos no contexto
    ): DataStore<Preferences>{
        return PreferenceDataStoreFactory.create (
            produceFile = {context.preferencesDataStoreFile(SETTINGS)}
        )

    }
}