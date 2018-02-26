package net.zabador.retrovault.dto

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

/**
 * Created by skye on 2/25/18.
 */
@Root(strict = false, name = "Platform")
class PlatformDto @JvmOverloads constructor(
        @field:Element(name = "id") var id: Int = 0,
        @field:Element(name = "name") var name: String = "",
        @field:Element(name = "alias", required = false) var alias: String = "")
