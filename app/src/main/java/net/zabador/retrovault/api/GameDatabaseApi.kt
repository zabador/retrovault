package net.zabador.retrovault.api

import io.reactivex.Observable
import net.zabador.retrovault.dto.PlatformListDataDto
import retrofit2.http.GET


/**
 * Created by skye on 2/25/18.
 */
interface GameDatabaseApi {

    @GET("GetPlatformsList.php")
    fun getPlatformList(): Observable<PlatformListDataDto>

}