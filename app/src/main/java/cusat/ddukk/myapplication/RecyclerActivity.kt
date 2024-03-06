package cusat.ddukk.myapplication

import SampleData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cusat.ddukk.myapplication.Adaptor.RecyclerAdapter

class RecyclerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        var recyclerView = findViewById<RecyclerView>(R.id.rv_recycler_View)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val data = SampleData.conversationSample
        val adapter = RecyclerAdapter(data)
        recyclerView.adapter = adapter

    }
}