package com.lambda.shoppinglist

import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.shopping_item_layout.view.*
import java.util.ArrayList

class ShoppingListAdapter (val data: ArrayList<ShoppingItem>) :
    RecyclerView.Adapter<ShoppingListAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemImage: ImageView = view.item_image
        val itemName: TextView = view.item_name

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewGroup = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item_layout, parent, false)
        return ViewHolder(viewGroup)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemImage.setImageDrawable(getDrawable(holder.itemImage.context, data[position].itemImageId))
        holder.itemName.text = data[position].itemName

        holder.itemView.setOnClickListener {

            if (it.tag != "on") {

                it.tag = "on"
                holder.itemView.setBackgroundColor(ContextCompat.getColor(it.context, R.color.colorGreen))
                MainActivity.shoppingList.add(holder.itemName.text.toString())
            } else if (it.tag != "off") {
                it.tag = "off"
                holder.itemView.setBackgroundColor(ContextCompat.getColor(it.context, R.color.colorWhite))
                   MainActivity.shoppingList.removeAt(data[position].itemIndex-1)
                }


            }
        }
    }


