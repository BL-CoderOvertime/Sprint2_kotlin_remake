package com.lambda.shoppinglist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    internal var shoppingItems: ArrayList<ShoppingItem> = ArrayList()
    companion object{
       // var shoppingList: ArrayList<String> = ArrayList()
        var shoppingList = mutableListOf<String>()
        const val NOTIFICATION_ID = 22
    }

    private val adapter = ShoppingListAdapter(shoppingItems)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val shoppingListLayout=findViewById<RecyclerView>(R.id.shopping_list_layout)
        shoppingListLayout.setHasFixedSize(false)
        val manager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        shoppingListLayout.layoutManager = manager
        shoppingListLayout.adapter = adapter
        for (i in 0 until ShoppingItemConstants.ICON_IDS.size) {
            shoppingItems.add(ShoppingItem(ShoppingItemConstants.ITEM_NAMES_RAW[i], ShoppingItemConstants.ICON_IDS[i], 1))

        }
        adapter.notifyDataSetChanged()

        button_send_list.setOnClickListener {
            NotificationGenerator.orderNotification(this)

            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT,"Please add this order for me $shoppingList")
                type = "text/plain"
            }
            startActivity(sendIntent)

        }
    }
}
