package net.zabador.retrovault.adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import net.zabador.retrovault.R
import net.zabador.retrovault.dto.PlatformDto
import net.zabador.retrovault.inflate

import kotlinx.android.synthetic.main.row_platform.view.*

/**
 * Created by skye on 2/25/18.
 */
class PlatformRecyclerAdapter(private val platforms: ArrayList<PlatformDto>) : RecyclerView.Adapter<PlatformRecyclerAdapter.PlatformHolder>()  {
    override fun onBindViewHolder(holder: PlatformHolder?, position: Int) {
        val platform = platforms[position]
        holder?.bindPhoto(platform)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PlatformHolder {
        val inflatedView = parent?.inflate(R.layout.row_platform, false)
        return PlatformHolder(inflatedView)

    }

    override fun getItemCount(): Int {
        return platforms.size
    }


    class PlatformHolder(v: View?) : RecyclerView.ViewHolder(v), View.OnClickListener {
        //2
        private var view: View? = v
        private var platform: PlatformDto? = null

        //3
        init {
            v?.setOnClickListener(this)
        }

        //4
        override fun onClick(v: View) {
            Log.d("RecyclerView", "CLICK!")
        }

        companion object {
            //5
            private val PLATFORM_KEY = "PLATFORM"
        }

        fun bindPhoto(platform: PlatformDto) {
            this.platform = platform
            view?.platformName?.text = platform.name
        }
    }
}