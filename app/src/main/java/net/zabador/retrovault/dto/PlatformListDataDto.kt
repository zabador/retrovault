package net.zabador.retrovault.dto

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

/**
 * Created by skye on 2/25/18.
 */
@Root(strict = false, name = "Data")
class PlatformListDataDto @JvmOverloads constructor(
        @field:ElementList(name = "Platforms") var platforms: ArrayList<PlatformDto> = ArrayList())





