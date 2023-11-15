package vn.edu.hust.activityexamples

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.View
import android.widget.ListView
import android.widget.PopupMenu
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {}

        val items = arrayListOf<ItemModel>()
        repeat(28) {
            val id = it + 1
            items.add(ItemModel(
                id,
                "Viet Anh",
                "0703866975",
                "buivietanh399@gmail.com",
                resources.getIdentifier("test", "drawable", packageName)
            ))
        }
        findViewById<ListView>(R.id.list_view).adapter = ItemAdapter(items)

        findViewById<ListView>(R.id.list_view).setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("id", items[position].id.toString())
            intent.putExtra("name", items[position].name)
            intent.putExtra("phone", items[position].phone)
            intent.putExtra("email", items[position].email)
            launcher.launch(intent)
        }

        findViewById<ListView>(R.id.list_view).setOnItemLongClickListener { parent, view, position, id ->
            val popupMenu = PopupMenu(this, view)
            popupMenu.inflate(R.menu.main_menu)
            popupMenu.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.action_phone -> Log.v("TAG", "Phone")
                    R.id.action_message-> Log.v("TAG", "Message")
                    R.id.action_mail -> Log.v("TAG", "Mail")
                }
                true
            }
            popupMenu.show()
            true
        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.main_menu, menu)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
}