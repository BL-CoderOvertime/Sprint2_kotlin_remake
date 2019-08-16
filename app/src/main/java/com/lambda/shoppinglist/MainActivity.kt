package com.lambda.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    internal var shoppingList: ArrayList<ShoppingItem> = ArrayList()
    private val adapter = ShoppingListAdapter(shoppingList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val shoppingListLayout=findViewById<RecyclerView>(R.id.shopping_list_layout)
        shoppingListLayout.setHasFixedSize(false)
        val manager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        shoppingListLayout.layoutManager = manager
        shoppingListLayout.adapter = adapter

        for (i in 0 until ShoppingItemConstants.ICON_IDS.size) {
            shoppingList.add(ShoppingItem(ShoppingItemConstants.ITEM_NAMES_RAW[i], ShoppingItemConstants.ICON_IDS[i], 1))

        }
        adapter.notifyDataSetChanged()
    }
}
